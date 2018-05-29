package dominio.tareas.condicionales;

import dominio.EsqueletoFunzo;
import dominio.tareas.Tarea;

public class TareaCondicional implements Tarea {

	private Condicion condicion;
	private Tarea tareaSiCumple;
	private Tarea tareaSiNoCumple;
	
	public TareaCondicional(Condicion condicion, Tarea tareaSiCumple, Tarea tareaSiNoCumple) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ejecutar(EsqueletoFunzo esqueleto) {

		if(condicion.seCumple(esqueleto))
			tareaSiCumple.ejecutar(esqueleto);
		else
			tareaSiNoCumple.ejecutar(esqueleto);
	}
}