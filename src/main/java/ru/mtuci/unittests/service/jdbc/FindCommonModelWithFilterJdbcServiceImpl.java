package ru.mtuci.unittests.service.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import ru.mtuci.unittests.controllers.dto.RangeValue;
import ru.mtuci.unittests.controllers.filters.CommonModelFilter;
import ru.mtuci.unittests.models.CommonModel;
import ru.mtuci.unittests.models.enums.Type;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class FindCommonModelWithFilterJdbcServiceImpl implements CommonModelJdbcService {

    public static final String QUERY = "SELECT * FROM COMMON_MODEL WHERE 1 = 1 ";

    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<CommonModel> exec(CommonModelFilter filter) {
        StringBuilder query = new StringBuilder(QUERY);
        Map<String, Object> params = new HashMap<>();
        addConditionals(query, params, filter);
        return jdbcTemplate.query(query.toString(), params, this::mapRow);
    }

    private CommonModel mapRow(ResultSet rs, int i) throws SQLException {
        CommonModel commonModel = new CommonModel();
        commonModel.setId(rs.getLong("ID"));
        commonModel.setName(rs.getString("NAME"));
        commonModel.setType(Type.valueOf(rs.getString("TYPE")));
        commonModel.setCreated(rs.getTimestamp("CREATED").toLocalDateTime());
        commonModel.setWeight(rs.getInt("WEIGHT"));
        return commonModel;
    }

    private void addConditionals(StringBuilder query, Map<String, Object> params, CommonModelFilter filter) {
        addNameConditional(query, params, filter);
        addTypeConditional(query, params, filter);
        addCreatedConditional(query, params, filter);
        addWeightConditional(query, params, filter);
    }

    private void addNameConditional(StringBuilder query, Map<String, Object> params, CommonModelFilter filter) {
        String name = filter.getName();
        if (name != null) {
            query.append(" AND name = :name ");
            params.put("name", name);
        }
    }

    private void addTypeConditional(StringBuilder query, Map<String, Object> params, CommonModelFilter filter) {
        Type type = filter.getType();
        if (type != null) {
            query.append(" AND type = :type ");
            params.put("type", type.name());
        }
    }

    private void addCreatedConditional(StringBuilder query, Map<String, Object> params, CommonModelFilter filter) {
        RangeValue<LocalDateTime> created = filter.getCreated();
        if (created != null) {
            LocalDateTime startLimit = created.getStartLimit();
            LocalDateTime endLimit = created.getEndLimit();

            if (startLimit != null) {
                query.append(" AND CREATED ")
                        .append(" >= ")
                        .append(":startCreatedLimit");
                params.put("startCreatedLimit", startLimit);
            }

            if (startLimit != null) {
                query.append(" AND CREATED ")
                        .append(" <= ")
                        .append(":endCreatedLimit");
                params.put("endCreatedLimit", endLimit);
            }
        }
    }

    private void addWeightConditional(StringBuilder query, Map<String, Object> params, CommonModelFilter filter) {
        RangeValue<Double> weight = filter.getWeight();
        if (weight != null) {
            Double startLimit = weight.getStartLimit();
            Double endLimit = weight.getEndLimit();

            if (startLimit != null) {
                query.append(" AND WEIGHT ")
                        .append(" >= ")
                        .append(":startWeightLimit");
                params.put("startWeightLimit", startLimit);
            }

            if (startLimit != null) {
                query.append(" AND WEIGHT ")
                        .append(" <= ")
                        .append(":endWeightLimit");
                params.put("endWeightLimit", endLimit);
            }
        }
    }


    @Autowired
    public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

}
