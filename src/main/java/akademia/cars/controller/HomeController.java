package akademia.cars.controller;

import akademia.cars.exceptions.AlreadyExistException;
import akademia.cars.exceptions.NotFoundException;
import akademia.cars.model.dtos.CarDTO;
import akademia.cars.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller

public class HomeController {

    private CarService carService;

    public HomeController(CarService carService) {
        this.carService = carService;
    }

    @RequestMapping("/")
    public String getHomePage(Model model) {
        String welcome = "Welcome to my owsome Cars App!";
        model.addAttribute("welcome", welcome);
        model.addAttribute("cars", carService.getCars());
        return "index";
    }

    @PostMapping("add")
    public String addCar(@ModelAttribute CarDTO car) throws AlreadyExistException {
        carService.addCar(car);

        //todo add methods

        return "redirect:/";
    }

    @GetMapping("del")
    public String deleteCar(@RequestParam(value = "plate") String plate) throws NotFoundException {
        carService.deleteCar(plate);
        return "redirect:/";
    }

    @PostMapping("update")
    public String updateCar(@ModelAttribute CarDTO car, Model model) {
        model.addAttribute("car", car);
        model.addAttribute("oldplate", car.getPlate());
        return "update";
    }

    @PostMapping("upd")
    public String updateCarByPlate(@ModelAttribute CarDTO car, @RequestParam String param) throws NotFoundException {
     //   System.out.println(param);
        carService.updateCarByPlate(param, car);

        return "redirect:/";
    }

}