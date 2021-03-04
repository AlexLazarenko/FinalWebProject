package edu.epam.web.command.impl;

import edu.epam.web.command.Command;
import edu.epam.web.dao.UserDao;
import edu.epam.web.dao.impl.UserDaoImpl;
import edu.epam.web.entity.User;
import edu.epam.web.service.UserDaoService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DeleteUserCommand extends Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDaoService service = new UserDaoService();
        String id = request.getParameter("id");
        RequestDispatcher usersPage = request.getRequestDispatcher("/jsp/usersAdmin.jsp");
        List<User> allUsers = new ArrayList<>();
        service.deleteUser(id);
        allUsers = service.readUsers();
        request.setAttribute("allUsers", allUsers);
        usersPage.forward(request, response);
    }
}
