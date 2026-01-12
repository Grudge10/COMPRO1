public class FinancialApplication {
    public static void main(String[] args) {
        System.out.printf("%-10s%-9s%-16s%-11s%-10s\n%-10s%-9s%-16s%-11s%-10s\n%-10s%-9s%-16s%-11s%-10s\n", "Taxable", "Single", "Married Joint", "Married", "Head of", "Income", "", "or Qualifying","Separate", "House hold", "", "", "Widow(er)", "", ""); // print the header showing all the categories
        for (int taxableIncome = 50000; taxableIncome <= 60000; taxableIncome += 50) // make multiple rows until $60,000. increment by 50
            System.out.printf("%-10d%-9d%-16d%-11d%-10d\n", taxableIncome, Math.round(computeTax(0, taxableIncome)), Math.round(computeTax(1, taxableIncome)), Math.round(computeTax(2, taxableIncome)), Math.round(computeTax(3, taxableIncome))); // print a whole row of the taxable incomes and taxes for all categories
    }

    public static double computeTax(int status, double taxableIncome) { // compute the tax according to status then return
        double tax = 0; // initialize tax
        switch (status) { // check the status and use the appropriate tax formula
            case 0: tax = 4675 + 0.25 * (taxableIncome - 33950); break; // compute for single
            case 1: tax = 1670 + 0.15 * (taxableIncome - 16700); break; // compute for married joint or qualifying widow(er)
            case 2: tax = 4675 + 0.25 * (taxableIncome - 33950); break; // compute for married separate
            case 3: tax = 6227.50 + 0.25 * (taxableIncome - 45500); break; // compute for head of house hold
        }
        return tax; // return the computed tax
    }
}