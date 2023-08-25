package dominio.fotos;

public class Foto {
    private String url;
    private EstadoFoto estado;

    public Foto(String url, EstadoFoto estado) {
        this.url = url;
        this.estado = estado;
    }

    public void setEstado(EstadoFoto estado) {
        this.estado = estado;
    }

    public void aceptar() {
        estado.aceptar(this);
    }

    public void rechazar() {
        estado.rechazar(this);
    }

    public boolean estaPendiente() {
        return estado.estaPendiente();
    }

    public boolean estaAceptada() {
        return estado.estaAceptada();
    }

    public boolean estaRechazada() {
        return estado.estaRechazada();
    }
}
