
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;//imports arraylist for storing gymm members
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
public class NewGUI {//this is the gui where all the buttons text fields are kept
    ArrayList<GymMember> gymMembers = new ArrayList<>();
    public NewGUI() {// this is the constructor
        JFrame frame = new JFrame("Gym Application");// frame name gym Application
        JPanel panel = new JPanel(new GridBagLayout());//panel with grib bag lay out
//radio button if we have to select one from option
        JRadioButton male = new JRadioButton("male");
        JRadioButton female = new JRadioButton("female");
        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(female);
//grouping the buttons so it acts as one and when one button is selected another unchoose itself
        JLabel id = new JLabel("Id:");// this are labels for id ,name locarion and so on  it is kept at the side of the textfield to make user easy so
                                           //they will know in which text field the data need to be entered
        JLabel name = new JLabel("Name:");
        JLabel location = new JLabel("Location:");
        JLabel phone = new JLabel("Phone:");
        JLabel mail = new JLabel("Email:");
        JLabel gender = new JLabel("Gender:");
        JLabel referralSource = new JLabel("Referral Source:");
        JLabel paidAmount = new JLabel("Paid Amount:");
        JLabel removalReason = new JLabel("Removal Reason:");
        JLabel trainerName = new JLabel("Trainer's Name:");
        JLabel plan=new JLabel("Plan");
        JLabel price=new JLabel("Price");
        JLabel premiumPlanCharge=new JLabel("Premium plan charge");
        JLabel discountAmount=new JLabel("Discount Amount");
//combo box for dob
        JLabel dob = new JLabel("DOB:");
        JPanel dobComboBoxPanel = new JPanel(new GridLayout(1, 3));
        JComboBox<String> dobYearComboBox = new JComboBox<>(new String[]{"Year", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008"});
        JComboBox<String> dobMonthComboBox = new JComboBox<>(new String[]{"Month", "jan", "feb", "march", "april", "may", "june", "july", "aug", "sept", "oct", "nov", "dec"});
        JComboBox<String> dobDayComboBox = new JComboBox<>(new String[]{"Day", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"});

        JLabel membershipStartDate = new JLabel("Membership Start Date:");
        JPanel memberComboBoxPanel = new JPanel(new GridLayout(1, 3));
        JComboBox<String> memberYearComboBox = new JComboBox<>(new String[]{"Year", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025"});
        JComboBox<String> memberMonthComboBox = new JComboBox<>(new String[]{"Month", "jan", "feb", "march", "april", "may", "june", "july", "aug", "sept", "oct", "nov", "dec"});
        JComboBox<String> memberDayComboBox = new JComboBox<>(new String[]{"Day", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"});
//TEXTFIELDS to enter data and at the side of this text fields the necessary labels are kept to make easy to recognize
        JTextField idTf = new JTextField(15);
        JTextField nameTf = new JTextField(15);
        JTextField locationTf = new JTextField(15);
        JTextField phoneTf = new JTextField(15);
        JTextField mailTf = new JTextField(15);
        JTextField referralTf = new JTextField(15);
        JTextField paidTf = new JTextField(15);
        JTextField removalTf = new JTextField(15);
        JTextField trainerNameTf = new JTextField(15);
        JTextField priceTf=new JTextField(15);
        priceTf.setEditable(false);
        JTextField premiumChargeTf=new JTextField(15);
        premiumChargeTf.setEditable(false);
        premiumChargeTf.setText("50000");
        JTextField discountTF=new JTextField(15);
        discountTF.setEditable(false);

        //BUTTON FOR THE ACTION WHICH WILL PERFORM ACCORDING TO THEIR METHODS
        JButton regularButton = new JButton("Regular Member");
        JButton premiumButton = new JButton("Premium Member");
        JButton activeButton = new JButton("Active Member");
        JButton deactivateButton = new JButton("Deactivate Member");
        JButton attendanceButton = new JButton("Mark Attendance");
        JButton upgradeButton = new JButton("Upgrade Plan");
        JButton calculateButton = new JButton("Calculate Discount");
        JButton revertRegular = new JButton("Revert Regular");
        JButton revertPremium=new JButton("Revert Premium");
        JButton paymentButton = new JButton("Pay Due Amount");
        JButton readButton = new JButton("Read from file");
        JButton saveButton = new JButton("Save to file");
        JButton displayButton = new JButton("Display");
        JButton clearButton = new JButton("Clear");
        JComboBox planComboBox = new JComboBox<>(new String[]{"Basic", "Standard", "Deluxe"});
//Using grid bag constraibts and has a variable name abc
        GridBagConstraints abc=new GridBagConstraints();
        abc.insets=new Insets(20,20,20,20);// this is for the padding the components
//x is for x-axis and y is for y-axis and adding that componet to the panel
        abc.gridx=0;
        abc.gridy=0;
        panel.add(id,abc);

        abc.gridx=1;
        abc.gridy=0;
        panel.add(idTf,abc);

        abc.gridx=0;
        abc.gridy=1;
        panel.add(name,abc);

        abc.gridx=1;
        abc.gridy=1;
        panel.add(nameTf,abc);

        abc.gridx=0;
        abc.gridy=2;
        panel.add(location,abc);

        abc.gridx=1;
        abc.gridy=2;
        panel.add(locationTf,abc);

        abc.gridx=0;
        abc.gridy=3;
        panel.add(phone,abc);

        abc.gridx=1;
        abc.gridy=3;
        panel.add(phoneTf,abc);

        abc.gridx=0;
        abc.gridy=4;
        panel.add(mail,abc);

        abc.gridx=1;
        abc.gridy=4;
        panel.add(mailTf,abc);

        abc.gridx=0;
        abc.gridy=5;
        panel.add(gender,abc);

        abc.gridx=1;
        abc.gridy=5;
        panel.add(male,abc);

        abc.gridx=2;
        abc.gridy=5;
        panel.add(female,abc);

        abc.gridx=3;
        abc.gridy=0;
        panel.add(dob,abc);

        abc.gridx=4;
        abc.gridy=0;
        dobComboBoxPanel.add(dobYearComboBox);
        dobComboBoxPanel.add(dobMonthComboBox);
        dobComboBoxPanel.add(dobDayComboBox);
        panel.add(dobComboBoxPanel,abc);

        abc.gridx=3;
        abc.gridy=1;
        panel.add(membershipStartDate,abc);

        abc.gridx=4;
        abc.gridy=1;

        memberComboBoxPanel.add(memberYearComboBox);
        memberComboBoxPanel.add(memberMonthComboBox);
        memberComboBoxPanel.add(memberDayComboBox);
        panel.add(memberComboBoxPanel,abc);

        abc.gridx=3;
        abc.gridy=2;
        panel.add(referralSource,abc);

        abc.gridx=4;
        abc.gridy=2;
        panel.add(referralTf,abc);

        abc.gridx=3;
        abc.gridy=3;
        panel.add(paidAmount,abc);

        abc.gridx=4;
        abc.gridy=3;
        panel.add(paidTf,abc);

        abc.gridx=3;
        abc.gridy=4;
        panel.add(removalReason,abc);

        abc.gridx=4;
        abc.gridy=4;
        panel.add(removalTf,abc);


        abc.gridx=3;
        abc.gridy=5;
        panel.add(trainerName,abc);


        abc.gridx=4;
        abc.gridy=5;
        panel.add(trainerNameTf,abc);

        abc.gridx=0;
        abc.gridy=6;
        panel.add(plan,abc);

        abc.gridx=1;
        abc.gridy=6;
        panel.add(planComboBox,abc);

        abc.gridx=0;
        abc.gridy=7;
        panel.add(price,abc);

        abc.gridx=1;
        abc.gridy=7;
        panel.add(priceTf,abc);

        abc.gridx=2;
        abc.gridy=7;
        panel.add(premiumPlanCharge,abc);

        abc.gridx=3;
        abc.gridy=7;
        panel.add(premiumChargeTf,abc);

        abc.gridx=4;
        abc.gridy=7;
        panel.add(discountAmount,abc);

        abc.gridx=5;
        abc.gridy=7;
        panel.add(discountTF,abc);

        abc.gridx=1;
        abc.gridy=8;
        panel.add(regularButton,abc);

        abc.gridx=2;
        abc.gridy=8;
        panel.add(premiumButton,abc);

        abc.gridx=3;
        abc.gridy=8;
        panel.add(activeButton,abc);

        abc.gridx=4;
        abc.gridy=8;
        panel.add(deactivateButton,abc);

        abc.gridx=1;
        abc.gridy=9;
        panel.add(attendanceButton,abc);

        abc.gridx=2;
        abc.gridy=9;
        panel.add(revertRegular,abc);

        abc.gridx=3;
        abc.gridy=9;
        panel.add(revertPremium,abc);

        abc.gridx=4;
        abc.gridy=9;
        panel.add(upgradeButton,abc);

        abc.gridx=1;
        abc.gridy=10;
        panel.add(calculateButton,abc);


        abc.gridx=2;
        abc.gridy=10;
        panel.add(paymentButton,abc);


        abc.gridx=3;
        abc.gridy=10;
        panel.add(readButton,abc);


        abc.gridx=4;
        abc.gridy=10;
        panel.add(saveButton,abc);


        abc.gridx=2;
        abc.gridy=11;
        panel.add(displayButton,abc);


        abc.gridx=3;
        abc.gridy=11;
        panel.add(clearButton,abc);

        //------------------------------------------------ACTION----LISTENER---------------------------------------------------/
        regularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Collecting data from the input fields
                    String idText = idTf.getText().trim();
                    String name = nameTf.getText().trim();
                    String location = locationTf.getText().trim();
                    String phone = phoneTf.getText().trim();
                    String email = mailTf.getText().trim();
                    String gender = male.isSelected() ? "Male" : "Female";
                    String dob = dobYearComboBox.getSelectedItem() + "-" + dobMonthComboBox.getSelectedItem() + "-" + dobDayComboBox.getSelectedItem();
                    String membershipStartDate = memberYearComboBox.getSelectedItem() + "-" + memberMonthComboBox.getSelectedItem() + "-" + memberDayComboBox.getSelectedItem();
                    String referralSource = referralTf.getText().trim();
                    // Validate required fields is enpty then so the message
                    if (idText.isEmpty() || name.isEmpty() || location.isEmpty() || phone.isEmpty() || email.isEmpty() || referralSource.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please fill in all fields which are empty.");
                        return;
                    }
                    int memberId = Integer.parseInt(idText); // Only this is inside try-catch and this converts the string into integer beacuse the id is inputed as string when enered and onverted it into the integer

                    // Check for duplicate IDs
                    for (GymMember member : gymMembers) {
                        if (member.getId() == memberId) {
                            JOptionPane.showMessageDialog(null, "This ID is already taken. Please choose a different ID.");
                            return;
                        }
                    }
                    // Create and add the RegularMember
                    RegularMember regularMember = new RegularMember(memberId, name, location, phone, email, gender, dob, membershipStartDate, referralSource);
                    gymMembers.add(regularMember);
                    JOptionPane.showMessageDialog(null, "Regular Member  is successfully added!");
                }
                catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Sorry !!!Member ID must be a valid number.");
                }
            }
        });

//------------------------------------CLEAR BUTTON ACTION LISTENER-----------------------------------------------------------------------------------------------
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // here we are clearing all the input text fileds when the clear button is pressed
                idTf.setText("");
                nameTf.setText("");
                locationTf.setText("");
                phoneTf.setText("");
                mailTf.setText("");
                referralTf.setText("");
                removalTf.setText("");
                trainerNameTf.setText("");
                priceTf.setText("");
                discountTF.setText("");
                paidTf.setText("");

                // Resetting the  combo boxes to the default option of index 0 so they still show year month and day
                dobYearComboBox.setSelectedIndex(0);
                dobMonthComboBox.setSelectedIndex(0);
                dobDayComboBox.setSelectedIndex(0);

                memberYearComboBox.setSelectedIndex(0);
                memberMonthComboBox.setSelectedIndex(0);
                memberDayComboBox.setSelectedIndex(0);

                // Unchecking gender radio buttons
                group.clearSelection();

                // here resetting the plan combo box to default value of index 0
                planComboBox.setSelectedIndex(0);
                JOptionPane.showMessageDialog(null, "All fields have been cleared.");
            }
        });


        //--------------PREMIUM BUTTON ACTION LISTENER-------------------------------------------------------------------------------------------------------
        premiumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Collecting the input data
                    String idText = idTf.getText().trim();
                    String name = nameTf.getText().trim();
                    String location = locationTf.getText().trim();
                    String phone = phoneTf.getText().trim();
                    String email = mailTf.getText().trim();
                    String gender = male.isSelected() ? "Male" : (female.isSelected() ? "Female" : "");
                    String dob = dobYearComboBox.getSelectedItem() + "-" + dobMonthComboBox.getSelectedItem() + "-" + dobDayComboBox.getSelectedItem();
                    String membershipStartDate = memberYearComboBox.getSelectedItem() + "-" + memberMonthComboBox.getSelectedItem() + "-" + memberDayComboBox.getSelectedItem();
                    String trainerName = trainerNameTf.getText().trim();

                    // Validate required fields if empty to the message box
                    if (idText.isEmpty() || name.isEmpty() || location.isEmpty() || phone.isEmpty() ||
                            email.isEmpty() || gender.isEmpty() || trainerName.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Sorry !!!Please fill in all required  fields.");
                        return;
                    }

                    // Validate ID
                    int memberId = Integer.parseInt(idText);//again convert the id entered into the integer

                    // Check for duplicate ID if the id is found already in the system then sho the message
                    for (GymMember member : gymMembers) {
                        if (member.getId() == memberId) {
                            JOptionPane.showMessageDialog(null, "Sorry!!!This ID is already taken. Please choose a new ID.");
                            return;
                        }
                    }
                    // Create and add PremiumMember to the gym memebers list
                    PremiumMember premiumMember = new PremiumMember(memberId, name, location, phone, email, gender, dob, membershipStartDate, trainerName);
                    gymMembers.add(premiumMember);

                    JOptionPane.showMessageDialog(null, "Premium Member successfully added!");

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Member ID must be a valid number.");
                }
            }
        });
        //-------------------------------ACTIVE MEMBERSHIP BUTTON ACTION LISTENER---------------------------------------------------------------------------------------
        activeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 1. Get the Member ID from the input field
                String idText = idTf.getText().trim();  // Get the text from the ID field

                // 2. Check if the ID field is empty
                if (idText.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter the Member ID to activate.");
                    return;
                }

                try {
                    // 3. Convert the entered text to an integer (Member ID)
                    int memberId = Integer.parseInt(idText);  // Convert the input into an integer
                    boolean found = false;  // to check if the ID was found

                    // 4. Loop through the gymMembers list to find a match
                    for (GymMember member : gymMembers) {
                        if (member.getId() == memberId) {
                            // . If the Member ID matches, activate the membership
                            member.activateMembership();  // Call the method from GymMember
                            JOptionPane.showMessageDialog(null, "Membership activated for Member ID: " + memberId+ "name:"+member.getName());// to when active button or deactive button is pressed we are using getNAme()*because whe are displaying the member which are already existing not getTExt()
                            found = true;  // Set the flag to true indicating the member was found
                            break;  // Exit the loop
                        }
                    }

                    // 6. If the Member ID was not found, show an error message
                    if (!found) {
                        JOptionPane.showMessageDialog(null, "sorry!! there is no member with this ID : " + memberId);
                    }

                } catch (NumberFormatException ex) {
                    // 7. If the entered ID is not a valid number, show an error message
                    JOptionPane.showMessageDialog(null, "Sorry,Member ID must be a valid number.");
                }
            }
        });
