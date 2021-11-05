package HallAdmissionSystem;

import java.util.ArrayList;

public class Validation {
	public static int getHallInput() {
		String input = null;
		int output = 0;
		input = Display.runDisplayDetails("Preferenced Hall");
		while(!validationHall(input)) {
			input = Display.runDisplayDetails("Not existing hall, please enter again!");
		}
		output = Integer.parseInt(input);
		return output;
	}
	
	public static String getAcademicType(){
		String input;
		input = Display.runDisplayDetails("Academic Type");
		while(!validationType(input.toUpperCase())){
			input = Display.runDisplayDetails("Wrong input, please enter Dse or GPA!");
		}
		return input;
	}
	
	public static String getAcademicScore(String academicType) {
		String input;
		input = Display.runDisplayDetails("Academic Score");
		while(!validationScore(input,academicType)) {
			input = Display.runDisplayDetails("Wrong input, please enter correct score!");
		}
		return input;
	}
	
	public static String getEcaNLeaderShip(String printString) {
		String input;
		input = Display.runDisplayDetails(printString);
		while(!checkInteger(input)) {
			input = Display.runDisplayDetails("Wrong input,please enter non-negative integer");
		}
		return input;
	}
	
	public static String getLocation() {
		String input;
		input = Display.runDisplayDetails("Lived Location");
		while(!validationLocation(input)) {
			input = Display.runDisplayDetails("Wrong input,please enter correct location!");
		}
		return input;
	}
	
	public static boolean validationHall(String input) {
		int pHall = 0;
		HallSystem hS = HallSystem.getInstance();
		ArrayList<Hall>allHallList = hS.getHallList();
		if(input==null) return false;
		if(!checkInteger(input)) return false;
		pHall = Integer.parseInt(input);
		for(Hall hall:allHallList){
			if(pHall==hall.getHallNumber()) return true;
		}
		return false;
	}
	
	public static boolean validationType(String input) {
		if(input==null) return false;
		if(input.equals("DSE")||input.equals("GPA"))
			return true;
		return false;
	}
	
	public static boolean validationScore(String input, String academicType) {
		Double temp = 0.0;
		if(input==null||academicType==null) return false;
		if(academicType.equals("DSE")) {
			if(input.equals("5**")||input.equals("5*")||input.equals("5")||input.equals("4")||input.equals("3")||input.equals("2")||input.equals("1")||input.equals("U"))
				return true;
		}else {
			if(!checkDouble(input))
				return false;
			temp = Double.parseDouble(input);
			if(temp<4.3 && temp>0)
				return true;
		}
		return false;
	}
	
	public static boolean validationLocation(String input) {
		if(input==null) return false;
		String locationList[]= {"Cheung Chau","Lamma Island","Lantau","Mui Wo","Peng Chau","Shenzhen","Hung Shui Kiu","Kam Tin","Ma Wan","Sha Tau Kok","Deep Bay","Stanley","Wah Fu","Discovery Bay","Fanling","Lo Wu","Sai Kung","Sheung Shui","Tin Shui Wai","Tsing Lung Tau","Tuen Mun","Tung Chung","Yuen Long","Aberdeen","Ap Lei Chau","Chai Wan","Mid Level","Pok Fu Lam","Siu Sai Wan","South Horizons","Kwun Tong","Laguna City","Lai Chi Kok","Lam Tin","Lok Wah","Ngau Chi Wan","Sau Mau Ping","Yau Tong","Fo Tan","Hang Hau","Kwai Chung","Kwai Fong","Kwai Shing","Lai King","Ma On Shan","Po Lam","Shatin","Tai Po","Tai Wai","Tai Wo Hau","Tseung Kwan O","Tsing Yi","Tsuen Wan","Causeway Bay","Central","Fortress Hill","Happy Valley","Kennedy Town","North Point","Quarry Bay","Sai Wan Ho","Sai Ying Pun","Shau Kei Wan","Sheung Wan","Tai Hang","Tai Koo Shing","Tin Hau","Wan Chai","Western District?","Wong Chuk Hang","Cheung Sha Wan","Chuk Yuen","Choi Hung","Diamond Hill","Ho Man Tin","Hung Hom","Jordan","Kowloon Bay","Kowloon City","Lok Fu","Ma Tau Wai","Mei Foo","Ngau Tau Kok Mongkok","Ping Shek","San Po Kong","Sham Shui Po","Shek Kip Mei","Tai Kok Tsui","To Kwa Wan","Tsz Wan Shan","Wang Tau Hom","Whampoa","Wong Tai Sin","Yau Ma Tei","Kowloon Tong"};
		for(int i=0;i<locationList.length;i++){
			if(input.equals(locationList[i])){
				return true;
			}
		}
		return false;
	}
	
	public static boolean checkInteger(String input) {
		boolean isInt = false;
		int convertInt = 0;
		try {
			if(input==null) return false;
			convertInt = Integer.parseInt(input);
			if(convertInt>=0) {
				isInt = true;
			}
		}catch(NumberFormatException e) {
			isInt = false;
		}

		return isInt;
	}
	
	public static boolean checkDouble(String input) {
		boolean isDouble = false;
		int convertDouble = 0;
		try {
			if(input==null) return false;
			Double.parseDouble(input);
			if(convertDouble>=0) {
				isDouble = true;
			}
		}catch(NumberFormatException e) {
			isDouble = false;
		}
		return isDouble;
	}
	
	public static int getIntegerValue(String printString) {
		String input = null;
		int output = 0;
		input = Display.runDisplayDetails(printString);
		while(!checkInteger(input)) {
			input = Display.runDisplayDetails("Not Valid input again");
		}
		output = Integer.parseInt(input);
		return output;
	}
	
}