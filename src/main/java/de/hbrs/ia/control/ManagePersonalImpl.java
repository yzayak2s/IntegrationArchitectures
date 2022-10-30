package de.hbrs.ia.control;

import com.google.gson.Gson;
import com.mongodb.MongoClient;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;

import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.*;

import java.util.ArrayList;
import java.util.List;

import de.hbrs.ia.model.EvaluationRecord;
import de.hbrs.ia.model.SalesMan;

public class ManagePersonalImpl implements ManagePersonal{

    // Connection to MongoDB Database
    MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
    MongoDatabase database = mongoClient.getDatabase("highperformance");
    MongoCollection<Document> salesmen = database.getCollection("salesmen");
    MongoCollection<Document> evaluation_record = database.getCollection("evaluation_record");

    // TODO: 25.10.22 Condition if user already exists
    @Override
    public void createSalesMan(SalesMan record) {
//        Document document = salesman.find(eq("id", record.getId())).first();
        salesmen.insertOne(record.toDocument());
    }

    @Override
    public void addPerformanceRecord(EvaluationRecord record, int sid) {
        record.setSalesManID(sid);
        evaluation_record.insertOne(record.toDocument());
    }

    @Override
    public SalesMan readSalesMan(int sid) {
        Document oneSalesMan = salesmen.find(eq("id", sid)).first();
        Gson gson = new Gson();
        SalesMan salesMan = gson.fromJson(oneSalesMan.toJson(), SalesMan.class);
        return salesMan;
    }

    /**
     * Reference: https://mongodb.github.io/mongo-java-driver/3.4/driver/getting-started/quick-start/
     * Section: Find All Documents in a Collection (here SalesMen)
     * @param attribute
     * @param key
     * @return
     */
    @Override
    public List<SalesMan> querySalesMan(String attribute, String key) {
        List<SalesMan> salesManList = new ArrayList<>();
        // TODO: 25.10.22 Provide for find()-method an util-method that customize the query!
        //       Example: gt("i", 50)-method -> "i" > 50 (i is grater than)
        MongoCursor<Document> cursor = salesmen.find().iterator();
        try {
            while (cursor.hasNext()) {
                Gson gson = new Gson();
                SalesMan salesMan = gson.fromJson(cursor.next().toJson(), SalesMan.class);
                salesManList.add(salesMan);
            }
        } finally {
            cursor.close();
        }
        return salesManList;
    }

    @Override
    public EvaluationRecord readEvaluationRecord(int sid) {
        Document oneEvaluationRecord = evaluation_record.find(eq("salesManID", sid)).first();
        Gson gson = new Gson();
        EvaluationRecord evaluationRecord = gson.fromJson(oneEvaluationRecord.toJson(), EvaluationRecord.class);
        return evaluationRecord;
    }

    @Override
    public List<EvaluationRecord> queryEvaluationRecords(int sid) {
        List<EvaluationRecord> evaluationRecordList = new ArrayList<>();
        MongoCursor<Document> cursor = evaluation_record.find(eq("salesManID", sid)).iterator();
        try {
            while (cursor.hasNext()) {
                Gson gson = new Gson();
                EvaluationRecord evaluationRecord = gson.fromJson(cursor.next().toJson(), EvaluationRecord.class);
                evaluationRecordList.add(evaluationRecord);
            }
        } finally {
            cursor.close();
        }
        return evaluationRecordList;
    }

    // TODO: 25.10.22 Implementation follows ...
    @Override
    public void updateSalesMan(int sid, SalesMan updatedSalesMan) {
        Document checkSalesMan = salesmen.find(eq("id", sid)).first();
//        SalesMan checkSalesMan = updatedSalesMan.readEvaluationRecords(sid);
        if (!checkSalesMan.isEmpty()) {
//            salesman.updateOne(eq("id", sid), new Document("$set", new Document("id")))
        }
    }

    // TODO: 25.10.22 Implementation follows ...
    @Override
    public void updateEvaluationRecord(int goalID, EvaluationRecord updatedRecord) {
    }

    @Override
    public void deleteSalesMan(int sid) {
        salesmen.deleteOne(eq("id", sid));
    }

    @Override
    public void deleteAllSalesMan() {
        salesmen.deleteMany(new Document());
    }

    @Override
    public void deleteEvaluationRecord(int goalID) {
        evaluation_record.deleteOne(eq("goalID", goalID));
    }

    @Override
    public void deleteAllEvaluationRecords() {
        evaluation_record.deleteMany(new Document());
    }
}
