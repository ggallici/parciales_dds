package dominio.perfiles;

import dominio.Perfil;
import dominio.fotos.Foto;
import dominio.fotos.CreadorFotos;
import dominio.fotos.Notificador;
import dominio.grillas.Grilla;
import dominio.grillas.Localizador;

public class CreadorPerfiles {
    private String nombre;
    private Integer edad;
    private Foto foto;
    private Float altura;
    private Float peso;
    private Genero genero;

    private CreadorFotos creadorFotos;
    private Grilla grilla;
    private Localizador localizador;
    private Notificador notificador;

    public CreadorPerfiles(CreadorFotos creadorFotos, Grilla grilla, Localizador localizador, Notificador notificador) {
        this.creadorFotos = creadorFotos;
        this.grilla = grilla;
        this.localizador = localizador;
        this.notificador = notificador;
    }

    public CreadorPerfiles conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public CreadorPerfiles conEdad(int edad) {
        this.edad = edad;
        return this;
    }

    public CreadorPerfiles conFoto(String url) {
        this.foto = creadorFotos.crearFoto(url);
        return this;
    }

    public CreadorPerfiles conAltura(float altura) {
        this.altura = altura;
        return this;
    }

    public CreadorPerfiles conPeso(float peso) {
        this.peso = peso;
        return this;
    }

    public CreadorPerfiles conGenero(TipoGeneroEspecifico tipoGeneroEspecifico) {
        this.genero = new Genero(tipoGeneroEspecifico);
        return this;
    }

    public CreadorPerfiles conGeneroNoBinarieConDescripcion(String descripcion) {
        this.genero = new Genero(descripcion);
        return this;
    }

    public Perfil build() {
        return new Perfil(grilla, localizador, notificador, nombre, edad, foto, altura, peso, genero);
    }
}
