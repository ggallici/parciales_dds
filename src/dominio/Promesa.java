package dominio;

import java.math.BigDecimal;
import java.util.Collection;

//ESTO TIENE QUE SER ABSTRACTO
public class Promesa {

	private String descripcion;
	private Collection<Topico> topicosQueAfecta;
	private BigDecimal costo;
	
	public void cumplir() {
		
		
	}

	//MMMM VS DESIS
	public boolean contieneAlgunTopicoDe(Collection<Topico> otrosTopicos) {
		
		return topicosQueAfecta.stream().anyMatch(otrosTopicos::contains);
	}

	public BigDecimal getCosto() {
		
		return costo;
	}

	public Integer cantidadTopicos() {
		
		return topicosQueAfecta.size();
	}
	
	public Double porcentajeDeAceptacion(Collection<Votante> votantes) {
		
		return cantidadAFavor(votantes) - cantidadAEnContra(votantes) / votantes.size();
	}

	private double cantidadAEnContra(Collection<Votante> votantes) {
		// TODO Auto-generated method stub
		return votantes.stream().filter(votante -> votante.estaEnContra(this)).count();
	}

	private double cantidadAFavor(Collection<Votante> votantes) {
		// TODO Auto-generated method stub
		return votantes.stream().filter(votante -> votante.estaAFavor(this)).count();
	}
}