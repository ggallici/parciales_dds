package dominio.criteriosOrdenPromesas;

import java.util.Comparator;

import dominio.Promesa;

public interface CriterioOrdenPromesas extends Comparator<Promesa> {

	@Override
	public int compare(Promesa unaPromesa, Promesa otraPromesa);
}