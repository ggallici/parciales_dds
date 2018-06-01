package dominio;

import java.util.List;

import dominio.comportamiento.TipoComportamiento;
import dominio.piezas.Color;
import dominio.piezas.extremidades.Extremidad;
import dominio.versiones.Version;

public class EsqueletoFunzo {
	
	/*
		ACA LA VERSION ES UN FACTORY METHOD, OTRAS OPCIONES PODRÍAN HABER SIDO:
			. UN STRATEGY: LA VERSION SE PASA COMO ARGUMENTO AL FUNZO Y DEPENDIENDO QUE VERSION SEA,
				       EL METODO "validarCambioComportamiento" TIRA UNA EXCEPCION EN EL METODO ACTUALIZAR COMPORTAMIENTO
				       (ESTA OPCION ELIMINA LAS CLASES: FUNZOPREMIUM, FUNZOBASE)
			. UN BOOLEANO: "esPremium" SE PASA COMO ARGUMENTO AL FUNZO, HACE TIPE TEST Y LANZA LA EXCEPCION
					(ESTA OPCION ELIMINA LAS CLASES: FUNZOPREMIUM, FUNZOBASE, VERSION, VERSIONPREMIUM, VERSIONBASE)
			AMBAS OPCIONES, PERMITEN QUE LA VERSION SEA CAMBIADA A FUTURO.
	*/
	private Version version;
	private List<Extremidad> extremidades;
	private Color color;
	private TipoComportamiento comportamiento;

	public EsqueletoFunzo(Version version) {
		
		this.version = version;
	}

	public void agregarExtremidad(Extremidad extremidad) {
		
		extremidades.add(extremidad);
	}

	public void pintar(Color color) {
		
		this.color = color;
	}

	public void agregarComportamiento(TipoComportamiento comportamiento) {

		this.comportamiento = comportamiento;
	}

	public Funzo construir() {

		return version.construir(extremidades, color, comportamiento);
	}

	public boolean esVersionPremium() {
		
		return version.esPremium();
	}
}
