package ru.mtuci.unittests.service;

import ru.mtuci.unittests.controllers.filters.CommonModelFilter;
import ru.mtuci.unittests.models.CommonModel;

import java.util.List;

public interface CommonService {

    List<CommonModel> findAllCommonModels();

    CommonModel findById(Long id);

    CommonModel createCommonModel(CommonModel commonModel);

    CommonModel updateCommonModel(CommonModel commonModel);

    List<CommonModel> findByFilter(CommonModelFilter filter);

    void deleteCommonModel(Long id);
}
