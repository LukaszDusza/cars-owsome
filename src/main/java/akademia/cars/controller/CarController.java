package akademia.cars.controller;

import akademia.cars.exceptions.AlreadyExist;
import akademia.cars.exceptions.NotFoundException;
import akademia.cars.model.Car;
import akademia.cars.model.dtos.CarDTO;
import akademia.cars.service.CarService;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @PostMapping("/dto/cars")
    public ResponseEntity<?> addCar(@RequestBody CarDTO carDTO) throws AlreadyExist {
        if (!carService.addCar(carDTO)) {
            return new ResponseEntity<>(HttpStatus.CONFLICT); //409
        } else {
            return new ResponseEntity<>(HttpStatus.CREATED); //201
        }
    }

    @PostMapping("/dto/cars/param")
    public ResponseEntity<?> addCarParams(

            @RequestParam(value = "brand", required = false) String brand,
            @RequestParam(value = "model", required = false) String model,
            @RequestParam(value = "power", required = false) String power,
            @RequestParam(value = "plate", required = false) String plate,
            @RequestParam(value = "message", required = false) String message

    ) throws AlreadyExist {

        if (message == null) {
            message = "no message";
        }

        if (!carService.addCar(new CarDTO(
                        brand, model, power, plate, message
                )
        )) {
            return new ResponseEntity<>(HttpStatus.CONFLICT); //409
        } else {
            return new ResponseEntity<>(HttpStatus.CREATED); //201
        }
    }

    @DeleteMapping("/dto/cars/{plate}")
    public ResponseEntity<?> deleteCar(@PathVariable String plate) throws NotFoundException {

        if(carService.deleteCar(plate)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
           // throw new NotFoundException("Car not exist!");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/dto/cars/{plate}")
    public CarDTO updateCarByPlate(
            @PathVariable(value = "plate") String plate,
            @RequestBody CarDTO carDto) throws NotFoundException {
        return carService.updateCarByPlate(plate, carDto);
    }



}
