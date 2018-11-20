package com.ufpe.Escola.domain.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tb_aluno")
public class Aluno implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_aluno")
	private Integer idAluno;
	
	@Column(nullable=false)
	private String nomeAluno;
	
	@Column(nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataNascimento;
	
	@Column(nullable=false)
	private String nomePai;
	
	@Column(nullable=false)
	private String nomeMae;
	
	@Column(nullable=false)
	private Cidade cidade;
	
	@Column(nullable=false)
	private Estado estado;
	
	@OneToOne
	@JoinColumn(name="id_serie")
	private Serie serie;
	
	@OneToOne
	@JoinColumn(name="id_responsavel")
	private ResponsavelAluno responsavel;
	
	@OneToOne
	@JoinColumn(name="id_endereco")
	private Endereco endereco;
	
	@OneToMany(mappedBy="aluno")
	private Set<Contato> contatos;
	
	@OneToMany(mappedBy="aluno")
	private Set<Documento> documentos;
	
	@Enumerated(EnumType.STRING)
	private NivelEnsino nivelEnsino;;
	
	@Enumerated(EnumType.STRING)
	private Turma turma;
	
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	
	@Enumerated(EnumType.STRING)
	private Turno turno;
	
	public Aluno(){
		this.contatos = new HashSet<Contato>();
		this.documentos = new HashSet<Documento>();
	}

	public Integer getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(Integer idAluno) {
		this.idAluno = idAluno;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	public ResponsavelAluno getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(ResponsavelAluno responsavel) {
		this.responsavel = responsavel;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Set<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(Set<Contato> contatos) {
		this.contatos = contatos;
	}

	public Set<Documento> getDocumentos() {
		return documentos;
	}

	public void setDocumentos(Set<Documento> documentos) {
		this.documentos = documentos;
	}

	public NivelEnsino getNivelEnsino() {
		return nivelEnsino;
	}

	public void setNivelEnsino(NivelEnsino nivelEnsino) {
		this.nivelEnsino = nivelEnsino;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}
	
	public Documento addDocumento(Documento documento){
		this.documentos.add(documento);
		documento.setAluno(this);
		return documento;
	}

}