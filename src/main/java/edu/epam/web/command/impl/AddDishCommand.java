package edu.epam.web.command.impl;

import edu.epam.web.command.Command;
import edu.epam.web.exception.ValidatorException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class AddDishCommand extends Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, ValidatorException {
        RequestDispatcher addDish = request.getRequestDispatcher("/jsp/addDish.jsp");
        Map<String, String> messages = new HashMap<String, String>();
        request.setAttribute("messages", messages);
        addDish.forward(request, response);
    }
}
