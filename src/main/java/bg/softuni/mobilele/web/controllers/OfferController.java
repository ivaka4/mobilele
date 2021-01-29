package bg.softuni.mobilele.web.controllers;

import bg.softuni.mobilele.models.enums.EngineEnum;
import bg.softuni.mobilele.models.enums.TransmissionEnum;
import bg.softuni.mobilele.models.view.OfferDetailsViewModel;
import bg.softuni.mobilele.models.view.OfferUploadModel;
import bg.softuni.mobilele.services.BrandService;
import bg.softuni.mobilele.services.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/offers")
public class OfferController extends BaseController {
    private final OfferService offerService;
    private final BrandService brandService;

    @Autowired
    public OfferController(OfferService offerService, BrandService brandService) {
        this.offerService = offerService;
        this.brandService = brandService;
    }

    @GetMapping("/add")
    public ModelAndView addOffers() {
        ModelAndView modelAndView = new ModelAndView("offer-add");
        modelAndView.addObject("engines", EngineEnum.values());
        modelAndView.addObject("transmissions", TransmissionEnum.values());
        modelAndView.addObject("brands", brandService.getAllBrands());
        modelAndView.addObject("formData", new OfferUploadModel());
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addOffersConfirm(OfferUploadModel offerUploadModel) {
        this.offerService.uploadOffer(offerUploadModel);
        return super.redirect("/offers/all");
    }

    @GetMapping("/all")
    public ModelAndView allOffers() {
        ModelAndView modelAndView = new ModelAndView("offers");
        modelAndView.addObject("offers", offerService.getAllOffers());
        return modelAndView;
    }

    @GetMapping("/details")
    public ModelAndView detailsOffers() {
        return new ModelAndView("details");
    }

    @GetMapping("/update")
    public ModelAndView getUpdateOffers() {
        return new ModelAndView("update");
    }

    @GetMapping("/{id}")
    public ModelAndView offerDetails(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("details");

        OfferDetailsViewModel offerDetailsModel = offerService.getOfferDetails(id).
                orElseThrow();

        modelAndView.addObject("offer", offerDetailsModel);

        return modelAndView;
    }


}
