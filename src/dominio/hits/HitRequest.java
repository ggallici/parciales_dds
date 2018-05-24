package dominio.hits;

import java.util.Collection;

import dominio.Bag;

public class HitRequest {

	private Collection<Hit> hits;
	private boolean aprobado;
	
	public void realizar(Bag bag) {

		hits.forEach(hit -> hit.realizar(bag));
		
		aprobado = true;
	}
	
	

}
