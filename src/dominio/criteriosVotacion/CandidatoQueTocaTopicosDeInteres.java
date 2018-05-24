package dominio.criteriosVotacion;

import java.util.Collection;
import java.util.Comparator;

import dominio.PartidoPolitico;
import dominio.Votante;

public class CandidatoQueTocaTopicosDeInteres implements CriterioVotacion {

	public PartidoPolitico aplicarCon(Votante votante, Collection<PartidoPolitico> partidos) {
		
		return partidos
				.stream()
				.flatMap(partido -> partido.getCandidatos())
				.max(Comparator.comparing(candidato -> candidato.cantidadDePromesasQueLeInteresan(votante)))
				.map(candidato -> candidato.getPartido())
				.get();
	}
}