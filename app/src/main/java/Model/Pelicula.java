package Model;

import java.io.Serializable;
import java.util.List;

public class Pelicula implements Serializable {
    private String titulo;
    private String actores;
    private String sinopsis;
    private String director;
    private int foto;


    public Pelicula(String titulo, String actores, String sinopsis, String director, int foto) {
        this.titulo = titulo;
        this.actores = actores;
        this.sinopsis = sinopsis;
        this.director = director;
        this.foto = foto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getActores() {
        return actores;
    }

    public void setActores(String actores) {
        this.actores = actores;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}