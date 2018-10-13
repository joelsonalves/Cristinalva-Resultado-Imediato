package model.DAO;

import java.util.List;

import model.entidade.Estudante;

public interface IEstudanteDAO {

	public void salvar(Estudante estudante) throws Exception;
	public void alterar(Estudante estudante) throws Exception;
	public void remover(Estudante estudante) throws Exception;
	public Estudante buscar(Long matricula) throws Exception;
	public List<Estudante> buscarPorNome(String nome) throws Exception;
	public List<Estudante> buscarPorNomeSocial(String nomeSocial) throws Exception;
	public List<Estudante> buscarTodos() throws Exception;
	
}
