package br.edu.infnet.swapmobile.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public
@Entity
@Table(name = "TAvaliacao") class Avaliacao extends Troca {

    private String condicaoAparelho;
    private float valorAvaliado;
    private String observacoes;

    public Avaliacao() {

    }

    public Avaliacao(Integer id) {
        super(id);
    }

    public Avaliacao(String tipoTroca, float valorTroca, int codigoTroca, String condicaoAparelho, float valorAvaliado, String observacoes) {
        super(tipoTroca, valorTroca, codigoTroca);
        this.condicaoAparelho = condicaoAparelho;
        this.valorAvaliado = valorAvaliado;
        this.observacoes = observacoes;
    }

    @Override
    public String toString() {
        return String.format("%s;%s;%.2f;%s", super.toString(), condicaoAparelho, valorAvaliado, observacoes);
    }

    public String getCondicaoAparelho() {
        return condicaoAparelho;
    }

    public void setCondicaoAparelho(String condicaoAparelho) {
        this.condicaoAparelho = condicaoAparelho;
    }

    public float getValorAvaliado() {
        return valorAvaliado;
    }

    public void setValorAvaliado(float valorAvaliado) {
        this.valorAvaliado = valorAvaliado;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}