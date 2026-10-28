package com.example.restapi_lab_multi.services;

import com.example.restapi_lab_multi.dto.Person;
import com.example.restapi_lab_multi.models.JsonPlaceholderUser;
import com.example.restapi_lab_multi.models.MongoPerson;
import com.example.restapi_lab_multi.models.Phone;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PersonMapperTest {

    private final JsonPlaceholderUser user = new JsonPlaceholderUser(1L, "Leanne Graham", "leanne@example.com");

    @Test
    void toPersonJoinsMatchingIds() {
        Person person = PersonMapper.toPerson(user, new MongoPerson("abc", 1L, "Tel Aviv", "Israel"), new Phone(1L, "050-1234567"));

        assertEquals(1L, person.getId());
        assertEquals("050-1234567", person.getPhone());
        assertEquals("Tel Aviv", person.getAddress().getCity());
    }

    @Test
    void toPersonRejectsMismatchedMongoId() {
        assertThrows(IllegalArgumentException.class,
                () -> PersonMapper.toPerson(user, new MongoPerson("abc", 2L, "Tel Aviv", "Israel"), new Phone(1L, "050-1234567")));
    }

    @Test
    void toPersonRejectsMismatchedPhoneId() {
        assertThrows(IllegalArgumentException.class,
                () -> PersonMapper.toPerson(user, new MongoPerson("abc", 1L, "Tel Aviv", "Israel"), new Phone(2L, "050-1234567")));
    }

    @Test
    void toPersonRejectsMissingMember() {
        assertThrows(NullPointerException.class,
                () -> PersonMapper.toPerson(user, null, new Phone(1L, "050-1234567")));
    }
}
