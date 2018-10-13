package model.DAO;

import java.util.List;

import model.entidade.Prova;
import model.entidade.Questao;

public interface IQuestaoDAO {
	
	public void salvar(Questao questao) throws Exception;
	public void alterar(Questao questao) throws Exception;
	public void remover(Questao questao) throws Exception;
	public Questao buscar(Long id) throws Exception;
	public List<Questao> buscar(String descricao) throws Exception;
	public List<Questao> buscar(Prova prova) throws Exception;
	public List<Questao> buscarTodos() throws Exception;

}
