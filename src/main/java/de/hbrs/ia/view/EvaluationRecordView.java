package de.hbrs.ia.view;

import de.hbrs.ia.model.EvaluationRecord;

import java.util.Arrays;
import java.util.List;

public class EvaluationRecordView {

    /*public void dumpSalesMan(List<EvaluationRecord> evaluationRecordList) {
        for (EvaluationRecord evaluationRecord : evaluationRecordList) {
            System.out.println(evaluationRecord.toString());
        }
    }*/

    public void startOutputEvaluationRecords(List<EvaluationRecord> evaluationRecordList) {
        if (evaluationRecordList.size() == 0) {
            System.out.println("There are no evaluation records yet!");
        } else {
            String format = "|%1$-13s|%2$-25s|%3$-13s|%4$-13s|%5$-7s|%6$-20s|%n";
            String str = "";
            System.out.format(format, "goalID", "goalDescription", "targetValue", "actualValue", "year", "salesManID");
            System.out.format(format, "=============", "=========================", "=============", "=============", "=======", "====================");
            for (EvaluationRecord evaluationRecord : evaluationRecordList) {
                str = evaluationRecord.getGoalDescription();
                str += "\n"; // Needed to handle last line correctly
                str = str.replaceAll("(.{1,25})\\s+", "$1\n");
                String[] strArray = str.split("\n");
                System.out.format(
                        format,
                        evaluationRecord.getGoalID(),
                        strArray[0],
                        evaluationRecord.getTargetValue(),
                        evaluationRecord.getActualValue(),
                        evaluationRecord.getYear(),
                        evaluationRecord.getSalesManID()
                );
                for (int i = 1; i < strArray.length; i++ ) {
                    System.out.format(
                            format,
                            "",
                            strArray[i],
                            "",
                            "",
                            "",
                            ""
                    );
                }
            }
        }
    }
}
