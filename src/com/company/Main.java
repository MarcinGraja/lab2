package com.company;
import java.util.*;

import static com.company.ItemCondition.*;

public class Main {

    public static void main(String[] args) {
        Item item = new Item("Paweł Hozer", NEW, 98, 1 /* niepowtarzalny */);
        FulfillmentCenter fulfillmentCenter = new FulfillmentCenter("tyle było dni", 3000000);
        fulfillmentCenter.addProduct(item);
        fulfillmentCenter.addProduct(item);
        fulfillmentCenter.addProduct(item);
        fulfillmentCenter.addProduct(new Item("asdf", USED, 124125, 3));
        fulfillmentCenter.addProduct(new Item("asdf", USED, 124125, 3));
        fulfillmentCenter.addProduct(new Item("asdf", USED, 124125, 2));
        fulfillmentCenter.print();
        fulfillmentCenter.removeProduct(new Item("asdf", USED, 124125));
        fulfillmentCenter.print();
        System.out.println("\n\n\na tutaj trzymamy maina");
        System.out.println(item.getMass());
    }
}
