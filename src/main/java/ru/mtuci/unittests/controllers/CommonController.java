package ru.mtuci.unittests.controllers;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.mtuci.unittests.controllers.dto.CommonModelDto;
import ru.mtuci.unittests.controllers.filters.CommonModelFilter;
import ru.mtuci.unittests.converters.CommonModelConverter;
import ru.mtuci.unittests.converters.CommonModelDtoConverter;
import ru.mtuci.unittests.models.CommonModel;
import ru.mtuci.unittests.service.CommonService;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/common")
public class CommonController {

    private CommonModelConverter commonModelConverter;
    private CommonModelDtoConverter commonModelDtoConverter;
    private CommonService commonService;

    @ApiOperation("Найти все общие модели")
    @GetMapping("/")
    public List<CommonModelDto> findAllCommonModels() {
        List<CommonModel> commonModels = commonService.findAllCommonModels();
        return commonModels.stream()
                .map(commonModelDtoConverter::convert)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }


    @ApiOperation("Найти общуюю модель по идентификатору в пути запроса")
    @GetMapping("/{id}")
    public CommonModelDto findByIdInPathParam(@PathVariable("id") String id) {
        CommonModel commonmodel = commonService.findById(Long.parseLong(id));
        return commonModelDtoConverter.convert(commonmodel);
    }


    @ApiOperation("Найти общую модель по идентификатору в заголовке запроса")
    @GetMapping("/findById")
    public CommonModelDto findByIdInRequestParam(@RequestParam("id") Long id) {
        CommonModel commonmodel = commonService.findById(id);
        return commonModelDtoConverter.convert(commonmodel);
    }

    @ApiOperation("Найти общую модель по фильтру")
    @PostMapping("/findByFilter")
    public List<CommonModelDto> findByFilter(@RequestBody CommonModelFilter filter) {
        List<CommonModel> commonModels = commonService.findByFilter(filter);
        return commonModels.stream()
                .map(commonModelDtoConverter::convert)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    @ApiOperation("Создать общую модель")
    @PostMapping("/")
    public CommonModelDto createCommonModel(@RequestBody CommonModelDto commonModelDto) {
        CommonModel commonModel = commonModelConverter.convert(commonModelDto);
        CommonModel createdCommonModel = commonService.createCommonModel(commonModel);
        return commonModelDtoConverter.convert(createdCommonModel);

    }

    @ApiOperation("Обновить общую модель")
    @PutMapping("/")
    public CommonModelDto updateCommonModel(@RequestBody CommonModelDto commonModelDto) {
        CommonModel commonModel = commonModelConverter.convert(commonModelDto);
        CommonModel updatedCommonModel = commonService.createCommonModel(commonModel);
        return commonModelDtoConverter.convert(updatedCommonModel);
    }

    @ApiOperation("Удалить общую модель")
    @DeleteMapping("/{id}")
    public void deleteCommonModel(@PathVariable("id") Long id) {
        commonService.deleteCommonModel(id);
    }

    @Autowired
    public void setCommonModelConverter(CommonModelConverter commonModelConverter) {
        this.commonModelConverter = commonModelConverter;
    }

    @Autowired
    public void setCommonModelDtoConverter(CommonModelDtoConverter commonModelDtoConverter) {
        this.commonModelDtoConverter = commonModelDtoConverter;
    }

    @Autowired
    public void setCommonService(CommonService commonService) {
        this.commonService = commonService;
    }
}
