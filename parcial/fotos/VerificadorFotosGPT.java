package cl.tenpo.utils.encrypt.parcial.fotos;

import cl.tenpo.utils.encrypt.parcial.fotos.externo.VerifyGPT;

public class VerificadorFotosGPT implements VerificadorFotos {
    private VerifyGPT verifyGPT;

    @Override
    public Foto verificarFoto(String url) {
        return new Foto(url, determinarEstado(url));
    }

    private EstadoFoto determinarEstado(String url) {
        var porcentaje = verifyGPT.rateContentSafery(url);

        if (porcentaje > 0.7)
            return EstadoFoto.ACEPTADA;
        if (porcentaje < 0.3)
            return EstadoFoto.RECHAZADA;

        return EstadoFoto.PENDIENTE;
    }
}
