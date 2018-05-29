package dominio.tareas.multiples;

import java.util.List;

import dominio.EsqueletoFunzo;
import dominio.tareas.Tarea;

public class TareaMultiple  implements Tarea {

	private List<Tarea> tareas;

	public TareaMultiple(List<Tarea> tareas) {

		this.tareas = tareas;
	}

	@Override
	public void ejecutar(EsqueletoFunzo esqueleto) {

		tareas.forEach(tarea -> tarea.ejecutar(esqueleto));
	}
}