package bg.softuni.mobilele.models.view;

import bg.softuni.mobilele.models.enums.EngineEnum;
import bg.softuni.mobilele.models.enums.ModelCategoryEnum;
import bg.softuni.mobilele.models.enums.TransmissionEnum;

public class OfferUploadModel {
    private EngineEnum engine;
    private TransmissionEnum transmission;
    private int year;
    private Long modelId;
    private Double price;
    private int mileage;
    private String description;
    private String imageUrl;

    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public void setEngine(EngineEnum engine) {
        this.engine = engine;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public void setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
