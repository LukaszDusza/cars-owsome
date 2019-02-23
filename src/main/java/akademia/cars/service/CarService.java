package akademia.cars.service;

import akademia.cars.model.Car;
//import akademia.cars.repository.CarRepository;
import akademia.cars.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private CarRepository carRepository;

    //DI - dependency injection //Adn. @Autowired jest nie wymagana

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getCars() {
        return carRepository.findAll();
    }

}
