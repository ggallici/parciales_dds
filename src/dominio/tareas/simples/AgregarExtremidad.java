package dominio.tareas.simples;

import dominio.EsqueletoFunzo;
import dominio.piezas.extremidades.Extremidad;
import dominio.tareas.Tarea;

public class AgregarExtremidad implements Tarea {

	private Extremidad extremidad;

	public AgregarExtremidad(Extremidad extremidad) {

		this.extremidad = extremidad;
	}

	@Override
	public void ejecutar(EsqueletoFunzo esqueleto) {
		
		esqueleto.agregarExtremidad(extremidad);
	}

}
