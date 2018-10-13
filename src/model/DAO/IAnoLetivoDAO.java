package model.DAO;

import java.util.List;

import model.entidade.AnoLetivo;

public interface IAnoLetivoDAO {

	public void salvar(AnoLetivo anoLetivo) throws Exception;
	public void alterar(AnoLetivo anoLetivo) throws Exception;
	public void remover(AnoLetivo anoLetivo) throws Exception;
	public AnoLetivo buscar(Long id) throws Exception;
	public List<AnoLetivo> buscar(String descricao) throws Exception;
	public List<AnoLetivo> buscarAtivos() throws Exception;
	public List<AnoLetivo> buscarTodos() throws Exception;
	
}
