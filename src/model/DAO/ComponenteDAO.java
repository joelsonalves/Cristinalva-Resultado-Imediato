package model.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.entidade.Componente;

public class ComponenteDAO implements IComponenteDAO {

	private EntityManager em;
	
	public ComponenteDAO(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public void salvar(Componente componente) throws Exception {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(componente);
		tx.commit();
	}

	@Override
	public void alterar(Componente componente) throws Exception {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(componente);
		tx.commit();
	}

	@Override
	public void remover(Componente componente) throws Exception {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(componente);
		tx.commit();
	}

	@Override
	public Componente buscar(Long id) throws Exception {
		Componente componente = em.find(Componente.class, id);
		return componente;
	}

	@Override
	public List<Componente> buscar(String descricao) throws Exception {
		String sql = "SELECT c FROM Componente c WHERE c.descricao LIKE :descricao";
		Query query = em.createQuery(sql);
		query.setParameter("descricao", "%" + descricao + "%");
		@SuppressWarnings("unchecked")
		List<Componente> componentes = query.getResultList();
		return componentes;
	}

	@Override
	public List<Componente> buscarAtivos() throws Exception {
		String sql = "SELECT c FROM Componente c WHERE c.ativo = :ativo";
		Query query = em.createQuery(sql);
		query.setParameter("ativo", true);
		@SuppressWarnings("unchecked")
		List<Componente> componentes = query.getResultList();
		return componentes;
	}

	@Override
	public List<Componente> buscarTodos() throws Exception {
		String sql = "SELECT c FROM Componente c";
		Query query = em.createQuery(sql);
		@SuppressWarnings("unchecked")
		List<Componente> componentes = query.getResultList();
		return componentes;
	}

}
