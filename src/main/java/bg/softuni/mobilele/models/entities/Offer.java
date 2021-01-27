package bg.softuni.mobilele.models.entities;

import bg.softuni.mobilele.models.enums.EngineEnum;
import bg.softuni.mobilele.models.enums.TransmissionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "offers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Offer extends BaseEntity {
    @Column
    private String description;

    @Column
    @Enumerated(EnumType.STRING)
    private EngineEnum engine;

    @Column(name = "image_url")
    private String imageUrl;

    @Column
    private int mileage;

    @Column
    private Double price;

    @Column
    @Enumerated(EnumType.STRING)
    private TransmissionEnum transmission;

    @Column
    private int year;

    @ManyToOne
    private Model model;

    @ManyToOne
    private User seller;

    public EngineEnum getEngine() {
        return engine;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }
}
