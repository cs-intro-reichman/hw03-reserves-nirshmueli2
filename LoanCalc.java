/**
* Computes the periodical payment necessary to re-pay a given loan.
*/
public class LoanCalc {	
	static double epsilon = 0.001;  // The computation tolerance (estimation error)
	static int iterationCounter = 0;    // Monitors the efficiency of the calculation
	
    /** 
     * Gets the loan data and computes the periodical payment.
     * Expects to get three command-line arguments: sum of the loan (double),
     * interest rate (double, as a percentage), and number of payments (int).  
     */
	public static void main(String[] args) {		
		// Gets the loan data
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan sum = " + loan + ", interest rate = " + rate + "%, periods = " + n);
		
		// Computes the periodical payment using brute force search
		iterationCounter = 0;
		System.out.print("Periodical payment, using brute force: ");
		System.out.printf("%.2f", bruteForceSolver(loan, rate, n, epsilon));
		System.out.println();
		System.out.println("number of iterations: " + iterationCounter);

		// Computes the periodical payment using bisection search
		iterationCounter = 0;
		System.out.print("Periodical payment, using bi-section search: ");
		System.out.printf("%.2f", bisectionSolver(loan, rate, n, epsilon));
		System.out.println();
		System.out.println("number of iterations: " + iterationCounter);
	}
	
	/**
	* Uses a sequential search method  ("brute force") to compute an approximation
	* of the periodical payment that will bring the ending balance of a loan close to 0.
	* Given: the sum of the loan, the periodical interest rate (as a percentage),
	* the number of periods (n), and epsilon, a tolerance level.
	*/
	// Side effect: modifies the class variable iterationCounter.
    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) { 
		double payment = loan/n; //for sure small enough- (it's a guess)
		double increment = epsilon/n;
		while (true) {
			double endingBalance = EndingBalance( loan, rate, n, payment );
			if (Math.abs(endingBalance ) < epsilon){
				break;
			}
			payment += increment;
			iterationCounter++;
		}
    	return payment ;
    } 

	/**
	* Computes the ending balance of a loan, given the sum of the loan, the periodical
	* interest rate (as a percentage), the number of periods (n), and the periodical payment.
	*/
    public static double EndingBalance (double loan, double rate, int n, double payment){
		double curendingBalance = loan;
		for (int i = 0; i < n; i++){
			curendingBalance = (curendingBalance - payment) * (1.0 + rate/100);
		}
		return curendingBalance; 		
	}
	
    /**
	* Uses bisection search to compute an approximation of the periodical payment 
	* that will bring the ending balance of a loan close to 0.
	* Given: the sum of theloan, the periodical interest rate (as a percentage),
	* the number of periods (n), and epsilon, a tolerance level.
	*/
	// Side effect: modifies the class variable iterationCounter.
    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {
		double L = 0;
        double H = loan;
		double payment = (L + H)/2;
		while (true) {
			double endingBalance = EndingBalance( loan, rate, n, payment );
			if (Math.abs(endingBalance ) < epsilon){
				break;
			}
			if (endingBalance > 0){
				L = payment;
				payment = (L + H)/2;

			}
			if (endingBalance < 0){
				H = payment;
				payment = (L + H)/2;

			}
			iterationCounter++;
		}
    	return payment ;
	}
}