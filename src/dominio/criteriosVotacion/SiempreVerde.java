package dominio.criteriosVotacion;

import java.util.Collection;

import dominio.Color;
import dominio.PartidoPolitico;
import dominio.Votante;

public class SiempreVerde implements CriterioVotacion {

	public PartidoPolitico aplicarCon(Votante votante, Collection<PartidoPolitico> partidos) {
		
		return partidos
				.stream()
				.filter(partido -> partido.getColor().equals(Color.VERDE))
				.findFirst()
				.get();
	}
}