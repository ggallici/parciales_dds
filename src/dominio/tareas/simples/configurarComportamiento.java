package dominio.tareas.simples;

import dominio.EsqueletoFunzo;
import dominio.comportamiento.TipoComportamiento;
import dominio.tareas.Tarea;

public class configurarComportamiento implements Tarea {

	private TipoComportamiento comportamiento;

	public configurarComportamiento(TipoComportamiento comportamiento) {

		this.comportamiento = comportamiento;
	}

	@Override
	public void ejecutar(EsqueletoFunzo esqueleto) {

		esqueleto.agregarComportamiento(comportamiento);
	}
}
