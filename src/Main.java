
public class Main {

	public static int printMenu(){
		java.util.Scanner input = new java.util.Scanner(System.in);
		System.out.println("\nChoose one of the following options: "
				           + "\n1. Compute overall numeric score"
				           + "\n2. Compute final letter grade"
				           + "\n3. View student record summary"
				           + "\n4. Set percentages for tests"
				           + "\n5. Set scores on tests"
				           + "\n6. Exit"
				           + "\nEnter your choice: ");
		int option = input.nextInt();
		while (option < 1 || option > 6){
			System.out.println("Please enter valid option (1 - 6): ");
			option = input.nextInt();
		}
		return option;
	}
	
	public static double validateInput(double userInput, double maximumPoints){
		java.util.Scanner input = new java.util.Scanner(System.in);
		while (userInput > maximumPoints || userInput < 0){
			System.out.println("Invalid input - maximum number of points is " + maximumPoints 
					           + "\nPlease enter your score: ");
			userInput = input.nextDouble();
		}
		return (userInput / maximumPoints) * 100;
	}
	
	public static void main(String[] args) {
		java.util.Scanner input = new java.util.Scanner(System.in);
		
		System.out.println(" _______________________________________"
				           + "\n| ~ WELCOME TO THE STUDENT RECORD APP ~ |\n"
				           + " _______________________________________\n");

		double maxAssignments, maxMidterm, maxFinal, assignments, midterm, finalExam;
		int percentageForAssignments, percentageForMidterm, percentageForFinal;
		
		System.out.println("Enter maximum number of points on the final exam: ");
		maxFinal = input.nextDouble();
		System.out.println("Enter percentage of final grade that carries the final exam: ");
		percentageForFinal = input.nextInt();
		System.out.println("Enter your score on the final exam: ");
		finalExam = validateInput(input.nextDouble(), maxFinal);

		System.out.println("\nEnter maximum number of points on the midterm exam: ");
		maxMidterm = input.nextDouble();
		System.out.println("Enter percentage of final grade that carries the midterm exam: ");
		percentageForMidterm = input.nextInt();
		System.out.println("Enter your score on the midterm exam: ");
		midterm = validateInput(input.nextDouble(), maxMidterm);

		System.out.println("\nSum maximum number of points on other assignments: ");
		maxAssignments = input.nextDouble();
		System.out.println("Enter percentage of final grade that other assignments carry: ");
		percentageForAssignments = input.nextInt();
		System.out.println("Sum your score on other assignments: ");
		assignments = validateInput(input.nextDouble(), maxAssignments);

		StudentRecord student = new StudentRecord(percentageForFinal, percentageForMidterm, percentageForAssignments, 
												  finalExam, midterm,assignments);
	
		int option = printMenu();
		while (option != 6){
			switch(option){
			case 1: System.out.println("~ Overall numeric score: " + student.getOverallNumericScore() + "%\n"); break;
			case 2: System.out.println("~ Final letter grade: " + student.getLetterGrade() + "\n"); break;
			case 3: System.out.println(" ____________________________"
					                   + "\n| ~ Student record summary ~ |\n"
					                   + " ____________________________\n" 
					                   + student.toString() + "\n"); break;
					                   
			case 4: System.out.println("Enter percentage of final grade that carries the final exam: ");
					student.setPercentageForFinalExam(input.nextInt());
					System.out.println("Enter percentage of final grade that carries the midterm exam: ");
					student.setPercentageForMidterm(input.nextInt());
					System.out.println("Enter percentage of final grade that other assignments carry: ");
					student.setPercentageForAssignments(input.nextInt()); break;
					
			case 5: System.out.println("Enter your score on the final exam: ");
					student.setFinalExam(validateInput(input.nextDouble(), maxFinal));
					System.out.println("Enter your score on the midterm exam: ");
					student.setMidterm(validateInput(input.nextDouble(), maxMidterm));
					System.out.println("Sum your score on other assignments: ");
					student.setAssignments(validateInput(input.nextDouble(), maxAssignments));
			}
			option = printMenu();
		}
		
		System.out.println(" ______________________________________"
				           + "\n| ~ TAHNK YOU FOR USING OUR SERVICES ~ |"
				           + "\n ______________________________________");
		input.close();
	}
}
