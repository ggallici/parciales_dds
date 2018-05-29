package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import dominio.EsqueletoFunzo;
import dominio.Funzo;
import dominio.PlanDeTrabajo;
import dominio.comportamiento.Docil;
import dominio.piezas.Color;
import dominio.piezas.extremidades.PiernaIzquierda;
import dominio.tareas.Tarea;
import dominio.tareas.condicionales.TareaCondicional;
import dominio.tareas.multiples.TareaMultiple;
import dominio.tareas.simples.AgregarElementoSorpresa;
import dominio.tareas.simples.AgregarExtremidad;
import dominio.tareas.simples.Desechar;
import dominio.tareas.simples.Empaquetar;
import dominio.tareas.simples.Pintar;
import dominio.tareas.simples.configurarComportamiento;
import dominio.versiones.VersionPremium;

class Main {

	@Test
	void test() {

		List<Tarea> tareas = new ArrayList<>();
		tareas.add(new AgregarExtremidad(new PiernaIzquierda()));
		tareas.add(new Pintar(Color.AZUL));
		tareas.add(new configurarComportamiento(new Docil()));
		tareas.add(
				new TareaCondicional(
						unEsqueleto -> unEsqueleto.esVersionPremium(),
						new TareaMultiple(Arrays.asList(new AgregarElementoSorpresa(), new Empaquetar())),
						new Desechar()
					)
				);
		
		PlanDeTrabajo plan = new PlanDeTrabajo(tareas);
		
		EsqueletoFunzo esqueleto = new EsqueletoFunzo(new VersionPremium());
		
		Funzo funzo = plan.ejecutarPlan(esqueleto);
	}
}