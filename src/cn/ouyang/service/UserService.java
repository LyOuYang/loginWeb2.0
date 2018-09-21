package cn.ouyang.service;

import cn.ouyang.dao.UserDao;
import cn.ouyang.user.User;

public class UserService {
    private UserDao userDao = new UserDao();

    public void regist(User user) throws UserException {
        User _user = userDao.findUserName(user.getUserName());
        if (_user == null)
            userDao.addUser(user);
        else throw new UserException("用户名" + _user.getUserName() + "已被注册");
    }

    public void login(User u ){

    }

}
