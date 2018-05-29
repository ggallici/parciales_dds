package dominio;

import java.util.List;

import dominio.comportamiento.TipoComportamiento;
import dominio.piezas.Color;
import dominio.piezas.extremidades.Extremidad;
import dominio.versiones.Version;

public class EsqueletoFunzo {

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