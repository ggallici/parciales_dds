package dominio;

import java.util.List;

import dominio.tareas.Tarea;

public class PlanDeTrabajo {

	private List<Tarea> tareas;
	
	public PlanDeTrabajo(List<Tarea> tareas) {

		this.tareas = tareas;
	}

	public Funzo ejecutarPlan(EsqueletoFunzo unEsqueleto) {
		
		tareas.forEach(tarea -> tarea.ejecutar(unEsqueleto));
		
		return unEsqueleto.construir();
	}
}