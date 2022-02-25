package com.java.feature.date;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class NewDateRun {

    public static SimpleDateFormat dateFormatLoc = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    public static void main(final String[] args) {
        Date dateLoc = new Date();
        GregorianCalendar calendarLoc = new GregorianCalendar();
        calendarLoc.add(Calendar.DATE,
                        3);
        calendarLoc.add(Calendar.MINUTE,
                        50);
        long timeInMillisLoc = calendarLoc.getTimeInMillis();
        SimpleDateFormat dateFormatLoc = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        LocalDate localDateLoc = LocalDate.now()
                                          .plusDays(1)
                                          .plusWeeks(1);
        LocalDate localDateLoc2 = LocalDate.of(2023,
                                               9,
                                               25);
        LocalDateTime localDateTimeLoc = LocalDateTime.now()
                                                      .plusHours(10);
        LocalDateTime localDateTimeLoc2 = LocalDateTime.of(2023,
                                                           10,
                                                           10,
                                                           10,
                                                           10);
        LocalTime localTimeLoc = LocalTime.now();

        ZonedDateTime dateTimeLoc = ZonedDateTime.of(LocalDateTime.now(),
                                                     ZoneId.of("Europe/Paris"));
        long epochMilliLoc = dateTimeLoc.toInstant()
                                        .toEpochMilli();
        LocalDateTime.now()
                     .toInstant(ZoneOffset.UTC)
                     .toEpochMilli();
        Duration betweenLoc = Duration.between(localTimeLoc,
                                               dateTimeLoc);
        long hoursLoc = betweenLoc.toHours();

        DateTimeFormatter ofPatternLoc = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    }
}
