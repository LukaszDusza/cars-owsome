package akademia.cars.service;

import akademia.cars.exceptions.AlreadyExistException;
import akademia.cars.exceptions.NotFoundException;
import akademia.cars.mappers.CarMapper;
import akademia.cars.model.Car;
//import akademia.cars.repository.CarRepository;
import akademia.cars.model.dtos.CarDTO;
import akademia.cars.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
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

    public Optional<Car> getCarByPlateOptional(String plate) {
        return carRepository.findCarByPlate(plate);
    }

    public List<CarDTO> getCarsDto() {

        List<CarDTO> carDTOS = new ArrayList<>();

        carRepository
                .findAll()
                .stream()
                .map(c -> carDTOS.add(carMapper.map(c)))
                .collect(Collectors.toList());

        return carDTOS;
    }

    public boolean deleteCar(String plate) throws NotFoundException {
        Optional<Car> car = carRepository.findCarByPlate(plate);

        if (car.isPresent()) {
            carRepository.deleteById(car.get().getId());
            return true;
        } else {
            return false;
        }
    }

    public boolean addCar(CarDTO carDto) throws AlreadyExistException {

        Optional<Car> car = carRepository.findCarByPlate(carDto.getPlate());

        if (car.isPresent()) {
            throw new AlreadyExistException();
        } else {

//            Car carDao = new Car(
//                    carDto.getBrand(),
//                    carDto.getModel(),
//                    carDto.getPower(),
//                    carDto.getPlate()
//            );
//
//            carRepository.save(carDao);

            //if car plate is blank.
            if(carDto.getPlate().equals("")) {
                Random random = new Random();
                carDto.setPlate("rand" + random.nextInt(500));
            }

            carRepository.save(
                    Car.builder()
                            .brand(carDto.getBrand())
                            .model(carDto.getModel())
                            .power(carDto.getPower())
                            .plate(carDto.getPlate())
                            .build()
            );

            return true;
        }

    }

    public Car addNewCar(CarDTO carDto) throws AlreadyExistException {
        if(!carRepository.findCarByPlate(carDto.getPlate()).isPresent()) {
           return carRepository.save(
                    Car.builder()
                    .brand(carDto.getBrand())
                    .model(carDto.getModel())
                    .power(carDto.getPower())
                    .plate(carDto.getPlate())
                    .build()
            );
        }
         throw new AlreadyExistException();
    }

    public CarDTO updateCarByPlate(String plate, CarDTO carDTO) throws NotFoundException {

        Optional<Car> car = carRepository.findCarByPlate(plate);

        if(car.isPresent()) {

            car.get().setBrand(carDTO.getBrand());
            car.get().setModel(carDTO.getModel());
            car.get().setPower(carDTO.getPower());
            car.get().setPlate(carDTO.getPlate());

            carRepository.save(car.get());

            return carMapper.map(car.get());
        }
        throw new NotFoundException();
    }




}
