package dominio;

import java.util.Collection;

import dominio.criteriosVotacion.CriterioVotacion;
import dominio.interesadosEnPromesas.InteresadoEnPromesa;
import dominio.interesadosEnPromesas.tiposElectores.TipoVotante;

public class Votante implements InteresadoEnPromesa {

	private Collection<Topico> topicosDeInteres;
	private CriterioVotacion criterioDeEleccion;
	private PartidoPolitico preferenciaFamiliar;
	private TipoVotante tipo;
	
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

	@Override
	public void onPromesaCumplida(Candidato candidato, Promesa promesa) {

		tipo.accionarAntePromesa(this, candidato, promesa);
	}

	public void setPreferenciaFamiliar(PartidoPolitico preferenciaFamiliar) {
		this.preferenciaFamiliar = preferenciaFamiliar;
	}

	public Zona getZona() {
		// TODO Auto-generated method stub
		return null;
	}
}