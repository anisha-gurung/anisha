
//this is also child class for gym member since it is extending the parent class
public class PremiumMember extends GymMember {
    // Private attributes  are declared within the class and not accessible directly from outside class
    private final double premiumCharge = 50000; // it is constant
    private String personalTrainer;
    private boolean isFullPayment;
    private double paidAmount;
    private double discountAmount;

    // Constructor
    public PremiumMember(int id, String name, String location, String phone, String email,
                         String gender, String DOB, String membershipStartDate, String personalTrainer) {
        super(id, name, location, phone, email, gender, DOB, membershipStartDate);//this call the constructor of parent class
        this.personalTrainer = personalTrainer;//setting personal trainer name
        this.isFullPayment = false;// keeping the payment to false when not paid full amount
        this.paidAmount = 0;//amount set to 0 at first
        this.discountAmount = 0;//discount amount set to 0 at first
    }

    // Accessor methods which will return all the methods
    public double getPremiumCharge() {
        return premiumCharge;
    }

    public String getPersonalTrainer() {
        return personalTrainer;
    }

    public boolean isFullPayment() {
        return isFullPayment;
    }

    public double getPaidAmount() {
        return paidAmount;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }
// setter which will update the values of attributes
    public void setPersonalTrainer(String personalTrainer) {
        this.personalTrainer = personalTrainer;
    }

    public void setFullPayment(boolean fullPayment) {
        isFullPayment = fullPayment;
    }

    public void setPaidAmount(double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    // Implementation of the abstract method markAttendance from GymMember
    public void markAttendance() {
        // Increment attendance by 1 for PremiumMember
        attendance++;
        loyaltyPoints += 5; // Increment loyalty points by 5 as an example for PremiumMember
    }

    // Method to pay due amount
    public String payDueAmount(double amount) {
        if (isFullPayment == true) { // Check if payment is already full
            return "your payment is done.";
        }

        else {
            paidAmount += amount; // Add the paid amount

            if (paidAmount > premiumCharge) { // If total paid is greater than the total charge of premium
                return "your payment is excees .Please check again thankyou!.";
            }
            else {
                double remainingAmount = premiumCharge - paidAmount; // Calculate remaining amount

                if (paidAmount == premiumCharge) { // If the full payment is made
                    isFullPayment = true;
                    return "Payment successful!  Premium charge of " + premiumCharge + " has been paid.";

                } else { // If payment is not full
                    return "Payment successful! Remaining amount: " + remainingAmount;
                }
            }
        }
    }

    // Method to calculate discount
    public void calculateDiscount() {
        if (isFullPayment == true) { // If full payment is made
            discountAmount = 0.1 * premiumCharge; // 10% discount on premium charge
            System.out.println("Discount of " + discountAmount + " has been applied to your premium charge.");
        } else { // If full payment is not made
            discountAmount = 0; // No discount available if payment is not full
            System.out.println("No discount available as payment is not full. please consider to pay!!");
        }
    }

    // Method to revert PremiumMember details
    public void revertPremiumMember() {
        super.resetMember(); // Call resetMember() from the superclass
        this.personalTrainer = ""; // Reset personalTrainer to empty
        this.isFullPayment = false;//resetting full payment to false
        this.paidAmount = 0;// reset amount to 0
        this.discountAmount = 0; //reset discount amount to 0
    }

    // Display method to show PremiumMember details
    public void display() {
        super.display(); // Call display() from the superclass which is parent class
        System.out.println("Personal Trainer: " + personalTrainer);
        System.out.println("Paid Amount: " + paidAmount);
        System.out.println("Full Payment Status: " + isFullPayment);

        // Calculate and display remaining amount if payment is not full
        double remainingAmount = premiumCharge - paidAmount;
        if (isFullPayment == false) { // If payment is not full
            System.out.println("Remaining Amount to be Paid: " + remainingAmount);
        }

        // Display discount amount if full payment is done
        if (isFullPayment == true) { // If full payment is done
            System.out.println("Discount Amount: " + discountAmount);
        }
    }
}