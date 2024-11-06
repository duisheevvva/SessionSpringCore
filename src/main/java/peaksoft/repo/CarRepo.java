package peaksoft.repo;

import peaksoft.Car;

import java.util.List;

public interface CarRepo {
    String saveCar(Car car);
    Car getById(Long id);
    List<Car> getAll();
    String updateCar(Long id, Car newCar);
    String deleteCar(Long id);


}
