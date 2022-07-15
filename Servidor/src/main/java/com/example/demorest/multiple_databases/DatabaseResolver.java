package com.example.demorest.multiple_databases;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DatabaseResolver implements CurrentTenantIdentifierResolver {
    @Value("${bd.databasename}")
    private String defaultDatabaseName;

    @Override
    public String resolveCurrentTenantIdentifier() {
        String currentDatabaseName =  DatabaseContext.getCurrentDatabase();
        if(currentDatabaseName!=null){
            return currentDatabaseName;
        } else {
            return defaultDatabaseName;
        }
    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return true;
    }
}
