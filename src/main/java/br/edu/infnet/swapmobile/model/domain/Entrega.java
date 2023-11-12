package br.edu.infnet.swapmobile.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "TEntrega")
public class Entrega extends Troca {

    private boolean sedex;
    private String enderecoEntrega;
    private String statusEntrega;

    public Entrega() {

    }

    public Entrega(Integer id) {
        super(id);
    }

    public Entrega(String tipoTroca, float valorTroca, int codigoTroca, Boolean sedex, String enderecoEntrega, String statusEntrega) {
        super(tipoTroca, valorTroca, codigoTroca);
        this.sedex = sedex;
        this.enderecoEntrega = enderecoEntrega;
        this.statusEntrega = statusEntrega;
    }

    public String toString() {
        return String.format("%s;%s;%s;%s",
                super.toString(),
                sedex,
                enderecoEntrega,
                statusEntrega
        );
    }

    public boolean getSedex() {
        return sedex;
    }

    public void setSedex(Boolean sedex) {
        this.sedex = sedex;
    }

    public String getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(String enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    public String getStatusEntrega() {
        return statusEntrega;
    }

    public void setStatusEntrega(String statusEntrega) {
        this.statusEntrega = statusEntrega;
    }
}