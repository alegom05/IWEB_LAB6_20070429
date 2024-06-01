package com.example.clase10crud.servlets;

import com.example.clase10crud.beans.Actor;
import com.example.clase10crud.beans.Pelicula;
import com.example.clase10crud.daos.ActorDao;
import com.example.clase10crud.daos.PeliculaDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ActorServlet", value = "/ActorServlet")
public class ActorServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        String action = request.getParameter("action") == null ? "lista" : request.getParameter("action");

        PeliculaDao peliculaDao = new PeliculaDao();

        switch (action){
            case "lista":
                //saca del modelo
                ArrayList<Actor> list = ActorDao.listar();

                //mandar la lista a la vista -> job/lista.jsp
                request.setAttribute("listaActor",list);

                RequestDispatcher rd = request.getRequestDispatcher("pelicula/listaActores.jsp");
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
