package com.ufpe.Escola.domain.util;

import org.jboss.logging.Logger;

public class LogFactory {

	private LogFactory() {
		super();
	}

	public static Logger getLog(Class classe) {
		return Logger.getLogger(classe);
	}
}
