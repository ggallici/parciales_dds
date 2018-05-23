package dominio.hits.cambios;

import dominio.Bag;
import dominio.contenido.Contenido;

public class Agregar extends Cambio {

	private Contenido contenidoNuevo;
	
	@Override
	public void realizar(Bag unBag) {

		unBag.agregarContenido(contenidoNuevo);
	}

	@Override
	public void deshacer(Bag unBag) {

		unBag.eliminarContenido(contenidoNuevo);
	}
}