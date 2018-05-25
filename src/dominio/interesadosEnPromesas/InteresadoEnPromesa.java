package dominio.interesadosEnPromesas;

import dominio.Candidato;
import dominio.Promesa;

public interface InteresadoEnPromesa {

	public void onPromesaCumplida(Candidato candidato, Promesa promesa);
}