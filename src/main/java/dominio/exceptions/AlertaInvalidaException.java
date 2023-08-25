package dominio.exceptions;

public class AlertaInvalidaException extends RuntimeException {
    public AlertaInvalidaException(String mensaje) {
        super(mensaje);
    }
}
