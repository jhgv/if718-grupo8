package com.ufpe.Escola.domain.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "tb_sub_menu")
public class SubMenu implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_sub_menu")
	private Integer idSubMenu;
	
	@Column(nullable = false)
	private String descricaoSubMenu;
	
	private int ordem;
	
	@ManyToOne
	@JoinColumn(name = "id_menu")
	@Fetch(FetchMode.JOIN)
	private Menu menu;
	
	@OneToMany(mappedBy = "subMenu", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<ItemMenu> itensMenu;
	
	public SubMenu(){
		super();
		this.itensMenu = new HashSet<ItemMenu>();
	}

	public Integer getIdSubMenu() {
		return idSubMenu;
	}

	public void setIdSubMenu(Integer idSubMenu) {
		this.idSubMenu = idSubMenu;
	}

	public String getDescricaoSubMenu() {
		return descricaoSubMenu;
	}

	public void setDescricaoSubMenu(String descricaoSubMenu) {
		this.descricaoSubMenu = descricaoSubMenu;
	}

	public int getOrdem() {
		return ordem;
	}

	public void setOrdem(int ordem) {
		this.ordem = ordem;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Set<ItemMenu> getItensMenu() {
		return itensMenu;
	}

	public void setItensMenu(Set<ItemMenu> itensMenu) {
		this.itensMenu = itensMenu;
	}
}