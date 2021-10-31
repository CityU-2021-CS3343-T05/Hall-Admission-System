package HallAdmissionSystem;

import java.util.Scanner;

public class Display {
	private int width = 50;
	
	private Scanner sc;
	
	private Display() {
		sc = new Scanner(System.in);
	}

	private void DisplayTitle(String title) {
		int newWidth = width - title.length();
		int upper = (int) Math.ceil(newWidth / 2.0);
		int lower = (int) Math.floor(newWidth / 2.0);

		String out = "";

		for (int i = 0; i < upper; i++) {
			out += "=";
		}

		out += " " + title + " ";

		for (int i = 0; i < lower; i++) {
			out += "=";
		}

		System.out.println(out);
	}

	private void DisplayContent(String c) {
		System.out.println(c);
	}

	private void DisplayEnd() {
		String out = "";

		for (int i = 0; i < width; i++) {
			out += "=";
		}

		System.out.println(out);
	}

	private String DisplayInput() {
		System.out.print("> ");
		String str = sc.nextLine();
		return str;
	}

	public static String runDisplay(String title, String Content, boolean needInput) {
		Display d = new Display();
		
		d.DisplayTitle(title);
		d.DisplayContent(Content);
		d.DisplayEnd();

		if (needInput) {
			return d.DisplayInput();
		} else {
			return null;
		}
	}
	
	private String DisplaySubInput() {
		System.out.print("> ");
		String str = sc.nextLine();
		return str;
	}
	
	public static String runDisplayDetails(String title) {
		Display d = new Display();
		
		System.out.println(title);
		
		return d.DisplaySubInput();
	}
	
	public static void runDisplayLine(String title) {
		Display d = new Display();
		
		System.out.println(title);
	}
}
