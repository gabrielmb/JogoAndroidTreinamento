package dals.br.gamevoalazarento.engine;

import android.graphics.Canvas;
import android.graphics.Paint;

import dals.br.gamevoalazarento.assets.Cores;

/**
 * Created by gabriel.barbosa on 31/01/2017.
 */

public class Pontuacao {

    private static final Paint BRANCO = Cores.getCorDaPontuacao();

    private int pontos = 0;
    private Som som;

    public Pontuacao(Som som) {
        this.som = som;
    }

    public void aumenta() {
        som.play(Som.PONTO);
        pontos++;
    }

    public void desenhaNo(Canvas canvas){
        canvas.drawText(String.valueOf(pontos),100 ,100 , BRANCO);
    }
}
