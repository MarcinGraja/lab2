package com.company;

import java.util.*;

import static com.company.ItemCondition.*;

public class FulfillmentCenter {
    private String name;
    public ArrayList <Item> listOfProducts = new ArrayList<>();
    private int capacity;
    FulfillmentCenter(String name, int capacity){
        this.name = name;
        this.capacity=capacity;
    }
    public void addProduct(Item item){
        if (listOfProducts.contains(item)){
            Item listedItem = listOfProducts.get(listOfProducts.indexOf(item));
            listedItem.setCount(listedItem.getCount()+item.getCount());

        }
        else{
            Item newItem = new Item(item.getName(), item.getCondition(), item.getMass(), item.getCount());
            listOfProducts.add(newItem);
        }
    }
    public void getProduct(Item item){
        if (listOfProducts.indexOf(item)==-1){
            System.err.println("brak takiego produktu; funkcja getProduct");
            return;
        }
        Item listedItem = listOfProducts.get(listOfProducts.indexOf(item));
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
    public int getCapacity(){
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
