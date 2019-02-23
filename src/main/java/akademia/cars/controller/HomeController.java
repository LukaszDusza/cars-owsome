package akademia.cars.controller;

import akademia.cars.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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



}
