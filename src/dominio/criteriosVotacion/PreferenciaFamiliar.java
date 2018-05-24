package dominio.criteriosVotacion;

import java.util.Collection;

import dominio.PartidoPolitico;
import dominio.Votante;

public class PreferenciaFamiliar implements CriterioVotacion {

	public PartidoPolitico aplicarCon(Votante votante, Collection<PartidoPolitico> partidos) {
		
		return votante.getPreferenciaFamiliar();
	}
}