package bg.softuni.mobilele.services;

import bg.softuni.mobilele.models.view.OfferDetailsViewModel;
import bg.softuni.mobilele.models.view.OfferSummaryViewModel;
import bg.softuni.mobilele.models.view.OfferUploadModel;
import bg.softuni.mobilele.models.view.UpdateOfferViewModel;

import java.util.List;
import java.util.Optional;

public interface OfferService {

    void uploadOffer(OfferUploadModel offerUploadModel);

    List<OfferSummaryViewModel> getAllOffers();

    Optional<OfferDetailsViewModel> getOfferDetails(long id);

    void updateOffer(Long id, UpdateOfferViewModel updateOfferViewModel);

    void deleteOffer(Long id);
}
