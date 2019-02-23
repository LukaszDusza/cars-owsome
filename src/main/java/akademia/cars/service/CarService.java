package akademia.cars.service;

import akademia.cars.mappers.CarMapper;
import akademia.cars.model.Car;
//import akademia.cars.repository.CarRepository;
import akademia.cars.model.dtos.CarDTO;
import akademia.cars.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {

    private CarRepository carRepository;
    private CarMapper carMapper;

    //DI - dependency injection //Adn. @Autowired jest nie wymagana


    public CarService(CarRepository carRepository, CarMapper carMapper) {
        this.carRepository = carRepository;
        this.carMapper = carMapper;
    }

    public List<Car> getCars() {
       // System.out.println(carRepository.findAll());
        return carRepository.findAll();
    }

    public Car getCarByPlate(String plate) {
        return carRepository.findCarByPlate(plate).get();
    }

    //---------- DTO ---------------------------------------

    public List<CarDTO> getCarsDto() {

        List<CarDTO> carDTOS = new ArrayList<>();
      //  List<Car> cars = carRepository.findAll();

        for (Car car: carRepository.findAll()) {
            carDTOS.add(carMapper.map(car));
        }

//        List<CarDTO> cardtos =carRepository.findAll()
//                .stream()
//                .map(c -> carDTOS.add(carMapper.map(c)


        return carDTOS;
    }



}
