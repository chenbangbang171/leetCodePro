//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.utils;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

public final class DateUtil {
    public static final String TIMESTAMP_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String TIMESTAMP_PATTERN_2 = "yyyy-MM-dd HH:mm";
    public static final String YEAR_MONTH = "yyyy-MM";
    public static final String DATE_FORMAT_YMD = "yyyy-MM-dd";
    public static final String DATE_FORMAT_YYYYMMDD = "yyyyMMdd";
    public static final String DATE_FORMAT_ONE = "yyyy/MM/dd";
    public static final String TIMESTAMP_PATTERN_EXT = "yyyy_MM_dd_HHmmss";
    public static final String PATTERN_ZERO = "yyyy-MM-dd '00:00:00'";
    public static final String MM_DD = "MM-dd";
    public static final String FIRST_TIME_STAMP = "1970-01-01 00:00:00";

    private DateUtil() {
    }

    public static Date getBeginningOfDay(Date date) {
        if (date == null) {
            return null;
        } else {
            date = DateUtils.setHours(date, 0);
            date = DateUtils.setMinutes(date, 0);
            date = DateUtils.setSeconds(date, 0);
            date = DateUtils.setMilliseconds(date, 0);
            return date;
        }
    }

    public static Date getBeginOfToday() {
        return getBeginningOfDay(getCurrentDate());
    }

    public static Date getEndingOfDay(Date date) {
        if (date == null) {
            return null;
        } else {
            date = DateUtils.setHours(date, 23);
            date = DateUtils.setMinutes(date, 59);
            date = DateUtils.setSeconds(date, 59);
            date = DateUtils.setMilliseconds(date, 999);
            return date;
        }
    }

    public static Date getEndOfToday() {
        return getEndingOfDay(getCurrentDate());
    }

    public static Date getEndOfDay(Date date) {
        if (date == null) {
            return null;
        } else {
            date = DateUtils.setHours(date, 23);
            date = DateUtils.setMinutes(date, 59);
            date = DateUtils.setSeconds(date, 59);
            date = DateUtils.setMilliseconds(date, 0);
            return date;
        }
    }

    public static Date getBeginningOfWeek(Date date) {
        date = DateUtils.addDays(date, -1 * date.getDay());
        return getBeginningOfDay(date);
    }

    public static Date getEndingOfWeek(Date date) {
        date = DateUtils.addDays(date, -1 * date.getDay() + 6);
        return getEndingOfDay(date);
    }

    public static Date getBeginningOfMonth(Date date) {
        date = DateUtils.setDays(date, 1);
        return getBeginningOfDay(date);
    }

    public static Date getEndingOfMonth(Date date) {
        date = getBeginningOfMonth(date);
        date = DateUtils.addMonths(date, 1);
        date = DateUtils.addDays(date, -1);
        return getEndingOfDay(date);
    }

    public static Date getBeginningOfMonth(Integer year, Integer month) {
        Calendar time = Calendar.getInstance();
        time.set(year, month - 1, 1, 0, 0, 0);
        return time.getTime();
    }

    public static String getBeginningOfMonth(Integer year, Integer month, String format) {
        Calendar time = Calendar.getInstance();
        time.set(year, month - 1, 1, 0, 0, 0);
        return format(time.getTime(), format);
    }

    public static Date subMilliseconds(Date date) {
        return date == null ? null : DateUtils.setMilliseconds(date, 0);
    }

    public static Date getEndingOfMonth(Integer year, Integer month) {
        Calendar time = Calendar.getInstance();
        time.set(year, month, 0, 23, 59, 59);
        return time.getTime();
    }

    public static String getEndingOfMonth(Integer year, Integer month, String format) {
        Calendar time = Calendar.getInstance();
        time.set(year, month, 0, 23, 59, 59);
        return format(time.getTime(), format);
    }

    public static Date getBeginingOfYear() {
        Calendar currCal = Calendar.getInstance();
        int currentYear = currCal.get(1);
        return getYearFirst(currentYear);
    }

    public static Date getEndingOfYear() {
        Calendar currCal = Calendar.getInstance();
        int currentYear = currCal.get(1);
        return getYearLast(currentYear);
    }

    public static Date getYearFirst(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(1, year);
        Date currYearFirst = calendar.getTime();
        return currYearFirst;
    }

    public static Date getYearLast(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(1, year);
        calendar.roll(6, -1);
        Date currYearLast = calendar.getTime();
        return currYearLast;
    }

    public static boolean isBetween(Date source, Date date1, Date date2) {
        if (source == null && date1 == null && date2 == null) {
            return true;
        } else if (source != null && date1 != null && date2 != null) {
            return source.compareTo(date1) >= 0 && source.compareTo(date2) <= 0;
        } else {
            return false;
        }
    }

    public static boolean isBetweenDefaultFalse(Date time, Date begin, Date end) {
        if (time == null) {
            return false;
        } else if (begin == null && end == null) {
            return true;
        } else if (begin != null && end == null) {
            return time.after(begin);
        } else if (begin == null && end != null) {
            return time.before(end);
        } else {
            return time.after(begin) && time.before(end);
        }
    }

