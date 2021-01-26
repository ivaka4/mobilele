package bg.softuni.mobilele.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/offers")
public class OfferController {

    @GetMapping("/add")
    public ModelAndView getAddOfferView() {
        return new ModelAndView("offer-add");
    }

    @GetMapping("all")
    public ModelAndView getAllOffers() {
        return new ModelAndView("offers");
    }
}
