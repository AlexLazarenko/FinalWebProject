package edu.epam.web.factory;

import edu.epam.web.entity.*;
import edu.epam.web.exception.ValidatorException;
import edu.epam.web.validator.UserValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;

public class UserFactory {
    private static final Logger logger = LogManager.getLogger(UserFactory.class);
    private final UserValidator validator = new UserValidator();

    public User createNewUser(int id, String telephoneNumber, String surname,
                           String name, Date birthday, UserGender gender, String email,
                            byte[] avatar) throws ValidatorException {
        User user = null;
        if (validator.isUser( telephoneNumber, surname, name, birthday, email)) {
            user = new User(id, telephoneNumber, surname, name, birthday, gender, email,
                    0, UserRole.CLIENT, avatar, UserStatus.SILVER,  AccountStatus.NEW);
        }
        logger.info("User created " + user);
        return user;
    }
    public User createUser(int id, String telephoneNumber, String surname,
                              String name, Date birthday, UserGender gender, String email,
                              byte[] avatar,int statusPoint, UserRole userRole,UserStatus userStatus,
                           AccountStatus accountStatus) throws ValidatorException {
        User user = null;
        if (validator.isUser( telephoneNumber, surname, name, birthday, email)) {
            user = new User(id, telephoneNumber, surname, name, birthday, gender, email,
                    statusPoint, userRole, avatar, userStatus, accountStatus);
        }
        logger.info("User created " + user);
        return user;
    }
}
