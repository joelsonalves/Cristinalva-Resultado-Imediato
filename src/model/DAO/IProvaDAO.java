package model.DAO;

import java.util.List;

import model.entidade.AnoLetivo;
import model.entidade.Curso;
import model.entidade.Prova;

public interface IProvaDAO {

	public void salvar(Prova prova) throws Exception;
	public void alterar(Prova prova) throws Exception;
	public void remover(Prova prova) throws Exception;
	public Prova buscar(Long id) throws Exception;
	public List<Prova> buscar(AnoLetivo anoLetivo) throws Exception;
	public List<Prova> buscar(String descricao) throws Exception;
	public List<Prova> buscar(Curso curso) throws Exception;
	public List<Prova> buscar(AnoLetivo anoLetivo, Curso curso) throws Exception;
	public List<Prova> buscarAtivo() throws Exception;
	public List<Prova> buscarTodos() throws Exception;
	
}
