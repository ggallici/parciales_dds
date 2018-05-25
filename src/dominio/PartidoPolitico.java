package dominio;

import java.util.Collection;
import java.util.stream.Stream;

public class PartidoPolitico {

	private Color color;
	private Collection<Candidato> candidatos;
	
	public Color getColor() {
		
		return color;
	}

	public Stream<Candidato> getCandidatos() {
	
		return candidatos.stream();
	}
}