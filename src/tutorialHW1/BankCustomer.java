package tutorialHW1;

public class BankCustomer {
    private int accountNumber;
    private String customerName;
    private String customerAddress;
    private String customerDateOfBirth;

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public String getCustomerDateOfBirth() {
        return customerDateOfBirth;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public void setCustomerDateOfBirth(String customerDateOfBirth) {
        this.customerDateOfBirth = customerDateOfBirth;
    }
}
