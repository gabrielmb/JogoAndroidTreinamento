package dals.br.gamevoalazarento.assets;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

import dals.br.gamevoalazarento.engine.Tela;

/**
 * Created by gabriel.barbosa on 31/01/2017.
 */

public class Cano {

    private static final int TAMANHO_DO_CANO = 250;
    private static final int LARGURA_DO_CANO = 100;

    private final Paint verde = Cores.getCorDoCano();

    private int alturaDoCanoInferior;
    private int alturaDoCanoSuperior;
    private int posicao;
    private Tela tela;
    private Bitmap bp;
    private Bitmap canoInferior;
    private Bitmap canoSuperior;

    public Cano(Tela tela, int posicao) {
        this.tela = tela;
        this.posicao = posicao;
        this.alturaDoCanoInferior = tela.getAltura() - TAMANHO_DO_CANO - valorAleatorio();
        this.alturaDoCanoSuperior = 0 + TAMANHO_DO_CANO + valorAleatorio();
    }

    private int valorAleatorio() {
        return (int) (Math.random() * 150);
    }

    public void desenhaNo(Canvas canvas, Bitmap bp){
        this.bp = bp;
        desenhaCanoInferiorNo(canvas);
        desenhaCanoSuperiorNo(canvas);
    }

    private void desenhaCanoInferiorNo(Canvas canvas){
        this.canoInferior = Bitmap.createScaledBitmap(this.bp,LARGURA_DO_CANO, this.alturaDoCanoInferior, false);
        canvas.drawBitmap(canoInferior,posicao,alturaDoCanoInferior, null);
    }

    private void desenhaCanoSuperiorNo(Canvas canvas){
        this.canoSuperior = Bitmap.createScaledBitmap(this.bp,LARGURA_DO_CANO,
                    this.alturaDoCanoSuperior, false);
        canvas.drawBitmap(canoSuperior,posicao, 0, null);
    }

    public void move() {
        posicao -= 8;
    }

    public boolean saiuDaTela() {
        return posicao+LARGURA_DO_CANO < 0;
    }

    public int getPosicao() {
        return posicao+LARGURA_DO_CANO;
    }

    public boolean temColisaoHorizontalCom(Passaro passaro) {
        return this.posicao - passaro.getX() < passaro.getRAIO();
    }

    public boolean temColisaoVerticalCom(Passaro passaro) {
        return passaro.getAltura() - passaro.getRAIO() < this.alturaDoCanoSuperior
                || passaro.getAltura() + passaro.getRAIO() > this.alturaDoCanoInferior;
    }
}
