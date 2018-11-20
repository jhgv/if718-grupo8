package com.ufpe.Escola.negocio.implementacoes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ufpe.Escola.domain.model.Arquivo;
import com.ufpe.Escola.domain.model.TipoArquivo;
import com.ufpe.Escola.domain.util.EscolaException;
import com.ufpe.Escola.negocio.interfaces.IArquivoService;
import com.ufpe.Escola.persistencia.implementacoes.ArquivoDAO;

@Service
@Transactional
public class ArquivoService implements IArquivoService{

	@Autowired
	private ArquivoDAO arquivoDAO;
	
	@Override
	@Transactional
	public void salvarArquivo(Arquivo arquivo) throws EscolaException {
		arquivoDAO.salvar(arquivo);
	}

	@Override
	public TipoArquivo carregarTipoArquivoProId(Integer idTipoArquivo) {
		
		return arquivoDAO.obterTipoArquivoPorId(idTipoArquivo);
	}

	@Override
	public List<Arquivo> obterTodos() throws EscolaException {

		return arquivoDAO.pesquisarTodos();
	}

}
