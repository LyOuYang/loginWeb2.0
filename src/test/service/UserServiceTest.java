package test.service;

import cn.ouyang.service.UserException;
import cn.ouyang.service.UserService;
import cn.ouyang.user.User;
import org.junit.Test;

public class UserServiceTest {
    @Test
    public void testRegist() {
        UserService userService = new UserService();
        User u = new User();
        u.setUserName("欧阳");
        u.setPassWord("ouyang");
        try {
            userService.regist(u);
        } catch (UserException e) {
            System.out.println(e.getMessage());
        }
    }

}
