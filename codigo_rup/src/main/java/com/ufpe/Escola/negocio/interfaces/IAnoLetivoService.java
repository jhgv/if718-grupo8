package com.ufpe.Escola.negocio.interfaces;

import com.ufpe.Escola.domain.model.AnoLetivo;
import com.ufpe.Escola.domain.util.EscolaException;

public interface IAnoLetivoService {
	
	public void salvar(AnoLetivo entidade)throws EscolaException;
	public void atualizar(AnoLetivo entidade) throws EscolaException;
	public void remover(AnoLetivo entidade) throws EscolaException;
	public AnoLetivo pesquisarPorId(Class<AnoLetivo> clazz, Integer idEntidade) throws EscolaException;


	
}
