package com.ufpe.Escola.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "tb_item_menu")
public class ItemMenu implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_item_menu")
	private Integer idItemMenu;
	
	@Column(nullable = false)
	private String dsItemMenu;
	
	@Column(nullable = false)
	private String url;
	
	@Column(nullable = false)
	private int ordem;
	
	@ManyToOne
	@JoinColumn(name = "id_submenu")
	@Fetch(FetchMode.JOIN)
	private SubMenu submenu;

	public Integer getIdItemMenu() {
		return idItemMenu;
	}

	public void setIdItemMenu(Integer idItemMenu) {
		this.idItemMenu = idItemMenu;
	}

	public String getDsItemMenu() {
		return dsItemMenu;
	}

	public void setDsItemMenu(String dsItemMenu) {
		this.dsItemMenu = dsItemMenu;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getOrdem() {
		return ordem;
	}

	public void setOrdem(int ordem) {
		this.ordem = ordem;
	}

	public SubMenu getSubmenu() {
		return submenu;
	}

	public void setSubmenu(SubMenu submenu) {
		this.submenu = submenu;
	}
}