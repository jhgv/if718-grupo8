package com.ufpe.Escola.negocio.interfaces;

import com.ufpe.Escola.domain.model.Menu;
import com.ufpe.Escola.domain.model.Usuario;
import com.ufpe.Escola.domain.util.EscolaException;

public interface IMenuService {
	
	public void salvar(Menu entidade)throws EscolaException;
	public void atualizar(Menu entidade)throws EscolaException;
	public void remover(Menu entidade)throws EscolaException;
	public Menu pesquisarPorId(Class<Menu> clazz, Integer idEntidade) throws EscolaException;
	public Menu consultaProUsuario(Usuario usuario) throws EscolaException;



}
