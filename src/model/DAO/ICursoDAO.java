package model.DAO;

import java.util.List;

import model.entidade.Curso;

public interface ICursoDAO {
	
	public void salvar(Curso curso) throws Exception;
	public void alterar(Curso curso) throws Exception;
	public void remover(Curso curso) throws Exception;
	public Curso buscar(Long id) throws Exception;
	public List<Curso> buscar(String descricao) throws Exception;
	public List<Curso> buscarTodos() throws Exception;

}
