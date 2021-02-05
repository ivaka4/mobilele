package bg.softuni.mobilele.models.view;

import bg.softuni.mobilele.models.enums.EngineEnum;
import bg.softuni.mobilele.models.enums.TransmissionEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateOfferViewModel {
    private Long id;
    private EngineEnum engine;
    private TransmissionEnum transmission;
    private int year;
    private Long modelId;
    private Double price;
    private int mileage;
    private String description;
    private String imageUrl;
}
