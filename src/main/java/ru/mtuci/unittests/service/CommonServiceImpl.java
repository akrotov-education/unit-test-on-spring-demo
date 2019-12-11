package ru.mtuci.unittests.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mtuci.unittests.controllers.filters.CommonModelFilter;
import ru.mtuci.unittests.models.CommonModel;
import ru.mtuci.unittests.repository.CommonRepository;
import ru.mtuci.unittests.service.jdbc.FindCommonModelWithFilterJdbcServiceImpl;

import java.util.List;
import javax.transaction.Transactional;

@Service
public class CommonServiceImpl implements CommonService {

    private CommonRepository commonRepository;
    private FindCommonModelWithFilterJdbcServiceImpl findCommonModelWithFilterJdbcService;

    @Override
    public List<CommonModel> findAllCommonModels() {
        return commonRepository.findAll();
    }

    @Override
    public CommonModel findById(Long id) {
        return commonRepository.findById(id).orElse(null);
    }

    @Override
    public List<CommonModel> findByFilter(CommonModelFilter filter) {
        return findCommonModelWithFilterJdbcService.exec(filter);
    }

    @Override
    @Transactional
    public CommonModel createCommonModel(CommonModel commonModel) {
        return commonRepository.save(commonModel);
    }

    @Override
    @Transactional
    public CommonModel updateCommonModel(CommonModel commonModel) {
        return commonRepository.save(commonModel);
    }

    @Override
    @Transactional
    public void deleteCommonModel(Long id) {
        commonRepository.deleteById(id);
    }

    @Autowired
    public void setCommonRepository(CommonRepository commonRepository) {
        this.commonRepository = commonRepository;
    }

    @Autowired
    public void setFindCommonModelWithFilterJdbcService(FindCommonModelWithFilterJdbcServiceImpl findCommonModelWithFilterJdbcService) {
        this.findCommonModelWithFilterJdbcService = findCommonModelWithFilterJdbcService;
    }
}
