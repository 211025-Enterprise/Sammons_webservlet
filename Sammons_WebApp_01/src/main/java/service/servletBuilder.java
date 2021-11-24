package service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import persistence.Dao;
import models.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


public class servletBuilder extends HttpServlet {
    testerclass test = new testerclass();
    public Dao projorm = new Dao();
    public ObjectMapper mapper = new ObjectMapper();
    private Object testerclass = new testerclass();


    public static void doGetter(HttpServletRequest request, HttpServletResponse response, Class<?> clazz) {
        ObjectMapper map = new ObjectMapper();
        Dao orm = new Dao();
        List<Object> ojects = orm.readAll(clazz);
        try {
            for (Object obj : ojects) {
                response.getWriter().print(
                        map.writeValueAsString(obj)
                );
                response.setHeader("Content-Type", "application/json");
                response.setStatus(200);
            }
        } catch (IOException h) {
            h.printStackTrace();
        }

    }

    public static void doPoster(HttpServletRequest request, HttpServletResponse response, Class<?> clazz) throws IOException {
        ObjectMapper map = new ObjectMapper();
        Dao orm = new Dao();
        Object object = null;
        request.getHeader("Content-Type");
        String req = request.getReader().lines().collect(Collectors.joining("\n"));
        try {
            object = map.readValue(req, clazz);
            orm.createTable(clazz, object);
            response.getWriter().println("table created");
            response.setStatus(200);
            response.setHeader("Content-Type", "application/json");
            response.getWriter().println(map.writeValueAsString(object));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}








