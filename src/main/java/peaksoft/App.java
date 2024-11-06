package peaksoft;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import peaksoft.repo.CarRepo;
import peaksoft.repo.repoImpl.CarRepoImpl;
import peaksoft.springConfig.SpringConfig;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        SpringConfig.getEntityManager();

        CarRepo carRepo = new CarRepoImpl();
//        System.out.println(carRepo.saveCar(new Car("Mercedes 124", "Mercedes Benz")));
//        System.out.println(carRepo.getById(10L));
//        System.out.println(carRepo.updateCar(10L, new Car("Kia K5", "kia")));
        System.out.println(carRepo.deleteCar(10L));
        System.out.println(carRepo.getAll());



    }
}
