package dals.br.gamevoalazarento.assets;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

/**
 * Created by gabriel.barbosa on 30/01/2017.
 */

public class Cores {

    public Cores() {
    }

    public static Paint getCorDoPassaro(){
        Paint vermelho = new Paint();
        vermelho.setColor(Color.RED);
        return  vermelho;
    }

    public static Paint getCorDoCano(){
        Paint verde = new Paint();
        verde.setColor(0xFF00FF00);
        return verde;
    }

    public static Paint getCorDaPontuacao() {
        Paint branco = new Paint();
        branco.setColor(Color.WHITE);
        branco.setTextSize(80);
        branco.setTypeface(Typeface.DEFAULT_BOLD);
        branco.setShadowLayer(3 , 5 , 5 ,0xFF000000);
        return branco;
    }

    public static Paint getCorDoGameOver() {
        Paint go = new Paint();
        go.setColor(Color.RED);
        go.setTextSize(50);
        go.setTypeface(Typeface.DEFAULT_BOLD);
        go.setShadowLayer(2,3,3,0xFF000000);
        return go;
    }
}
