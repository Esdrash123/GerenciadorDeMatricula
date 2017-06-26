/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.garanhuns.ifpe.controladores;

import br.edu.garanhuns.ifpe.entidades.Aluno;
import br.edu.garanhuns.ifpe.model.dao.ManagerDao;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="cAluno")
@SessionScoped
public class AlunoController {
    public void insert (Aluno a){
        ManagerDao.getCurrentInstance().insert(a);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("O aluno foi cadastrado"));
    }
    
    public void update(Aluno a){
        ManagerDao.getCurrentInstance().update(a);
    }
    
    public void deletar(Aluno a){
        ManagerDao.getCurrentInstance().delete(a);
    }
    
    public Aluno read(int codigo){
        try{
            return (Aluno) ManagerDao.getCurrentInstance()
                    .read("select a from Aluno a where a.id="+codigo, Aluno.class).get(0);
        }catch(ArrayIndexOutOfBoundsException arr){
            return null;
        }
    }
    
}
