package dominio.hits;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Comparator;

import dominio.Bag;
import dominio.hits.cambios.Cambio;

public class Hit {

	private LocalDateTime fechaRealizacion;
	private Collection<Cambio> cambios;

	public boolean esAnteriorA(Hit unHit) {
		
		return fechaRealizacion.isBefore(unHit.getFechaRealizacion());
	}

	public LocalDateTime getFechaRealizacion() {
		
		return fechaRealizacion;
	}

	public void deshacer(Bag unBag) {
		
		cambios
		.stream()
		.sorted(Comparator.comparing(Cambio::getFechaRealizacion))
		.forEach(cambio -> cambio.deshacer(unBag));
	}

	public void realizar(Bag unBag) {

		cambios
		.stream()
		.forEach(cambio -> cambio.realizar(unBag));
		
		unBag.agregarHitAlHistorial(this);
	}
}