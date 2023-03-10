package havryliuk.module3.util;

import lombok.SneakyThrows;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    private static final String DATE_PATTERN = "dd-MM-yyyy";


    @SneakyThrows
    public static Date createDate(String date) {
        date = date.replaceAll("[./_: ]+", "-").strip();
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_PATTERN);
        return formatter.parse(date);
    }

    @SneakyThrows
    public static String formatDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_PATTERN);
        return formatter.format(date);
    }




}
