package dominio;

import java.math.BigDecimal;
import java.util.Collection;

import dominio.criteriosOrdenPromesas.CriterioOrdenPromesas;

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
	
	public void cumplirPromesasEnBaseA(BigDecimal unPresupuesto, CriterioOrdenPromesas criterio) {

		BigDecimal acumulado = new BigDecimal(0);
		
		promesas
		.stream()
		.sorted(criterio)
		.takeWhile(promesa -> acumulado.compareTo(unPresupuesto) <= 0)
		.forEach(promesa -> {
			
			promesa.cumplir();
			
			acumulado.add(promesa.getCosto());
		});
	}
}