package com.ufpe.Escola.persistencia.implementacoes;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.ufpe.Escola.domain.model.Menu;
import com.ufpe.Escola.domain.model.Usuario;
import com.ufpe.Escola.domain.util.CoreValidacoes;
import com.ufpe.Escola.domain.util.EscolaException;

@Repository
public class MenuDAO extends GenericDAOImplement<Menu>{
	
	@Override
	public List<Menu> pesquisarTodos() throws EscolaException {
		StringBuilder select = new StringBuilder("select menu from Menu menu ");
		List<Menu> retorno;
		try{
			TypedQuery<Menu> consulta = getEntityManager().createQuery(select.toString(), Menu.class); 
			retorno = consulta.getResultList();
			return retorno;
		}catch(Exception e){
			throw new EscolaException(CoreValidacoes.ERRO_NAO_ENCONTROU_NENHUM_MENU,e);
		}
	}
	
	public Menu pesquisarPorUsuario(Usuario usuario) throws EscolaException{
		StringBuilder select = new StringBuilder("select menu from Menu menu ");
		select.append("where menu.idMenu = :idMenuUsuario");
		Menu retorno;
		try{
			TypedQuery<Menu> consulta = getEntityManager().createQuery(select.toString(), Menu.class);
			consulta.setParameter("idMenuUsuario", usuario.getMenu().getIdMenu());
			retorno = consulta.getSingleResult();
			return retorno;
		}catch(Exception e){
			throw new EscolaException(CoreValidacoes.ERRO_NAO_ENCONTROU_MENU_USUARIO,e);
		}
	}

}
