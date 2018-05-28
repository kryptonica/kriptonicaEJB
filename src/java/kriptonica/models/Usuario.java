/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kriptonica.models;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import kriptonica.utils.BCrypt;

/**
 *
 * @author Mathe
 */
@Entity
public class Usuario implements Serializable {

    private static final long serialVersionUID = -3390700353351295024L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String email;
    @Column(name = "dataNascimento", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date nascimento;
    @Column(nullable = false)
    private String senha;

    public Usuario() {
    }

    public Usuario(String nome, Date nascimento, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.nascimento = nascimento;
        this.senha = BCrypt.hashpw(senha, BCrypt.gensalt());
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

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = BCrypt.hashpw(senha, BCrypt.gensalt());
    }

    @Override
    public String toString() {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        return "Nome: " + getNome() + "\nEmail: " + getEmail() + "\nData de Nascimento: " + df.format(nascimento) + "\nSenha: " + getSenha() + "\n";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
