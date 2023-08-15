package cl.tenpo.utils.encrypt.parcial;

import cl.tenpo.utils.encrypt.parcial.perfiles.Genero;
import cl.tenpo.utils.encrypt.parcial.fotos.Foto;
import cl.tenpo.utils.encrypt.parcial.fotos.Notificador;
import cl.tenpo.utils.encrypt.parcial.grillas.Grilla;
import cl.tenpo.utils.encrypt.parcial.perfiles.TipoGenero;
import cl.tenpo.utils.encrypt.parcial.grillas.Localizador;
import cl.tenpo.utils.encrypt.parcial.grillas.Ubicacion;
import cl.tenpo.utils.encrypt.parcial.grillas.filtros.Filtro;
import cl.tenpo.utils.encrypt.parcial.tipos.Tipo;
import cl.tenpo.utils.encrypt.parcial.alertas.Alerta;
import cl.tenpo.utils.encrypt.parcial.acciones.AccionAgregarTipo;
import cl.tenpo.utils.encrypt.parcial.acciones.AccionSetFoto;
import cl.tenpo.utils.encrypt.parcial.acciones.AccionGetPerfilesCercanos;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class Perfil {
    private static final String MSJ_FOTO_HA_SIDO = "Su foto %s ha sido %s";
    private static final String MSJ_ACEPTADA = "aceptada";
    private static final String MSJ_RECHAZADA = "rechazada";

    private static final String MSJ_PERFIL_CERCA = "Perfil %s cerca de tu área";

    private static final long MINUTOS_ANTES_DE_FIGURAR_DESCONECTADO = 10;
    private static final long MINUTOS_ANTES_DE_NECESITAR_ACTUALIZAR_UBICACION = 5;

    private Grilla grilla;
    private Localizador localizador;
    private Notificador notificador;

    private String nombre;
    private Integer edad;
    private Foto foto;
    private Float altura;
    private Float peso;
    private Genero genero;

    private Ubicacion ubicacion;
    private LocalDateTime horarioUltimaAccion;

    private List<Tipo> tipos;
    private List<Alerta> alertas;

    public Perfil(Grilla grilla, Localizador localizador, Notificador notificador, String nombre, Integer edad, Foto foto, Float altura, Float peso, Genero genero) {
        this.grilla = grilla;
        this.localizador = localizador;
        this.notificador = notificador;

        this.nombre = nombre;
        this.edad = edad;
        this.foto = foto;
        this.altura = altura;
        this.peso = peso;
        this.genero = genero;
    }

    private void notificar(String mensaje) {
        notificador.enviarNotificacion(this, mensaje);
    }

    private void notificarFotoAceptada() {
        notificar(MSJ_FOTO_HA_SIDO.formatted(foto, MSJ_ACEPTADA));
    }

    private void notificarFotoRechazada() {
        notificar(MSJ_FOTO_HA_SIDO.formatted(foto, MSJ_RECHAZADA));
    }

    public void notificarPerfilCercano(Perfil perfil) {
        notificar(MSJ_PERFIL_CERCA.formatted(perfil));
    }

    // Antes de aceptar o rechazar hay que filtrar perfiles que `tieneFotoPendiente`
    public void aceptarFoto() {
        foto.aceptar();
        notificarFotoAceptada();
    }

    public void rechazarFoto() {
        foto.rechazar();
        notificarFotoRechazada();
    }

    public double distanciaA(Perfil perfil) {
        return ubicacion.distanciaA(perfil.ubicacion);
    }

    public boolean tieneFoto() {
        return foto != null;
    }

    public boolean noTieneFoto() {
        return !tieneFoto();
    }

    public boolean tieneFotoPendiente() {
        return tieneFoto() && foto.estaPendiente();
    }

    public boolean tieneFotoAceptada() {
        return tieneFoto() && foto.estaAceptada();
    }

    public boolean tieneFotoRechazada() {
        return tieneFoto() && foto.estaRechazada();
    }

    private long minutosDesdeUltimaAccion() {
        return Duration.between(horarioUltimaAccion, LocalDateTime.now()).toMinutes();
    }

    public boolean necesitaActualizarUbicacion() {
        return minutosDesdeUltimaAccion() > MINUTOS_ANTES_DE_NECESITAR_ACTUALIZAR_UBICACION;
    }

    public boolean estaConectado() {
        return minutosDesdeUltimaAccion() <= MINUTOS_ANTES_DE_FIGURAR_DESCONECTADO;
    }

    public boolean estaDesconectado() {
        return !estaConectado();
    }

    private boolean tieneGenero() {
        return genero != null;
    }

    public boolean tieneTipoGenero(TipoGenero tipoGenero) {
        return tieneGenero() && genero.esDelTipo(tipoGenero);
    }

    public void actualizarUbicacion() {
        this.ubicacion = localizador.localizar(this);
    }

    public void actualizarHorarioUltimaAccion() {
        this.horarioUltimaAccion = LocalDateTime.now();
        grilla.notificarInteresadosSobrePerfilCercano(this);
    }

    public boolean encajaConAlgunaDeLasAlertasDe(Perfil perfil) {
        return perfil.alertas.stream()
                .filter(alerta -> alerta.coincideDistancia(perfil, this))
                .anyMatch(alerta -> alerta.coincideTipo(this));
    }

    public List<Perfil> _getPerfilesCercanos(List<Filtro> filtros, List<Tipo> tipos) {
        return grilla.perfilesCercanosA(this, filtros, tipos);
    }

    public List<Perfil> getPerfilesCercanos(List<Filtro> filtros, List<Tipo> tipos) {
        return new AccionGetPerfilesCercanos(filtros, tipos)
                .realizarSobre(this);
    }

    public void _setFoto(Foto foto) {
        this.foto = foto;
    }

    public void setFoto(Foto foto) {
        new AccionSetFoto(foto)
                .realizarSobre(this);
    }

    public void _agregarTipo(Tipo tipo) {
        tipos.add(tipo);
    }

    public void agregarTipo(Tipo tipo) {
        new AccionAgregarTipo(tipo)
                .realizarSobre(this);
    }

    // GETTERS Y SETTERS
    public String getNombre() {
        return nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public Foto getFoto() {
        return foto;
    }

    public Float getAltura() {
        return altura;
    }

    public Float getPeso() {
        return peso;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public void setAltura(Float altura) {
        this.altura = altura;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
}
