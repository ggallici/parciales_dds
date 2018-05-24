package dominio;

import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Stream;

import dominio.contenido.Contenido;
import dominio.hits.Hit;
import dominio.hits.HitRequest;

public class Bag extends Contenido implements Cloneable {

	private Collection<Hit> historialDeHits;
	private Collection<HitRequest> hitRequests;
	private Collection<Contenido> contenidos;
	private Collection<Usuario> colaboradores;
	
	public void agregarContenido(Contenido contenido) {
		
		contenidos.add(contenido);
	}
	
	public void eliminarContenido(Contenido contenido) {
		
		contenidos.remove(contenido);
	}
	
	public void modificarContenido(Contenido viejo, Contenido nuevo) {
		
		contenidos.remove(viejo);
		
		contenidos.add(nuevo);
	}
	
	public Bag estadoEn(Hit unHit) throws CloneNotSupportedException {
		
		Bag bagVieja = (Bag) this.clone();
		
		bagVieja.deshacerHitsHasta(unHit);
		
		return bagVieja;
	}

	public void deshacerHitsHasta(Hit unHit) {
		
		historialDeHits
		.stream()
		.sorted(Comparator.comparing(Hit::getFechaRealizacion))
		.filter(hit -> hit.esAnteriorA(unHit))
		.forEach(hit -> hit.deshacer(this));
	}

	public void agregarColaborador(Usuario colaborador) {

		colaboradores.add(colaborador);
	}

	public void eliminarColaborador(Usuario colaborador) {

		colaboradores.remove(colaborador);
	}

	public void agregarHitAlHistorial(Hit hit) {

		historialDeHits.add(hit);
	}

	public boolean esColaborador(Usuario usuario) {
		
		return colaboradores.contains(usuario);
	}

	public void validarColaborador(Usuario usuario) {
		
		if(!esColaborador(usuario))
		
			throw new NoEsColaboradorException();
	}

	public void agregarHitRequestPendiente(HitRequest hitRequest) {

		hitRequests.add(hitRequest);
	}

	public void deshacerLosUltimosNHits(int n) {

		historialDeHits
		.stream()
		.sorted(Comparator.comparing(Hit::getFechaRealizacion))
		.skip(n)
		.forEach(hit -> hit.deshacer(this));		
	}

	@Override
	public Stream<Contenido> getContenidoMultimedia() {
		
		return contenidos
				.stream()
				.flatMap(contenido -> contenido.getContenidoMultimedia());
	}
}