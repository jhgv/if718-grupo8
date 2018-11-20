package com.ufpe.Escola.persistencia.implementacoes;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.ufpe.Escola.domain.model.Usuario;
import com.ufpe.Escola.domain.util.CoreValidacoes;
import com.ufpe.Escola.domain.util.EscolaException;

@Repository
public class UsuarioDAO extends GenericDAOImplement<Usuario>{
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> pesquisarTodos() throws EscolaException {
		String select = "select usu from Usuario usu";
		Query consulta = getEntityManager().createQuery(select);
		return consulta.getResultList();
	}

	public Usuario pesquisarPorLogin(String login) throws EscolaException{
		StringBuilder select = new StringBuilder("select usu from Usuario usu ");
		select.append("where usu.login = :login");
		Usuario retorno;
		try{
			TypedQuery<Usuario> consulta = getEntityManager().createQuery(select.toString(),Usuario.class);
			consulta.setParameter("login", login);
			retorno = consulta.getSingleResult();
			return retorno;
		}catch(Exception e){
			throw  new EscolaException(CoreValidacoes.ERRO_CONSULT_USUARIO_LOGIN,e);
		}
	}
	
}
