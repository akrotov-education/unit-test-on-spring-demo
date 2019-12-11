package ru.mtuci.unittests.controllers.filters;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import ru.mtuci.unittests.controllers.dto.RangeValue;
import ru.mtuci.unittests.models.enums.Type;

import java.time.LocalDateTime;

@Data
public class CommonModelFilter {

    @ApiModelProperty(value = "Наименование общей модели")
    private String name;

    @ApiModelProperty(value = "Тип общей модели")
    private Type type;

    @ApiModelProperty(value = "Вес")
    private RangeValue<Double > weight;

    @ApiModelProperty(value = "Дата создания")
    private RangeValue<LocalDateTime> created;

}
