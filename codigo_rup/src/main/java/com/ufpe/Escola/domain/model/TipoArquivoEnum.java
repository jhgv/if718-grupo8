package com.ufpe.Escola.domain.model;

public enum TipoArquivoEnum {
	ARQUIVO_TESTE(new TipoArquivo(1,"teste")),
	ARQUIVO_FOTO_ALUNO(new TipoArquivo(2,"Foto Aluno"));
	
	private TipoArquivo tipoArquivo;
	
	private TipoArquivoEnum(TipoArquivo tpArquivo){
		this.tipoArquivo = tpArquivo;
	}
	
	public TipoArquivo getArquivo(){
		return tipoArquivo;
	}
}
