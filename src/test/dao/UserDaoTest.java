package test.dao;

import cn.ouyang.dao.UserDao;
import cn.ouyang.user.User;
import org.junit.Test;

public class UserDaoTest {
    @Test
    public void testAddUser(){
        UserDao userDao = new UserDao();
        User u = new User();
        u.setUserName("李四");
        u.setPassWord("lisi");
        userDao.addUser(u);
    }

    @Test
    public void testFindUserName(){
        UserDao userDao = new UserDao();
        if (userDao!=null)
            System.out.println(userDao.findUserName("李四"));
        else
            System.out.println("查无此人");
    }
}
