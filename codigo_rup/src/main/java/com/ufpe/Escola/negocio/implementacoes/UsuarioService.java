package com.ufpe.Escola.negocio.implementacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ufpe.Escola.domain.model.Usuario;
import com.ufpe.Escola.domain.util.EscolaException;
import com.ufpe.Escola.negocio.interfaces.IUsuarioService;
import com.ufpe.Escola.persistencia.implementacoes.UsuarioDAO;

@Transactional
@Service
public class UsuarioService implements IUsuarioService {
	
	@Autowired
	private UsuarioDAO usuarioDAO;

	@Override
	public void salvar(Usuario entidade) throws EscolaException {
		
		usuarioDAO.salvar(entidade);
	}

	@Override
	public void atualizar(Usuario entidade) throws EscolaException {

		usuarioDAO.atualizar(entidade);
	}

	@Override
	public void remover(Usuario entidade) throws EscolaException {

		usuarioDAO.remover(entidade);
	}

	@Override
	public Usuario pesquisarPorId(Class<Usuario> clazz, Integer idEntidade) throws EscolaException {
		
		Usuario retorno = usuarioDAO.pesquisarProId(clazz, idEntidade);
		
		return retorno;
	}

	@Override
	public Usuario pesquisarProLogin(String login) throws EscolaException {

		return usuarioDAO.pesquisarPorLogin(login);
	}

}
