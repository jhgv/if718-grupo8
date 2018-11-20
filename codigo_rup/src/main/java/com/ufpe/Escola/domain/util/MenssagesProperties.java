package com.ufpe.Escola.domain.util;

import java.text.MessageFormat;
import java.util.Iterator;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;
import javax.faces.validator.ValidatorException;

public class MenssagesProperties {

	private static final ResourceBundle DEFAULT_RESOURCE_BUNDLE = ResourceBundle
			.getBundle("/messages_pt_BR");

	private MenssagesProperties() {
		super();
	}

	public static String getMessage(String key) {
		return getMessage(DEFAULT_RESOURCE_BUNDLE, key);
	}

	public static String getMessage(ResourceBundle bnd, String codMsg,
			String... params) {
		String retorno = null;
		if (bnd != null) {
			boolean existeMsg = bnd.containsKey(codMsg);
			while (existeMsg) {
				retorno = bnd.getString(codMsg.toString());
				if (StringUtil.valorPreenchido(retorno)) {
					if (retorno.startsWith("${")
							&& retorno.trim().endsWith("}")) {
						codMsg = retorno.replaceFirst("\\$", "")
								.replaceFirst("\\{", "")
								.replaceFirst("\\}", "").trim();
						existeMsg = bnd.containsKey(codMsg);
					} else {
						existeMsg = false;
					}
				} else {
					existeMsg = false;
				}
			}
		}
		return getTextMessageReplace(retorno, params);
	}

	public static String getTextMessageReplace(String descMsg, String... params) {
		if (descMsg != null && params != null) {
			MessageFormat mf = new MessageFormat(descMsg);
			descMsg = mf.format(params, new StringBuffer(), null).toString();
		}
		return descMsg;
	}

	public static String getMessageReplace(String codMsg, String... params) {
		String line = DEFAULT_RESOURCE_BUNDLE.getString(codMsg);
		return getTextMessageReplace(line, params);
	}

	public static void errorMsg(String codMsg) {
		exibeMsg(FacesMessage.SEVERITY_ERROR, codMsg, null);
	}

	public static void sucessoMsg(String codMsg) {
		exibeMsg(FacesMessage.SEVERITY_INFO, codMsg, null);
	}

	public static void warningMsg(String codMsg) {
		exibeMsg(FacesMessage.SEVERITY_WARN, codMsg, null);
	}

	public static void fatalMsg(String codMsg) {
		exibeMsg(FacesMessage.SEVERITY_FATAL, codMsg, null);
	}

	public static void cleanMessages() {
		Iterator<String> itIds = FacesContext.getCurrentInstance()
				.getClientIdsWithMessages();
		while (itIds.hasNext()) {
			itIds.next();
			itIds.remove();
		}
	}

	public static void exibeMsg(Severity severity, String codMsg,
			String codMsgDetalhe, String... params) {
		FacesMessage fm = getFacesMessage(severity, codMsg, codMsgDetalhe,
				params);
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.addMessage(null, fm);
	}

	public static void exibeMsgValidatorException(Severity severity,
			String codMsg, String codMsgDetalhe, String... params)
			throws ValidatorException {
		FacesMessage fm = getFacesMessage(severity, codMsg, codMsgDetalhe,
				params);
		throw new ValidatorException(fm);
	}

	public static void exibeMsgConverterException(Severity severity,
			String codMsg, String codMsgDetalhe, String... params)
			throws ConverterException {
		FacesMessage fm = getFacesMessage(severity, codMsg, codMsgDetalhe,
				params);
		throw new ConverterException(fm);
	}

	private static FacesMessage getFacesMessage(Severity severity,
			String codMsg, String codMsgDetalhe, String... params) {
		String textoMsg = getMessage(DEFAULT_RESOURCE_BUNDLE, codMsg, params);
		if (codMsgDetalhe != null && !codMsgDetalhe.isEmpty()) {
			codMsgDetalhe = getMessage(DEFAULT_RESOURCE_BUNDLE, codMsgDetalhe);
		} else {
			codMsgDetalhe = "";
		}
		FacesMessage fm = new FacesMessage(severity, textoMsg, codMsgDetalhe);
		return fm;
	}
}
