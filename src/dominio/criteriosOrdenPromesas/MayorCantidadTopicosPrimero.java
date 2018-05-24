package dominio.criteriosOrdenPromesas;

import dominio.Promesa;

public class MayorCantidadTopicosPrimero implements CriterioOrdenPromesas {

	@Override
	public int compare(Promesa unaPromesa, Promesa otraPromesa) {
		
		return unaPromesa.cantidadTopicos().compareTo(otraPromesa.cantidadTopicos());
	}
}