package model.DAO;

import java.util.List;

import model.entidade.AnoLetivo;
import model.entidade.Curso;
import model.entidade.Turma;

public interface ITurmaDAO {
	
	public void salvar(Turma turma) throws Exception;
	public void alterar(Turma turma) throws Exception;
	public void remover(Turma turma) throws Exception;
	public Turma buscar(Long id) throws Exception;
	public List<Turma> buscar(String descricao) throws Exception;
	public List<Turma> buscar(AnoLetivo anoLetivo) throws Exception;
	public List<Turma> buscar(Curso curso) throws Exception;
	public List<Turma> buscar(AnoLetivo anoLetivo, Curso curso) throws Exception;
	public List<Turma> buscarTodos() throws Exception;

}
