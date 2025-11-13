
public abstract class GymMember {
    //Abstract class for gym member because it has both common attributes and methods for regukar and premium members
    // Attributes with protected access modifier
    //protected access modifier  can be accessed with in the same class subclass and classes in the same package
    protected int id;
    protected String name;
    protected String location;
    protected String phone;
    protected String email;
    protected String gender;
    protected String DOB;
    protected String membershipStartDate;
    protected int attendance;
    protected double loyaltyPoints;
    protected boolean activeStatus;

    // Constructor  which will be accepting parameters for id, name, location, phone, email, gender, DOB, and membershipStartDate
    public GymMember(int id, String name, String location, String phone, String email,String gender, String DOB, String membershipStartDate) {
        this.id = id; // this will assign id to the member
        this.name = name;
        this.location = location;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.DOB = DOB;
        this.membershipStartDate = membershipStartDate;
        this.attendance = 0;  // Initialized to 0
        this.loyaltyPoints = 0;  // Initialized to 0
        this.activeStatus = false;  // Default value is  false (it will shjow the active status deactivated at first)
    }

    // Access methods
    public int getId() {
        return id;
    }//this returns the members id

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() { return gender;
    }

    public String getDOB() {
        return DOB;
    }

    public String getMembershipStartDate() {
        return membershipStartDate;
    }

    public int getAttendance() {
        return attendance;
    }

    public double getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public boolean isActiveStatus() {
        return activeStatus;
    }

    //setter methods to update the attributes values  with their respected  variables
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public void setMembershipStartDate(String membershipStartDate) {
        this.membershipStartDate = membershipStartDate;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    public void setLoyaltyPoints(double loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
    }

    // abstract method
    public abstract void markAttendance();

    // Method to activate membership
    public void activateMembership() {
        if (activeStatus == false) {  // when at first the membership is not in active mode then
            activeStatus = true;  //  we activated it later
            System.out.println("the membership is active : " + name);
        }
    }

    // Method to deactivate membership
    public void deactivateMembership() {
        if (activeStatus == true) {  // when  the membership is active at first so we can later deactive it
            activeStatus = false;  // Deactivating the membership
            System.out.println("the membership is deactive: " + name);
        }
    }

    // to reset details methods:
    public void resetMember() {
        activeStatus = false;  // So to reset all the activity should be in deactivate state and then only we can activated it later after resetting
        attendance = 0;  // Resetting the  attendance to zero so the new attendance can be captured
        loyaltyPoints = 0;  // Resetting the loyalty points to zero so after setting new contract the new loyalty points are counted
        System.out.println("Reset of membership : " + name);
    }

    // Method to display member details
    //below prints the id ,nme,location and so on
    public void display() {
        System.out.println("the id of member: " + id);
        System.out.println("the name of memeber: " + name);
        System.out.println("Location: " + location);
        System.out.println("Phone number of member: " + phone);
        System.out.println("Email address of member: " + email);
        System.out.println("Gender: " + gender);
        System.out.println("Date of Birth: " + DOB);
        System.out.println("Date of Joined: " + membershipStartDate);
        System.out.println("Attendance : " + attendance);
        System.out.println("Loyalty points count: " + loyaltyPoints);
        System.out.println("the active status is"+ activeStatus);
    }
}