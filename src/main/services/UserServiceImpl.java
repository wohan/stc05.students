package main.services;

import main.model.entity.User;
import main.model.impl.UserDaoImpl;
import org.apache.log4j.Logger;

/**
 * Created by Aleksei Lysov on 20.04.2017.
 */
public class UserServiceImpl implements UserService{

    private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);


    @Override
    public User auth(String login, String password) {
        User user = new UserDaoImpl().findLoginAndPassword(login, password);
        LOGGER.debug(user);

        if ((user != null) && (!user.isBlocked()))
                return user;
        return null;
    }
}
