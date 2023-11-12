package br.edu.infnet.swapmobile.model.domain;

import javax.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Entity
@Table(name = "TOrdemDeTroca")
public class OrdemDeTroca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String status;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dataAgendamento;
    private boolean urgente;
    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "idCliente")
    private Cliente cliente;
    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    private List<Troca> trocas;
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    public String getFormattedDataAgendamento() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return this.dataAgendamento.format(formatter);
    }


    public OrdemDeTroca() {
        status = "Agendado";
        dataAgendamento = LocalDateTime.now();
        urgente = true;
    }

    public OrdemDeTroca(String status, Cliente cliente, List<Troca> trocas, Usuario usuario) {
        this();
        this.status = status;
        this.cliente = cliente;
        this.trocas = trocas;
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return status + ";" + dataAgendamento + ";" + urgente + ";" + cliente + ";" + trocas.size();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(LocalDateTime dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public boolean isUrgente() {
        return urgente;
    }

    public void setUrgente(boolean urgente) {
        this.urgente = urgente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Troca> getTrocas() {
        return trocas;
    }

    public void setTrocas(List<Troca> trocas) {
        this.trocas = trocas;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}

