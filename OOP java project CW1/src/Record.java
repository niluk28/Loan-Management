public class Record {
    private String recordID;
    private String customerID;
    private String loanType;
    private double loanAmountLeft;
    private double interestRate;
    private int loanTerm;

    // getter and setter for the private properties
    public String getRecordID() {
        return recordID;
    }

    public void setRecordID(String recordID) {
        this.recordID = recordID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public double getLoanAmountLeft() {
        return loanAmountLeft;
    }

    public void setLoanAmountLeft(double loanAmountLeft) {
        this.loanAmountLeft = loanAmountLeft;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getLoanTerm() {
        return loanTerm;
    }

    public void setLoanTerm(int loanTerm) {
        this.loanTerm = loanTerm;
    }

    //it is the constructor with the custom values
    public Record(String recordID, String customerID, String loanType, double loanAmountLeft, double interestRate, int loanTerm) {
        this.recordID = recordID;
        this.customerID = customerID;
        this.loanType = loanType;
        this.loanAmountLeft = loanAmountLeft;
        this.interestRate = interestRate;
        this.loanTerm = loanTerm;

    }
    public void newRecord(String recordID, String customerID, String loanType, double loanAmountLeft, double interestRate, int loanTerm) {
        this.recordID = recordID;
        this.customerID = customerID;
        this.loanType = loanType;
        this.loanAmountLeft = loanAmountLeft;
        this.interestRate = interestRate;
        this.loanTerm = loanTerm;

    }
}

