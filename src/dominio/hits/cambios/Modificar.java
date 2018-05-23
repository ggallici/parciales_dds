package dominio.hits.cambios;

import dominio.Bag;
import dominio.contenido.Contenido;

public class Modificar extends Cambio {

	private Contenido contenidoViejo;
	private Contenido contenidoNuevo;
	
	@Override
	public void realizar(Bag unBag) {

		unBag.modificarContenido(contenidoViejo, contenidoNuevo);
	}

	@Override
	public void deshacer(Bag unBag) {
		
		unBag.modificarContenido(contenidoNuevo, contenidoViejo);
	}
}