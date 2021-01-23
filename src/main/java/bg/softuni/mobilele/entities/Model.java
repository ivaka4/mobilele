package bg.softuni.mobilele.entities;

import bg.softuni.mobilele.entities.enums.ModelCategoryEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "models")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Model extends BaseEntity{

    @Column(nullable = false)
    private String name;

    @Column
    @Enumerated(EnumType.STRING)
    private ModelCategoryEnum category;

    @Column(name = "image_url", length = 512)
    private String imageUrl;

    @Column(name = "start_year")
    private Integer startYear;

    @Column(name = "end_year")
    private Integer endYear;

    @ManyToOne
    private Brand brand;

    public Model(String name, ModelCategoryEnum category, Integer startYear, Integer endYear, String imageUrl) {
        this.name = name;
        this.category = category;
        this.startYear = startYear;
        this.endYear = endYear;
        this.imageUrl = imageUrl;
    }
}
