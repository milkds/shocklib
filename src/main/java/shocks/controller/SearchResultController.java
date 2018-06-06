package shocks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import shocks.model.Car;
import shocks.model.FilterKeeper;
import shocks.service.CarService;

import java.util.List;

@Controller
public class SearchResultController {

    @Autowired
    @Qualifier(value = "carService")
    private CarService carService;

   @RequestMapping("showresults")
    public String showResults(Model model){
       FilterKeeper keeper = (FilterKeeper) model.asMap().get("fk");
       List<Car> cars = this.carService.getCars(keeper);
       model.addAttribute("Cars", cars);

        return "showresults";
    }

    public void setCarService(CarService carService) {
        this.carService = carService;
    }
}
