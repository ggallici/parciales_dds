package cl.tenpo.utils.encrypt.parcial.perfiles;

public enum TipoGeneroEspecifico {
    HOMBRE_CIS(TipoGenero.HOMBRE),
    MUJER_CIS(TipoGenero.MUJER),
    HOMBRE_TRANS(TipoGenero.HOMBRE),
    MUJER_TRANS(TipoGenero.MUJER),
    NO_BINARIE(TipoGenero.NO_BINARIE);

    private TipoGenero tipo;

    TipoGeneroEspecifico(TipoGenero tipo) {
        this.tipo = tipo;
    }

    public boolean esDelTipo(TipoGenero tipo) {
        return this.tipo.equals(tipo);
    }
}
