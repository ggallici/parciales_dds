package dominio.interesadosEnPromesas.tiposElectores;

import dominio.Candidato;
import dominio.Promesa;
import dominio.Votante;

public class SegunZona implements TipoVotante {

	@Override
	public void accionarAntePromesa(Votante votante, Candidato candidato, Promesa promesa) {

		if(votante.getZona().esValiosa())
			
			votante.setPreferenciaFamiliar(candidato.getPartido());
	}
}