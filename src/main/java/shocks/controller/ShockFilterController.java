package shocks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import shocks.model.ShockFilter;
import shocks.service.ShockFilterService;

@Controller
public class ShockFilterController {

    @Autowired
    @Qualifier(value = "shockFilterService")
    private ShockFilterService shockFilterService;

    @RequestMapping(value = "filterbyshock")
    public String filterByShock(Model model){
        ShockFilter filterKeep = (ShockFilter)model.asMap().get("keeper");
        if (filterKeep==null){
            filterKeep = new ShockFilter();
            this.shockFilterService.populateFilters(filterKeep);
        }
        model.addAttribute("keeper", filterKeep);

        return "filterbyshock";
    }

    @RequestMapping(value = "processinput")
    public String processInput(@ModelAttribute("keeper") ShockFilter keeper, RedirectAttributes attrs){
        System.out.println(keeper);
        this.shockFilterService.populateFilters(keeper);
        attrs.addFlashAttribute("keeper", keeper);
        return "redirect:/filterbyshock";
    }

}
