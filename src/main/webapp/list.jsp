<%@ page import="com.example.testwcd.entity.Employee" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
</head>
<body>

<h2>HTML Table</h2>

<table>
    <tr>
        <th>Id</th>
        <th>Full name</th>
        <th>Birthday</th>
        <th>Address</th>
        <th>Position</th>
        <th>Department</th>
    </tr>
    <%
        List<Employee> employees = (ArrayList<Employee>) request.getAttribute("employees");
        for(Employee employee: employees) {%>
    <tr>
        <td><%= employee.getId() %></td>
        <td>
            <%= employee.getFullName() %>
        </td>
        <td><%= employee.getBirthday() %></td>
        <td><%= employee.getAddress() %></td>
        <td><%= employee.getPosition() %></td>
        <td><%= employee.getDepartment() %></td>
    </tr>
    <%}%>
</table>

</body>
</html>
