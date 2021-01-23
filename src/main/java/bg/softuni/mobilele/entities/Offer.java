package bg.softuni.mobilele.entities;

import bg.softuni.mobilele.entities.enums.EngineEnum;
import bg.softuni.mobilele.entities.enums.TransmissionEnum;
import com.fasterxml.jackson.databind.ser.Serializers;
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




}