//---------------------------------ACTION LISTENER OF DEACTIVATE BUTTON------------------------------------------------------------------------
        deactivateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idText = idTf.getText().trim();

                // Check if ID is entered if empty show the message below
                if (idText.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Sorry!!!!Please enter  ID to deactivate.");
                    return;
                }

                try {
                    // 3. Convert the entered text to an integer (Member ID)
                    int memberId = Integer.parseInt(idText);
                    boolean found = false;

                    for (GymMember member : gymMembers) {
                        if (member.getId() == memberId) {
                            member.deactivateMembership();  // Call method from GymMember class
                            JOptionPane.showMessageDialog(null, "Membership deactivated for Member ID: " + memberId + ", Name: " + member.getName());
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        JOptionPane.showMessageDialog(null, "No member found with ID: " + memberId);
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid Member ID. Please enter a valid number.");
                }
            }
        });
        //------------------------------------ REVERT REGULAR BUTTON------------------------------------------------
        revertRegular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idText = idTf.getText().trim();  // Use the ID field for member ID
                 String removalReason =removalTf.getText().trim();
                if (idText.isEmpty() || removalReason.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter Member ID. And Also write your removal reason");
                    return;
                }
                try {
                    int memberId = Integer.parseInt(idText); // Convert the entered text to an integer (Member ID)
                    boolean found = false;

                    for (GymMember member : gymMembers) {
                        if (member.getId() == memberId && member instanceof RegularMember) {
                            ((RegularMember) member).revertRegularMember(removalReason);
                            JOptionPane.showMessageDialog(null, " Regular Member reverted: " + member.getName()+"Reason of Removal:"+removalReason);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        JOptionPane.showMessageDialog(null, "Sorry!!! No id is found : " + memberId);
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, " Sorry !!!Please enter a valid  ID.");
                }
            }
        });
