package com.example.clase10crud.servlets;

import com.example.clase10crud.beans.Job;
import com.example.clase10crud.beans.Pelicula;
import com.example.clase10crud.daos.JobDao;
import com.example.clase10crud.daos.PeliculaDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "PeliculaServlet", value = "/PeliculaServlet")
public class PeliculaServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        String action = request.getParameter("action") == null ? "lista" : request.getParameter("action");

        PeliculaDao peliculaDao = new PeliculaDao();

        switch (action){
            case "lista":
                ArrayList<Pelicula> list = PeliculaDao.listar();

                request.setAttribute("listaPeliculas",list);

                RequestDispatcher rd = request.getRequestDispatcher("pelicula/listaPeliculas.jsp");
                rd.forward(request,response);
                break;
            case "new":
                break;
            case "edit":
                break;
            case "del":
                break;
        }
    }
}
