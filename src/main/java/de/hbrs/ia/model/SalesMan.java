package de.hbrs.ia.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "SalesMan")
public class SalesMan {
    private String firstname;
    private String lastname;
    @Id
    private Integer id;

    public SalesMan(String firstname, String lastname, Integer id) {
        this.firstname = firstname;
        this.lastname = lastname;

        this.id = id;
    }

    public SalesMan() {
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

    @Override
    public String toString() {
        return "SalesMan [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname +"]" ;
    }
 /*   public Document toDocument() {
        org.bson.Document document = new Document();
        document.append("firstname" , this.firstname );
        document.append("lastname" , this.lastname );
        document.append("id" , this.id);
        return document;
    }*/
}
