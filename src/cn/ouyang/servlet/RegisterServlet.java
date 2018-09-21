package cn.ouyang.servlet;

import cn.ouyang.service.UserException;
import cn.ouyang.service.UserService;
import cn.ouyang.user.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "RegisterServlet",urlPatterns = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        UserService userService = new UserService();
        //User u  = new User();
        Map<String,String> error = new HashMap<>();
        Map<String, String[]> parameterMap = request.getParameterMap();
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        if (userName==null||userName.trim().isEmpty()){
            error.put("userNameError","用户名不能为空");
        }else if (userName.trim().length()<3||userName.trim().length()>10){
            error.put("userNameError", "用户名长度需要在3-9之间");
        }else {
            //u.setUserName(userName);
        }
        if (userName==null||passWord.trim().isEmpty()){
            error.put("passWordError", "密码不能为空");
        }else if (passWord.trim().length()<3||passWord.trim().length()>10){
            error.put("passWordError", "密码长度需要在3-9之间");
        }else {
            //u.setPassWord(passWord);
        }

        if (error!=null&&error.size()>0){
            request.setAttribute("errors",error);
            request.getRequestDispatcher("/normalPage/registerPage.jsp").forward(request,response);
            return;
        }else {
            try {
                User u = new User();
                System.out.println(request.getParameterMap().toString());
                BeanUtils.populate(u,request.getParameterMap());
                System.out.println(u.toString());
                userService.regist(u);
                response.getWriter().write("注册成功");
            } catch (UserException e) {
                error.put("repetitionError", e.getMessage());
                request.setAttribute("errors",error);
                request.getRequestDispatcher("/normalPage/registerPage.jsp").forward(request,response);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
