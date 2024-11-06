package peaksoft.springConfig;

import jakarta.persistence.EntityManagerFactory;
import org.hibernate.HibernateException;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.context.annotation.PropertySource;
import peaksoft.Car;

import java.util.Properties;


@org.springframework.context.annotation.Configuration
@ComponentScan("peaksoft")
@PropertySource("classpath:application.properties")
public class SpringConfig {
    public static EntityManagerFactory getEntityManager() {
        try {
            Properties properties = new Properties();
            properties.put(Environment.DRIVER, "org.postgresql.Driver");
            properties.put(Environment.URL, "jdbc:postgresql://localhost:5432/java14");
            properties.put(Environment.USER, "postgres");
            properties.put(Environment.PASS, "1234");
            properties.put(Environment.HBM2DDL_AUTO, "update");
            properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
            properties.put(Environment.SHOW_SQL, "true");


            Configuration configuration = new Configuration();
            configuration.addProperties(properties);
            configuration.addAnnotatedClass(Car.class);

            return configuration.buildSessionFactory().unwrap(EntityManagerFactory.class);
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
