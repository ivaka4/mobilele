package bg.softuni.mobilele.models.view;

import java.util.ArrayList;
import java.util.List;

public class BrandViewModel {
    private String name;
    private List<ModelViewModel> models = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ModelViewModel> getModels() {
        return models;
    }

    public void addModel(ModelViewModel model) {
        this.models.add(model);
    }
}
