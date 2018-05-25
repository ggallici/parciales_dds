package dominio;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import dominio.interesadosEnPromesas.InteresadoEnPromesa;

public class Zona implements InteresadoEnPromesa {

	private BigDecimal felicidad;
	private Collection<Votante> votantes;
	
	
	public Map<PartidoPolitico, Long> intencionesDeVoto(Collection<PartidoPolitico> partidos) {
		
		return votantes
				.stream()
				.map(votante -> votante.aQuienVotariaDe(partidos))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	}

	@Override
	public void onPromesaCumplida(Candidato candidato, Promesa promesa) {

		felicidad
		.add(
				promesa.getCosto()
				.divide(new BigDecimal(1000))
				.multiply(new BigDecimal(promesa.cantidadTopicos()))
		);
	}

	public boolean esValiosa() {
		
		return felicidad.compareTo(new BigDecimal(10000000)) > 1;
	}
}