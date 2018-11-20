package com.ufpe.Escola.domain.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EscolaException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private List<String> parametros = new ArrayList<String>();
	private EscolaValidacao validacao;
	
	public EscolaException(EscolaValidacao validacao) {
		super(validacao.getCodigoMsg());
		this.validacao = validacao;
	}
	
	public EscolaException(EscolaValidacao validacao, String...params) {
		super(validacao.getCodigoMsg());
		this.validacao = validacao;
		this.parametros = Arrays.asList(params);
	}
	
	public EscolaException(EscolaValidacao validacao, Throwable throwable, String...params){
		super(validacao.getCodigoMsg(), throwable);
		this.validacao = validacao;
		this.parametros = Arrays.asList(params);
	}

	public List<String> getParametros() {
		return parametros;
	}

	public void setParametros(List<String> parametros) {
		this.parametros = parametros;
	}

	public EscolaValidacao getValidacao() {
		return validacao;
	}

	public void setValidacao(EscolaValidacao validacao) {
		this.validacao = validacao;
	}
	
	public final String getPilhaError(Throwable t) {
		StringWriter writer = new StringWriter();
		PrintWriter printWriter = new PrintWriter(writer);
		t.printStackTrace(printWriter);
		return writer.toString();
	}
	
	
	public static final EscolaException getPrimeiraEscolaException(
			Throwable throwable) {
		EscolaException retorno = null;
		if (throwable != null) {
			if (throwable instanceof EscolaException) {
				retorno = (EscolaException) throwable;
			} else {
				retorno = getPrimeiraEscolaException(throwable.getCause());
			}
		}
		return retorno;
	}
	
	public static final EscolaException getUltimoPMJPException(Throwable throwable) {

		EscolaException retorno = null;

		if (throwable != null && throwable instanceof EscolaException) {
			retorno = (EscolaException) throwable;
			if (throwable.getCause() != null
					&& throwable.getCause() instanceof EscolaException) {
				retorno = getUltimoPMJPException(throwable.getCause());
			}
		}
		return retorno;
	}

}
