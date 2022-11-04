package de.hbrs.ia.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "evaluation_record")
public class EvaluationRecord {
    @Id
    private int goalID;
    private String goalDescription;
    private int targetValue;
    private int actualValue;
    private int year;
    private int salesManID;

    public EvaluationRecord(
            int goalID,
            String goalDescription,
            int targetValue,
            int actualValue,
            int year,
            int salesManID
    ) {
        this.goalID = goalID;
        this.goalDescription = goalDescription;
        this.targetValue = targetValue;
        this.actualValue = actualValue;
        this.year = year;
        this.salesManID = salesManID;
    }

    public int getGoalID() {
        return goalID;
    }

    public void setGoalID(int goalID) {
        this.goalID = goalID;
    }

    public String getGoalDescription() {
        return goalDescription;
    }

    public void setGoalDescription(String goalDescription) {
        this.goalDescription = goalDescription;
    }

    public int getTargetValue() {
        return targetValue;
    }

    public void setTargetValue(int targetValue) {
        this.targetValue = targetValue;
    }

    public int getActualValue() {
        return actualValue;
    }

    public void setActualValue(int actualValue) {
        this.actualValue = actualValue;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getSalesManID() {
        return salesManID;
    }

    public void setSalesManID(int salesManID) {
        this.salesManID = salesManID;
    }

    @Override
    public String toString() {
        return (
                "EvaluationRecord [goalID=" + goalID + "," +
                " goalDescription=" + goalDescription + "," +
                " targetValue=" + targetValue + "," +
                " actualValue=" + actualValue + "," +
                " year=" + year + "," +
                " salesManID=" + salesManID +"]"
        ) ;
    }
}
