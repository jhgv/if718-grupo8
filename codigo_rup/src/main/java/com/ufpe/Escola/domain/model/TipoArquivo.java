package com.ufpe.Escola.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_tipoArquivo")
public class TipoArquivo implements Serializable{

	
	private static final long serialVersionUID = -609523454447966591L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipoDocumento")
	private Integer idTipoDocumento;
	
	@Column(name = "ds_tipo_arquivo")
	private String descricao;
	
	public TipoArquivo(){
		
	}
	
	public TipoArquivo(Integer id, String desc){
		super();
		this.idTipoDocumento = id;
		this.descricao = desc;
	}

	public Integer getIdTipoDocumento() {
		return idTipoDocumento;
	}

	public void setIdTipoDocumento(Integer idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((idTipoDocumento == null) ? 0 : idTipoDocumento.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoArquivo other = (TipoArquivo) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (idTipoDocumento == null) {
			if (other.idTipoDocumento != null)
				return false;
		} else if (!idTipoDocumento.equals(other.idTipoDocumento))
			return false;
		return true;
	}
}