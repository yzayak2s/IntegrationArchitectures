package de.hbrs.ia.view;

import de.hbrs.ia.model.SalesMan;

import java.util.List;

public class SalesManView {

    public void dumpSalesMan(List<SalesMan> salesManList) {
        for (SalesMan salesMan : salesManList) {
            System.out.println(salesMan.toString());
        }
    }
}
