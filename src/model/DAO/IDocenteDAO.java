package model.DAO;

import java.util.List;

import model.entidade.Docente;

public interface IDocenteDAO {
	
	public void salvar(Docente docente) throws Exception;
	public void alterar(Docente docente) throws Exception;
	public void remover(Docente docente) throws Exception;
	public Docente buscar(String cpf) throws Exception;
	public List<Docente> buscarPorNome(String nome) throws Exception;
	public List<Docente> buscarPorNomeSocial(String nomeSocial) throws Exception;
	public List<Docente> buscarPorFormacao(String formacao) throws Exception;
	public List<Docente> buscarTodos() throws Exception;

}
