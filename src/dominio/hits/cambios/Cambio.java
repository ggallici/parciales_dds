package dominio.hits.cambios;

import java.time.LocalDateTime;

import dominio.Bag;

public abstract class Cambio {

	private LocalDateTime fechaRealizacion;
	
	public LocalDateTime getFechaRealizacion() {
		
		return fechaRealizacion;
	}
	
	public abstract void realizar(Bag unBag);
	
	public abstract void deshacer(Bag unBag);
}