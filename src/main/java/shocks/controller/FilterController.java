package shocks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import shocks.model.FilterKeeper;
import shocks.service.FilterService;



@org.springframework.stereotype.Controller
public class FilterController {

    private FilterService filterService;

    @Autowired
    @Qualifier(value = "filterService")
    public void setFilterService(FilterService filterService) {
        this.filterService = filterService;
    }

    @RequestMapping(value = "filterbycar")
    public String filterByCar (Model model){
        FilterKeeper keeper = (FilterKeeper) model.asMap().get("fk");
        if (keeper!=null){
            model.addAttribute("filterKeeper",keeper);
        }
        else{
            FilterKeeper newKeeper = new FilterKeeper();
            newKeeper = this.filterService.getYears(newKeeper);
            model.addAttribute("filterKeeper",newKeeper);
        }

        return "filterbycar";
    }

    @RequestMapping("filterbyyear")
    private String filterByYear(@ModelAttribute("filterKeeper") FilterKeeper keeper, RedirectAttributes attrs){
        FilterKeeper makeKeeper = this.filterService.getCarMakes(keeper);
        attrs.addFlashAttribute("fk", makeKeeper);

        return "redirect:/filterbycar";

    }
    @RequestMapping("filterbymake")
    private String filterByMake(@ModelAttribute("filterKeeper") FilterKeeper keeper, RedirectAttributes attrs){
        FilterKeeper modelKeeper = this.filterService.getCarModels(keeper);
        attrs.addFlashAttribute("fk", modelKeeper);

        return "redirect:/filterbycar";

    }

    @RequestMapping("filterbymodel")
    private String filterByModel(@ModelAttribute("filterKeeper") FilterKeeper keeper, RedirectAttributes attrs){
        FilterKeeper driveKeeper = this.filterService.getDrives(keeper);
        attrs.addFlashAttribute("fk", driveKeeper);
        /*if (!driveKeeper.isHasDriveInfo()){
            return "redirect:/showresults";
        }*/

        return "redirect:/filterbycar";
    }

    @RequestMapping("filterbydrive")
    private String filterByDrive(@ModelAttribute("filterKeeper") FilterKeeper keeper, RedirectAttributes attrs){
        FilterKeeper driveKeeper = this.filterService.getDrives(keeper);
        attrs.addFlashAttribute("fk", driveKeeper);

        return "redirect:/filterbycar";

    }

}
