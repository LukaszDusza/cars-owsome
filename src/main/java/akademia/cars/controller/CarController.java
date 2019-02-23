package akademia.cars.controller;

import akademia.cars.model.Car;
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

}
