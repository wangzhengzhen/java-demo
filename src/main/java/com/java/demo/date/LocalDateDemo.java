package com.java.demo.date;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalField;
import java.util.Date;
import java.util.TimeZone;

/**
 * DateTimeFormatter 线程安全 ，SimpleDateFormat 非线程安全
 * DateTimeFormatter是Java8提供的新方式
 * 单线程环境下DateTimeFormatter和LocalDateTime的parse性能比SimpleDateFormat的parse性能高
 * 多线程环境下DateTimeFormatter作为共享变量时，大部分情况下性能比SimpleDateFormat高(因为多线程环境的复杂性，此结论不一定准确)
 *
 * LocalDateTime.now() 是不带有时区的，所以在被是带有时区的DateTimeFormatter格式化的时候，会报错
 * 被带有时区的DateTimeFormatter格式化的时候需要使用ZonedDateTime.now()
 */
public class LocalDateDemo {

    @Test
    public void main() {

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        // 自定义格式化日期
        DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder();
        builder.appendPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter formatter = builder.toFormatter();
        System.out.println(formatter.format(localDateTime));

        // 获得日期毫秒数
        Long time = LocalDate.now().withDayOfMonth(LocalDate.now().getDayOfMonth() + 1).atStartOfDay().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        System.out.println(time);
        Date date = new Date(time);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(date));
    }

}
