
public class StudentRecord {

	private double finalExam;
	private double midterm;
	private double assignments;
	private int percentageForFinalExam;
	private int percentageForMidterm;
	private int percentageForAssignments;
	private double overallNumericScore;
	private char letterGrade;
	
	public StudentRecord(){
		
		finalExam = 0;
		midterm = 0;
		assignments = 0;
		percentageForFinalExam = 0;
		percentageForMidterm = 0;
		percentageForAssignments = 0;
		overallNumericScore = 0;
		letterGrade = 'F';
	}
	
	public StudentRecord(int percentageForFinal, int percentageForMidterm, int percentageForAssignments,
						 double finalExam, double midterm, double assignments){
		
		this.percentageForFinalExam = percentageForFinal;
		this.percentageForMidterm = percentageForMidterm;
		this.percentageForAssignments = percentageForAssignments;
		this.finalExam = finalExam;
		this.midterm = midterm;
		this.assignments = assignments;
		computeOverallNumericGrade();
		computeLetterGrade();
	}
	
	// accessor and mutator methods
	public double getFinalExam(){
		return finalExam;
	}
	public double getMidterm(){
		return midterm;
	}
	public double getAssignments(){
		return assignments;
	}
	public double getPercentageForFinalExam(){
		return percentageForFinalExam;
	}
	public double getPercentageForMidterm(){
		return percentageForMidterm;
	}
	public double getPercentageForAssignments(){
		return percentageForAssignments;
	}
	public double getOverallNumericScore(){
		computeOverallNumericGrade();
		return overallNumericScore;
	}
	public char getLetterGrade(){
		computeLetterGrade();
		return letterGrade;
	}
	public void setFinalExam(double finalExam){
		this.finalExam = finalExam;
	}
	public void setMidterm(double midterm){
		this.midterm = midterm;
	}
	public void setAssignments(double assignments){
		this.assignments = assignments;
	}
	public void setPercentageForFinalExam(int percentageForFinalExam){
		this.percentageForFinalExam = percentageForFinalExam;
	}
	public void setPercentageForMidterm(int percentageForMidterm){
		this.percentageForMidterm = percentageForMidterm;
	}
	public void setPercentageForAssignments(int percentageForAssignments){
		this.percentageForAssignments = percentageForAssignments;
	}
	
	// sums student's percentage on each test to get overall numeric score
	// and rounds it to two decimals
	public void computeOverallNumericGrade(){
		double totalInAssignments = percentageOfGrade(this.assignments, this.percentageForAssignments);
		double totalInMidterm = percentageOfGrade(this.midterm, this.percentageForMidterm);
		double totalInFinal = percentageOfGrade(this.finalExam, this.percentageForFinalExam);
		this.overallNumericScore = Math.round((totalInAssignments + totalInMidterm + totalInFinal) * 100.0)/100.0;	
	}
	
	// returns the percentage of grade student got on each test
	public double percentageOfGrade(double points, int maximumPercentage){
		return points * ((double)maximumPercentage / 100);
	}
	
	public void computeLetterGrade(){
		if (this.overallNumericScore >= 90) this.letterGrade = 'A';
		else if (this.overallNumericScore >= 80) this.letterGrade = 'B';
		else if (this.overallNumericScore >= 70) this.letterGrade = 'C';
		else if (this.overallNumericScore >= 60) this.letterGrade = 'D';
		else this.letterGrade = 'F';
	}
	
	public String toString(){
		return "- Assignments: " + percentageOfGrade(this.assignments, this.percentageForAssignments) + "% of grade\n"
				+ "- Midterm: " + percentageOfGrade(this.midterm, this.percentageForMidterm) + "% of grade\n"
				+ "- Final: " + percentageOfGrade(this.finalExam, this.percentageForFinalExam) + "% of grade\n"
				+ "\nOverall numeric score: "+  this.overallNumericScore + "%\n"
				+ "Final letter grade: " + this.letterGrade;
	}
}
