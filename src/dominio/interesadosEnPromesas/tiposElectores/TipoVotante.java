package dominio.interesadosEnPromesas.tiposElectores;

import dominio.Candidato;
import dominio.Promesa;
import dominio.Votante;

public interface TipoVotante {

	void accionarAntePromesa(Votante votante, Candidato candidato, Promesa promesa);
}