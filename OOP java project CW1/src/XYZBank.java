import java.util.Scanner;

public class XYZBank {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the maximum number of records: ");
        int maxRecords = 0;
        try {
            maxRecords = scanner.nextInt();
            if (maxRecords <= 0) {
                throw new IllegalArgumentException("Maximum records should be a positive number.");
            }
        } catch (Exception e) {
            System.out.println("Invalid input for maximum records. " + e.getMessage());
            return;
        }

        System.out.print("Enter the number of registered records: ");
        int registeredRecords = 0;
        try {
            registeredRecords = scanner.nextInt();
            if (registeredRecords < 0 || registeredRecords > maxRecords) {
                throw new IllegalArgumentException("Invalid number of registered records.");
            }
        } catch (Exception e) {
            System.out.println("Invalid input for registered records. " + e.getMessage());
            return;
        }

        Record[] records = new Record[maxRecords];

        for (int i = 0; i < registeredRecords; i++) {
            records[i] = createRecord(scanner, i + 1);
            if (records[i] == null) {
                i--;
            }
        }

        // print records in a table
        System.out.println("\nMaximum number of records: " + maxRecords);
        System.out.println("Number of registered records: " + registeredRecords);
        System.out.printf("%-15s%-15s%-15s%-25s%-15s%-15s\n", "Record ID", "Customer ID", "Loan Type", "Loan Amount Left", "Interest Rate", "Loan Term Left");

        for (Record record : records) {
            if (record != null) {
                System.out.printf("%-15s%-15s%-15s%-25.2f%-15.2f%-15d\n", record.getRecordID(), record.getCustomerID(),
                        record.getLoanType(), record.getLoanAmountLeft(), record.getInterestRate(), record.getLoanTerm());
            }
        }
    }

    public static Record createRecord(Scanner scanner, int recordNumber) {
        System.out.println("\nRecord " + recordNumber + ":");

        // input for Record ID (error handling)
        String recordID = "";
        try {
            System.out.print("Enter record ID (123456): ");
            recordID = scanner.next();
            if (!recordID.matches("\\d{6}")) {
                throw new IllegalArgumentException("Invalid format for Record ID.");
            }
        } catch (Exception e) {
            System.out.println("Error in Record " + recordNumber + ": " + e.getMessage());
            return null;
        }

        // input for Customer ID (error handling)
        String customerID = "";
        try {
            System.out.print("Enter customer ID (ABC123): ");
            customerID = scanner.next();
            if (!customerID.matches("[A-Z]{3}\\d{3}")) {
                throw new IllegalArgumentException("Invalid format for Customer ID.");
            }
        } catch (Exception e) {
            System.out.println("Error in Record " + recordNumber + ": " + e.getMessage());
            return null;
        }

        // input for Loan Type (error handling)
        String loanType = "";
        try {
            System.out.print("Enter loan type (Auto/Builder/Mortgage/Personal/Other): ");
            loanType = scanner.next();
            if (!loanType.matches("(Auto|Builder|Mortgage|Personal|Other)")) {
                throw new IllegalArgumentException("Invalid loan type.");
            }
        } catch (Exception e) {
            System.out.println("Error in Record " + recordNumber + ": " + e.getMessage());
            return null;
        }

        // input for Interest Rate (error handling)
        double interestRate = 0;
        try {
            System.out.print("Enter interest rate: ");
            interestRate = scanner.nextDouble();
        } catch (Exception e) {
            System.out.println("Error in Record " + recordNumber + ": Invalid input for interest rate.");
            return null;
        }

        // input for Loan Amount Left (error handling)
        double loanAmountLeft = 0;
        try {
            System.out.print("Enter loan amount left: £ ");
            loanAmountLeft = scanner.nextDouble();
        } catch (Exception e) {
            System.out.println("Error in Record " + recordNumber + ": Invalid input for loan amount left.");
            return null;
        }

        // input for Loan Term Left (error handling)
        int loanTerm = 0;
        try {
            System.out.print("Enter loan term left (in years): ");
            loanTerm = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Error in Record " + recordNumber + ": Invalid input for loan term left.");
            return null;
        }

        return new Record(recordID, customerID, loanType, loanAmountLeft, interestRate, loanTerm);
    }
}