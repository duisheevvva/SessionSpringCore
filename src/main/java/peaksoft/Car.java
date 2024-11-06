package peaksoft;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


@Entity
@Table(name = "cars")
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(generator = "car_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "car_gen", sequenceName = "car_seq", allocationSize = 1, initialValue = 10)
    Long id;
    String name;
    String brand;

    public Car(String name, String brand) {
        this.name = name;
        this.brand = brand;
    }
}
