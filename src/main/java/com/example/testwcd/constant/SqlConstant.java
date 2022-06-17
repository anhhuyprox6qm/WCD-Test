package com.example.testwcd.constant;

import org.omg.CORBA.PUBLIC_MEMBER;

public class SqlConstant {
    public static final String EMPLOYEE_INSERT = "INSERT INTO employee (full name, birthday, address, position, department) values (?, ?, ?, ?)";
    public static final String EMPLOYEE_SELECT_ALL = "SELECT * FROM phones";
    public static final String EMPLOYEE_FIELD_ID ="id";
    public static final String EMPLOYEE_FIELD_FULL_NAME = "full name";
    public static final String EMPLOYEE_FIELD_BIRTHDAY = "birthday";
    public static final String EMPLOYEE_FIELD_ADDRESS = "address";
    public static final String EMPLOYEE_FIELD_POSITION = "position";
    public static final String EMPLOYEE_FIELD_DEPARTMENT = "department";
}
