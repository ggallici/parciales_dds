package dominio;

import java.util.Collection;

import dominio.criteriosVotacion.CriterioVotacion;

public class Votante {

	private Collection<Topico> topicosDeInteres;
	private CriterioVotacion criterioDeEleccion;
	private PartidoPolitico preferenciaFamiliar;
	
	public PartidoPolitico getPreferenciaFamiliar() {
		
		return preferenciaFamiliar;
	}

	public Collection<Topico> getTopicosDeInteres() {
		
		return topicosDeInteres;
	}
	
	public PartidoPolitico aQuienVotariaDe(Collection<PartidoPolitico> partidos) {
		
		return criterioDeEleccion.aplicarCon(this, partidos);
	}

	public boolean estaEnContra(Promesa promesa) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean estaAFavor(Promesa promesa) {
		// TODO Auto-generated method stub
		return false;
	}
}