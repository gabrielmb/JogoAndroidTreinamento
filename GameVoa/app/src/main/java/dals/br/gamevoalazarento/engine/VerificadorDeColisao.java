package dals.br.gamevoalazarento.engine;

import dals.br.gamevoalazarento.assets.Canos;
import dals.br.gamevoalazarento.assets.Passaro;

/**
 * Created by gabriel.barbosa on 31/01/2017.
 */

public class VerificadorDeColisao {

    private final Passaro passaro;
    private final Canos canos;
    
    public VerificadorDeColisao(Passaro passaro, Canos canos) {
        this.passaro = passaro;
        this.canos = canos;
    }

    public boolean temColisao() {
        return canos.temColisaoCom(passaro);
    }
}
