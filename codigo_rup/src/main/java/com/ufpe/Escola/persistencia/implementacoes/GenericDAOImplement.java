package com.ufpe.Escola.persistencia.implementacoes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;

import com.ufpe.Escola.domain.util.CoreValidacoes;
import com.ufpe.Escola.domain.util.EscolaException;
import com.ufpe.Escola.persistencia.interfaces.IGenericDAO;

public abstract class GenericDAOImplement<T> implements IGenericDAO<T> {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void salvar(T entidade) throws EscolaException {
		try{
			getEntityManager().persist(entidade);
		}catch(Exception ex){
			throw new EscolaException(CoreValidacoes.ERRO_SALVAR_ENTIDADE,ex);
		}
	}

	@Override
	public void atualizar(T entidade) throws EscolaException {
		try{
			getEntityManager().merge(entidade);
		}catch(Exception ex){
			throw new EscolaException(CoreValidacoes.ERRO_ATUALIZAR_ENTIDADE,ex);
		}
	}

	@Override
	public void remover(T entidade) throws EscolaException {
		try{
			getEntityManager().remove(entidade);
		}catch(Exception ex){
			throw new EscolaException(CoreValidacoes.ERRO_REMOVER_ENTIDADE,ex);
		}
	}

	@Override
	public T pesquisarProId(Class<T> clazz, Integer idEntidade) throws EscolaException {
		try{
			T entidade = getEntityManager().find(clazz, idEntidade);
			return entidade;
		}catch(Exception ex){
			throw new EscolaException(CoreValidacoes.ERRO_CONSULTAR_POR_ID,ex);
		}
	}

	@Override
	public List<T> pesquisarTodos() throws EscolaException {

		return null;
	}
	
	public EntityManager getEntityManager() {

		return entityManager;
	}
	
	public Session getHibernateSession(){
		return getEntityManager().unwrap(Session.class);
	}

}