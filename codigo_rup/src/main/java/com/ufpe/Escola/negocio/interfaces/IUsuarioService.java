package com.ufpe.Escola.negocio.interfaces;

import com.ufpe.Escola.domain.model.Usuario;
import com.ufpe.Escola.domain.util.EscolaException;

public interface IUsuarioService {
	
	public void salvar(Usuario entidade)throws EscolaException;
	public void atualizar(Usuario entidade)throws EscolaException;
	public void remover(Usuario entidade)throws EscolaException;
	public Usuario pesquisarPorId(Class<Usuario> clazz, Integer idEntidade) throws EscolaException;
	public Usuario pesquisarProLogin(String login) throws EscolaException;


}
