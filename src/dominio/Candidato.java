package dominio;

import java.util.Collection;

public class Candidato {

	private Collection<Promesa> promesas;
	private PartidoPolitico partido;
	
	public int cantidadPromesas() {
		
		return promesas.size();
	}

	public PartidoPolitico getPartido() {
		
		return partido;
	}
	
	public long cantidadDePromesasQueLeInteresan(Votante unVotante) {
		
		return promesas
				.stream()
				.filter(promesa -> promesa.contieneAlgunTopicoDe(unVotante.getTopicosDeInteres()))
				.count();
	}
}