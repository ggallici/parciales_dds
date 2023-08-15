package cl.tenpo.utils.encrypt.parcial.perfiles;

import cl.tenpo.utils.encrypt.parcial.Perfil;
import cl.tenpo.utils.encrypt.parcial.fotos.Foto;
import cl.tenpo.utils.encrypt.parcial.fotos.VerificadorFotos;
import cl.tenpo.utils.encrypt.parcial.fotos.Notificador;
import cl.tenpo.utils.encrypt.parcial.grillas.Grilla;
import cl.tenpo.utils.encrypt.parcial.grillas.Localizador;

public class CreadorPerfiles {
    private String nombre;
    private Integer edad;
    private Foto foto;
    private Float altura;
    private Float peso;
    private Genero genero;

    private VerificadorFotos verificadorFotos;
    private Grilla grilla;
    private Localizador localizador;
    private Notificador notificador;

    public CreadorPerfiles(VerificadorFotos verificadorFotos, Grilla grilla, Localizador localizador, Notificador notificador) {
        this.verificadorFotos = verificadorFotos;
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
        this.foto = verificadorFotos.verificarFoto(url);
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
