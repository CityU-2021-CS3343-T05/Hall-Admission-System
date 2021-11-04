package HallAdmissionSystem;

import java.util.ArrayList;

public class Validation {
	public static int validationHall(){
		int input = 0;
		boolean isCorrect = false;
		HallSystem hS = HallSystem.getInstance();
		ArrayList<Hall>allHallList = hS.getHallList();
		while(!isCorrect){
			input = validationInt("Preferenced Hall");
			for(Hall hall:allHallList){
				if(input==hall.getHallNumber())
					isCorrect = true;
			}
		}
		return input;
	}
	
	public static String validationType(){
		String input;
		boolean isCorrect = false;
		input = Display.runDisplayDetails("Academic Type");
		input = input.toUpperCase();
		while(!isCorrect){
			if(input.equals("DSE")||input.equals("GPA"))
				isCorrect = true;
			else
				input = Display.runDisplayDetails("Wrong input, please enter \"Dse\" or \"GPA\"");
		}
		return input;
	}

	public static String validationScore(String academicType){
		String input="";
		double convertInput;
		boolean isCorrect = false;
		while(!isCorrect){
			if(academicType.equals("GPA")){
				convertInput = validationDouble("Academic Score");
				if(convertInput<4.3 && convertInput>0) {
					isCorrect = true;
					input = Double.toString(convertInput);		
				}
			}else{
				input = Display.runDisplayDetails("Academic Score");
				if(input.equals("5**")||input.equals("5*")||input.equals("5")||input.equals("4")||input.equals("3")||input.equals("2")||input.equals("1")||input.equals("U"))
					isCorrect = true;
			}
		}
		return input;
	}

	public static int validationInt(String title){
		int convertInput = 0;
		boolean isInt = false;
		String input = Display.runDisplayDetails(title);
		while(isInt){
			try{
				convertInput = Integer.parseInt(input);
				isInt = true;
			}catch(NumberFormatException e){
				input = Display.runDisplayDetails("Wrong input, please enter an integer!");
			}
		}
		return convertInput;
	}

	public static double validationDouble (String input){
		double convertInput = 0;
		boolean isDouble = false;
		while(isDouble){
			try{
				convertInput = Double.parseDouble(input);
				isDouble = true;
			}catch(NumberFormatException e){
				input = Display.runDisplayDetails("Wrong input, please enter an integer!");
			}
		}
		return convertInput;
	}

	public static String validationString(String title){
		int input = validationInt(title);
		return Integer.toString(input);
	}

	public static String validationLocation(){
		String input="";
		boolean isCorrect = false; 
		String locationList[]= {"Cheung Chau","Lamma Island","Lantau","Mui Wo","Peng Chau","Shenzhen","Hung Shui Kiu","Kam Tin","Ma Wan","Sha Tau Kok","Deep Bay","Stanley","Wah Fu","Discovery Bay","Fanling","Lo Wu","Sai Kung","Sheung Shui","Tin Shui Wai","Tsing Lung Tau","Tuen Mun","Tung Chung","Yuen Long","Aberdeen","Ap Lei Chau","Chai Wan","Mid Level","Pok Fu Lam","Siu Sai Wan","South Horizons","Kwun Tong","Laguna City","Lai Chi Kok","Lam Tin","Lok Wah","Ngau Chi Wan","Sau Mau Ping","Yau Tong","Fo Tan","Hang Hau","Kwai Chung","Kwai Fong","Kwai Shing","Lai King","Ma On Shan","Po Lam","Shatin","Tai Po","Tai Wai","Tai Wo Hau","Tseung Kwan O","Tsing Yi","Tsuen Wan","Causeway Bay","Central","Fortress Hill","Happy Valley","Kennedy Town","North Point","Quarry Bay","Sai Wan Ho","Sai Ying Pun","Shau Kei Wan","Sheung Wan","Tai Hang","Tai Koo Shing","Tin Hau","Wan Chai","Western District?","Wong Chuk Hang","Cheung Sha Wan","Chuk Yuen","Choi Hung","Diamond Hill","Ho Man Tin","Hung Hom","Jordan","Kowloon Bay","Kowloon City","Lok Fu","Ma Tau Wai","Mei Foo","Ngau Tau Kok Mongkok","Ping Shek","San Po Kong","Sham Shui Po","Shek Kip Mei","Tai Kok Tsui","To Kwa Wan","Tsz Wan Shan","Wang Tau Hom","Whampoa","Wong Tai Sin","Yau Ma Tei","Kowloon Tong"};
		while(!isCorrect){
			input = Display.runDisplayDetails("Lived Location");
			for(int i=0;i<locationList.length;i++){
				if(input.equals(locationList[i])){
					isCorrect = true;
				}
			}
		}
		return input;
	}
}
