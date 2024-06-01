<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.clase10crud.beans.Actor" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="listaActor" scope="request" type="ArrayList<Actor>" />

<%
    String idParameter = request.getParameter("id");
    int idPelicula = 0; // Valor predeterminado en caso de que el parámetro "id" no esté presente

    // Verificar si el parámetro "id" no es nulo ni está vacío
    if (idParameter != null && !idParameter.isEmpty()) {
        try {
            idPelicula = Integer.parseInt(idParameter);
        } catch (NumberFormatException e) {
            // Manejo de excepción en caso de que el parámetro no sea un número válido
            out.println("ID de película no válido.");
        }
    }
%>

<html>
<head>
    <title>Lista de actores</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
          crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="clearfix mt-3 mt-2">
        <a href="<%=request.getContextPath()%>/PeliculaServlet">
            <h1 class="float-start link-dark">Lista de Actores</h1>
        </a>
        <a class="btn btn-primary float-end mt-1" href="<%=request.getContextPath() %>/ActorServlet?action=new">Crear trabajo</a>
    </div>
    <hr/>
    <form method="post" action="<%=request.getContextPath()%>/ActorServlet?action=s">
        <div class="form-floating mt-3">
            <input type="text" class="form-control" id="floatingInput"
                   placeholder="Por ID o por nombre" name="textoBuscar" value="<%= request.getAttribute("busqueda") != null ? request.getAttribute("busqueda") : "" %>">
            <label for="floatingInput">Buscar trabajo</label>
        </div>
    </form>
    <table class="table table-striped mt-3">
        <tr class="table-primary">
            <th>IdActor</th>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Año de nacimiento</th>
            <th>Ganador Premio Oscar</th>
        </tr>
        <%
            if (listaActor != null) {
                for (Actor actor : listaActor) {
        %>
        <tr>
            <td><%=actor.getIdActor()  %></td>
            <td><%=actor.getNombre()%></td>
            <td><%=actor.getApellido()%></td>
            <td><%=actor.getAnhoNacimiento()%></td>
            <td><%=actor.isPremioOscar()%></td>
        </tr>
        <%
            }
        } else {
        %>
        <tr>
            <td colspan="5">No hay actores disponibles.</td>
        </tr>
        <%
            }
        %>
    </table>
</div>
</body>
</html>
