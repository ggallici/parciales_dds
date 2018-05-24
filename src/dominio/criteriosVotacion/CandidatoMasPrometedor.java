package dominio.criteriosVotacion;

import java.util.Collection;
import java.util.Comparator;

import dominio.Candidato;
import dominio.PartidoPolitico;
import dominio.Votante;

public class CandidatoMasPrometedor implements CriterioVotacion {

public PartidoPolitico aplicarCon(Votante votante, Collection<PartidoPolitico> partidos) {
		
		return partidos
				.stream()
				.flatMap(partido -> partido.getCandidatos())
				.max(Comparator.comparing(Candidato::cantidadPromesas))
				.map(candidato -> candidato.getPartido())
				.get();
	}
}