package model.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.entidade.Docente;

public class DocenteDAO implements IDocenteDAO {
	
	private EntityManager em;
	
	public DocenteDAO(EntityManager em) {
		this.em = em;
	}

	@Override
	public void salvar(Docente docente) throws Exception {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(docente);
		tx.commit();
	}

	@Override
	public void alterar(Docente docente) throws Exception {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(docente);
		tx.commit();
	}

	@Override
	public void remover(Docente docente) throws Exception {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(docente);
		tx.commit();
	}

	@Override
	public Docente buscar(String cpf) throws Exception {
		Docente docente = em.find(Docente.class, cpf);
		return docente;
	}

	@Override
	public List<Docente> buscarPorNome(String nome) throws Exception {
		String sql = "SELECT d FROM Docente d WHERE d.nome LIKE :nome";
		Query query = em.createQuery(sql);
		query.setParameter("nome", "%" + nome + "%");
		@SuppressWarnings("unchecked")
		List<Docente> docentes = query.getResultList();
		return docentes;
	}

	@Override
	public List<Docente> buscarPorNomeSocial(String nomeSocial) throws Exception {
		String sql = "SELECT d FROM Docente d WHERE d.nomeSocial LIKE :nomeSocial";
		Query query = em.createQuery(sql);
		query.setParameter("nomeSocial", "%" + nomeSocial + "%");
		@SuppressWarnings("unchecked")
		List<Docente> docentes = query.getResultList();
		return docentes;
	}

	@Override
	public List<Docente> buscarPorFormacao(String formacao) throws Exception {
		String sql = "SELECT d FROM Docente d WHERE d.formacao LIKE :formacao";
		Query query = em.createQuery(sql);
		query.setParameter("formacao", "%" + formacao + "%");
		@SuppressWarnings("unchecked")
		List<Docente> docentes = query.getResultList();
		return docentes;
	}

	@Override
	public List<Docente> buscarTodos() throws Exception {
		String sql = "SELECT d FROM Docente d";
		Query query = em.createQuery(sql);
		@SuppressWarnings("unchecked")
		List<Docente> docentes = query.getResultList();
		return docentes;
	}

	
}
