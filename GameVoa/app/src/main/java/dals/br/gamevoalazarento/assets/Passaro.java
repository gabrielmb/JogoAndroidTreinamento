package dals.br.gamevoalazarento.assets;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import dals.br.gamevoalazarento.R;
import dals.br.gamevoalazarento.engine.Som;
import dals.br.gamevoalazarento.engine.Tela;

/**
 * Created by gabriel.barbosa on 30/01/2017.
 */

public class Passaro {

    private final Paint corDoPassaro = Cores.getCorDoPassaro();
    private static final int X = 100;
    private static final int RAIO = 50;
    private Bitmap passaroImg;

    private int altura;
    private Tela tela;
    private Resources resources;
    private Som som;

    public Passaro(Tela tela, Resources resources, Som som) {
        this.tela = tela;
        this.altura = 100;
        this.resources = resources;
        this.som = som;
    }

    public void desenhaNo(Canvas canvas){
        Bitmap bm = BitmapFactory.decodeResource(resources, R.drawable.passaro);
        this.passaroImg = Bitmap.createScaledBitmap(bm, RAIO*2, RAIO*2, false);
        canvas.drawBitmap(this.passaroImg,X-RAIO,altura-RAIO,null);
    }

    public void cai() {
        boolean chegouNoChao = altura + RAIO > tela.getAltura();
        if(!chegouNoChao){
            this.altura += 15;
        }else{
            som.play(Som.COLIDE);
        }
    }

    public void pula(){
        if(altura > RAIO){
            som.play(Som.PULO);
            this.altura -= 100;
        }
    }

    public static int getX() {
        return X;
    }

    public static int getRAIO() {
        return RAIO;
    }

    public int getAltura() {
        return altura;
    }
}
