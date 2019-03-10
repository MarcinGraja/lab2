package com.company;

import java.util.*;

import static com.company.ItemCondition.*;

public class FulfillmentCenter {
    private String name;
    public ArrayList <Item> listOfProducts = new ArrayList<>();
    private double capacity;
    private double currentCapacity;
    FulfillmentCenter(String name, int capacity){
        this.name = name;
        this.capacity=capacity;
    }
    public void addProduct(Item item){
        if (currentCapacity<item.getCount()*item.getMass()){
            System.err.println("Brak miejsca w magazynie; Wymagane miejsce: " + item.getCount()*item.getMass() + "; dostępne: " + currentCapacity);
        }
        if (listOfProducts.contains(item)){
            Item listedItem = listOfProducts.get(listOfProducts.indexOf(item));
            listedItem.setCount(listedItem.getCount()+item.getCount());
        }
        else{
            Item newItem = new Item(item.getName(), item.getCondition(), item.getMass(), item.getCount());
            listOfProducts.add(newItem);
        }
        currentCapacity-=item.getCount()*item.getMass();
    }
    public void getProduct(Item item){
        if (listOfProducts.indexOf(item)==-1){
            System.err.println("brak takiego produktu; funkcja getProduct");
            return;
        }
        Item listedItem = listOfProducts.get(listOfProducts.indexOf(item));
        currentCapacity+=listedItem.getMass();
        if (listedItem.getCount()==1){
            listOfProducts.remove(listedItem);
            return;
        }
        listedItem.setCount(listedItem.getCount()-1);
    }
    public void removeProduct(Item item){
        if (listOfProducts.indexOf(item)==-1) {
            System.err.println("brak takiego produktu; funkcja removeProduct");
        }
        else{
            Item listedItem = listOfProducts.get(listOfProducts.indexOf(item));
            currentCapacity+=listedItem.getMass()*listedItem.getCount();
            listOfProducts.remove(item);
        }
    }
    public List search(String name){
        Iterator iterator = listOfProducts.iterator();
        List<Item> returned = new ArrayList<>();
        while (iterator.hasNext()){
            Item item = (Item) iterator.next();
            if ((item.getName().equals(name))){
                returned.add(item);
            }
        }
        return returned;
    }
    public List searchPartial(String partialName){
        Iterator iterator = listOfProducts.iterator();
        List<Item> returned = new ArrayList<>();
        while (iterator.hasNext()){
            Item item = (Item) iterator.next();
            if ((item.getName().contains(name))){
                returned.add(item);
            }
        }
        return returned;
    }
    public int[] countByCondition() {
        Iterator iterator = listOfProducts.iterator();
        int[] returned = new int[3];
        while (iterator.hasNext()) {
            Item item = (Item) iterator.next();
            returned[item.getCondition().ordinal()] += item.getCount();
        }
        return returned;
    }
    public void summary(){
        for(Item item: listOfProducts){
            item.print();
        }
    }
    public List sortByName(){
        return listOfProducts.sort(new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.compareTo(o2);
            }
        });
    }
    public double getCapacity(){
        return capacity;
    }
    public void print(){
        Iterator iterator = listOfProducts.iterator();
        while (iterator.hasNext()){
            Item item= (Item)iterator.next();
            item.print();
        }
    }
}
