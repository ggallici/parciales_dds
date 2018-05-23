package dominio.hits.cambios;

import dominio.Bag;
import dominio.contenido.Contenido;

public class Eliminar extends Cambio {

	private Contenido contenidoViejo;
	
	@Override
	public void realizar(Bag unBag) {

		unBag.eliminarContenido(contenidoViejo);
	}

	@Override
	public void deshacer(Bag unBag) {

		unBag.agregarContenido(contenidoViejo);
	}
}