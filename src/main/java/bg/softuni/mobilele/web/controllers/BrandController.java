package bg.softuni.mobilele.web.controllers;

import bg.softuni.mobilele.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/brands")
public class BrandController extends BaseController {
    private final BrandService brandService;

    @Autowired
    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/all")
    public ModelAndView getAllBrands() {
        ModelAndView modelAndView = new ModelAndView("brands");
        modelAndView.addObject("brands", brandService.getAllBrands());
        return modelAndView;
    }
}
