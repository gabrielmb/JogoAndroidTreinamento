package dals.br.gamevoalazarento.assets;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import dals.br.gamevoalazarento.R;
import dals.br.gamevoalazarento.engine.Pontuacao;
import dals.br.gamevoalazarento.engine.Tela;

/**
 * Created by gabriel.barbosa on 31/01/2017.
 */

public class Canos {

    private static final int QUANTIDADE_DE_CANOS = 5;
    private static final int DISTANCIA_ENTRE_CANOS = 250;

    private List<Cano> canos = new ArrayList<>();
    private Tela tela;
    private Pontuacao pontuacao;
    private Resources resources;
    private Bitmap bp;

    public Canos(Tela tela,Pontuacao pontuacao,Resources resources) {
        this.tela = tela;
        this.pontuacao = pontuacao;
        this.resources = resources;
        this.bp = BitmapFactory.decodeResource(this.resources, R.drawable.cano);
        int posicaoInicial = 200;
        for(int i=0;i <QUANTIDADE_DE_CANOS;i++){
            posicaoInicial += DISTANCIA_ENTRE_CANOS;
            canos.add(new Cano(tela, posicaoInicial));
        }
    }

    public void desenhaNo(Canvas canvas){
        for(Cano cano : canos)
            cano.desenhaNo(canvas,this.bp);
    }

    public void move(){
        ListIterator<Cano> iterator = canos.listIterator();
        while (iterator.hasNext()){
            Cano cano = (Cano) iterator.next();
            cano.move();
            if(cano.saiuDaTela()){
                pontuacao.aumenta();
                iterator.remove();
                Cano outroCano = new Cano(tela, getMaximo()+DISTANCIA_ENTRE_CANOS);
                iterator.add(outroCano);
            }
        }

    }

    private int getMaximo() {
        int maximo = 0;
        for(Cano cano : canos){
            maximo = Math.max(cano.getPosicao(), maximo);
        }
        return maximo;
    }

    public boolean temColisaoCom(Passaro passaro) {
        for(Cano cano : canos){
            if(cano.temColisaoHorizontalCom(passaro)
                    && cano.temColisaoVerticalCom(passaro)){
                return true;
            }
        }
        return false;
    }
}
