package dominio;

import dominio.hits.Hit;
import dominio.hits.HitRequest;

public class Usuario {

	private Bag bag;
	
	
	public void agregarColaborador(Usuario colaborador) {
		
		bag.agregarColaborador(colaborador);
	}
	
	public void eliminarColaborador(Usuario colaborador) {
		
		bag.eliminarColaborador(colaborador);
	}
	
	public void realizarHit(Hit unHit) {
		
		unHit.realizar(bag);
	}
	
	public void realizarHitEn(Hit unHit, Bag unBag) {
		
		unBag.validarColaborador(this);
		
		unHit.realizar(unBag);
	}
	
	public void realizarHitRequestEn(HitRequest hitRequest, Bag unBag) {
		
		unBag.validarColaborador(this);
		
		unBag.agregarHitRequestPendiente(hitRequest);
	}
	
	public void aprobarHitRequest(HitRequest hitRequest) {
		
		hitRequest.realizar(bag);
	}
	
	public void deshacerLosUltimosNHits(int n) {
		
		bag.deshacerLosUltimosNHits(n);
	}
}