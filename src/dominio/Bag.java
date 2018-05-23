package dominio;

import java.util.Collection;
import java.util.Comparator;

import dominio.contenido.Contenido;
import dominio.hits.Hit;

public class Bag implements Cloneable {

	private Collection<Hit> hits;
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
	
	public void referenciarContenido(Bag unBag) {
		
		//TODO 
	}
	
	public Bag estadoEn(Hit unHit) throws CloneNotSupportedException {
		
		Bag bagVieja = (Bag) this.clone();
		
		bagVieja.deshacerHitsHasta(unHit);
		
		return bagVieja;
	}

	public void deshacerHitsHasta(Hit unHit) {
		
		hits
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

	public void agregarHit(Hit hit) {

		hits.add(hit);
	}

	public boolean esColaborador(Usuario usuario) {
		
		return colaboradores.contains(usuario);
	}
}
