package com.example.testwcd.controller;

import com.example.testwcd.entity.Employee;
import com.example.testwcd.model.EmployeeModel;
import entity.Employee;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListEmployeeServlet extends HttpServlet {
    private EmployeeModel employeeModel;
    public ListEmployeeServlet(){this.employeeModel = new MySqlPhoneModel();}
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        List<Employee> employees = employeeModel.findAll();
        req.setAttribute("employees", employees);
        req.getRequestDispatcher("/list.jsp").forward(req,resp);
    }
}
