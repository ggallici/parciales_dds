package dominio;

import java.util.List;

import dominio.comportamiento.TipoComportamiento;
import dominio.piezas.Color;
import dominio.piezas.extremidades.Extremidad;

public class FunzoPremium extends Funzo {

	public FunzoPremium(List<Extremidad> extremidades, Color color, TipoComportamiento comportamiento) {
		// TODO Auto-generated constructor stub
	}

	public void actualizarComportamiento(TipoComportamiento comportamiento) {
		
		this.comportamiento = comportamiento;
	}
}