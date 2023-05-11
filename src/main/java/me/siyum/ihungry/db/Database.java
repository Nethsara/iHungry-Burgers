package me.siyum.ihungry.db;

import me.siyum.ihungry.model.Customer;
import me.siyum.ihungry.model.Order;

import java.util.Objects;

public class Database {
    public static Customer[] customerArray = new Customer[0];
    public static Order[] orderArray = new Order[0];

    public static boolean addToDatabase(Customer obj) {
//        if (!checkDuplicates(customerArray, obj)) {
            Object[] objects = addToArray(customerArray, obj);
            Customer[] cs = new Customer[objects.length];
            for (int i = 0; i < objects.length; i++) {
                cs[i] = (Customer) objects[i];
            }
            customerArray = cs;
            return true;
//        }
//        return false;
    }

    public static boolean addToDatabase(Order obj) {
        try {
            Object[] objects = addToArray(orderArray, obj);
            Order[] cs = new Order[objects.length];
            for (int i = 0; i < objects.length; i++) {
                cs[i] = (Order) objects[i];
            }
            orderArray = cs;
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public static Object[] addToArray(Object[] objects, Object item) {
        objects = increment(objects);
        objects[objects.length - 1] = item;
        return objects;
    }

    public static Object[] increment(Object[] objects) {
        Object[] newObjects = new Object[objects.length + 1];
        for (int i = 0; i < objects.length; i++) {
            newObjects[i] = objects[i];
        }
        return newObjects;
    }

    public static boolean checkDuplicates(Customer[] objects, Customer item) {
        for (Customer customer : objects) {
            if (Objects.equals(customer.getId(), item.getId())) return true;
        }
        return false;
    }

    public static Customer getCustomer(String id) {
        for (Customer o : customerArray
        ) {
            if (o.getId().equals(id)) {
                return o;
            }
        }
        return null;
    }

    public static int getOrder(String id) {
        for (int i = 0; i < orderArray.length; i++) {
            if (orderArray[i].getOrderId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public static double getOrderTotalByCustID(String id) {
        double x = 0;
        for (Order o : orderArray
        ) {
            if (o.getCustID().equals(id)) {
                x += o.getQty() * 500;
            }
        }
        System.out.println(x + " total ");
        return x;
    }
}
