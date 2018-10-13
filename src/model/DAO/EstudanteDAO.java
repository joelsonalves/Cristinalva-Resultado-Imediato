package model.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.entidade.Estudante;

public class EstudanteDAO implements IEstudanteDAO {

	private EntityManager em;
	
	public EstudanteDAO(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public void salvar(Estudante estudante) throws Exception {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(estudante);
		tx.commit();
	}

	@Override
	public void alterar(Estudante estudante) throws Exception {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(estudante);
		tx.commit();
	}

	@Override
	public void remover(Estudante estudante) throws Exception {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(estudante);
		tx.commit();
	}

	@Override
	public Estudante buscar(Long matricula) throws Exception {
		Estudante estudante = em.find(Estudante.class, matricula);
		return estudante;
	}

	@Override
	public List<Estudante> buscarPorNome(String nome) throws Exception {
		String sql = "SELECT e FROM Estudante e WHERE e.nome LIKE :nome";
		Query query = em.createQuery(sql);
		query.setParameter("nome", "%" + nome + "%");
		@SuppressWarnings("unchecked")
		List<Estudante> estudantes = query.getResultList();
		return estudantes;
	}

	@Override
	public List<Estudante> buscarPorNomeSocial(String nomeSocial) throws Exception {
		String sql = "SELECT e FROM Estudante e WHERE e.nomeSocial LIKE :nomeSocial";
		Query query = em.createQuery(sql);
		query.setParameter("nomeSocial", "%" + nomeSocial + "%");
		@SuppressWarnings("unchecked")
		List<Estudante> estudantes = query.getResultList();
		return estudantes;
	}

	@Override
	public List<Estudante> buscarTodos() throws Exception {
		String sql = "SELECT e FROM Estudante e";
		Query query = em.createQuery(sql);
		@SuppressWarnings("unchecked")
		List<Estudante> estudantes = query.getResultList();
		return estudantes;
	}

}
