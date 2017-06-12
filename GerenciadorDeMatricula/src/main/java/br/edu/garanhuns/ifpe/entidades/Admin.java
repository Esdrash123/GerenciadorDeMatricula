/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.garanhuns.ifpe.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 *
 * @author esdra
 */

@Entity
@Table
public class Admin {
    
    @Id
    @GeneratedValue
    private int id;
    @Column(length = 30)
    private String nome;
    @Column(length = 6)
    private String codigo;
    @Column(length = 20)
    private String senha;

    public Admin(int id, String nome, String codigo, String senha) {
        this.id = id;
        this.nome = nome;
        this.codigo = codigo;
        this.senha = senha;
    }
    
    public Admin(){
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
