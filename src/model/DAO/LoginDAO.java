package model.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.entidade.Docente;
import model.entidade.Login;

public class LoginDAO implements ILoginDAO {
	
	private EntityManager em;
	
	public LoginDAO(EntityManager em) {
		this.em = em;
	}

	@Override
	public void salvar(Login login) throws Exception {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(login);
		tx.commit();
	}

	@Override
	public void alterar(Login login) throws Exception {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(login);
		tx.commit();
	}

	@Override
	public void remover(Login login) throws Exception {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(login);
		tx.commit();
	}

	@Override
	public Login buscar(Long id) throws Exception {
		Login login = em.find(Login.class, id);
		return login;
	}

	@Override
	public Login buscarPorDocente(Docente docente) throws Exception {
		String sql = "SELECT l FROM Login l WHERE l.docente.cpf = :docenteCpf";
		Query query = em.createQuery(sql);
		query.setParameter("docenteCpf", docente.getCpf());
		Login login = (Login) query.getSingleResult();
		return login;
	}

	@Override
	public List<Login> buscarAdministradores() throws Exception {
		String sql = "SELECT l FROM Login l WHERE l.administrador = :administrador";
		Query query = em.createQuery(sql);
		query.setParameter("administrador", true);
		@SuppressWarnings("unchecked")
		List<Login> logins = query.getResultList();
		return logins;
	}

	@Override
	public List<Login> buscarCoordenadores() throws Exception {
		String sql = "SELECT l FROM Login l WHERE l.coordenador = :coordenador";
		Query query = em.createQuery(sql);
		query.setParameter("coordenador", true);
		@SuppressWarnings("unchecked")
		List<Login> logins = query.getResultList();
		return logins;
	}

	@Override
	public List<Login> buscarAtivos() throws Exception {
		String sql = "SELECT l FROM Login l WHERE l.ativo = :ativo";
		Query query = em.createQuery(sql);
		query.setParameter("ativo", true);
		@SuppressWarnings("unchecked")
		List<Login> logins = query.getResultList();
		return logins;
	}

	@Override
	public List<Login> buscarTodos() throws Exception {
		String sql = "SELECT l FROM Login l";
		Query query = em.createQuery(sql);
		@SuppressWarnings("unchecked")
		List<Login> logins = query.getResultList();
		return logins;
	}

}
