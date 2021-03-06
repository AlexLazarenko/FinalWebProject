package edu.epam.web.command.impl;

import edu.epam.web.command.Command;
import edu.epam.web.entity.AccountStatus;
import edu.epam.web.entity.User;
import edu.epam.web.exception.EmailException;
import edu.epam.web.exception.ValidatorException;
import edu.epam.web.service.UserDaoService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class UpdateAccountStatusCommand extends Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, ValidatorException, EmailException {
        UserDaoService service = new UserDaoService();
        List<User> allUsers = new ArrayList<>();
        RequestDispatcher usersPage = request.getRequestDispatcher("/jsp/usersAdmin.jsp");
        int id= Integer.parseInt(request.getParameter("id"));
        AccountStatus status= AccountStatus.valueOf(request.getParameter("account_status"));
        service.updateAccountStatus(id,status);
        allUsers = service.findUsers();
        request.setAttribute("allUsers", allUsers);
        usersPage.forward(request, response);

   /*     UsersDao usersDao = new UsersDao();
        String login = request.getParameter("login");
        RequestDispatcher usersPage = request.getRequestDispatcher("/showUsers.jsp");
        Map<String, User> allUsers = new HashMap<String, User>();

        usersDao.removeUser(login);
        allUsers = usersDao.getUsers();
        request.setAttribute("allUsers", allUsers);
        usersPage.forward(request, response); */
    }
}
