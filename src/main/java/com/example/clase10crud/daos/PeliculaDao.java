package com.example.clase10crud.daos;

import com.example.clase10crud.beans.Genero;
import com.example.clase10crud.beans.Job;
import com.example.clase10crud.beans.Pelicula;

import java.sql.*;
import java.util.ArrayList;

public class PeliculaDao {


        public static ArrayList<Pelicula> listar(){

            ArrayList<Pelicula> lista = new ArrayList<>();

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            String url = "jdbc:mysql://localhost:3306/mydb";
            String username = "root";
            String password = "root";

            String sql = "select p.titulo, p.director, p.anoPublicacion, p.rating, p.boxOffice, g.nombre\n" +
                    "from pelicula p\n" +
                    "join genero g\n" +
                    "where p.idGenero=g.idGenero\n" +
                    "order by rating desc, boxOffice desc;";

            try (Connection conn = DriverManager.getConnection(url, username, password);
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {

                while (rs.next()) {
                    Pelicula pelicula = new Pelicula();
                    pelicula.setTitulo(rs.getString(1));
                    pelicula.setDirector(rs.getString(2));
                    pelicula.setAnhoPublicacion(rs.getInt(3));
                    pelicula.setRating(rs.getInt(4));
                    pelicula.setBoxOffice(rs.getDouble(5));
                    pelicula.setGenero(rs.getString(6));

                    lista.add(pelicula);
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
