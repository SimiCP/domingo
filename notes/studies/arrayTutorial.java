public class arrayTutorial {

	public static void main(String[] args){
	
		int arrInt[] = new int[5]; // creates a new array instance // tell you the amount of elements 
		
		arrInt[0] = 1; // sets the first container to 1
		
		int i = 1;  // sets the i to 1 so it can start the process
		while(i <= 4){
			arrInt[i] = i+1;
			i++;
		}
		System.out.println(arrInt[4]);
		
	}
	
}