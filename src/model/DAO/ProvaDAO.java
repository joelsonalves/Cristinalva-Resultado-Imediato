package model.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.entidade.AnoLetivo;
import model.entidade.Curso;
import model.entidade.Prova;

public class ProvaDAO implements IProvaDAO {
	
	private EntityManager em;
	
	public ProvaDAO(EntityManager em) {
		this.em = em;
	}

	@Override
	public void salvar(Prova prova) throws Exception {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(prova);
		tx.commit();
	}

	@Override
	public void alterar(Prova prova) throws Exception {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(prova);
		tx.commit();
	}

	@Override
	public void remover(Prova prova) throws Exception {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(prova);
		tx.commit();
	}

	@Override
	public Prova buscar(Long id) throws Exception {
		Prova prova = em.find(Prova.class, id);
		return prova;
	}

	@Override
	public List<Prova> buscar(AnoLetivo anoLetivo) throws Exception {
		String sql = "SELECT p FROM Prova p WHERE p.anoletivo.id = :anoLetivoId";
		Query query = em.createQuery(sql);
		query.setParameter("anoLetivoId", anoLetivo.getId());
		@SuppressWarnings("unchecked")
		List<Prova> provas = query.getResultList();
		return provas;
	}

	@Override
	public List<Prova> buscar(String descricao) throws Exception {
		String sql = "SELECT p FROM Prova p WHERE p.descricao LIKE :descricao";
		Query query = em.createQuery(sql);
		query.setParameter("descricao", "%" + descricao + "%");
		@SuppressWarnings("unchecked")
		List<Prova> provas = query.getResultList();
		return provas;
	}

	@Override
	public List<Prova> buscar(Curso curso) throws Exception {
		String sql = "SELECT p FROM Prova p WHERE p.curso.id = :cursoId";
		Query query = em.createQuery(sql);
		query.setParameter("cursoId", curso.getId());
		@SuppressWarnings("unchecked")
		List<Prova> provas = query.getResultList();
		return provas;
	}

	@Override
	public List<Prova> buscar(AnoLetivo anoLetivo, Curso curso) throws Exception {
		String sql = "SELECT p FROM Prova p WHERE p.anoletivo.id = :anoLetivoId AND p.curso.id = :cursoId";
		Query query = em.createQuery(sql);
		query.setParameter("anoLetivoId", anoLetivo.getId());
		query.setParameter("cursoId", curso.getId());
		@SuppressWarnings("unchecked")
		List<Prova> provas = query.getResultList();
		return provas;
	}

	@Override
	public List<Prova> buscarAtivo() throws Exception {
		String sql = "SELECT p FROM Prova p WHERE p.ativo = :ativo";
		Query query = em.createQuery(sql);
		query.setParameter("ativo", true);
		@SuppressWarnings("unchecked")
		List<Prova> provas = query.getResultList();
		return provas;
	}

	@Override
	public List<Prova> buscarTodos() throws Exception {
		String sql = "SELECT p FROM Prova p";
		Query query = em.createQuery(sql);
		@SuppressWarnings("unchecked")
		List<Prova> provas = query.getResultList();
		return provas;
	}

}
