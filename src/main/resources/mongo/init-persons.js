// Seeds the "persons" collection with the address documents from the lab instructions.
// MongoDB's equivalent of a .sql seed file - run it with mongosh:
//   mongosh mongodb://localhost:27017 src/main/resources/mongo/init-persons.js
// Safe to re-run: it clears the collection before inserting.

db = db.getSiblingDB('restapi_lab');

db.persons.deleteMany({});

db.persons.insertMany([
    {
        _id: ObjectId('615b2a12903a47eadac90e0e'),
        externalId: 1,
        city: 'London',
        country: 'UK'
    },
    {
        _id: ObjectId('615b2a29903a47eadac90e1f'),
        externalId: 2,
        city: 'New York',
        country: 'USA'
    }
]);

printjson(db.persons.find().toArray());
