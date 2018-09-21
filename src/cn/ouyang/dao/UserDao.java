package cn.ouyang.dao;

import cn.ouyang.user.User;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class UserDao {

    public User findUserName(String userName) {
        SAXReader saxReader = new SAXReader();
        Document document = null;
        User u = null;
        try {
            document = saxReader.read("F:\\user.xml");
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        Element rootElement = document.getRootElement();
        List<Element> elements = rootElement.elements();
        for (Element e : elements){
            if (e.attributeValue("userName").equals(userName)){
                u = new User();
                u.setUserName(userName);
                u.setPassWord(e.attributeValue("passWord"));
            }
        }
        return u;
    }

    public void addUser(User user) {
        SAXReader saxReader = new SAXReader();
        Document document = null;
        try {
            document = saxReader.read("F:\\user.xml");
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        Element rootElement = document.getRootElement();
        Element user1 = rootElement.addElement("user");
        user1.addAttribute("userName", user.getUserName());
        user1.addAttribute("passWord", user.getPassWord());
        FileOutputStream out = null;
        try {
            out = new FileOutputStream("F:\\user.xml");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("UTF-8");
        XMLWriter writer = null;
        try {
            writer = new XMLWriter(out, format);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            writer.write(document);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
