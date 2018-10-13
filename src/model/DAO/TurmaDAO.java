package model.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.entidade.AnoLetivo;
import model.entidade.Curso;
import model.entidade.Turma;

public class TurmaDAO implements ITurmaDAO {
	
	private EntityManager em;
	
	public TurmaDAO(EntityManager em) {
		this.em = em;
	}

	@Override
	public void salvar(Turma turma) throws Exception {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(turma);
		tx.commit();
	}

	@Override
	public void alterar(Turma turma) throws Exception {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(turma);
		tx.commit();
	}

	@Override
	public void remover(Turma turma) throws Exception {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(turma);
		tx.commit();
	}

	@Override
	public Turma buscar(Long id) throws Exception {
		Turma turma = em.find(Turma.class, id);
		return turma;
	}

	@Override
	public List<Turma> buscar(String descricao) throws Exception {
		String sql = "SELECT t FROM Turma t WHERE t.descricao LIKE :descricao";
		Query query = em.createQuery(sql);
		query.setParameter("descricao", "%" + descricao + "%");
		@SuppressWarnings("unchecked")
		List<Turma> turmas = query.getResultList();
		return turmas;
	}

	@Override
	public List<Turma> buscar(AnoLetivo anoLetivo) throws Exception {
		String sql = "SELECT t FROM Turma t WHERE t.anoLetivo.id = :anoLetivoId";
		Query query = em.createQuery(sql);
		query.setParameter("anoLetivoId", anoLetivo.getId());
		@SuppressWarnings("unchecked")
		List<Turma> turmas = query.getResultList();
		return turmas;
	}

	@Override
	public List<Turma> buscar(Curso curso) throws Exception {
		String sql = "SELECT t FROM Turma t WHERE t.curso.id = :cursoId";
		Query query = em.createQuery(sql);
		query.setParameter("cursoId", curso.getId());
		@SuppressWarnings("unchecked")
		List<Turma> turmas = query.getResultList();
		return turmas;
	}

	@Override
	public List<Turma> buscar(AnoLetivo anoLetivo, Curso curso) throws Exception {
		String sql = "SELECT t FROM Turma t WHERE t.anoLetivo.id = :anoLetivoId AND t.curso.id = :cursoId";
		Query query = em.createQuery(sql);
		query.setParameter("anoLetivoId", anoLetivo.getId());
		query.setParameter("cursoId", curso.getId());
		@SuppressWarnings("unchecked")
		List<Turma> turmas = query.getResultList();
		return turmas;
	}
	
	@Override
	public List<Turma> buscarTodos() throws Exception {
		String sql = "SELECT t FROM Turma t";
		Query query = em.createQuery(sql);
		@SuppressWarnings("unchecked")
		List<Turma> turmas = query.getResultList();
		return turmas;
	}

}
