package bg.softuni.mobilele.services.impl;

import bg.softuni.mobilele.models.entities.Brand;
import bg.softuni.mobilele.models.entities.Model;
import bg.softuni.mobilele.models.view.BrandViewModel;
import bg.softuni.mobilele.models.view.ModelViewModel;
import bg.softuni.mobilele.repositories.BrandRepository;
import bg.softuni.mobilele.repositories.ModelRepository;
import bg.softuni.mobilele.services.BrandService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;
    private final ModelRepository modelRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public BrandServiceImpl(BrandRepository brandRepository, ModelRepository modelRepository, ModelMapper modelMapper) {
        this.brandRepository = brandRepository;
        this.modelRepository = modelRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<BrandViewModel> getAllBrands() {

        List<BrandViewModel> result = new ArrayList<>();
        List<Model> allModels =
                this.modelRepository.findAll();

        ModelMapper modelMapper = new ModelMapper();

        allModels.forEach(m -> {
            Brand brand = m.getBrand();
            Optional<BrandViewModel> brandModel = findByName(brand.getName(), result);

            if (brandModel.isEmpty()) {
                BrandViewModel newModel = new BrandViewModel();
                modelMapper.map(brand, newModel);
                result.add(newModel);
                brandModel = Optional.of(newModel);
            }

            ModelViewModel newModel = new ModelViewModel();
            modelMapper.map(m, newModel);
            brandModel.get().addModel(newModel);
        });

        return result;
    }

    private static Optional<BrandViewModel> findByName(String name, List<BrandViewModel> brands) {
        return brands.
                stream().
                filter(b -> b.getName().equals(name)).
                findAny();
    }

}
