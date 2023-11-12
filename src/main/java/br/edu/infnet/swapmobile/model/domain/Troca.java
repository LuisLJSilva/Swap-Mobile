package br.edu.infnet.swapmobile.model.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TTroca")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Troca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tipoTroca;
    private float valorTroca;
    private int codigoTroca;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @ManyToMany(mappedBy = "trocas")
    private List<OrdemDeTroca> ordemDeTroca;

    public Troca() {

    }

    public Troca (Integer id) {
        this.id = id;
    }

    public Troca (String tipoTroca, float valorTroca, int codigoTroca) {
        this.tipoTroca = tipoTroca;
        this.valorTroca = valorTroca;
        this.codigoTroca = codigoTroca;
    }

    @Override
    public String toString() {
        return String.format("%s;%.2f;%d", tipoTroca, valorTroca, codigoTroca);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoTroca() {
        return tipoTroca;
    }

    public void setTipoTroca(String tipoTroca) {
        this.tipoTroca = tipoTroca;
    }

    public float getValorTroca() {
        return valorTroca;
    }

    public void setValorTroca(float valorTroca) {
        this.valorTroca = valorTroca;
    }

    public int getCodigoTroca() {
        return codigoTroca;
    }

    public void setCodigoTroca(int codigoTroca) {
        this.codigoTroca = codigoTroca;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<OrdemDeTroca> getOrdemDeTroca() {
        return ordemDeTroca;
    }

    public void setOrdemDeTroca(List<OrdemDeTroca> ordemDeTroca) {
        this.ordemDeTroca = ordemDeTroca;
    }
}
