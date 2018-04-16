/**
 * Copyright 2008-2014 OpenTide Inc. All Rights Reserved.
 * 
 * @ProjectName:  otc framework util
 * @Package:      com.otc.framework.tools.util.validation
 * @FileName:     UsernamePasswordValidator.java
 * @Description:  
 * @CreateUser:   yang.liu
 * @CreateDate:   2014年7月7日 上午11:45:22
 * @UpdateUser:   yang.liu
 * @UpdateDate:   2014年7月7日 上午11:45:22
 * @UpdateRemark: 
 * 
 */
package com.jifenbao.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.otc.framework.tools.util.validation.ValidateUtil;

/**
 * @ClassName UsernamePasswordValidator
 * @Description TODO
 * 
 * @author yang.liu
 * @version 1.0
 * 
 */
public final class UsernamePasswordValidator {
    
    // 日志实例
    private static final Log    LOG                 = LogFactory
                                                            .getLog(UsernamePasswordValidator.class);
    /**
     * 密码位数
     */
    private static final int    PASSWORD_LENGTH_MIN = 8;
    /**
     * 密码位数
     */
    private static final int    PASSWORD_LENGTH_MAX = 32;
    
    // "^[a-zA-Z]{1}([a-zA-Z0-9]|[._@]){5,29}$";
    
    private static final String USERNAME_PATTERN    = "^[a-zA-Z][a-zA-Z0-9@._-]{5,63}$";
    
    private static final String PASSWORD_PATTERN    = "^[a-zA-Z0-9][a-zA-Z0-9@#+=._-]{9,31}$";
    
    // return ValidateUtil.isMatches(str, "(?!\\D+$)(?![^a-zA-Z]+$).{10,30}$");
    
    private UsernamePasswordValidator() {
    }
    
    /**
     * 是否找到.<BR>
     * 匹配是否符合正则表达式pattern
     * 
     * @param str
     *            字符串
     * @param regex
     *            正则表达式
     * @param isCaseSensitive
     *            是否忽略大小写
     * @return true匹配，false不匹配
     */
    public static boolean isFind(String str, String regex,
            boolean isCaseSensitive) {
        
        if (ValidateUtil.isEmpty(str))
            return false;
        Pattern pattern;
        if (isCaseSensitive) {
            pattern = Pattern.compile(regex);
        }
        else {
            pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        }
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }
    
    /**
     * 是否找到.<BR>
     * 匹配是否符合正则表达式pattern
     * 
     * @param str
     *            字符串
     * @param regex
     *            正则表达式
     * @return true匹配，false不匹配
     */
    public static boolean isFind(String str, String regex) {
        
        return isFind(str, regex, true);
    }
    
    /**
     * 判断是否 3个连续(或相同)的顺序字符
     * 
     * @param str
     * @return
     */
    public static boolean isSeqChar(String str) {
        int intcount = 0; // 次数
        int inttemp = 0; // 上一个值
        int intpoor = 0; // 差值
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) - inttemp == intpoor) {
                intcount = intcount + 1;
            }
            else {
                intcount = 1;
            }
            
            intpoor = str.charAt(i) - inttemp;
            inttemp = str.charAt(i);
            if (intcount >= 2) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * 判断是否严格的用户名
     * 
     * 一下
     * 
     * @param str
     * @return
     */
    public static boolean isUsername(String str) {
        if (ValidateUtil.isEmpty(str)) {
            LOG.debug("Username Should not be null");
            return false;
        }
        return ValidateUtil.isMatches(str, USERNAME_PATTERN);
    }
    
    /**
     * 判断是否严格的密码
     * 
     * @param str
     * @return
     */
    public static boolean isPassword(String str) {
        if (ValidateUtil.isEmpty(str)) {
            LOG.debug("Password Should not be null");
            return false;
        }
        
        // 密码不能包含连续3个相同字符或3个顺序字符
        if (isSeqChar(str)) {
            LOG.debug("Password should not be contain as 123 abc aaa 111.");
            return false;
        }
        // 是否特殊字符
        if (isFind(str, ValidateUtil.SPECIAL_CHAR)
                && str.length() >= PASSWORD_LENGTH_MIN
                && str.length() <= PASSWORD_LENGTH_MAX) {
            LOG.debug("Password should be contain special char and the length is between 8 to 32.");
            
            return true;
        }
        
        return ValidateUtil.isMatches(str, PASSWORD_PATTERN);
    }
    
    /**
     * 密码规则验证
     * 
     * @param username
     *            用户名
     * @param password
     *            密码
     * @param oldPassword
     *            旧密码
     * @param birthday
     *            生日
     */
    public static boolean passwordValidation(String username, String password,
            String oldPassword, String birthday) {
        
        boolean valid = true;
        
        LOG.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>");
        LOG.debug("username:" + username);
        LOG.debug("password:" + password);
        LOG.debug("oldPassword:" + oldPassword);
        LOG.debug("birthday:" + birthday);
        LOG.debug("<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        
        // 密码必须有字符串和数字组合，可以包含特殊字符，但不能含有空格
        if (valid && !isPassword(password)) {
            LOG.debug("Password should be less than 30 and more than 10 characters in length.");
            LOG.debug("Password should contain atleast one char and one number.");
            valid = false;
        }
        
        // 密码和用户名不能相互包含
        if (valid
                && !ValidateUtil.isEmpty(username)
                && (password.indexOf(username) > -1 || username
                        .indexOf(password) > -1)) {
            LOG.debug("Password Should not be same as username");
            valid = false;
        }
        
        // 密码和旧不能相互包含
        if (valid
                && !ValidateUtil.isEmpty(oldPassword)
                && (password.indexOf(oldPassword) > -1 || oldPassword
                        .indexOf(password) > -1)) {
            LOG.debug("Password Should not be same as old password");
            valid = false;
        }
        
        // 密码不能包含生日
        if (valid && !ValidateUtil.isEmpty(birthday)
                && password.indexOf(birthday) > -1) {
            LOG.debug("Password Should not be same as user birthday");
            valid = false;
        }
        
        if (valid) {
            LOG.debug("Password is valid.");
        }
        return valid;
    }
    
    /**
     * 生成随机数字和字母组合
     * 
     * @param length
     *            [生成随机数的长度]
     * @return
     */
    public static String getCharAndNumr(int length) {
        StringBuffer valSb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            String charOrNum = Math.round(Math.random()) % 2 == 0 ? "char"
                    : "num"; // 输出字母还是数字
            if ("char".equalsIgnoreCase(charOrNum)) {
                // 字符串
                int choice = Math.round(Math.random()) % 2 == 0 ? 65 : 97; // 取得大写字母还是小写字母
                valSb.append((char) (choice + Math.round(Math.random() * 25)));
            }
            else if ("num".equalsIgnoreCase(charOrNum)) {
                // 数字
                valSb.append(String.valueOf(Math.round(Math.random() * 9)));
            }
        }
        return valSb.toString();
    }
}
