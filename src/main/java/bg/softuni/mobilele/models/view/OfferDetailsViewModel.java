package bg.softuni.mobilele.models.view;

import java.time.Instant;

public class OfferDetailsViewModel extends OfferSummaryViewModel{
    private Instant offerCreated;
    private Instant offerModified;
    private String sellerFirstName;
    private String sellerLastName;

    public Instant getOfferCreated() {
        return offerCreated;
    }

    public void setOfferCreated(Instant offerCreated) {
        this.offerCreated = offerCreated;
    }

    public Instant getOfferModified() {
        return offerModified;
    }

    public void setOfferModified(Instant offerModified) {
        this.offerModified = offerModified;
    }

    public String getSellerFirstName() {
        return sellerFirstName;
    }

    public void setSellerFirstName(String sellerFirstName) {
        this.sellerFirstName = sellerFirstName;
    }

    public String getSellerLastName() {
        return sellerLastName;
    }

    public void setSellerLastName(String sellerLastName) {
        this.sellerLastName = sellerLastName;
    }
}
