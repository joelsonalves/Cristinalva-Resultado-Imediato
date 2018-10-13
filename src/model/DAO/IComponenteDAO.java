package model.DAO;

import java.util.List;

import model.entidade.Componente;

public interface IComponenteDAO {

	public void salvar(Componente componente) throws Exception;
	public void alterar(Componente componente) throws Exception;
	public void remover(Componente componente) throws Exception;
	public Componente buscar(Long id) throws Exception;
	public List<Componente> buscar(String descricao) throws Exception;
	public List<Componente> buscarAtivos() throws Exception;
	public List<Componente> buscarTodos() throws Exception;
	
}
