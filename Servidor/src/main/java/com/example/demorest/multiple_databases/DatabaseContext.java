package com.example.demorest.multiple_databases;

public class DatabaseContext {
    private static ThreadLocal<String> currentDatabaseName = new InheritableThreadLocal<>();

    public static String getCurrentDatabase() {
        return currentDatabaseName.get();
    }

    public static void setCurrentSchema(String tenant) {
        currentDatabaseName.set(tenant);
    }

    public static void clear() {
        currentDatabaseName.set(null);
    }
}