package HallAdmissionSystem;

import java.util.Scanner;

public class Display {
	private static int width = 50;

	private static Scanner sc;
	
	public static void createScanner() {
		sc = new Scanner(System.in);
	}
	
	public static void closeScanner() {
		sc.close();
	}
	
	public static Scanner getScanner() {
		return sc;
	} 
	
	private static void displayTitle(String title) {
		int newWidth = width - title.length() - 2;
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

	private static void displayContent(String c) {
		System.out.println(c);
	}

	private static void displayEnd() {
		String out = "";

		for (int i = 0; i < width; i++) {
			out += "=";
		}

		System.out.println(out);
	}

	private static String DisplayInput() {
//		Scanner sc = new Scanner(System.in);
		
		System.out.print("> ");
		String str = sc.nextLine();
		
//		sc.close();
		
		return str;
	}

	public static String runDisplay(String title, String Content, boolean needInput) {
		
		displayTitle(title);
		displayContent(Content);
		displayEnd();

		if (needInput) {
			return DisplayInput();
		} else {
			return null;
		}
	}
	
	private static String displaySubInput() {
//		Scanner sc = new Scanner(System.in);
		
		System.out.print("> ");
		String str = sc.nextLine();
		
//		sc.close();
		return str;
	}
	
	public static String runDisplayDetails(String title) {
		
		System.out.println(title);
		
		return displaySubInput();
	}
	
	public static void runDisplayLine(String title) {

		System.out.println(title);
	}
	
	public static void runTitleLine(String title) {
		
		displayTitle(title);
	}
	
	public static void runEndLine() {
		
		displayEnd();
	}
}