    public static boolean isBetween2(Date source, Date startAt, Date endAt) {
        if (source == null && startAt == null && endAt == null) {
            return true;
        } else if (source != null && startAt == null && endAt == null) {
            return true;
        } else if (source != null && startAt != null && endAt == null) {
            return source.compareTo(startAt) >= 0;
        } else if (source != null && startAt == null) {
            return source.compareTo(endAt) <= 0;
        } else if (source == null) {
            return endAt != null && startAt != null && startAt.compareTo(endAt) > 0 ? false : false;
        } else {
            return source.compareTo(startAt) >= 0 && source.compareTo(endAt) <= 0;
        }
    }

    public static boolean isBetween(Date startAt, Date endAt) {
        return isBetween2(getCurrentDate(), startAt, endAt);
    }

    public static Date addMonth(Date date, int amount) {
        return DateUtils.addMonths(date, amount);
    }

    public static Date addYear(Date date, int amount) {
        return DateUtils.addYears(date, amount);
    }

    public static Date addDay(Date date, int amount) {
        return DateUtils.addDays(date, amount);
    }

    public static Date addHour(Date date, int amount) {
        return DateUtils.addHours(date, amount);
    }

    public static Date addMinutes(Date date, int amount) {
        return DateUtils.addMinutes(date, amount);
    }

    public static Date getCurrentDate() {
        return getCurrentDate(true);
    }

    public static String getCurrentDateStr() {
        return format(getCurrentDate(true), "yyyy-MM-dd HH:mm:ss");
    }

    public static String getCurrentDateStr(String pattern) {
        return format(getCurrentDate(true), pattern);
    }

    public static Date getCurrentDate(boolean needTime) {
        Calendar now = Calendar.getInstance();
        if (needTime) {
            return now.getTime();
        } else {
            now.set(11, 0);
            now.set(12, 0);
            now.set(13, 0);
            now.set(14, 0);
            return now.getTime();
        }
    }

    public static long getSurplusDate(Date source, Date endTime) {
        return source != null && endTime != null && source.compareTo(endTime) <= 0 ? endTime.getTime() - source.getTime() : 0L;
    }

    public static Date parseDate(String dateStr, String pattern) {
        if (StringUtils.isBlank(dateStr)) {
            return null;
        } else {
            try {
                return DateUtils.parseDate(dateStr, new String[]{pattern});
            } catch (ParseException var3) {
                throw new IllegalArgumentException("dateStr is not fitted for pattern");
            }
        }
    }

    public static String format(Date date, String... patterns) {
        if (date == null) {
            return "";
        } else {
            String pattern = "yyyy-MM-dd HH:mm:ss";
            if (patterns != null && patterns.length > 0 && !StringUtils.isBlank(patterns[0])) {
                pattern = patterns[0];
            }

            return DateFormatUtils.format(date, pattern);
        }
    }

    public static int compareDate(Date first, Date second) {
        if (first != null && second != null) {
            return first.compareTo(second);
        } else {
            throw new IllegalArgumentException("first| second cannot be null");
        }
    }

    public static Date getFirstTimeStamp(Date date) {
        if (date == null) {
            return null;
        } else {
            return DateFormatUtils.format(date, "yyyy-MM-dd HH:mm:ss").compareTo("1970-01-01 00:00:00") > 0 ? date : null;
        }
    }

    public static Date getDateBefore(Date date, int day) {
        Calendar dateCan = Calendar.getInstance();
        dateCan.setTime(date);
        dateCan.add(5, -day);
        return dateCan.getTime();
    }

    public static Date getYearBefore(Date date, int year) {
        Calendar dateCan = Calendar.getInstance();
        dateCan.setTime(date);
        dateCan.add(1, -year);
        return dateCan.getTime();
    }

    public static Date getStartOfSomeday(Date date) {
        if (date == null) {
            return null;
        } else {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            return calendar.getTime();
        }
    }

    public static int differentDays(Date first, Date second) {
        return first != null && second != null ? (int)((first.getTime() - second.getTime()) / 86400000L) : 0;
    }

    public static long differentTime(long limitTime, long startTime) {
        long passedTime = getCurrentDate().getTime() - startTime;
        long remainingTime = limitTime * 60L * 1000L - passedTime;
        return remainingTime < 0L ? 0L : remainingTime;
    }

    public static Date getAfterYearTime(Date time) {
        if (time == null) {
            return null;
        } else {
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(1);
            calendar.setTime(time);
            calendar.set(1, year);
            return calendar.getTime().before(getCurrentDate()) ? addYear(calendar.getTime(), 1) : calendar.getTime();
        }
    }

    public static int subDateYear(Date time) {
        if (time == null) {
            return 0;
        } else {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(time);
            return Calendar.getInstance().get(1) - calendar.get(1);
        }
    }

    public static boolean changeDay(String oldTime, String newTime) {
        return isChangeDay(oldTime, newTime);
    }

    public static boolean isChangeDay(String oldTime, String newTime) {
        if (StringUtils.isBlank(oldTime)) {
            return false;
        } else if (StringUtils.isBlank(newTime)) {
            return true;
        } else {
            Date firstTime = getBeginningOfDay(parseDate(oldTime, "yyyy-MM-dd HH:mm:ss"));
            Date secondTime = getBeginningOfDay(parseDate(newTime, "yyyy-MM-dd HH:mm:ss"));
            if (firstTime == null) {
                return false;
            } else if (secondTime == null) {
                return true;
            } else {
                return firstTime.getTime() != secondTime.getTime();
            }
        }
    }
}
