package dominio;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Zona {

	private long felicidad;
	private Collection<Votante> votantes;
	
	
	public Map<PartidoPolitico, Long> intencionesDeVoto(Collection<PartidoPolitico> partidos) {
		
		return votantes
				.stream()
				.map(votante -> votante.aQuienVotariaDe(partidos))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	}
}