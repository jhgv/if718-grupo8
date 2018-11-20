package com.ufpe.Escola.domain.util;

public interface EscolaValidacao {
	
	public static final int SEVERIDADE_ERRO = 1;
	public static final int SEVERIDADE_ALERTA = 2;
	
	public String getCodigoMsg();
	public String getCodigoMsgAuxiliar();
	public int getSeveridade();
	public String getDescricao();
	public String getDescricaoMsgAuxiliar();
	
}