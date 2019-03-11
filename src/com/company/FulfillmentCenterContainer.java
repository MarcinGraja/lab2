package com.company;

import java.util.*;

public class FulfillmentCenterContainer {
    private List <FulfillmentCenter> listOfCenters;
    FulfillmentCenterContainer(){
        listOfCenters = new ArrayList<>();
    }
    public void addCenter(String name, double capacity){
        FulfillmentCenter fulfillmentCenter = new FulfillmentCenter(name, capacity);
        if (listOfCenters.indexOf(fulfillmentCenter)!=-1){
            System.out.println("Lista zawiera już " + fulfillmentCenter.getName());
        }
        listOfCenters.add(new FulfillmentCenter(name, capacity));
    }
    public void removeCenter(FulfillmentCenter fulfillmentCenter){
        if (listOfCenters.indexOf(fulfillmentCenter)==-1) {
            System.err.println("brak takiego produktu; funkcja removeProduct");
        }
        else{
            FulfillmentCenter listedFulfillmentCenter = listOfCenters.get(listOfCenters.indexOf(fulfillmentCenter));
            listOfCenters.remove(listedFulfillmentCenter);
        }
    }
    public List findEmpty(){
        List <FulfillmentCenter>returned = new ArrayList<>();
        for (FulfillmentCenter fulfillmentCenter: listOfCenters){
            if (fulfillmentCenter.getCapacity() == fulfillmentCenter.getCurrentCapacity()){
                returned.add(fulfillmentCenter);
            }
        }
        return returned;
    }
    public void summary(){
        for (FulfillmentCenter fulfillmentCenter: listOfCenters){
            System.out.println("nazwa: " + fulfillmentCenter.getName() + " zapełnienie: " + fulfillmentCenter.getCurrentCapacity() / fulfillmentCenter.getCurrentCapacity()*100 + "%");
        }
    }
}
