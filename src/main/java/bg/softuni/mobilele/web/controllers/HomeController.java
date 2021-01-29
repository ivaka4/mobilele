package bg.softuni.mobilele.web.controllers;

import bg.softuni.mobilele.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController extends BaseController {
    private final UserService userService;

    @Autowired
    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public ModelAndView index(@AuthenticationPrincipal UserDetails user) {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("user", user != null ?
                user.getUsername() :
                "Anonymous");
        return modelAndView;
    }

//    @GetMapping("/home")
//    public String home(@AuthenticationPrincipal UserDetails user, Model model) {
//        model.addAttribute("user", user != null ?
//                user.getUsername() : null);
//        return "index";
//    }
}
