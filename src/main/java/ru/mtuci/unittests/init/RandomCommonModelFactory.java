package ru.mtuci.unittests.init;

import org.springframework.stereotype.Component;
import ru.mtuci.unittests.models.CommonModel;
import ru.mtuci.unittests.models.enums.Type;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class RandomCommonModelFactory {

    private Random random = new Random();

    public List<CommonModel> create(int count) {
        return IntStream.range(0, count)
                .mapToObj(a -> create())
                .collect(Collectors.toList());
    }

    public CommonModel create() {
        CommonModel commonModel = new CommonModel();
        commonModel.setId((long) random.nextInt(10000));
        commonModel.setWeight(random.nextInt(100));
        commonModel.setName(stringGenerator());
        commonModel.setCreated(dateGenerator());
        commonModel.setType(Type.values()[random.nextInt(1)]);
        return commonModel;
    }

    private String stringGenerator() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        char[] stringChars = new char[5];
        for (int i = 0; i < stringChars.length; i++) {
            stringChars[i] = chars.toCharArray()[random.nextInt(chars.length())];
        }
        return new String(stringChars);
    }

    private LocalDateTime dateGenerator() {
        LocalDateTime start = LocalDateTime.of(1970, Month.JANUARY, 1, 1, 1);
        long days = ChronoUnit.DAYS.between(start, LocalDateTime.now());
        LocalDateTime randomDate = start.plusDays(new Random().nextInt((int) days + 1));
        return randomDate;
    }
}
