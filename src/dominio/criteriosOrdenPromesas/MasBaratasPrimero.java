package dominio.criteriosOrdenPromesas;

import dominio.Promesa;

public class MasBaratasPrimero implements CriterioOrdenPromesas {

	@Override
	public int compare(Promesa unaPromesa, Promesa otraPromesa) {
		
		return unaPromesa.getCosto().compareTo(otraPromesa.getCosto());
	}
}