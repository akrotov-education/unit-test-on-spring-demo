package ru.mtuci.unittests.converters;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.mtuci.unittests.controllers.dto.CommonModelDto;
import ru.mtuci.unittests.models.CommonModel;

@Component
public class CommonModelConverter implements Converter<CommonModelDto, CommonModel> {

    @Override
    public CommonModel convert(CommonModelDto commonModelDto) {

        validate(commonModelDto);

        CommonModel commonModel = new CommonModel();
        commonModel.setId(commonModelDto.getId());
        commonModel.setName(commonModelDto.getName());
        commonModel.setCreated(commonModel.getCreated());
        commonModel.setType(commonModel.getType());
        commonModel.setWeight(commonModel.getWeight());
        return commonModel;
    }

    private void validate(CommonModelDto commonModelDto) {

        if (commonModelDto == null) {
            throw new IllegalArgumentException("Can't create nullable commonModelDto!");
        }

        if (StringUtils.isBlank(commonModelDto.getName())) {
            throw new IllegalArgumentException("Name shouldn't be empty!");
        }

        if (StringUtils.isBlank(commonModelDto.getName())) {
            throw new IllegalArgumentException("Type shouldn't be empty!");
        }

    }
}
