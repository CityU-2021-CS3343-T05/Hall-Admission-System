package HallAdmissionSystem;

import java.util.HashMap;
import java.util.Map;

public class Area_Location implements Weighting, Score {

	private Value value;
	
	
	private static String locationList[]= {"Cheung Chau","Lamma Island","Lantau","Mui Wo","Peng Chau","Shenzhen","Hung Shui Kiu","Kam Tin","Ma Wan","Sha Tau Kok","Deep Bay","Stanley","Wah Fu","Discovery Bay","Fanling","Lo Wu","Sai Kung","Sheung Shui","Tin Shui Wai","Tsing Lung Tau","Tuen Mun","Tung Chung","Yuen Long","Aberdeen","Ap Lei Chau","Chai Wan","Mid Level","Pok Fu Lam","Siu Sai Wan","South Horizons","Kwun Tong","Laguna City","Lai Chi Kok","Lam Tin","Lok Wah","Ngau Chi Wan","Sau Mau Ping","Yau Tong","Fo Tan","Hang Hau","Kwai Chung","Kwai Fong","Kwai Shing","Lai King","Ma On Shan","Po Lam","Shatin","Tai Po","Tai Wai","Tai Wo Hau","Tseung Kwan O","Tsing Yi","Tsuen Wan","Causeway Bay","Central","Fortress Hill","Happy Valley","Kennedy Town","North Point","Quarry Bay","Sai Wan Ho","Sai Ying Pun","Shau Kei Wan","Sheung Wan","Tai Hang","Tai Koo Shing","Tin Hau","Wan Chai","Western District","Wong Chuk Hang","Cheung Sha Wan","Chuk Yuen","Choi Hung","Diamond Hill","Ho Man Tin","Hung Hom","Jordan","Kowloon Bay","Kowloon City","Lok Fu","Ma Tau Wai","Mei Foo","Ngau Tau Kok Mongkok","Ping Shek","San Po Kong","Sham Shui Po","Shek Kip Mei","Tai Kok Tsui","To Kwa Wan","Tsz Wan Shan","Wang Tau Hom","Whampoa","Wong Tai Sin","Yau Ma Tei","Kowloon Tong"};
	private static int locationScore[]= {100,100,100,100,100,100,84,84,84,84,84,84,84,67,67,67,67,67,67,67,67,67,67,67,67,67,67,67,67,67,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,50,34,34,34,34,34,34,34,34,34,34,34,34,34,34,34,34,34,34,34,34,34,34,34,34,17};
	
	public Area_Location(Value v) {
		this.value = v;
	}
	
	public static int convertScore(String rawData) {
		for (int i = 0; i < locationList.length; i++) {
			if(rawData.equals(locationList[i])) {
				return (int) Math.round(locationScore[i]/100.0*10.0);
			}
		}
		return 0;
	}

	@Override
	public void setScoreValue(String v) {
		this.value.setValue(convertScore(v));	
	}
	
	@Override
	public void setWeightValue(int newWeight) {
		this.value.setValue(newWeight);
	}


	@Override
	public int getValue() {
		return this.value.getValue();
	}

}