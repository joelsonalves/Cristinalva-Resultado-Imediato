package model.DAO;

import java.util.List;

import model.entidade.Estudante;
import model.entidade.Questao;
import model.entidade.Resposta;

public interface IRespostaDAO {
	
	public void salvar(Resposta resposta) throws Exception;
	public void alterar(Resposta resposta) throws Exception;
	public void remover(Resposta resposta) throws Exception;
	public Resposta buscar(Long id) throws Exception;
	public List<Resposta> buscar(Estudante estudante) throws Exception;
	public List<Resposta> buscar(Questao questao) throws Exception;
	public List<Resposta> buscar(Estudante estudante, Questao questao) throws Exception;
	public List<Resposta> buscarTodos() throws Exception;

}
