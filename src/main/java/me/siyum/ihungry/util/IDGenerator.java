package me.siyum.ihungry.util;

import me.siyum.ihungry.db.Database;

public class IDGenerator {
    public static String getID() {
        String id = "O-1";
        if (Database.orderArray.length < 1) {
            return id;
        }
        String last = Database.orderArray[Database.orderArray.length - 1].getOrderId();
        String[] split = last.split("-");
        int l = Integer.parseInt(split[1]);
        id = "O-" + ++l;
        return id;
    }
}
