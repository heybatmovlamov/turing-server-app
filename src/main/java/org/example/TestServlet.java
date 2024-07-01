package org.example;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("text/plain");
        String name = req.getParameter("name");

        try (PrintWriter pw = resp.getWriter()) {
            System.out.println("GET method called -> " + LocalDateTime.now());
            if ("Hello".equalsIgnoreCase(name)) {
                pw.write("Hello,"+ name +"!");
            } else {
                pw.write("Hello, World!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}