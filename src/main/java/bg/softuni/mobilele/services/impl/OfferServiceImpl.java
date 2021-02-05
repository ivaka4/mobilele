package bg.softuni.mobilele.services.impl;

import bg.softuni.mobilele.models.entities.Model;
import bg.softuni.mobilele.models.entities.Offer;
import bg.softuni.mobilele.models.view.OfferDetailsViewModel;
import bg.softuni.mobilele.models.view.OfferSummaryViewModel;
import bg.softuni.mobilele.models.view.OfferUploadModel;
import bg.softuni.mobilele.models.view.UpdateOfferViewModel;
import bg.softuni.mobilele.repositories.ModelRepository;
import bg.softuni.mobilele.repositories.OfferRepository;
import bg.softuni.mobilele.services.OfferService;
import bg.softuni.mobilele.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {
    private final ModelMapper modelMapper;
    private final OfferRepository offerRepository;
    private final UserService userService;
    private final ModelRepository modelRepository;

    @Autowired
    public OfferServiceImpl(ModelMapper modelMapper, OfferRepository offerRepository, UserService userService, ModelRepository modelRepository) {
        this.modelMapper = modelMapper;
        this.offerRepository = offerRepository;
        this.userService = userService;
        this.modelRepository = modelRepository;
    }

    @Override
    public void uploadOffer(OfferUploadModel offerUploadModel) {

        Offer newOffer = asNewOffer(offerUploadModel);

        Model model = modelRepository.findById(offerUploadModel.getModelId()).
                orElse(null);

        newOffer.setModel(model);
        newOffer.setSeller(userService.getRandomUser());
        offerRepository.save(newOffer);
    }

    private Offer asNewOffer(OfferUploadModel offerServiceModel) {
        ModelMapper modelMapper = new ModelMapper();

        Offer newOffer = new Offer();

        modelMapper.map(offerServiceModel, newOffer);

        newOffer.setCreated(Instant.now());
        newOffer.setModified(Instant.now());
        newOffer.setId(null);

        return newOffer;
    }

    @Override
    public List<OfferSummaryViewModel> getAllOffers() {
        List<Offer> offerEntities = offerRepository.findAll();

        return offerEntities.
                stream().
                map(OfferServiceImpl::mapToSummary).
                collect(Collectors.toList());
    }

    @Override
    public Optional<OfferDetailsViewModel> getOfferDetails(long id) {
        return offerRepository.findById(id).map(OfferServiceImpl::mapToDetails);
    }

    @Override
    public void updateOffer(Long id, UpdateOfferViewModel updateOfferViewModel) {
        Offer offer = this.modelMapper.map(updateOfferViewModel, Offer.class);
        offer.setModified(Instant.now());
        offer.setCreated(offerRepository.findById(id).get().getCreated());
        this.offerRepository.saveAndFlush(offer);
    }

    @Override
    public void deleteOffer(Long id) {
        this.offerRepository.delete(this.offerRepository.findById(id).get());
    }

    private static OfferSummaryViewModel mapToSummary(Offer offerEntity) {
        OfferSummaryViewModel offerModel = new OfferSummaryViewModel();
        mapToSummary(offerEntity, offerModel);
        return offerModel;
    }

    private static void mapToSummary(Offer offerEntity, OfferSummaryViewModel offerModel) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(offerEntity, offerModel);
        offerModel.
                setModel(offerEntity.getModel().getName()).
                setBrand(offerEntity.getModel().getBrand().getName());
    }

    private static OfferDetailsViewModel mapToDetails(Offer offerEntity) {
        OfferDetailsViewModel offerModel = new OfferDetailsViewModel();
        mapToSummary(offerEntity, offerModel);
//    offerModel.
//        setSellerFirstName(offerEntity.getSeller().getFirstName()).
//        setSellerLastName(offerEntity.getSeller().getLastName());
        return offerModel;
    }
}
