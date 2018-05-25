package dominio.interesadosEnPromesas.tiposElectores;

import dominio.Candidato;
import dominio.Promesa;
import dominio.Votante;

public class SegunPromesa implements TipoVotante {

	@Override
	public void accionarAntePromesa(Votante votante, Candidato candidato, Promesa promesa) {

		if(promesa.contieneAlgunTopicoDe(votante.getTopicosDeInteres()))
		
			votante.setPreferenciaFamiliar(candidato.getPartido());
	}
}