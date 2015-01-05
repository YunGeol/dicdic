package dicdic.config;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Driver;

/**
 * Created by 1001073 on 2014-12-18.
 */
@Configuration
public class DataSourceConfig {

    /*
    @Value("${oracle.datasource.driverClassName}")
    private String databaseDriverClassName;

    @Value("${oracle.datasource.url}")
    private String datasourceUrl;

    @Value("${oracle.datasource.username}")
    private String databaseUsername;

    @Value("${oracle.datasource.password}")
    private String databasePassword;
    */


    @Bean
    public DataSource dataSource (
              @Value("${oracle.datasource.driverClassName}")    Class<Driver> driverClass
            , @Value("${oracle.datasource.url}")                String url
            , @Value("${oracle.datasource.username}")           String user
            , @Value("${oracle.datasource.password}")           String password
    ) throws PropertyVetoException
    {
        return new SimpleDriverDataSource(BeanUtils.instantiateClass(driverClass), url, user, password);
    }
}
