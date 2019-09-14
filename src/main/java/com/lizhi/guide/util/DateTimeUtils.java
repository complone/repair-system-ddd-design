package com.lizhi.guide.util;


import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.sql.Blob;
import java.util.Date;

public class DateTimeUtils {

    public static final String STANDARD_FORMAT = "yyyy-MM-dd HH;mm;ss";
    //org.joda.time
    //str -> Date
    //Date -> str

    public static Date strToDate(String dateTimeStr, String formatStr){
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(formatStr);
        DateTime dateTime = dateTimeFormatter.parseDateTime(dateTimeStr);
        return dateTime.toDate();
    }

    public static String dateToStr(Date date,String formarStr){
        if (date == null){
            return StringUtils.EMPTY;
        }
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(formarStr);

    }

    public static Date strToDate(String dateTimeStr){

        int strLength = dateTimeStr.length();
        if (strLength<16){
            for (int i =0;i<16-strLength;i++){
                dateTimeStr ="0"+dateTimeStr;
            }
        }

        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(STANDARD_FORMAT);
        DateTime dateTime = dateTimeFormatter.parseDateTime(dateTimeStr);
        return dateTime.toDate();
    }

    public static String dateToStr(Date date){
        if (date == null){
            return StringUtils.EMPTY;
        }
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(STANDARD_FORMAT);

    }



    public static void main(String[] args){
        Blob blob = DataTypeUtils.TransferFromStringtoBlob("Welcome editor project document");
    }



}
