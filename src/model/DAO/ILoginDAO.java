package model.DAO;

import java.util.List;

import model.entidade.Docente;
import model.entidade.Login;

public interface ILoginDAO {

	public void salvar(Login login) throws Exception;
	public void alterar(Login login) throws Exception;
	public void remover(Login login) throws Exception;
	public Login buscar(Long id) throws Exception;
	public Login buscarPorDocente(Docente docente) throws Exception;
	public List<Login> buscarAdministradores() throws Exception;
	public List<Login> buscarCoordenadores() throws Exception;
	public List<Login> buscarAtivos() throws Exception;
	public List<Login> buscarTodos() throws Exception;
	
}
