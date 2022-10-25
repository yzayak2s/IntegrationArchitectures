package test;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import de.hbrs.ia.model.SalesMan;
import org.bson.Document;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import de.hbrs.ia.control.ManagePersonalImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HighPerformanceTest {

    private MongoClient client;
    private MongoDatabase supermongo;
    private MongoCollection<Document> salesmen;
    private ManagePersonalImpl managePersonal = null;
    private SalesMan salesMan = null;

    /**
     * Attention: You might update the version of the Driver
     * for newer version of MongoDB!
     * This tests run with MongoDB 4.2.17 Community
     */
    @BeforeEach
    void setUp() {
        // Setting up the connection to a local MongoDB with standard port 27017
        // must be started within a terminal with command 'mongod'.
        client = new MongoClient("localhost", 27017);

        // Get database 'highperformance' (creates one if not available)
        supermongo = client.getDatabase("highperformance");

        // Get Collection 'salesmen' (creates one if not available)
        salesmen = supermongo.getCollection("salesmen");

        managePersonal = new ManagePersonalImpl();

        // Provide SalesMan
        salesMan = new SalesMan("Younes", "Zayakh", 11);
    }

    @Test
    void insertSalesMan() {
        // CREATE (Storing) the salesman object
        Document document = new Document();
        document.append("firstname" , "Sascha");
        document.append("lastname" , "Alda");
        document.append("id" , 90133);

        // ... now storing the object
        salesmen.insertOne(document);

        // READ (Finding) the stored Documnent
        Document newDocument = this.salesmen.find().first();
        System.out.println("Printing the object (JSON): " + newDocument );

        // Assertion
        Integer id = (Integer) newDocument.get("id");
        assertEquals( 90133 , id );

        // Deletion
        salesmen.drop();
    }

    @Test
    void insertSalesManMoreObjectOriented() {
        // CREATE (Storing) the salesman business object
        // Using setter instead
        SalesMan salesMan = new SalesMan( "Leslie" , "Malton" , 90444 );

        // ... now storing the object
        salesmen.insertOne(salesMan.toDocument());

        // READ (Finding) the stored Document
        // Mapping Document to business object would be fine...
        Document newDocument = this.salesmen.find().first();
        System.out.println("Printing the object (JSON): " + newDocument );

        // Assertion
        Integer id = (Integer) newDocument.get("id");
        assertEquals( 90444 , id );

        // Deletion
        salesmen.drop();
    }

    @Test
    void insertReadAssertAndDeleteSalesMan() {
        // CREATE
        // Create (Storing) and insert the salesman object
        managePersonal.createSalesMan(salesMan);

        // READ
        // Read (Finding) the stored salesman
        SalesMan salesManDoc = managePersonal.readSalesMan(salesMan.getId());

        // ASSERTION
        assertEquals(salesMan.getId(), salesManDoc.getId());

        // DELETION
        managePersonal.deleteSalesMan(salesMan.getId());
    }
}