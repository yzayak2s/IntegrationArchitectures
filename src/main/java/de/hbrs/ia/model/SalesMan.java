package de.hbrs.ia.model;

import de.hbrs.ia.interfaces.ManagePersonal;
import org.bson.Document;

import java.util.List;

public class SalesMan implements ManagePersonal {
    private String firstname;
    private String lastname;
    private Integer id;

    public SalesMan(String firstname, String lastname, Integer id) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Document toDocument() {
        org.bson.Document document = new Document();
        document.append("firstname" , this.firstname );
        document.append("lastname" , this.lastname );
        document.append("id" , this.id);
        return document;
    }

    @Override
    public void createSalesMan(SalesMan record) {

    }

    @Override
    public void addPerformanceReord(EvaluationRecord record, int sid) {

    }

    @Override
    public SalesMan readSalesMan(int sid) {
        return null;
    }

    @Override
    public List<SalesMan> querySalesMan(String attribute, String key) {
        return null;
    }

    @Override
    public EvaluationRecord readEvaluationRecords(int sid) {
        return null;
    }
}
