import java.util.Random;

public class StartingPoint {
	public static void main(String win[]) {
	
	int numOfGames = 13;
	Random r = new Random();
	//int num[] = {0, 1, 2, 0, 4};
	//int[] num = {0, 0, 0, 0, 9};
	//int[] num = new int[100];  // hundred places starting at 0 end at 99
	int[] num = new int[3]; // same as " ={0,0,0,0,0} 
	boolean gameResult = true; 
	boolean[] odds = new boolean[numOfGames]; /// alll hundred position will equal false on a boolean array    
	int a = 0;
	
	while(a < numOfGames){
	
	
	
		for(int i = 0; i < num.length; i++){
			num[i] = r.nextInt(100) + 1; // the plus one lets the random numbers start at 1-100 instead of 0 o 99
			if (num[i] % 2 == 0){
				 System.out.println("TRUE - " + num[i] + " is divisible by two");
				 }else{
				 System.out.println("FALSE - " + num[i] + " is not divisible by two");
				 gameResult = false;
			}
		}
		if (gameResult == true){
			odds[a] = true;
			System.out.println("YOU HAVE WON ! !.");
		}else{
			System.out.println("you have lost SUCKA!!.");
			}
			a++;
	 }
	}
}

	


