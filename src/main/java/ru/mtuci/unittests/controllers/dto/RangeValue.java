package ru.mtuci.unittests.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RangeValue<T> {

    /**
     * Если не задано (null) нижний лимит отсутствует.
     */
    T startLimit;

    /**
     * Если не задано (null) верхний лимит отсутствует.
     */
    T endLimit;

}
