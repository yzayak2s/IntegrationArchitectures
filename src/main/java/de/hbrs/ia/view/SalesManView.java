package de.hbrs.ia.view;

import de.hbrs.ia.model.SalesMan;

import java.util.List;

public class SalesManView {

    /*public void dumpSalesMan(List<SalesMan> salesManList) {
        for (SalesMan salesMan : salesManList) {
            System.out.println(salesMan.toString());
        }
    }*/

    public void startOutputSalesMen(List<SalesMan> salesManList) {
        if (salesManList.size() == 0) {
            System.out.println("There are no salesmen yet!");
        } else {
            String format = "|%1$-20s|%2$-20s|%3$-20s|%n";
            System.out.format(format, "ID", "Firstname", "Lastname");
            System.out.format(format, "====================", "====================", "====================");
            for (SalesMan salesMan : salesManList) {
                System.out.format(
                        format,
                        salesMan.getId(),
                        salesMan.getFirstname(),
                        salesMan.getLastname()
                );
            }
        }
    }
}
