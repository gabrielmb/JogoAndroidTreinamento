package dals.br.gamevoalazarento.engine;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import dals.br.gamevoalazarento.assets.Cores;

/**
 * Created by gabriel.barbosa on 31/01/2017.
 */

public class GameOver {

    private final Tela tela;

    private static final Paint GAMEOVER_COLOR = Cores.getCorDoGameOver();

    public GameOver(Tela tela) {
        this.tela = tela;
    }

    public void desenhaNo(Canvas canvas){
        String gameOver = "Perdeu Lazarento";
        int centroHorizontal = centralizaTexto(gameOver);
        canvas.drawText(gameOver, centroHorizontal, tela.getAltura() / 2, GAMEOVER_COLOR);
    }

    private int centralizaTexto(String gameOver) {
        Rect limiteDoTexto = new Rect();
        GAMEOVER_COLOR.getTextBounds(gameOver,0,gameOver.length(),limiteDoTexto);
        int centroHorizontal = tela.getLargura()/2 - (limiteDoTexto.right - limiteDoTexto.left) /2;
        return centroHorizontal;
    }
}
