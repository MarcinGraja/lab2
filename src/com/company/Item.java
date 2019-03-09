package com.company;
enum ItemCondition{
    NEW, USED, REFURBISHED;
}
public class Item implements Comparable<Item>{
    private String name;
    private ItemCondition condition;
    private double mass;
    private int count;
    Item(String name, ItemCondition condition, double mass, int count){
        this.name=name;
        this.condition=condition;
        this.mass=mass;
        this.count=count;
    }
    public void print(){
        System.out.println("Nazwa produktu: " + name + " stan: " + condition + " masa: " + mass + " ilosc: " + count);
    }
    public int compareTo(Item compared){
        return this.name.compareTo(compared.name);
    }
    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (this.getClass()!=obj.getClass()){
            return false;
        }
        Item compared = (Item) obj;
        return (this.name.equals(compared.name) && this.condition == compared.condition && this.mass == compared.mass);
    }
    public String getName(){
        return name;
    }
    public ItemCondition getCondition(){
        return condition;
    }

    public double getMass() {
        return mass;
    }

    public int getCount(){
        return this.count;
    }
    public void setCount(int count){
        this.count = count;
    }

}
