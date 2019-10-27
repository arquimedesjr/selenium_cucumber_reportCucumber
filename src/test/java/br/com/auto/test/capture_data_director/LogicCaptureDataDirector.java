package br.com.auto.test.capture_data_director;

import br.com.auto.logic.Logic;
import br.com.auto.pageObject.Google;

public class LogicCaptureDataDirector extends Logic {
	public static Integer id = null;
	public String text = null;
	public String name = null;
	public int day = 0;
	public int month = 0;
	public int year = 0;
	
	private Google pageGoogle = new Google();
	
	
	public void captureDateBirthDirector(String string) {
		
		if (string.equals("Joe Russo")) {
			text = Logic.getInstance().captureText(pageGoogle.textDateBirthJoe());
			day = Integer.parseInt(text.substring(0, 1));
			year = Integer.parseInt(text.substring(14, 18));

		}
		if (string.equals("Anthony Russo")) {
			text = Logic.getInstance().captureText(pageGoogle.textDateBirthAnthony());
			day = Integer.parseInt(text.substring(0, 1));
			year = Integer.parseInt(text.substring(18, 22));

		}
		if (string.equals("Joss Whedon")) {
			text = Logic.getInstance().captureText(pageGoogle.textDateBirthJoss());
			day = Integer.parseInt(text.substring(0, 1));
			year = Integer.parseInt(text.substring(15, 19));

		}

		System.out.println(text);

		if (text.contains("fevereiro")) {
			month = 03;
		} else if (text.contains("junho")) {
			month = 06;
		} else if (text.contains("julho")) {
			month = 07;
		}

	}
	


}
