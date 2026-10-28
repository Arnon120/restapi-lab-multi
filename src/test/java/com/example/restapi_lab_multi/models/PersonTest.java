package com.example.restapi_lab_multi.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PersonTest {

    private final JsonPlaceholderUser user = new JsonPlaceholderUser(1L, "Leanne Graham", "leanne@example.com");

    @Test
    void fromMembersJoinsMatchingIds() {
        Person person = Person.FromMembers(user, new MongoPerson("abc", 1L, "Tel Aviv", "Israel"), new Phone(1L, "050-1234567"));

        assertEquals(1L, person.getId());
        assertEquals("050-1234567", person.getPhone());
        assertEquals("Tel Aviv", person.getAddress().getCity());
    }

    @Test
    void fromMembersRejectsMismatchedMongoId() {
        assertThrows(IllegalArgumentException.class,
                () -> Person.FromMembers(user, new MongoPerson("abc", 2L, "Tel Aviv", "Israel"), new Phone(1L, "050-1234567")));
    }

    @Test
    void fromMembersRejectsMismatchedPhoneId() {
        assertThrows(IllegalArgumentException.class,
                () -> Person.FromMembers(user, new MongoPerson("abc", 1L, "Tel Aviv", "Israel"), new Phone(2L, "050-1234567")));
    }

    @Test
    void fromMembersRejectsMissingMember() {
        assertThrows(NullPointerException.class,
                () -> Person.FromMembers(user, null, new Phone(1L, "050-1234567")));
    }
}
