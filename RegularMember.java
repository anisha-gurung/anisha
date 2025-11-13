//this is subclass or child class gym member with its own attributes and behaviours
public class RegularMember extends GymMember {
    // Private attributes for regular member
    private final int attendanceLimit = 30; // final constant which means this is the minimum limit need to match or should be more to be able to upgrade plan
    private boolean isEligibleForUpgrade;//to make sure if the member is eligible or not to have a upgrade plan
    private String removalReason;//Reason for removal
    private String referralSource;//From where they got referral
    private String plan;
    private double price;

    // Constructor this will initialize the member object
    public RegularMember(int id, String name, String location, String phone, String email,
                         String gender, String DOB, String membershipStartDate, String referralSource) {
        super(id, name, location, phone, email, gender, DOB, membershipStartDate);//this super mean this will call the constructor from the parent class
        this.referralSource = referralSource;
        this.isEligibleForUpgrade = false;// at first setting the eligiblity to false beacuse no one is eligible when first takes the membership
        this.plan = "basic";//default value of plan
        this.price = 6500;//default value of price
        this.removalReason = "";//making sure no the removal reason is empty at first
    }

    // Accessor methods which will return  attendamce,eligiblity,removal reason,referral source,plan,price
    public int getAttendanceLimit() {
        return attendanceLimit;
    }

    public boolean isEligibleForUpgrade() {
        return isEligibleForUpgrade;
    }

    public String getRemovalReason() {
        return removalReason;
    }

    public String getReferralSource() {
        return referralSource;
    }

    public String getPlan() {
        return plan;
    }

    public double getPrice() {
        return price;
    }

    public void setEligibleForUpgrade(boolean eligibleForUpgrade) {
        isEligibleForUpgrade = eligibleForUpgrade;
    }

    public void setRemovalReason(String removalReason) {
        this.removalReason = removalReason;
    }
//access method setter which will updates the attribute value fpr referra; source,plan,price
    public void setReferralSource(String referralSource) {
        this.referralSource = referralSource;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Abstract method markAttendance
    public void markAttendance() {
        attendance++;
        loyaltyPoints += 5; // Increment loyalty points by 5
        if (attendance >= attendanceLimit) {//condition is that the attendance need to be 30 or more than 30 to be able to upgrade plan
            isEligibleForUpgrade = true; // If attendance limit is reached, set eligible for upgrade
        }
    }

    // Method to get plan price
    public double getPlanPrice(String plan) {
        switch (plan.toLowerCase()) {//since it can be case-insensitive we use tolowerCase()
            case "basic":
                return 6500;
            case "standard":
                return 12500;
            case "deluxe":
                return 18500;
            default:
                return -1; // if the invalid plan ispassed then the getplanprice() method should return -1
        }
    }

    // Method to upgrade the plan
    public String upgradePlan(String newPlan) {
        if (isEligibleForUpgrade == false) {
            return "You are not eligible for an upgrade yet.";
        } else {
            double newPrice = getPlanPrice(newPlan);
            if (newPrice == -1) { // Checking for invalid plan with if-else
                return "Invalid plan. Please select a valid plan.";
            } else {
                if (this.plan.equalsIgnoreCase(newPlan)) { // Replacing if (!this.plan.equalsIgnoreCase(newPlan))
                    return "You are already subscribed to the " + newPlan + " plan.";
                } else {
                    this.plan = newPlan;
                    this.price = newPrice;
                    isEligibleForUpgrade = false; // Reset eligibility after upgrading
                    return "Plan successfully upgraded to " + newPlan + " with a price of " + price;
                }
            }
        }
    }

    // Method to revert RegularMember details
    public void revertRegularMember(String removalReason) {
        super.resetMember(); // Call resetMember() from the superclass
        this.isEligibleForUpgrade = false;//again resetting the eligiblity to false when rvert regualar button clicked
        this.plan = "basic";//reseting plan to basic when button reverrt is clicked
        this.price = 6500;//resetting price to 6500
        this.removalReason = removalReason;
    }

    // Display method to show RegularMember details
    public void display() {
        super.display(); // Call display() from the superclass
        System.out.println("Plan: " + plan);//
        System.out.println("Price: " + price);
        if (removalReason.equals("")) { // Replacing !removalReason.isEmpty() with if-else
            // Do nothing, no removal reason to display
        } else {
            System.out.println("Removal Reason: " + removalReason);
        }
    }
}