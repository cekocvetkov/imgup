package core;

import dbutils.DBConnectionManager;
import exceptions.ConnectionException;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/imgupload")
public class MainController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().write("Zekata Servletchi ot Get Requesta");
        DBConnectionManager dbConnectionManager = new DBConnectionManager();
        try {
            dbConnectionManager.getConnection();
        } catch (ConnectionException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().append("<b>doPost</b> at: ").append(request.getRequestURI());
    }

}
