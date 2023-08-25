package dominio.perfiles;

public class Genero {
    private TipoGeneroEspecifico tipoEspecifico;
    private String descripcion;

    public Genero(TipoGeneroEspecifico tipoEspecifico) {
        this.tipoEspecifico = tipoEspecifico;
    }

    public Genero(String descripcion) {
        this.tipoEspecifico = TipoGeneroEspecifico.NO_BINARIE;
        this.descripcion = descripcion;
    }

    public boolean esDelTipo(TipoGenero tipo) {
        return tipoEspecifico.esDelTipo(tipo);
    }
}
