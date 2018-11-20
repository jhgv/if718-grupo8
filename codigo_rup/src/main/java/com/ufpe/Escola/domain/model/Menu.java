package com.ufpe.Escola.domain.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="tb_menu")
public class Menu implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_menu")
	private Integer idMenu;
	
	@OneToMany(mappedBy="menu",
			   cascade=CascadeType.ALL,
			   fetch=FetchType.EAGER)
	private Set<SubMenu> subMenus;
	
	public Menu(){
		super();
		this.subMenus = new HashSet<SubMenu>();
	}
	
	
	public Integer getIdMenu() {
		return idMenu;
	}
	
	
	public void setIdMenu(Integer idMenu) {
		this.idMenu = idMenu;
	}

	
	public Set<SubMenu> getSubMenus() {
		return subMenus;
	}

	
	public void setSubMenus(Set<SubMenu> subMenus) {
		this.subMenus = subMenus;
	}
	
	public void addSubMenu(SubMenu subMenu){
		subMenu.setMenu(this);
		this.subMenus.add(subMenu);
	}
}
