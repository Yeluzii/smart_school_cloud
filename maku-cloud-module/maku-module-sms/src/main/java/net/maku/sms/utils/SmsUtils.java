package net.maku.sms.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SmsUtils {
    public static boolean checkPhone(String mobile){
        if(mobile == null || mobile.length() != 11){
            return false;
        }
        String regex = "^1[3-9]\\d{9}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(mobile);
        return matcher.matches();
    }
}
