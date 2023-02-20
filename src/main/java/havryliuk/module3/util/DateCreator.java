package havryliuk.module3.util;

import lombok.SneakyThrows;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateCreator {
    private static final String DATE_PATTERN = "yyyy-MM-dd";

    @SneakyThrows
    public static Date createDate(String date) {
        date = date.replaceAll("[./_: ]+", "-").strip();
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_PATTERN);
        return formatter.parse(date);
    }
}
