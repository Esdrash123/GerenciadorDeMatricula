/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpe.edu.br.repositorios;

import ifpe.edu.br.entidades.Admin;
import ifpe.edu.br.repositorios.RepositorioGenerico;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author esdra
 */
public class RepositorioAdmin implements RepositorioGenerico<Admin, Integer> {

    List<Admin> ListaDeAdmin = new ArrayList<Admin>();

    @Override
    public void cadastro(Admin t) {
        this.ListaDeAdmin.add(t);
    }

    @Override
    public void alterar(Admin t) {

        for (Admin e : this.ListaDeAdmin) {
            if (e.getCodigo() == t.getCodigo()) {
                e.setCodigo(t.getCodigo());
                e.setCpf(t.getCpf());
                e.setNome(t.getNome());
                e.setSenha(t.getSenha());

            }

        }

    }

    @Override
    public Admin recuperar(Integer codigo) {
        for (Admin a : this.ListaDeAdmin) {
            if (a.getNome().equals(codigo)) {
                return a;
            }

        }
        return null;
    }

    @Override
    public void deletar(Admin t) {
        this.ListaDeAdmin.remove(t);
    }

    @Override
    public List<Admin> recuperarTodos() {
        return this.ListaDeAdmin;
    }

}
