package th.co.extosoft.trainning;

public class TestIfElse {

	public static void main(String args[]) {
		
		int point = 49;
		String grade = "";
		
		if(point >= 80) {
			grade = "A";
		}else if((point >= 70) && (point < 80)) {
			grade = "B";
		}else if((point >= 60) && (point < 70)) {
			grade = "C";
		}else if((point >= 50) && (point < 60)){
			grade = "D";
		}else{
			grade = "F";
		}
		
		System.out.println("Grade --> " + grade);
	}
	
}
