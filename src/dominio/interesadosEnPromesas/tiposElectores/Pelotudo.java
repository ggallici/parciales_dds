package dominio.interesadosEnPromesas.tiposElectores;

import dominio.Candidato;
import dominio.Promesa;
import dominio.Votante;

public class Pelotudo implements TipoVotante {

	@Override
	public void accionarAntePromesa(Votante votante, Candidato candidato, Promesa promesa) {

		//no cambio mi forma de elegir
	}
}