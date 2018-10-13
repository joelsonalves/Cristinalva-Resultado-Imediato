package model.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.entidade.Curso;

public class CursoDAO implements ICursoDAO {

	private EntityManager em;
	
	public CursoDAO(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public void salvar(Curso curso) throws Exception {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(curso);
		tx.commit();
	}

	@Override
	public void alterar(Curso curso) throws Exception {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(curso);
		tx.commit();
	}

	@Override
	public void remover(Curso curso) throws Exception {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(curso);
		tx.commit();
	}

	@Override
	public Curso buscar(Long id) throws Exception {
		Curso curso = em.find(Curso.class, id);
		return curso;
	}

	@Override
	public List<Curso> buscar(String descricao) throws Exception {
		String sql = "SELECT c FROM Curso c WHERE c.descricao LIKE :descricao";
		Query query = em.createQuery(sql);
		query.setParameter("descricao", "%" + descricao + "%");
		@SuppressWarnings("unchecked")
		List<Curso> cursos = query.getResultList();
		return cursos;
	}

	@Override
	public List<Curso> buscarTodos() throws Exception {
		String sql = "SELECT c FROM Curso c";
		Query query = em.createQuery(sql);
		@SuppressWarnings("unchecked")
		List<Curso> cursos = query.getResultList();
		return cursos;
	}

}
