package akademia.cars.controller;

import akademia.cars.exceptions.AlreadyExist;
import akademia.cars.exceptions.NotFoundException;
import akademia.cars.model.Car;
import akademia.cars.model.dtos.CarDTO;
import akademia.cars.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class HomeController {

    private CarService carService;

    public HomeController(CarService carService) {
        this.carService = carService;
    }

    @RequestMapping("home")
    public String getHomePage(Model model) {
        String welcome = "Welcome to my owsome Cars App!";
        model.addAttribute("welcome", welcome);
        model.addAttribute("cars", carService.getCars());
        return "index";
    }

    @PostMapping("add")
    public String addCar(@Valid @ModelAttribute CarDTO car) throws AlreadyExist {
        carService.addCar(car);

        //todo add methods

        return "redirect:/home";
    }

    @GetMapping("del")
    public String deleteCar(@RequestParam(value = "plate") String plate) throws NotFoundException {
        carService.deleteCar(plate);
        return "redirect:/home";
    }

    @PostMapping("update")
    public String updateCar(@Valid @ModelAttribute CarDTO car, Model model) {
        model.addAttribute("car", car);
        return "update";
    }

    @PostMapping("upd")
    public String updateCarByPlate(@Valid @ModelAttribute CarDTO car, @RequestParam String plate) throws NotFoundException {
        System.out.println(plate);
        carService.updateCarByPlate(plate, car);

        return "redirect:/home";
    }

}
