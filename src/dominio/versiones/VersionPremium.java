package dominio.versiones;

import java.util.List;

import dominio.Funzo;
import dominio.FunzoPremium;
import dominio.comportamiento.TipoComportamiento;
import dominio.piezas.Color;
import dominio.piezas.extremidades.Extremidad;

public class VersionPremium implements Version {

	@Override
	public Funzo construir(List<Extremidad> extremidades, Color color, TipoComportamiento comportamiento) {

		return new FunzoPremium(extremidades, color, comportamiento);
	}

	@Override
	public boolean esPremium() {
		
		return true;
	}
}