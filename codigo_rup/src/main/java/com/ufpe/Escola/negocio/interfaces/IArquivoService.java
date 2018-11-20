package com.ufpe.Escola.negocio.interfaces;

import java.util.List;

import com.ufpe.Escola.domain.model.Arquivo;
import com.ufpe.Escola.domain.model.TipoArquivo;
import com.ufpe.Escola.domain.util.EscolaException;

public interface IArquivoService {
	
	public void salvarArquivo(Arquivo arquivo) throws EscolaException;
	public TipoArquivo carregarTipoArquivoProId(Integer idTipoArquivo);
	public List<Arquivo> obterTodos()throws EscolaException;

}
