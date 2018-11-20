package com.ufpe.Escola.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "tb_bimestre")
public class Bimestre implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_bimestre")
	private int idBimestre;
	
	@Column(name = "data_inicio", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataInicio;
	
	@Column(name = "data_final", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataFinal;
	
	@Column(name = "quantidade_faltas")
	private Integer quantidadeFaltas;
	
	private BigDecimal mediaBimestre;
	
	@ManyToOne
	@JoinColumn(name = "id_disciplina")
	@Fetch(FetchMode.JOIN)
	private Disciplina disciplina;
	
	@OneToMany(mappedBy = "bimestre")
	private Set<Nota> notas;
	
	@Column(name = "ds_bimestre", nullable = false)
	@Enumerated(EnumType.STRING)
	private DescricaoBimestre descricao;
}