package dominio.versiones;

import java.util.List;

import dominio.Funzo;
import dominio.comportamiento.TipoComportamiento;
import dominio.piezas.Color;
import dominio.piezas.extremidades.Extremidad;

public interface Version {

	public Funzo construir(List<Extremidad> extremidades, Color color, TipoComportamiento comportamiento);

	public boolean esPremium();
}