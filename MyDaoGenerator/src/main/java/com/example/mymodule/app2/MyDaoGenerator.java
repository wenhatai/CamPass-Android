package com.example.mymodule.app2;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class MyDaoGenerator {
    public static void main(String[] args) throws Exception{
        Schema schema = new Schema(1,"net.bingyan.campass");

        addModule(schema);
        addCache(schema);
        new DaoGenerator().generateAll(schema,"../app/src-gen");
    }

    private static void addModule(Schema schema){
        Entity module = schema.addEntity("Module");
        module.addIdProperty().autoincrement();
        module.addStringProperty("name").notNull();
        module.addIntProperty("frequency");
        module.addIntProperty("iconid");
        module.addStringProperty("classname");
    }

    private static void addCache(Schema schema){
        Entity cache = schema.addEntity("Cache");
//        cache.addIdProperty().autoincrement();
        cache.addStringProperty("name").notNull().primaryKey();
        cache.addStringProperty("json");
        cache.addDateProperty("date");
    }
}