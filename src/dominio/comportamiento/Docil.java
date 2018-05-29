package dominio.comportamiento;

import dominio.Funzo;

public class Docil implements TipoComportamiento {

	@Override
	public void jugar(Funzo juguete) {

		System.out.println("Soy un marica jugando");
	}
}