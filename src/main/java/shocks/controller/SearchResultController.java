package shocks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import shocks.model.*;
import shocks.service.CarService;
import shocks.service.ShockService;

import java.util.List;

@Controller
public class SearchResultController {

    @Autowired
    @Qualifier(value = "carService")
    private CarService carService;

    @Autowired
    @Qualifier(value = "shockService")
    private ShockService shockService;

   @RequestMapping("showresults")
    public String showResults(Model model, @ModelAttribute ("filterKeeper")FilterKeeper keeper){
       List<Car> cars = this.carService.getCars(keeper);
       model.addAttribute("Cars", cars);
       model.addAttribute("partno", new ShockAbsorberRev());

        return "showresults";
    }

    @RequestMapping("showresultsbyshock")
    public String showResultByShock(Model model, @ModelAttribute ("keeper")ShockFilter shockFilter){
        List<ShockAbsorber> shocks = this.shockService.getShocks(shockFilter);
        model.addAttribute("Shocks", shocks);
        model.addAttribute("partno", new ShockAbsorberRev());

       return "showresbyshock";
    }

    @RequestMapping("shockdata")
    public String showData(Model model, @ModelAttribute("partno") ShockAbsorberRev partNo){
       ShockAbsorberRev shock = shockService.getShock(partNo.getPartNo());
       model.addAttribute("shock", shock);

       return "shockdata";
    }

    public void setCarService(CarService carService) {
        this.carService = carService;
    }

    public void setShockService(ShockService shockService) {
        this.shockService = shockService;
    }
}
