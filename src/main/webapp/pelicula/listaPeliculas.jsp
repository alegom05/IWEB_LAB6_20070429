
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.clase10crud.beans.Job" %>
<%@ page import="com.example.clase10crud.beans.Pelicula" %>
<%@ page import="com.example.clase10crud.beans.Genero" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="listaPeliculas" scope="request" type="ArrayList<Pelicula>" />
<html>
    <head>
        <title>Lista de películas</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
              crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <div class="clearfix mt-3 mt-2">
                <a href="<%=request.getContextPath()%>/PeliculaServlet">
                    <h1 class="float-start link-dark">Lista de Trabajos</h1>
                </a>
                <a class="btn btn-primary float-end mt-1" href="<%=request.getContextPath() %>/PeliculaServlet?action=new">Crear trabajo</a>
            </div>
            <hr/>
            <form method="post" action="<%=request.getContextPath()%>/PeliculaServlet?action=s">
                <div class="form-floating mt-3">
                    <input type="text" class="form-control" id="floatingInput"
                           placeholder="Por ID o por nombre" name="textoBuscar" value="<%= request.getAttribute("busqueda") != null ? request.getAttribute("busqueda") : "" %>">
                    <label for="floatingInput">Buscar trabajo</label>
                </div>
            </form>
            <table class="table table-striped mt-3">
                <tr class="table-primary">
                    <th>Título</th>
                    <th>Director</th>
                    <th>Año publicación</th>
                    <th>Rating</th>
                    <th>Box Office</th>
                    <th>Género</th>
                    <th>Actores</th>
                </tr>
                <% for (Pelicula pelicula : listaPeliculas) { %>
                <tr>
                    <td><a class="btn btn-success" href="<%=request.getContextPath()%>/DetallesServlet?id=<%= pelicula.getIdPelicula() %>"><%= pelicula.getTitulo() %></a></td>
                    </td>
                    <td><%=pelicula.getDirector()%>
                    </td>
                    <td><%=pelicula.getAnhoPublicacion()%>
                    </td>
                    <td><%=pelicula.getRating()%>
                    </td>
                    <td><%=pelicula.getBoxOffice()%>
                    </td>
                    <td><%=pelicula.getGenero()%>
                    </td>
                    <td><%=pelicula.getRating()%>
                    </td>
                    <td><a class="btn btn-success" href="<%=request.getContextPath()%>/ActorServlet?id=<%= pelicula.getIdPelicula() %>">Ver actores</a></td>
                </tr>
                <% } %>
            </table>
        </div>
    </body>
</html>
