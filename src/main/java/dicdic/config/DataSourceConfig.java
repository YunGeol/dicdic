package dicdic.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Driver;

@Configuration
@MapperScan(basePackages="dicdic.persistence.mapper")
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


    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        return sessionFactory.getObject();
    }
}
