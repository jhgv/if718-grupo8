package com.ufpe.Escola.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ufpe.Escola.domain.model.ItemMenu;
import com.ufpe.Escola.domain.model.Menu;
import com.ufpe.Escola.domain.model.SubMenu;
import com.ufpe.Escola.domain.model.Usuario;
import com.ufpe.Escola.domain.util.EscolaException;
import com.ufpe.Escola.domain.util.FacesUtil;
import com.ufpe.Escola.negocio.interfaces.IMenuService;
import com.ufpe.Escola.negocio.interfaces.IUsuarioService;

@Controller(value="sessaoController")
@Scope("session")
public class SessaoController implements Serializable{

	private static final long serialVersionUID = 1L;

	
private MenuModel menuModel;
	
	private Usuario usuarioLogado;
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@Autowired
	private IMenuService menuService;
	
	@PostConstruct
	public void init() throws EscolaException{
		String login = FacesUtil.getLoginUsuarioLogado();
		if(null != login && !login.isEmpty()){
			this.usuarioLogado = usuarioService.pesquisarProLogin(login);
			obterMenuUsuario(usuarioLogado);
		}
	}

	private void obterMenuUsuario(Usuario usuario) throws EscolaException{
		Menu menuUsuario = usuario.getMenu();
		if(menuUsuario != null 
				&& menuUsuario.getSubMenus() != null
					&& !menuUsuario.getSubMenus().isEmpty()){
			this.menuModel = new DefaultMenuModel();
			DefaultSubMenu subMenu;
			for(SubMenu sb: menuUsuario.getSubMenus()){
				subMenu = new DefaultSubMenu(sb.getDescricaoSubMenu());
				DefaultMenuItem itemMenu;
				if(sb.getItensMenu() != null
						&& !sb.getItensMenu().isEmpty()){
					for(ItemMenu item :sb.getItensMenu()){
						itemMenu = new DefaultMenuItem(item.getDsItemMenu());
						itemMenu.setUrl(item.getUrl());
						subMenu.addElement(itemMenu);
					}
				}
				menuModel.addElement(subMenu);
			}
		}
	}
	
	public MenuModel getMenuModel() {
		return menuModel;
	}

	public void setMenuModel(MenuModel menuModel) {
		this.menuModel = menuModel;
	}

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
}