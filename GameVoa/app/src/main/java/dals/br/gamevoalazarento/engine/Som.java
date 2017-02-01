package dals.br.gamevoalazarento.engine;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

import dals.br.gamevoalazarento.R;

/**
 * Created by gabriel.barbosa on 31/01/2017.
 */

public class Som {

    private SoundPool soundPool;

    public static int PULO;
    public static int COLIDE;
    public static int PONTO;

    public Som(Context context) {
        this.soundPool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
        PULO = soundPool.load(context, R.raw.pulo, 1);
        COLIDE = soundPool.load(context, R.raw.colisao, 1);
        PONTO = soundPool.load(context,R.raw.pontos,1);
    }

    public void play(int som){
        soundPool.play(som,1,1,1,0,1);
    }
}
