package edu.epam.web.controller;

import edu.epam.web.command.Command;
import edu.epam.web.command.CommandFactory;
import edu.epam.web.connection.ConnectionPool;
import edu.epam.web.exception.EmailException;
import edu.epam.web.exception.ValidatorException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;

@WebServlet(name="Home", urlPatterns = {"/Home","*.do"})
public class Servlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processReguest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processReguest(request, response);
    }

    protected void processReguest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ConnectionPool.getInstance();
        String action = request.getParameter("action");

        if (action == null) {
            action = "home";
        }
        try {
            CommandFactory factory = CommandFactory.getInstance();
            Command command = factory.getCommand(action);
            command.execute(request, response);
        } catch (ServletException | IOException | ParseException | ValidatorException | EmailException e) {
            e.printStackTrace();
        }
    }
}

