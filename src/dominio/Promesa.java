package dominio;

import java.math.BigDecimal;
import java.util.Collection;

//ESTO TIENE QUE SER ABSTRACTO
public class Promesa {

	private String descripcion;
	private Collection<Topico> topicosQueAfecta;
	private BigDecimal costo;
	
	public void implementar() { }

	//MMMM VS DESIS
	public boolean contieneAlgunTopicoDe(Collection<Topico> otrosTopicos) {
		
		return topicosQueAfecta.stream().anyMatch(otrosTopicos::contains);
	}
}