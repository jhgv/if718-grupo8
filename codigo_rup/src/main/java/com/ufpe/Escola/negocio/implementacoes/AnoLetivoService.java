package com.ufpe.Escola.negocio.implementacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ufpe.Escola.domain.model.AnoLetivo;
import com.ufpe.Escola.domain.util.EscolaException;
import com.ufpe.Escola.negocio.interfaces.IAnoLetivoService;
import com.ufpe.Escola.persistencia.implementacoes.AnoLetivoDAO;

@Transactional
@Service
public class AnoLetivoService implements IAnoLetivoService {
	
	@Autowired
	private AnoLetivoDAO anoLetivoDAO;

	@Override
	public void salvar(AnoLetivo entidade) throws EscolaException {
		anoLetivoDAO.salvar(entidade);
	}

	@Override
	public void atualizar(AnoLetivo entidade) throws EscolaException {
		anoLetivoDAO.atualizar(entidade);
	}

	@Override
	public void remover(AnoLetivo entidade) throws EscolaException {
		anoLetivoDAO.remover(entidade);
	}

	@Override
	public AnoLetivo pesquisarPorId(Class<AnoLetivo> clazz, Integer idEntidade) throws EscolaException {
		AnoLetivo retorno = anoLetivoDAO.pesquisarProId(clazz, idEntidade);
		
		return retorno;
	}
	

}
