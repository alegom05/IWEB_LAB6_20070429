package com.example.clase10crud.daos;

import com.example.clase10crud.beans.Actor;
import com.example.clase10crud.beans.Job;
import com.example.clase10crud.beans.Pelicula;

import java.sql.*;
import java.util.ArrayList;

public class ActorDao {


        public static ArrayList<Actor> listar(){

            ArrayList<Actor> lista = new ArrayList<>();

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            String url = "jdbc:mysql://localhost:3306/mydb";
            String username = "root";
            String password = "root";

            String sql = "select a.idActor, a.Nombre, a.Apellido, a.anoNacimiento, a.premioOscar, concat(a.Nombre,' ',a.Apellido) as Nombre\n" +
                    "from pelicula p\n" +
                    "join actor a\n" +
                    "join protagonistas r\n" +
                    "where p.idPelicula=r.idPelicula\n" +
                    "and r.idActor=a.idActor;";

            try (Connection conn = DriverManager.getConnection(url, username, password);
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {

                while (rs.next()) {
                    Actor actor = new Actor();
                    actor.setIdActor(rs.getInt(1));
                    actor.setNombre(rs.getString(2));
                    actor.setApellido(rs.getString(3));
                    actor.setAnhoNacimiento(rs.getInt(4));
                    actor.setPremioOscar(rs.getBoolean(5));

                    lista.add(actor);
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            return lista;
        }

    public Job buscarPorId(String id){

        Job job = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "root";

        String sql = "select * from Pelicula where idPelicula = ?";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1,id);

            try(ResultSet rs = pstmt.executeQuery()){
                while (rs.next()) {
                    Pelicula pelicula = new Pelicula();
                    pelicula.setTitulo(rs.getString(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return job;
    }

}
