package akademia.cars.controller;

import akademia.cars.model.Car;
import akademia.cars.model.dtos.CarDTO;
import akademia.cars.service.CarService;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class CarController {

    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    //  @RequestMapping(value = "/cars", method = RequestMethod.GET)
    @GetMapping("/cars")
    public List<Car> getCars() {
        return carService.getCars();
    }

    @GetMapping("/cars/{plate}")
    public Car getCar(@PathVariable(value = "plate") String plate) {
        return carService.getCarByPlate(plate);
    }

    //---------------- DTO ------------------

    @GetMapping("/dto/cars")
    public List<CarDTO> getCarsDto() {
        return carService.getCarsDto();
    }



}
