package dominio.promesasMultiples;

import java.math.BigDecimal;
import java.util.Collection;

import dominio.Promesa;

public class PromesaMultiple extends Promesa {

	private Collection<Promesa> promesas;
	
	public BigDecimal getCosto() {
		
		return promesas.stream().map(Promesa::getCosto).reduce(new BigDecimal(0), (x,y) -> x.add(y));
	}

	public Integer cantidadTopicos() {
		
		return promesas.stream().mapToInt(Promesa::cantidadTopicos).sum();
	}
}
