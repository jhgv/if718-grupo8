package com.ufpe.Escola.negocio.implementacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ufpe.Escola.domain.model.Menu;
import com.ufpe.Escola.domain.model.Usuario;
import com.ufpe.Escola.domain.util.EscolaException;
import com.ufpe.Escola.negocio.interfaces.IMenuService;
import com.ufpe.Escola.persistencia.implementacoes.MenuDAO;

@Transactional
@Service
public class MenuService implements IMenuService {
	
	@Autowired
	private MenuDAO menuDAO;

	@Override
	public void salvar(Menu entidade) throws EscolaException {

		menuDAO.salvar(entidade);
	}

	@Override
	public void atualizar(Menu entidade) throws EscolaException {

		menuDAO.atualizar(entidade);
	}

	@Override
	public void remover(Menu entidade) throws EscolaException {
		
		menuDAO.remover(entidade);
	}

	@Override
	public Menu pesquisarPorId(Class<Menu> clazz, Integer idEntidade) throws EscolaException {

		Menu retorno = menuDAO.pesquisarProId(clazz, idEntidade);
		
		return retorno;
	}

	@Override
	public Menu consultaProUsuario(Usuario usuario) throws EscolaException {

		return menuDAO.pesquisarPorUsuario(usuario);
	}

}
