package ru.mtuci.unittests.models.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Type {

    STRING(1),
    LONG(2);

    @Getter
    private final int code;
}
