package ru.mtuci.unittests.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mtuci.unittests.models.CommonModel;

public interface CommonRepository extends JpaRepository<CommonModel, Long> {
}
