package com.java.demo.date;

import java.time.*;
import java.util.Date;

public class DateUtils {

    /**
     * 获得毫秒数
     * @param date
     * @return
     */
    public static Long getMilli(LocalDate date) {

        Long time = date.atStartOfDay().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        return time;
    }

    /**
     * 获得毫秒数
     * @param datetime
     * @return
     */
    public static Long getMilli(LocalDateTime datetime) {

        Long time = datetime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
        return time;
    }

    /**
     * 获得毫秒数
     * @param date
     * @param day
     * @return
     */
    public static Long getMilli(LocalDate date, int day) {

        LocalDate toDay = date.withMonth(date.getDayOfMonth() + day);
        Long time = toDay.atStartOfDay().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        return time;
    }

    /**
     * LocalDate转udate
     * @param date
     * @return
     */
    public static Date LocalDateToUDate(LocalDate date) {

        ZoneId zone = ZoneId.systemDefault();
        Instant instant = date.atStartOfDay().atZone(zone).toInstant();
        Date udate = Date.from(instant);
        return udate;
    }

    /**
     * LocalDateTime转udate
     * @param datetime
     * @return
     */
    public static Date LocalDateTimeToUDate(LocalDateTime datetime) {

        ZoneId zone = ZoneId.systemDefault();
        Instant instant = datetime.atZone(zone).toInstant();
        Date udate = Date.from(instant);
        return udate;
    }

    /**
     * udate转LocalDateTime
     * @param date
     * @return
     */
    public static LocalDateTime UDateToLocalDateTime(Date date) {

        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        return localDateTime;
    }

    /**
     * udate转LocalDate
     * @param date
     * @return
     */
    public static LocalDate UDateToLocalDate(Date date) {

        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        LocalDate localDate = localDateTime.toLocalDate();
        return localDate;
    }

}
