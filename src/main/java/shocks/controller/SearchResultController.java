package shocks.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SearchResultController {

   @RequestMapping("showresults")
    public String showResults(Model model){

        return "showresults";
    }
}
