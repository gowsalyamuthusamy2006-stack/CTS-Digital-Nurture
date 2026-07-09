package com.example.springlearn.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormatUtil {

    private static final Logger logger = LoggerFactory.getLogger(DateFormatUtil.class);

    @Value("${app.date-format:yyyy-MM-dd}")
    private String dateFormat;

    @Value("${app.datetime-format:yyyy-MM-dd HH:mm:ss}")
    private String datetimeFormat;

    private DateTimeFormatter dateFormatter;
    private DateTimeFormatter datetimeFormatter;

    public DateFormatUtil() {
        this.dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.datetimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    }

    public String formatDate(LocalDate date) {
        if (date == null) {
            return null;
        }
        return date.format(dateFormatter);
    }

    public String formatDateTime(LocalDateTime dateTime) {
        if (dateTime == null) {
            return null;
        }
        return dateTime.format(datetimeFormatter);
    }

    public LocalDate parseDate(String dateStr) {
        if (dateStr == null || dateStr.isEmpty()) {
            return null;
        }
        try {
            return LocalDate.parse(dateStr, dateFormatter);
        } catch (Exception e) {
            logger.error("Error parsing date: {}", dateStr, e);
            return null;
        }
    }

    public LocalDateTime parseDateTime(String dateTimeStr) {
        if (dateTimeStr == null || dateTimeStr.isEmpty()) {
            return null;
        }
        try {
            return LocalDateTime.parse(dateTimeStr, datetimeFormatter);
        } catch (Exception e) {
            logger.error("Error parsing datetime: {}", dateTimeStr, e);
            return null;
        }
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public String getDatetimeFormat() {
        return datetimeFormat;
    }
}