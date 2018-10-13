package model.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.entidade.Estudante;
import model.entidade.Questao;
import model.entidade.Resposta;

public class RespostaDAO implements IRespostaDAO {

	private EntityManager em;
	
	public RespostaDAO(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public void salvar(Resposta resposta) throws Exception {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(resposta);
		tx.commit();
	}

	@Override
	public void alterar(Resposta resposta) throws Exception {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(resposta);
		tx.commit();
	}

	@Override
	public void remover(Resposta resposta) throws Exception {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(resposta);
		tx.commit();
	}

	@Override
	public Resposta buscar(Long id) throws Exception {
		Resposta resposta = em.find(Resposta.class, id);
		return resposta;
	}

	@Override
	public List<Resposta> buscar(Estudante estudante) throws Exception {
		String sql = "SELECT r FROM Resposta r WHERE r.estudante.matricula = :estudanteMatricula";
		Query query = em.createQuery(sql);
		query.setParameter("estudanteMatricula", estudante.getMatricula());
		@SuppressWarnings("unchecked")
		List<Resposta> respostas = query.getResultList();
		return respostas;
	}

	@Override
	public List<Resposta> buscar(Questao questao) throws Exception {
		String sql = "SELECT r FROM Resposta r WHERE r.questao.id = :questaoID";
		Query query = em.createQuery(sql);
		query.setParameter("questaoID", questao.getId());
		@SuppressWarnings("unchecked")
		List<Resposta> respostas = query.getResultList();
		return respostas;
	}

	@Override
	public List<Resposta> buscar(Estudante estudante, Questao questao) throws Exception {
		String sql = "SELECT r FROM Resposta r WHERE r.estudante.id = :estudanteMatricula AND r.questao.id = :questaoId";
		Query query = em.createQuery(sql);
		query.setParameter("estudanteMatricula", estudante.getMatricula());
		query.setParameter("questaoId", questao.getId());
		@SuppressWarnings("unchecked")
		List<Resposta> respostas = query.getResultList();
		return respostas;
	}

	@Override
	public List<Resposta> buscarTodos() throws Exception {
		String sql = "SELECT r FROM Resposta r";
		Query query = em.createQuery(sql);
		@SuppressWarnings("unchecked")
		List<Resposta> respostas = query.getResultList();
		return respostas;
	}

}
