package com.ufpe.Escola.persistencia.implementacoes;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;


import org.springframework.stereotype.Repository;

import com.ufpe.Escola.domain.model.Arquivo;
import com.ufpe.Escola.domain.model.TipoArquivo;
import com.ufpe.Escola.domain.util.EscolaException;

@Repository
public class ArquivoDAO extends GenericDAOImplement<Arquivo>{
	
	@Override
	public List<Arquivo> pesquisarTodos() throws EscolaException {
		StringBuilder consulta = new StringBuilder("select a from Arquivo a");
		Query query = getEntityManager().createQuery(consulta.toString());
		return query.getResultList();
	}

	public TipoArquivo obterTipoArquivoPorId(Integer idTipoArquivo) {
		StringBuilder consulta = new StringBuilder("select a from TipoArquivo a where a.idTipoArquivo = :id");
		TypedQuery<TipoArquivo> query = getEntityManager().createQuery(consulta.toString(), TipoArquivo.class);
		query.setParameter("id", idTipoArquivo);
		return query.getSingleResult();
	}

}
