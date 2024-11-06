package peaksoft.repo.repoImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.stereotype.Repository;
import peaksoft.Car;
import peaksoft.repo.CarRepo;
import peaksoft.springConfig.SpringConfig;

import java.util.List;

@Repository
public class CarRepoImpl implements CarRepo, AutoCloseable {
    private final EntityManager entityManager = SpringConfig.getEntityManager().createEntityManager();

    @Override
    public String saveCar(Car car) {
        entityManager.getTransaction().begin();
        entityManager.persist(car);
        entityManager.getTransaction().commit();
        return "Success!";
    }

    @Override
    public Car getById(Long id) {
        entityManager.getTransaction().begin();
        Car car = entityManager.createQuery("select c from Car c where c.id = :id", Car.class)
                .setParameter("id", id)
                .getSingleResult();
        entityManager.getTransaction().commit();
        return car;
    }

    @Override
    public List<Car> getAll() {
        entityManager.getTransaction().begin();
        List<Car> cars = entityManager.createQuery("select c from Car c", Car.class).getResultList();
        entityManager.getTransaction().commit();
        return cars;
    }

    @Override
    public String updateCar(Long id, Car newCar) {
        Car car = getById(id);
        entityManager.getTransaction().begin();
        car.setName(newCar.getName());
        car.setBrand(newCar.getBrand());
        entityManager.getTransaction().commit();
        return "Success!";
    }

    @Override
    public String deleteCar(Long id) {
        Car car = getById(id);
        entityManager.getTransaction().begin();
        entityManager.remove(car);
        entityManager.getTransaction().commit();
        return "Success!";
    }

    @Override
    public void close() throws Exception {
        entityManager.close();
    }
}
