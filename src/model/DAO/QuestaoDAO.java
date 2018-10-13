package model.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.entidade.Prova;
import model.entidade.Questao;

public class QuestaoDAO implements IQuestaoDAO {

	private EntityManager em;
	
	public QuestaoDAO(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public void salvar(Questao questao) throws Exception {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(questao);
		tx.commit();
	}

	@Override
	public void alterar(Questao questao) throws Exception {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(questao);
		tx.commit();
	}

	@Override
	public void remover(Questao questao) throws Exception {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(questao);
		tx.commit();
	}

	@Override
	public Questao buscar(Long id) throws Exception {
		Questao questao = em.find(Questao.class, id);
		return questao;
	}

	@Override
	public List<Questao> buscar(String descricao) throws Exception {
		String sql = "SELECT q FROM Questao q WHERE q.descricao LIKE :descricao";
		Query query = em.createQuery(sql);
		query.setParameter("descricao", "%" + descricao + "%");
		@SuppressWarnings("unchecked")
		List<Questao> questoes = query.getResultList();
		return questoes;
	}

	@Override
	public List<Questao> buscar(Prova prova) throws Exception {
		String sql = "SELECT q FROM Questao q WHERE q.prova.id = :provaId";
		Query query = em.createQuery(sql);
		query.setParameter("provaId", prova.getId());
		@SuppressWarnings("unchecked")
		List<Questao> questoes = query.getResultList();
		return questoes;
	}

	@Override
	public List<Questao> buscarTodos() throws Exception {
		String sql = "SELECT q FROM Questao q";
		Query query = em.createQuery(sql);
		@SuppressWarnings("unchecked")
		List<Questao> questoes = query.getResultList();
		return questoes;
	}

}
