package dominio;

import dominio.comportamiento.TipoComportamiento;

public class Funzo {

	protected TipoComportamiento comportamiento;
	
	public void jugar() {
		
		comportamiento.jugar(this);
	}
}