package dominio;

import java.util.Map;
import java.util.stream.Stream;

public class PartidoPolitico {

	private Color color;
	private Map<Zona, Candidato> candidatosPorZona;
	
	public Color getColor() {
		
		return color;
	}

	public Stream<Candidato> getCandidatos() {
	
		return candidatosPorZona.values().stream();
	}
}