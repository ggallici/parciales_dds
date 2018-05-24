package dominio.criteriosOrdenPromesas;

import java.util.Collection;

import dominio.Promesa;
import dominio.Votante;

public class MasAceptadasPrimero implements CriterioOrdenPromesas {

	private Collection<Votante> votantes;
	
	@Override
	public int compare(Promesa unaPromesa, Promesa otraPromesa) {
		
		return unaPromesa.porcentajeDeAceptacion(votantes).compareTo(otraPromesa.porcentajeDeAceptacion(votantes));
	}
}