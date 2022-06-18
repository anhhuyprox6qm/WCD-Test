package com.example.testwcd.controller;

import com.example.testwcd.entity.Employee;
import com.example.testwcd.model.EmployeeModel;
import com.example.testwcd.model.MySqlEmployeeModel;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet(name="ListEmployeeServlet", value ="/ListEmployeeServlet")
public class ListEmployeeServlet extends HttpServlet {
    private EmployeeModel employeeModel;
    public ListEmployeeServlet(){this.employeeModel = new MySqlEmployeeModel();}
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        request.setAttribute("employees",employeeModel.findAll());
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }
}
