package edu.eci.cvds.servlet.model;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.Optional;

/**
 * @author Iván Camilo Rincón Saavedra
 * @author Leonardo Galeano Garzón
 * @version 1.0 9/12/2020
 */
public class NewServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //*********************************************** Implementacion

        //*********************************************** Dado
        Writer responseWriter = resp.getWriter();
        Optional<String> optName = Optional.ofNullable(req.getParameter("name"));
        String name = optName.isPresent() && !optName.get().isEmpty() ? " "+optName.get() : "";

        resp.setStatus(HttpServletResponse.SC_OK);
        responseWriter.write("Hello" + name + "!");
        responseWriter.flush();
    }
}
