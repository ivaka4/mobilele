package bg.softuni.mobilele.web.controllers;

import bg.softuni.mobilele.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController extends BaseController{
    private final UserService userService;

    @Autowired
    public HomeController(UserService userService) {
        this.userService = userService;
    }
//    private final BrandService brandService;
//    private final OfferService offerService;
//    private final ModelService modelService;

//    @Autowired
//    public HomeController(UserService userService, BrandService brandService, OfferService offerService, ModelService modelService) {
//        this.userService = userService;
//        this.brandService = brandService;
//        this.offerService = offerService;
//        this.modelService = modelService;
//    }


    @GetMapping("/")
    public String index(){
        return "index";
    }
}
