package cz.mendelu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import javax.sql.DataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "cz.mendelu")
@EnableTransactionManagement
public class EshopConfig {
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean em=
                new LocalContainerEntityManagerFactoryBean ();
        em.setPackagesToScan("cz.mendelu.dao.domain");
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        em.setDataSource(dataSource());
        em.setJpaProperties(additionalProperties());
        return em;
    }

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName(org.postgresql.Driver.class.getName());
        dataSource.setUrl("jdbc:postgresql://dev-postgres:5432/postgres");
        dataSource.setUsername("postgres");
        dataSource.setPassword("mysecretpassword");
        return dataSource;
    }

    private Properties additionalProperties(){
        Properties props=new Properties();
        props.setProperty("hibernate.hbm2ddl.auto","create");
        props.setProperty("hibernate.dialect","org.hibernate.dialect.PostgreSQLDialect");
        props.setProperty("hibernate.show_sql","true");
        props.setProperty("hibernate.format_sql","true");
        return props;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }

}
