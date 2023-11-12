package br.edu.infnet.swapmobile.model.domain;

import javax.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "TUsuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    private String senha;

    @OneToMany
    @JoinColumn(name = "idUsuario")
    private List<Cliente> clientes;

    @OneToMany
    @JoinColumn(name = "idUsuario")
    private List<Troca> trocas;

    @OneToMany
    @JoinColumn(name = "idUsuario")
    private List<OrdemDeTroca> ordemDeTroca;

    public Usuario() {

    }

    public Usuario(Integer id ) {
        this.id = id;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Troca> getTrocas() {
        return trocas;
    }

    public void setTrocas(List<Troca> trocas) {
        this.trocas = trocas;
    }

    public List<OrdemDeTroca> getOrdemDeTroca() {
        return ordemDeTroca;
    }

    public void setOrdemDeTroca(List<OrdemDeTroca> ordemDeTroca) {
        this.ordemDeTroca = ordemDeTroca;
    }
}
