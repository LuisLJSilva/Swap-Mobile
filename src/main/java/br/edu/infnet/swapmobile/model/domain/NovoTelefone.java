package br.edu.infnet.swapmobile.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "TNovoTelefone")
public class NovoTelefone extends Troca {

    private String modelo;
    private float preco;
    private String garantia;

    public NovoTelefone() {

    }

    public NovoTelefone(Integer id) {
        super(id);
    }

    public NovoTelefone(String tipoTroca, float valorTroca, int codigoTroca, String modelo, float preco, String garantia) {
        super(tipoTroca, valorTroca, codigoTroca);
        this.modelo = modelo;
        this.preco = preco;
        this.garantia = garantia;
    }

    @Override
    public String toString() {
        return String.format("%s;%s;%.2f;%s", super.toString(), modelo, preco, garantia);
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getGarantia() {
        return garantia;
    }

    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }
}