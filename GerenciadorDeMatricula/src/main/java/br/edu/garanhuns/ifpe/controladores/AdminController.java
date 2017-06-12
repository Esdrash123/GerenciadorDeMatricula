 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.garanhuns.ifpe.controladores;

import br.edu.garanhuns.ifpe.entidades.Admin;
import br.edu.garanhuns.ifpe.model.dao.ManagerDao;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author 1860915
 */

@ManagedBean
@SessionScoped
public class AdminController {
    
    private Admin adminLogado;

    public Admin getAdminLogado() {
        return adminLogado;
    }

    public void setAdminLogado(Admin adminLogado) {
        this.adminLogado = adminLogado;
    }
    
    public String insert(Admin u, String confirmacao) throws NoSuchAlgorithmException{
        
        String s = u.getSenha();
        
        if(!s.equals(confirmacao)){
            FacesContext.getCurrentInstance().addMessage("formularioCadastroAdmin:txtConfirm",
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "A senha e a confirmação não batem"));
            return null;
        }
        
         MessageDigest m=MessageDigest.getInstance("MD5");
       m.update(s.getBytes(),0,s.length());
       u.setSenha(""+new BigInteger(1,m.digest()).toString(16).substring(0,18));
        ManagerDao.getCurrentInstance().insert(u);
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("O administrador foi cadastrado"));
        
        return "login.xhtml";
        
    }
    
    public void update(Admin u){
        ManagerDao.getCurrentInstance().update(u);
        
        reloadUsuarioLogado();
    }
    
    public Admin read(int codigo){
        try{
        return (Admin)ManagerDao.getCurrentInstance().
                read("select u from Admin u where u.id="+codigo, Admin.class).get(0);
        }catch(ArrayIndexOutOfBoundsException arr){
            return null;
        }
    }
    
    public void deletar(Admin u){
        ManagerDao.getCurrentInstance().delete(u);
        reloadUsuarioLogado();
    }
    
    public String realizarLogin(String login, String senha) throws NoSuchAlgorithmException{
        MessageDigest m=MessageDigest.getInstance("MD5");
       m.update(senha.getBytes(),0,senha.length());
       senha=(""+new BigInteger(1,m.digest()).toString(16).substring(0,18));
       
       try{
        Admin u = (Admin)ManagerDao.getCurrentInstance().read("select u from Admin u where "
               + "u.login='"+login+"' and u.senha='"+senha+"'", Admin.class).get(0);
        
        this.adminLogado = u;
        
           //((HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true)).setAttribute("usuarioLogado", u);
        
       }catch(ArrayIndexOutOfBoundsException arr){
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("O login e/ou a senha está(ão) incorreto(s)"));
           return null;
       }
       return "paginaPrincipalAdmin.xhtml";
    }
    
    public String logOut(){
        this.adminLogado = null;
        
        return "login.xhtml";
    }
    
   
    
    private void reloadUsuarioLogado(){
        Admin u = (Admin)ManagerDao.getCurrentInstance().read("select u from Admin u where "
               + "u.login='"+this.adminLogado.getCodigo()+"' and u.senha='"+this.adminLogado.getSenha()
                +"'", Admin.class).get(0);
        
        this.adminLogado = u;
    }
    
    
    
}
