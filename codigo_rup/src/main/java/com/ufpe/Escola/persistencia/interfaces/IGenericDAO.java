package com.ufpe.Escola.persistencia.interfaces;

import java.util.List;

import com.ufpe.Escola.domain.util.EscolaException;

public interface IGenericDAO<T> {
	
	public void salvar(T entidade) throws EscolaException;
	public void atualizar(T entidade) throws EscolaException;
	public void remover(T entidade) throws EscolaException;
	public T pesquisarProId(Class<T> clazz, Integer idEntidade)throws EscolaException;
	public List<T> pesquisarTodos()throws EscolaException;
}
