package model.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.entidade.Gabarito;
import model.entidade.Questao;

public class GabaritoDAO implements IGabaritoDAO {
	
	private EntityManager em;
	
	public GabaritoDAO(EntityManager em) {
		this.em = em;
	}

	@Override
	public void salvar(Gabarito gabarito) throws Exception {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(gabarito);
		tx.commit();
	}

	@Override
	public void alterar(Gabarito gabarito) throws Exception {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(gabarito);
		tx.commit();
	}

	@Override
	public void remover(Gabarito gabarito) throws Exception {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(gabarito);
		tx.commit();
	}

	@Override
	public Gabarito buscar(Long id) throws Exception {
		Gabarito gabarito = em.find(Gabarito.class, id);
		return gabarito;
	}

	@Override
	public Gabarito buscar(Questao questao) throws Exception {
		String sql = "SELECT g FROM Gabarito g WHERE g.questao.id = :questaoId";
		Query query = em.createQuery(sql);
		query.setParameter("questaoId", questao.getId());
		Gabarito gabarito = (Gabarito) query.getSingleResult();
		return gabarito;
	}

	@Override
	public List<Gabarito> buscarTodos() throws Exception {
		String sql = "SELECT g FROM Gabarito g";
		Query query = em.createQuery(sql);
		@SuppressWarnings("unchecked")
		List<Gabarito> gabaritos = query.getResultList();
		return gabaritos;
	}

}
