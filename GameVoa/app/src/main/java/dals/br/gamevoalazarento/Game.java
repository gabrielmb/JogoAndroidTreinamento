package dals.br.gamevoalazarento;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.media.AudioManager;
import android.media.SoundPool;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import dals.br.gamevoalazarento.assets.Canos;
import dals.br.gamevoalazarento.assets.Passaro;
import dals.br.gamevoalazarento.engine.GameOver;
import dals.br.gamevoalazarento.engine.Pontuacao;
import dals.br.gamevoalazarento.engine.Som;
import dals.br.gamevoalazarento.engine.Tela;
import dals.br.gamevoalazarento.engine.VerificadorDeColisao;

/**
 * Created by gabriel.barbosa on 30/01/2017.
 */

public class Game extends SurfaceView implements Runnable, View.OnTouchListener {

    private boolean isRunning = true;

    private final SurfaceHolder holder = getHolder();
    private Bitmap background;

    private Passaro passaro;
    private Tela tela;
    private Canos canos;
    private Pontuacao pontuacao;
    private GameOver gameOver;
    private Som som;

    public Game(Context context) {
        super(context);
        inicializaElementos();
        setOnTouchListener(this);
    }

    private void inicializaElementos() {
        this.tela = new Tela(getContext());
        this.som = new Som(getContext());
        this.pontuacao = new Pontuacao(som);
        this.passaro = new Passaro(tela,getResources(),som);
        Bitmap back = BitmapFactory.decodeResource(getResources(),R.drawable.background);
        this.background = Bitmap.createScaledBitmap(back,back.getWidth(),tela.getAltura(),false);
        this.canos = new Canos(tela,pontuacao,getResources());
        this.gameOver = new GameOver(tela);
    }

    @Override
    public void run() {
        while (isRunning){
            if(holder.getSurface().isValid()) {
                Canvas canvas = holder.lockCanvas();
                canvas.drawBitmap(background,0,0,null);
                passaro.desenhaNo(canvas);
                passaro.cai();

                canos.desenhaNo(canvas);
                canos.move();
                pontuacao.desenhaNo(canvas);

                if(new VerificadorDeColisao(passaro,canos).temColisao()){
                    gameOver.desenhaNo(canvas);
                    isRunning = false;
                }

                holder.unlockCanvasAndPost(canvas);
            }
        }
    }

    public void cancela() {
        this.isRunning = false;
    }

    public void inicia() {
        this.isRunning = true;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        passaro.pula();
        return false;
    }
}
