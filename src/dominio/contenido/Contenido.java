package dominio.contenido;

import java.util.stream.Stream;

public abstract class Contenido {

	public Stream<Contenido> getContenidoMultimedia() {
		
		return Stream.of(this);
	}
}