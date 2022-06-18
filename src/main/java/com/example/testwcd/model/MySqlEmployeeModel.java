package com.example.testwcd.model;

import com.example.testwcd.constant.SqlConstant;
import com.example.testwcd.entity.Employee;
import com.example.testwcd.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MySqlEmployeeModel implements EmployeeModel{
    @Override
    public boolean save(Employee obj){
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.EMPLOYEE_INSERT);
            preparedStatement.setString(1,obj.getFullName());
            preparedStatement.setString(2,obj.getBirthday());
            preparedStatement.setString(3,obj.getAddress());
            preparedStatement.setString(4,obj.getPosition());
            preparedStatement.setString(5,obj.getDepartment());
            preparedStatement.execute();
            return true;
        }catch (Exception ex){
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
        return false;
    }
    @Override
    public List<Employee> findAll(){
        try{
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConstant.EMPLOYEE_SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Employee obj = convertResultSetToEmployee(resultSet);
                if (obj != null) {
                    listObj.add(obj);
                }
            }
            }catch(SQLException e){
                e.printStackTrace();
            }
            return listObj;
        }
        private Employee convertResultSetToEmployee(ResultSet resultSet){
            try {
                int id = resultSet.getInt(SqlConstant.EMPLOYEE_FIELD_ID);
                String fullName = resultSet.getString(SqlConstant.EMPLOYEE_FIELD_FULL_NAME);
                String birthday = resultSet.getString(SqlConstant.EMPLOYEE_FIELD_BIRTHDAY);
                String address = resultSet.getString(SqlConstant.EMPLOYEE_FIELD_ADDRESS);
                String position = resultSet.getString(SqlConstant.EMPLOYEE_FIELD_POSITION);
                String department = resultSet.getString(SqlConstant.EMPLOYEE_FIELD_DEPARTMENT);
                return Employee.EmployeeBuilder.aEmployee()
                        .withId(id)
                        .withFullName(fullName)
                        .withBirthday(birthday)
                        .withAddress(address)
                        .withPosition(position)
                        .withDepartment(department)
                        .build();
            }catch (SQLException ex){
                return null;
            }
        }
    }


