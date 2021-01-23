package bg.softuni.mobilele.services.impl;

import bg.softuni.mobilele.entities.Brand;
import bg.softuni.mobilele.repositories.BrandRepository;
import bg.softuni.mobilele.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;

    @Autowired
    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public Brand create(Brand brand) {
        return this.brandRepository.saveAndFlush(brand);
    }
}
