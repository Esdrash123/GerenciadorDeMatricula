/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.garanhuns.ifpe.repositorio.implementacao;

import br.edu.garanhuns.ifpe.entidades.Aluno;
import br.edu.ifpe.DAO.DaoManagerHiber;
import br.edu.ifpe.repositorio.comportamentos.RepositorioGenerico;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author esdra
 */
public class RepositorioAluno implements RepositorioGenerico{

    @Override
    public void inserir(Object t) {
        DaoManagerHiber.getInstance().persist(t);
    }

    @Override
    public void alterar(Object t) {
        DaoManagerHiber.getInstance().update(t);
    }

    @Override
    public Object recuperar(Object codigo) {
        try {
            return (Aluno) DaoManagerHiber.getInstance().recover("from Aluno where codigo" + codigo).get(0);
        } catch (IndexOutOfBoundsException in) {
            return null;
        }
    }

    @Override
    public void deletar(Object t) {
        DaoManagerHiber.getInstance().delete(t);
    }

    @Override
    public List<Aluno> recuperarTodos() {
        return DaoManagerHiber.getInstance().recover("from Aluno");
    }
    
    
    
}
