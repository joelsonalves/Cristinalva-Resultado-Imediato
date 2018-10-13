package model.DAO;

import java.util.List;

import model.entidade.Gabarito;
import model.entidade.Questao;

public interface IGabaritoDAO {
	
	public void salvar(Gabarito gabarito) throws Exception;
	public void alterar(Gabarito gabarito) throws Exception;
	public void remover(Gabarito gabarito) throws Exception;
	public Gabarito buscar(Long id) throws Exception;
	public Gabarito buscar(Questao questao) throws Exception;
	public List<Gabarito> buscarTodos() throws Exception;
	
}
