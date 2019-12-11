package ru.mtuci.unittests.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.mtuci.unittests.models.enums.Type;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@Entity
@NoArgsConstructor
@Table(name = "COMMON_MODEL")
public class CommonModel {

    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Getter
    @NotNull
    @Column(name = "NAME")
    private String name;

    @Getter
    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "TYPE")
    private Type type;

    @Getter
    @Column(name = "WEIGHT")
    private Integer weight;

    @Getter
    @Column(name = "CREATED")
    private LocalDateTime created;


}
