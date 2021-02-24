import java.util.Scanner;


public class Grades {

	public static void main(String[] args) {		
		Grades g = new Grades();
		Scanner scanner = new Scanner(System.in);  // Init scanner, for input

		System.out.println("Lab 9 written by Elizabeth Graham");

		while (true) {
			System.out.println("Enter grade point (or quit): ");
			String gradePoint = scanner.nextLine();

			if (gradePoint.toLowerCase().equals("quit")) {
				break;
			}

			g.printLetterGrade(Integer.parseInt(gradePoint));
		}
	}

	//uses if-else statement for 5 grades A - F
	//print letter grade and score
	public void printLetterGrade(int score ) {
		
		if (score >= 90) {
			System.out.println("Letter grade for score " + score + ", A");
		}
		else if (score >= 80) {
			System.out.println("Letter grade for score " + score + ", B");
		}
		else if (score >= 70) {
			System.out.println("Letter grade for score " + score + ", C");
		}
		else if (score >= 60) {
			System.out.println("Letter grade for score " + score + ", D");
		}
		else {
			System.out.println("Letter grade for score " + score + ", F");
		}
	}
}
