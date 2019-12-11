package ru.mtuci.unittests.service.jdbc;

import ru.mtuci.unittests.controllers.filters.CommonModelFilter;
import ru.mtuci.unittests.models.CommonModel;

import java.util.List;

public interface CommonModelJdbcService {

    List<CommonModel> exec(CommonModelFilter commonModelFilter);
}
