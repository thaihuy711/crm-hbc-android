package bys.crm.hbc.utils;

/**
 * Created by Admin on 3/9/2018.
 */

public class Constants {

    public static String ROLE_ADMIN = "Admin";
    public static String PREF_CUSTOMER = "PREF_CUSTOMER";
    public static String PREF_USER_PROFILE = "PREF_USER_PROFILE";
    public static final String CHARSET = "UTF-8";
    public static int FAILURE_SESSION_EXPIRED = 2;
    public static String PREF_SESSION_ID = "PREF_SESSION_ID";
    public static String PREF_USER_ID = "PREF_USER_ID";
    public static String PREF_EMPLOYEES_ID = "PREF_EMPLOYEES_ID";
    public static String PREF_ROLE = "PREF_ROLE";
    public static String PREF_GENERAL_DATA = "PREF_GENERAL_DATA";
    public static final String PREF_USERNAME = "username";
    public static final String PREF_PASSWORD_NAME = "password";
    public static final String EXTRAX_EMAIL = "email";
    public static final String EXTRAX_TOKEN_CODE = "token_code";

    //Code
    public static int CODE_SUCCESS = 0;
    public static int LIMIT_ITEMS = 10;

    public enum STATUS_WORK {
        WillAccept, Accepting, Checking, Problem, Done, Cancel
    }
    public static final String APPROVE = "APPROVE";
    public static final String UNAPPROVE = "UNAPPROVE";
}
