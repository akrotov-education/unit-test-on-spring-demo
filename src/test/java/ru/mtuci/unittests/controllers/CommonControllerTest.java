package ru.mtuci.unittests.controllers;

import org.aspectj.weaver.tools.CommonsTraceFactory;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.mtuci.unittests.controllers.dto.CommonModelDto;
import ru.mtuci.unittests.converters.CommonModelConverter;
import ru.mtuci.unittests.converters.CommonModelDtoConverter;
import ru.mtuci.unittests.init.RandomCommonModelFactory;
import ru.mtuci.unittests.models.CommonModel;
import ru.mtuci.unittests.repository.CommonRepository;
import ru.mtuci.unittests.service.CommonServiceImpl;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


class CommonControllerTest {

    private CommonController commonController;
    private RandomCommonModelFactory commonModelFactory = new RandomCommonModelFactory();

    @BeforeEach
    public void before() {
        commonController = new CommonController();
        commonController.setCommonModelConverter(new CommonModelConverter());
        commonController.setCommonModelDtoConverter(new CommonModelDtoConverter());
    }

    @Test
    void findAllCommonModels() {

        //prepare
        CommonRepository commonRepositoryMock = Mockito.mock(CommonRepository.class);
        Mockito.when(commonRepositoryMock.findAll()).thenReturn(commonModelFactory.create(5));
        CommonServiceImpl commonService = new CommonServiceImpl();
        commonService.setCommonRepository(commonRepositoryMock);
        commonController.setCommonService(commonService);

        //exec
        List<CommonModelDto> allCommonModels = commonController.findAllCommonModels();

        //validate
        Assert.assertEquals(5, allCommonModels.size());
    }

    @Test
    void findByIdInPathParam() {
    }

    @Test
    void findByIdInRequestParam() {
    }

    @Test
    void createCommonModel() {
    }

    @Test
    void updateCommonModel() {
    }

    @Test
    void deleteCommonModel() {
    }

    @Test
    void setCommonModelConverter() {
    }

    @Test
    void setCommonModelDtoConverter() {
    }


}