//-----------------------------------REVERT PREMIUM BUTTON-----------------------------------------------------------------------------------------------------
        revertPremium.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idText = idTf.getText().trim();  // Use the ID field for member ID


                if (idText.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Sorry!!!Please enter the required Member ID ");
                    return;
                }
                try {
                    //Convert the entered text to an integer (Member ID)
                    int memberId = Integer.parseInt(idText);
                    boolean found = false;

                    for (GymMember member : gymMembers) {
                        if (member.getId() == memberId && member instanceof PremiumMember) {
                            ((PremiumMember) member).revertPremiumMember();
                            JOptionPane.showMessageDialog(null, "Premium Member reverted successfully for: " + member.getName());
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        JOptionPane.showMessageDialog(null, "id cannot be found: " + memberId);
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number.");
                }
            }
        });
//-----------------------------------ATTENDANCE BUTTON-----------------------------------------------------------------------------------------------------------------
        attendanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Get the text from the ID input field and trim any spaces
                    String inputText = idTf.getText().trim();

                    //  Convert the input text to an integer (Member ID)
                    int enteredId = Integer.parseInt(inputText);

                    // Initialize a variable to hold the matching GymMember
                    GymMember foundMember = null;
                    //gymMember is class foundMember is variable and null means that is it right now empty and later it will find the id while looping

                    // Step 4: Loop through the gymMembers list to find a member with the entered ID
                    for (GymMember member : gymMembers) {
                        if (member.getId() == enteredId) {
                            foundMember = member; // Store the found member
                            break; // Exit the loop since we found the member
                        }
                    }

                    // Step 5: If a matching member was found
                    if (foundMember != null) {
                        // Call the member’s markAttendance() method
                        foundMember.markAttendance();

                        // Show a success message with updated attendance and loyalty points
                        JOptionPane.showMessageDialog(null, " Attendance marked for: " + foundMember.getName() +
                                        "\n Attendance count: " + foundMember.getAttendance() +
                                        "\n Loyalty Points: " + foundMember.getLoyaltyPoints());
                    }
                    /*
                foundMember.getName() return the member's name which is in gym member class
                */
                    else {
                        // If no member with the entered ID was found, show a basic error message
                        JOptionPane.showMessageDialog(null, " id is not available");
                    }
                } catch (NumberFormatException ex) {
                    // If the entered ID is not a valid number, show a simple text message (no warning icon)
                    JOptionPane.showMessageDialog(null, "Please enter a valid member id.");
                }
            }
        });
 //----------------------------------UPGRADE PLAN BUTTON--------------------------------------------------------------------------------------------------------------
        upgradeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textID = idTf.getText().trim();

                if (textID.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter Member ID.");
                    return;
                }
                //  Convert the input text to an integer (Member ID)
                int idEntered = Integer.parseInt(textID);

                GymMember idSearch = null;//looping to match the id
                for (GymMember memberUpgrade : gymMembers) {
                    if (memberUpgrade.getId() == idEntered) {
                        idSearch = memberUpgrade;
                        break;
                    }
                }
                if(idSearch !=null){
                    if(idSearch instanceof RegularMember){
                        RegularMember reg=(RegularMember) idSearch;

                        if(reg.isActiveStatus()){
                            String planSelect=(String) planComboBox.getSelectedItem();
                            String planUpgrade=reg.upgradePlan(planSelect);

                            priceTf.setText(String.valueOf(reg.getPrice()));
                            JOptionPane.showMessageDialog(null,planUpgrade);
                        }

                        else {
                            JOptionPane.showMessageDialog(null,"this id is not active.Please you need to active the id first");
                        }
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null,"Sorry ,We are unable to find the id");
                }


            }
        });
        //------------------------------PAY DUE AMOUNT----------------------------------------------------------------------------
        paymentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputId=idTf.getText().trim();
                String paymentInput=paidTf.getText().trim();
                if(inputId.isEmpty() || paymentInput.isEmpty()){
                    JOptionPane.showMessageDialog(null,"sorry you have not entered the ID  or Amount . Please enter valid ID and amount ");
                    return;
                }
                //  Convert the input text to an integer (Member ID)
                int idEnter=Integer.parseInt(inputId);
                double amountEnter=Double.parseDouble(paymentInput);

                GymMember searchId=null;
                for(GymMember memberPay:gymMembers){
                    if(memberPay.getId()==idEnter){
                        searchId=memberPay;
                        break;
                    }
                }

                if(searchId!=null){
                    if(searchId instanceof PremiumMember){
                        PremiumMember member=(PremiumMember) searchId;
                        String paymentMessage=member.payDueAmount(amountEnter);
                        JOptionPane.showMessageDialog(null,paymentMessage);
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"Sorry ,the entered id is not a premium member.");
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null,"sorry we all unable to find the id");
                }
            }
        });

        //-------------------------------------------Discount--Amount--Button----------------------------------------------------------------------------------------------
               calculateButton.addActionListener(new ActionListener() {
                   @Override
                   public void actionPerformed(ActionEvent e) {
                       String idEnter=idTf.getText().trim();
                       if (idEnter.isEmpty()) {
                           JOptionPane.showMessageDialog(null, "Sorry,You have not entered the ID. Please enter ID first");
                           return;
                       }
                       //  Convert the input text to an integer (Member ID)

                       int idInput=Integer.parseInt(idEnter);

                       GymMember searchId=null;
                       for(GymMember calculate :gymMembers){
                           if(calculate.getId()==idInput){
                               searchId=calculate;
                               break;
                           }
                       }

                       if(searchId!=null){
                           if(searchId instanceof PremiumMember){
                               PremiumMember discount=(PremiumMember) searchId;

                               if(discount.isActiveStatus()){
                                   discount.calculateDiscount();

                                   double discountAmount=discount.getDiscountAmount();
                                   discountTF.setText(String.valueOf(discountAmount));
                               }
                               else {
                                   JOptionPane.showMessageDialog(null,"sorry,this entered id is not active");
                               }
                           }
                       }
                       else{
                           JOptionPane.showMessageDialog(null,"Sorry,we are unable to the find the id");
                       }

                   }
               });

