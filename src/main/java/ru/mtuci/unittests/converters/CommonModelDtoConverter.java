package ru.mtuci.unittests.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.mtuci.unittests.controllers.dto.CommonModelDto;
import ru.mtuci.unittests.models.CommonModel;

@Component
public class CommonModelDtoConverter implements Converter<CommonModel, CommonModelDto> {

    @Override
    public CommonModelDto convert(CommonModel commonModel) {
        CommonModelDto commonModelDto = new CommonModelDto();
        commonModelDto.setId(commonModel.getId());
        commonModelDto.setName(commonModel.getName());
        commonModelDto.setType(commonModel.getType());
        commonModelDto.setCreated(commonModel.getCreated());
        commonModelDto.setWeight(commonModel.getWeight());
        return commonModelDto;
    }
}
