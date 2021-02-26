
public class MultiplicationTable {

	public static void main(String[] args) {
	
		//use nested loops

		//heading
        System.out.println("Lab 11 written by Elizabeth Graham"); 
        System.out.println(); 
        
		System.out.println("   1    2    3    4    5    6    7    8    9");
		
		//use loop with in a loop to construct table
		//outer for loop columns
		for(int i = 1; i <= 9; i++) {
			
			//far right column
			System.out.print(i + "  ");
			
			//inner loop rows goes here, identical to outer loop but "j"
            for (int j = 1; j <= 9; j++) {
			    //print product  i * j
                if (i*j >= 10) {
                    System.out.print(i*j + "   ");
                }
                else {
                    System.out.print(i*j + "    ");
                }
            }
			System.out.println(); // new  row
		}

	}
}
