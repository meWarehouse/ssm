package com.kc.mybatis_1.mvc1;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author wen
 * @create 2020-05-18 17:46
 */

public class DateFormatter implements Formatter<Date> {

    private SimpleDateFormat sdf;

//    public DateFormatter(SimpleDateFormat sdf) {
//        this.sdf = sdf;
//    }

    public void setPartern(String partern) {
        this.sdf = new SimpleDateFormat(partern);
    }

    @Override
    public Date parse(String text, Locale locale) throws ParseException {
        return sdf.parse(text);
    }

    @Override
    public String print(Date object, Locale locale) {
        return sdf.format(object);
    }


}
