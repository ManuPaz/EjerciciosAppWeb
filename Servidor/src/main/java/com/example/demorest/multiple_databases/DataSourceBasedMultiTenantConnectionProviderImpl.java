package com.example.demorest.multiple_databases;

import com.example.demorest.services.InsercionesGrandesService;
import org.hibernate.engine.jdbc.connections.spi.AbstractDataSourceBasedMultiTenantConnectionProviderImpl;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@Component
public class DataSourceBasedMultiTenantConnectionProviderImpl extends AbstractDataSourceBasedMultiTenantConnectionProviderImpl {

    @Autowired
    private DataSource defaultDS;
    @Value("${bd.databasename}")
    private String defaultDatabaseName;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${bd.host}")
    private String url;
    private Map<String, DataSource> dataSources = new HashMap<>();

    @PostConstruct
    public void load() {
        dataSources.put(defaultDatabaseName, defaultDS);
    }

    private DataSource getDataSource(String name) {
        if (!dataSources.containsKey(name)) {

                final String urlCompleta = url + name;
                DataSourceBuilder factory = DataSourceBuilder
                        .create()
                        .username(username)
                        .password(password)
                        .url(urlCompleta);
                DataSource ds = factory.build();
                dataSources.put(name, ds);

        }
        return dataSources.get(name);
    }

    @Override
    protected DataSource selectAnyDataSource() {
        return dataSources.get(defaultDatabaseName);
    }

    @Override
    protected DataSource selectDataSource(String databaseName) {

        return  getDataSource(databaseName);
    }
}
