package model.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.entidade.AnoLetivo;

public class AnoLetivoDAO implements IAnoLetivoDAO{
	
	private EntityManager em;
	
	public AnoLetivoDAO(EntityManager em) {
		this.em = em;
	}

	@Override
	public void salvar(AnoLetivo anoLetivo) throws Exception {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(anoLetivo);
		tx.commit();
		
	}

	@Override
	public void alterar(AnoLetivo anoLetivo) throws Exception {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(anoLetivo);
		tx.commit();
	}

	@Override
	public void remover(AnoLetivo anoLetivo) throws Exception {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(anoLetivo);
		tx.commit();
	}

	@Override
	public AnoLetivo buscar(Long id) throws Exception {
		AnoLetivo anoLetivo = em.find(AnoLetivo.class, id);
		return anoLetivo;
	}

	@Override
	public List<AnoLetivo> buscar(String descricao) throws Exception {
		Query query = em.createQuery("SELECT a FROM ANO_LETIVO a WHERE a.descricao LIKE :descricao");
		query.setParameter("descricao", "%" + descricao + "%");
		@SuppressWarnings("unchecked")
		List<AnoLetivo> anoLetivos = query.getResultList();
		return anoLetivos;
	}

	@Override
	public List<AnoLetivo> buscarAtivos() throws Exception {
		Query query = em.createQuery("SELECT a FROM ANO_LETIVO a WHERE a.ativo = :ativo");
		query.setParameter("ativo", true);
		@SuppressWarnings("unchecked")
		List<AnoLetivo> anoLetivos = query.getResultList();
		return anoLetivos;
	}

	@Override
	public List<AnoLetivo> buscarTodos() throws Exception {
		Query query = em.createQuery("SELECT a FROM ANO_LETIVO a");
		@SuppressWarnings("unchecked")
		List<AnoLetivo> anoLetivos = query.getResultList();
		return anoLetivos;
	}

	
}
