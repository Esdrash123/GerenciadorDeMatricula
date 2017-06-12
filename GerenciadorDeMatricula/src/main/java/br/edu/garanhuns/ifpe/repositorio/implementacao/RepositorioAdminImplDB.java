
import br.edu.garanhuns.ifpe.entidades.Admin;
import br.edu.ifpe.DAO.DaoManagerHiber;
import br.edu.ifpe.repositorio.comportamentos.RepositorioGenerico;
import java.util.List;

public class RepositorioAdminImplDB implements RepositorioGenerico {

    @Override
    public void inserir(Object t) {
        DaoManagerHiber.getInstance().persist(t);
    }

    @Override
    public Object recuperar(Object codigo) {
        try {
            return (Admin) DaoManagerHiber.getInstance().recover("from Admin where codigo" + codigo).get(0);
        } catch (IndexOutOfBoundsException in) {
            return null;
        }
    }

    @Override
    public void alterar(Object t) {
        DaoManagerHiber.getInstance().update(t);
    }

    @Override
    public void deletar(Object t) {
        DaoManagerHiber.getInstance().delete(t);
    }

    @Override
    public List<Admin> recuperarTodos() {
        return DaoManagerHiber.getInstance().recover("from Admin");
    }

    public Admin realizaLogin(String login, String senha) {

        try {

            return (Admin) DaoManagerHiber.getInstance().recover("from Admin where codigo='" + login + "' and senha='" + senha + "'").get(0);
        } catch (IndexOutOfBoundsException index) {
            return null;
        }
    }

}
