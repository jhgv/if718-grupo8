package com.ufpe.Escola.persistencia.implementacoes;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.ufpe.Escola.domain.model.AnoLetivo;
import com.ufpe.Escola.domain.util.EscolaException;

@Repository
public class AnoLetivoDAO extends GenericDAOImplement<AnoLetivo> {
	
	public List<AnoLetivo> pesquisarTodos() throws EscolaException {
		String select = "select al from Anoletivo al";
		Query consulta = getEntityManager().createQuery(select);
		return consulta.getResultList();
	}

}
