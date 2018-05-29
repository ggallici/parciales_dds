package dominio.tareas.simples;

import dominio.EsqueletoFunzo;
import dominio.piezas.Color;
import dominio.tareas.Tarea;

public class Pintar implements Tarea {

	private Color color;

	public Pintar(Color color) {

		this.color = color;
	}

	@Override
	public void ejecutar(EsqueletoFunzo esqueleto) {

		esqueleto.pintar(color);
	}
}