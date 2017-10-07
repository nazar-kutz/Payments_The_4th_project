package com.nazar.util;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class FormatConverter {
    public static Calendar convertSqlDateToCalendar(Date date){
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        return  calendar;
    }

    public static Date convertCalendarToSqlDate(Calendar calendar){
        Date date = new Date(calendar.getTimeInMillis());
        return date;
    }

    public static Calendar convertMillsToCalendar(long mills){
        Calendar result = Calendar.getInstance();
        result.setTimeInMillis(mills);
        return result;
    }

    public static String convertPhoneNumberToStandardPerformance(String phone){
        char[] chars = phone.toCharArray();
        StringBuilder result = new StringBuilder();
        for(char c : chars){
            if(Character.isDigit(c)){
                result.append(c);
            }
        }
        return result.toString();
    }
}
