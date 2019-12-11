package ru.mtuci.unittests.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import ru.mtuci.unittests.models.CommonModel;
import ru.mtuci.unittests.repository.CommonRepository;

import java.util.List;
import javax.annotation.PostConstruct;

@Component
public class PopulateDatabase {

    private CommonRepository commonRepository;
    private RandomCommonModelFactory commonModelFactory;

    public static final Integer MODELS_COUNT = 10000;

    @PostConstruct
    public void init () {
        List<CommonModel> commonModels = commonModelFactory.create(MODELS_COUNT);
        commonRepository.saveAll(commonModels);
    }

    @Autowired
    public void setCommonRepository(CommonRepository commonRepository) {
        this.commonRepository = commonRepository;
    }

    @Autowired
    public void setCommonModelFactory(RandomCommonModelFactory commonModelFactory) {
        this.commonModelFactory = commonModelFactory;
    }
}
