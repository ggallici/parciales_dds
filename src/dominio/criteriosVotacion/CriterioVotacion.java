package dominio.criteriosVotacion;

import java.util.Collection;

import dominio.PartidoPolitico;
import dominio.Votante;

public interface CriterioVotacion {

	public PartidoPolitico aplicarCon(Votante votante, Collection<PartidoPolitico> partidos);
}