//------------------------------------------------ACTION listener for SAVE TO file---------------------------------------------------------------
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (gymMembers.isEmpty()) {//if the gym member has no id then there will be no one and not able to save to the memberdetails file
                    JOptionPane.showMessageDialog(null, "No member data to save!", "Warning", JOptionPane.WARNING_MESSAGE);
                    return;
                }
//this allows to write text data into the file  this printerWriters handles the input /output
                try (PrintWriter writer = new PrintWriter("MemberDetails.txt")) {
                    // Write header line
                    writer.println(String.format("%-5s %-15s %-15s %-15s %-25s %-20s %-10s %-10s %-10s %-15s %-10s %-15s %-15s %-15s",
                            "ID", "Name", "Location", "Phone", "Email", "Membership Start Date",
                            "Plan", "Price", "Attendance", "Loyalty Points", "Active Status",
                            "Full Payment", "Discount Amount", "Net Amount Paid"));

                    // Write member details
                    for (GymMember member : gymMembers) {
                        if (member instanceof RegularMember) {
                            RegularMember rm = (RegularMember) member;//add to regular members
                            writer.println(String.format("%-5d %-15s %-15s %-15s %-25s %-20s %-10s %-10.2f %-10d %-15.2f %-10s %-15s %-15s %-15s",
                                    member.getId(), member.getName(), member.getLocation(), member.getPhone(),
                                    member.getEmail(), member.getMembershipStartDate(),
                                    rm.getPlan(), rm.getPrice(), member.getAttendance(),
                                    member.getLoyaltyPoints(), member.isActiveStatus() ? "Active" : "Inactive",
                                    "N/A", "N/A", "N/A"));
                        } else if (member instanceof PremiumMember) {
                            PremiumMember pm = (PremiumMember) member;
                            writer.println(String.format("%-5d %-15s %-15s %-15s %-25s %-20s %-10s %-10s %-10d %-15.2f %-10s %-15s %-15.2f %-15.2f",
                                    member.getId(), member.getName(), member.getLocation(), member.getPhone(),
                                    member.getEmail(), member.getMembershipStartDate(),
                                    "Premium", "N/A", member.getAttendance(),
                                    member.getLoyaltyPoints(), member.isActiveStatus() ? "Active" : "Inactive",
                                    pm.isFullPayment() ? "Yes" : "No", pm.getDiscountAmount(), pm.getPaidAmount()));
                        }
                    }

                    JOptionPane.showMessageDialog(null, "Member details saved to MemberDetails.txt successfully! Thankyouuu");
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "Sorry !!! not able to save: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        //-------------------------------------------READ TO FILE---------------------------------------------------------------------------------------------------
        readButton.addActionListener(e -> {
            try {
                // Create new frame
                JFrame readFrame = new JFrame("Member Details");//creates new frame for the read
                readFrame.setSize(600, 300);
                readFrame.setLocationRelativeTo(null);//it makes to open the frame in center
                readFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//close window without exiting app

                // Create text area to put all the details of members
                JTextArea textArea = new JTextArea();
                textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));//font is monospaced,size 12
                textArea.setEditable(false);//only able to read

                // Read file
                BufferedReader reader = new BufferedReader(new FileReader("MemberDetails.txt"));
                // this will open the member details.txt file for the reading
                String line;
                while ((line = reader.readLine()) != null) {
                    textArea.append(line + "\n");//this will add the every line to the text area
                }
                reader.close();//this will close the file

                // Add text area to scroll pane
                readFrame.add(new JScrollPane(textArea));//adding the readframe to the scroll plane
                readFrame.setVisible(true);//setting the frame to visible
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        //-------------DISPLAY ACTION LISTENER------------------------------------------------------------------------------------------------------------------------
        displayButton.addActionListener(e -> {
            // before displaying we need to check if the gym array list is empty or not
            if (gymMembers.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Sorry!!!No members to display!", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Create new frame to display
            JFrame displayFrame = new JFrame("Member Details");//name of frame is member details
            displayFrame.setSize(600, 300);
            displayFrame.setLocationRelativeTo(null);//this hepls to open the window in the center
            displayFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// this makes sure that the frame closes with out eixting the app

            // Create text area for members details.
            JTextArea textArea = new JTextArea();
            textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
            textArea.setEditable(false);

            // creates text area for members details and adds header
            textArea.append(String.format("%-5s %-15s %-15s %-15s %-25s %-20s %-10s %-10s %-10s %-15s %-10s %-15s %-15s %-15s\n",
                    "ID", "Name", "Location", "Phone", "Email", "Membership Start Date",
                    "Plan", "Price", "Attendance", "Loyalty Points", "Active Status",
                    "Full Payment", "Discount Amount", "Net Amount Paid"));

            // Add member details  to the  gymmembers
            for (GymMember member : gymMembers) {
                if (member instanceof RegularMember rm) {
                    //adds the text area  to the regular members details
                    textArea.append(String.format("%-5d %-15s %-15s %-15s %-25s %-20s %-10s %-10.2f %-10d %-15.2f %-10s %-15s %-15s %-15s\n",
                            member.getId(), member.getName(), member.getLocation(), member.getPhone(),
                            member.getEmail(), member.getMembershipStartDate(),
                            rm.getPlan(), rm.getPrice(), member.getAttendance(),
                            member.getLoyaltyPoints(), member.isActiveStatus() ? "Active" : "Inactive",
                            "N/A", "N/A", "N/A"));
                    //add the text area to the premium members details
                } else if (member instanceof PremiumMember pm) {
                    textArea.append(String.format("%-5d %-15s %-15s %-15s %-25s %-20s %-10s %-10s %-10d %-15.2f %-10s %-15s %-15.2f %-15.2f\n",
                            member.getId(), member.getName(), member.getLocation(), member.getPhone(),
                            member.getEmail(), member.getMembershipStartDate(),
                            "Premium", "N/A", member.getAttendance(),
                            member.getLoyaltyPoints(), member.isActiveStatus() ? "Active" : "Inactive",
                            pm.isFullPayment() ? "Yes" : "No", pm.getDiscountAmount(), pm.getPaidAmount()));
                }
            }
            // Add text area to scroll pane
            displayFrame.add(new JScrollPane(textArea));
            displayFrame.setVisible(true);
        });

        //----------------------------------------------------------------------------------------------------------------------------------------------------
        frame.add(panel);//adding the panel to the frame
                frame.setSize(1000, 800);
                frame.setLocationRelativeTo(null);//adding this makes sures that the frame centers
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);//setting the frame visible

            }

            public static void main(String[] args) {
                new NewGUI();
            }
        }