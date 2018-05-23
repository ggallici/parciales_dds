package dominio;

import dominio.hits.Hit;

public class Usuario {

	private Bag bag;
	
	
	public void agregarColaborador(Usuario colaborador) {
		
		bag.agregarColaborador(colaborador);
	}
	
	public void eliminarColaborador(Usuario colaborador) {
		
		bag.eliminarColaborador(colaborador);
	}
	
	public void realizarHit(Hit hit) {
		
		bag.agregarHit(hit);
	}
	
	public void realizarHitEn(Hit hit, Bag unBag) {
		
		if(!unBag.esColaborador(this))
		
			throw new NoEsColaboradorException();
		
		unBag.agregarHit(hit);
	}
	
	public void realizarHitRequestEn(Bag unBag) {
		
		
	}
	
	public void aprobarHitRequest() {
		
		
	}
}