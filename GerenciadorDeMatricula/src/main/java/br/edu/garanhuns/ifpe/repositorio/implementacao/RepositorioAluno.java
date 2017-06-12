/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.garanhuns.ifpe.repositorio.implementacao;

import br.edu.garanhuns.ifpe.entidades.Aluno;
import br.edu.ifpe.repositorio.comportamentos.RepositorioGenerico;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author esdra
 */
public class RepositorioAluno implements RepositorioGenerico<Aluno, Integer> {

    List<Aluno> listaDeAluno = new ArrayList<Aluno>();

    @Override
    public void inserir(Aluno t) {
        this.listaDeAluno.add(t);
    }

    @Override
    public void alterar(Aluno t) {

        for (Aluno a : this.listaDeAluno) {
            if (a.getCodigo() == t.getCodigo()) {
                a.setCodigo(t.getCodigo());
                a.setCpf(t.getCpf());
                a.setIdade(t.getIdade());
                a.setNome(t.getNome());
            }
        }
    }

    @Override
    public Aluno recuperar(Integer codigo) {

        for (Aluno a : this.listaDeAluno) {
            if (a.getNome().equals(codigo)) {
                return a;
            }
        }
        return null;

    }

    @Override
    public void deletar(Aluno t) {
        this.listaDeAluno.remove(t);

    }

    @Override
    public List<Aluno> recuperarTodos() {

        return this.listaDeAluno;

    }

}