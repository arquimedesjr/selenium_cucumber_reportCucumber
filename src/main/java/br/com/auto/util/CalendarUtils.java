package br.com.auto.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarUtils {

	private static String dataAtual;
	private static DateFormat formatar = new SimpleDateFormat("dd/MM/yyyy");
	private static DateFormat formatarAmerican = new SimpleDateFormat("MM/dd/yyyy");

	private static Calendar date = Calendar.getInstance();

	public static String getDataHoraAtual() {

		Calendar dateFormat = Calendar.getInstance();
		int yyy = dateFormat.get(Calendar.YEAR);
		int MM = dateFormat.get(Calendar.MONTH) + 1;
		int dd = dateFormat.get(Calendar.DATE);
		int HH = dateFormat.get(Calendar.HOUR_OF_DAY);
		int mm = dateFormat.get(Calendar.MINUTE);
		int SS = dateFormat.get(Calendar.SECOND);

		return dd + "_" + MM + "_" + yyy + "_" + HH + "_" + mm + "_" + SS;
	}
	

	public static String getDataAtual() {
		dataAtual = formatar.format(date.getTime());

		return dataAtual;
	}
	
	public static String getDataAtualPadraoAmericano() {
		dataAtual = formatarAmerican.format(date.getTime());
		
		return dataAtual;
	}
	
	
	// Método que soma quantidade de dias passado, na data atual
	public static String getNovaData(int qtdDias) {

		date.add(Calendar.DAY_OF_MONTH, qtdDias);
		return formatar.format(date.getTime());
	}

	// Método que soma quantidade de dias em cima da data passada por parâmetro
	public static String getNovaData(int qtdDias, String dataRecebida) throws Exception {

		Calendar novaData = Calendar.getInstance(); // Declaro uma variavel do tipo Calendar
		Date dataProvisoria = formatar.parse(dataRecebida); // Transformo a String da data recebida em uma varável do
															// tipo Date

		novaData.setTime(dataProvisoria); // Adiciono a Data na API Calendar

		novaData.add(Calendar.DAY_OF_MONTH, qtdDias); // Soma os dias na data adicionada na API Calendar
		
		return formatar.format(novaData.getTime()); // Retorna a nova Data Formatada

	}

}
