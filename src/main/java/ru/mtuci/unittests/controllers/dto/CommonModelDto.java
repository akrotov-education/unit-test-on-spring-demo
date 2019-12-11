package ru.mtuci.unittests.controllers.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import ru.mtuci.unittests.models.enums.Type;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class CommonModelDto {

    @ApiModelProperty("Идентификатор")
    @JsonProperty("id")
    private Long id;

    @ApiModelProperty("Наименование")
    @JsonProperty("name")
    private String name;

    @ApiModelProperty("Тип")
    @JsonProperty("type")
    private Type type;

    @ApiModelProperty("Вес")
    @JsonProperty("weight")
    private Integer weight;

    @ApiModelProperty("Дата создаения")
    @JsonProperty("created")
    private LocalDateTime created;

}
