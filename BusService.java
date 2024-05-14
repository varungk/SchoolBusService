import java.io.*;
import java.lang.*;

class BusService {
    String CustomerDetails[][] = new String[25][13];
    int no_of_cust = 0;
    String one_way_or_two_way;
    int no_of_seats;

    void TempConstructor() {
        for (int j = 0; j < 25; j++) {
            CustomerDetails[j][12] = "Available";
            CustomerDetails[j][0] = "Not Registered";
            CustomerDetails[j][10] = "Not Booked";
        }
    }

    String CustomerDetailsMethod(int custNo) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Name: ");
        String name = br.readLine();
        if (name.trim().length() == 0) {
            System.out.println("Your name is mandatory. Please fill this slot");
            String j = "false";
            return j;
        }
        CustomerDetails[custNo][0] = name;
        System.out.print("Gender(M for male,F for female,O for others): ");
        String gender = br.readLine().toUpperCase().substring(0, 1);
        if ((gender.equals("M")) || (gender.equals("F")) || (gender.equals("O"))) {
            CustomerDetails[custNo][1] = gender;
        } else {
            System.out.println("Please enter M for male, F for female or O for others");
            String j = "false";
            return j;
        }
        System.out.println("These following details are not mandatory");
        System.out.println();
        System.out.println("Address:");
        System.out.print("\tStreetName: ");
        CustomerDetails[custNo][2] = br.readLine();
        System.out.print("\tLocality: ");
        CustomerDetails[custNo][3] = br.readLine();
        System.out.print("\tCity: ");
        CustomerDetails[custNo][4] = br.readLine();
        System.out.print("\tState: ");
        CustomerDetails[custNo][5] = br.readLine();
        System.out.print("\tCountry: ");
        CustomerDetails[custNo][6] = br.readLine();
        System.out.print("PhoneNumber: ");
        CustomerDetails[custNo][7] = br.readLine();
        String k = "true";
        return k;
    }

    void AddCustomerDetails() throws IOException {
        System.out.println("Please enter the following information.");
        String check = CustomerDetailsMethod(no_of_cust);
        if (check.equals("true")) {
            ////////////////////////////////////////////// Customer ID
            ////////////////////////////////////////////// Generator//////////////////////////////////////
            double rand = Math.random();
            String no = Double.toString(rand);
            String test = no.substring(2, 12);
            String mfvc = "MFVC";
            String customerID = mfvc + test;
            CustomerDetails[no_of_cust][8] = customerID;
            System.out.println("Your customer ID :" + customerID);
            System.out.println();
            no_of_cust++;
        } else {
            System.out.println();
            AddCustomerDetails();
        }
    }

    String routeDetails(int j) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String choices = "";
        System.out.println("Please choose a number for desired route");
        System.out.println("1.One - Way");
        System.out.println("2.Two - Way");
        int choice = Integer.parseInt(br.readLine());
        switch (choice) {
            case 1:
                one_way_or_two_way = "One-Way";
                System.out.println("1.Point A - School");
                System.out.println("2.Point B - School");
                System.out.println("3.School - Point A");
                System.out.println("4.School - Point B");
                int choice1 = Integer.parseInt(br.readLine());
                switch (choice1) {
                    case 1:
                        System.out.println("The cost for this route is Rs 200");
                        System.out.println("Do you want to book a ticket(Yes/no)");
                        choices = br.readLine().toUpperCase();
                        if (choices.equals("YES")) {
                            CustomerDetails[j][9] = "Point A - School";// cost 200
                            CustomerDetails[j][11] = "200";
                        }
                        break;
                    case 2:
                        System.out.println("The cost for this route is Rs 300");
                        System.out.println("Do you want to book a ticket(Yes/no)");
                        choices = br.readLine().toUpperCase();
                        if (choices.equals("YES")) {
                            CustomerDetails[j][9] = "Point B - School";// cost 300
                            CustomerDetails[j][11] = "300";
                        }
                        break;
                    case 3:
                        System.out.println("The cost for this route is Rs 250");
                        System.out.println("Do you want to book a ticket(Yes/no)");
                        choices = br.readLine().toUpperCase();
                        if (choices.equals("YES")) {
                            CustomerDetails[j][9] = "School - Point A";// cost 250
                            CustomerDetails[j][11] = "250";
                        }
                        break;
                    case 4:
                        System.out.println("The cost for this route is Rs 350");
                        System.out.println("Do you want to book a ticket(Yes/no)");
                        choices = br.readLine().toUpperCase();
                        if (choices.equals("YES")) {
                            CustomerDetails[j][9] = "School - Point B";// cost 350
                            CustomerDetails[j][11] = "350";
                        }
                        break;
                    default:
                        System.out.println("Please check your input");
                }
                break;
            case 2:
                one_way_or_two_way = "Two-Way";
                System.out.println("1.Point A - School And School - Point A");// costs 400
                System.out.println("2.Point B - School And School - Point B");// costs 600
                int choice2 = Integer.parseInt(br.readLine());
                switch (choice2) {
                    case 1:
                        System.out.println("The cost for this route is Rs 400");
                        System.out.println("Do you want to book a ticket(Yes/no)");
                        choices = br.readLine().toUpperCase();
                        if (choices.equals("YES")) {
                            CustomerDetails[j][9] = "Point A - School And School - Point A";
                            CustomerDetails[j][11] = "400";
                        }
                        break;
                    case 2:
                        System.out.println("The cost for this route is Rs 600");
                        System.out.println("Do you want to book a ticket(Yes/no)");
                        choices = br.readLine().toUpperCase();
                        if (choices.equals("YES")) {
                            CustomerDetails[j][9] = "Point B - School And School - Point B";
                            CustomerDetails[j][11] = "600";
                        }
                        break;
                    default:
                        System.out.println("Please check your input");
                        System.out.println();
                }
                break;
            default:
                System.out.println("Please check your input");
                System.out.println();
                break;
        }
        return choices;
    }

    void BookASeat() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int check = 0;
        if (no_of_seats <= 25) {
            System.out.println("Enter your customer ID");
            String customerID = br.readLine();
            int validity = custIdValidityCheck(customerID);
            if (validity != -1) {
                System.out.println();
                if (CustomerDetails[validity][12] != "BOOKED") {
                    String choices = routeDetails(validity);
                    System.out.println();
                    if (choices.equals("YES")) {
                        System.out.println("Customer ID :" + CustomerDetails[validity][8]);
                        System.out.println("Customer Name :" + CustomerDetails[validity][0]);
                        CustomerDetails[validity][12] = "BOOKED";
                        //////////////////////////////////////////////// Seat
                        //////////////////////////////////////////////// Number///////////////////////////////////////////
                        double rand = Math.random();
                        String no = Double.toString(rand);
                        String test = no.substring(2, 8);
                        String mfv = "MFV";
                        String SeatNumber = mfv + test;
                        CustomerDetails[validity][10] = SeatNumber;
                        ///////////////////////////////////////////////// Continue.....///////////////////////////////////

                        System.out.println("Seat Number :" + CustomerDetails[validity][10]);
                        System.out.println(one_way_or_two_way + " , " + CustomerDetails[validity][9]);
                        System.out.println("Cost = " + CustomerDetails[validity][11]);
                        System.out.println();
                        no_of_seats = no_of_seats + 1;
                    } else if (choices.equals("NO")) {
                        System.out.println("Your Seat has not been booked");
                    } else {
                        System.out.println("Please enter yes or no to book or not book a seat.");
                    }
                } else {
                    System.out.println();
                    System.out.println("You can only book one seat per day and you have exceeded that.");
                    System.out.println("Sorry for your inconvenience");
                    System.out.println();
                }
            } else {
                System.out.println();
                System.out.println("Please enter a valid CustomerID");
                System.out.println("If you do not have one, please add your customer details from the main menu");
                System.out.println();
                check = 1;
            }
        } else {
            System.out.println();
            System.out.println("Tickets for today are sold out");
            System.out.println("Sorry for your inconvenience");
            System.out.println("Please come back tomorrow");
            System.out.println();
        }

    }

    int custIdValidityCheck(String custID) {
        for (int i = 0; i < 25; i++) {
            String customerID = CustomerDetails[i][8];
            if (custID.equals(customerID)) {
                return i;
            }
        }
        int j = -1;
        return j;
    }

    void EditSeatDetails() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int check = 0;
        System.out.println("Enter your SeatNumber");
        String seatNumber = br.readLine();
        int validity = custSeatNoCheck(seatNumber);
        if (validity != -1) {
            routeDetails(validity);
            System.out.println();
            System.out.println("Customer ID :" + CustomerDetails[validity][8]);
            System.out.println("Customer Name :" + CustomerDetails[validity][0]);
            System.out.println("Seat Number :" + CustomerDetails[validity][10]);
            System.out.println(one_way_or_two_way + " , " + CustomerDetails[validity][9]);
            System.out.println("Cost = " + CustomerDetails[validity][11]);
            System.out.println();
            check = 0;
        } else {
            System.out.println();
            System.out.println("Please enter a valid SeatNumber");
            System.out.println("If you do not have one, please book a seat from the main menu");
            System.out.println();
            check = 1;
        }
        // }while(check == 1);
    }

    int custSeatNoCheck(String seatNo) {
        for (int i = 0; i < 25; i++) {
            String seatNumber = CustomerDetails[i][10];
            if (seatNo.equals(seatNumber)) {
                return i;
            }
        }
        int j = -1;
        return j;
    }

    void EditCustomerDetails() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int check = 0;
        do {
            System.out.println("Enter your customer ID");
            String customerID = br.readLine();
            System.out.println();
            int validity = custIdValidityCheck(customerID);
            if (validity != -1) {
                System.out.println("Please re-enter the following information");
                CustomerDetailsMethod(validity);
                System.out.println();
            }
        } while (check == 1);
    }

    void SeatAvailabilityCheck() {
        System.out.println("The number of seats available are:");
        System.out.println();
        System.out.print("  No of Customers   ");
        System.out.print("  Customer Name     ");
        System.out.print("   Seat Number       ");
        System.out.println(" Availability      ");
        System.out.println(CustomerDetails[0][0]);
        for (int i = 0; i < 9; i++) {
            int s = i + 1;
            System.out.print("          " + s + "   ");
            System.out.print("       " + CustomerDetails[i][0] + "   ");
            System.out.print("      " + CustomerDetails[i][10] + "  ");
            System.out.println("      " + CustomerDetails[i][12]);
        }
        for (int k = 9; k < 25; k++) {
            int s = k + 1;
            System.out.print("         " + s + "   ");
            System.out.print("       " + CustomerDetails[k][0] + "   ");
            System.out.print("      " + CustomerDetails[k][10] + "  ");
            System.out.println("      " + CustomerDetails[k][12]);
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BusService s1 = new BusService();
        int whileLoop = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to van booking system");
        s1.TempConstructor();
        System.out.println();
        while (whileLoop == 0) {
            System.out.println("Enter your choice");
            System.out.println("A.Add Customer Details ");
            System.out.println("B.Book a seat");
            System.out.println("C.Edit seat details");
            System.out.println("D.Edit Customer Details");
            System.out.println("E.View seat Availability");
            System.out.println("F.Quit");
            String choices = br.readLine().toUpperCase();
            char choice = choices.charAt(0);

            switch (choice) {
                case 'A':
                    s1.AddCustomerDetails();
                    break;
                case 'B':
                    s1.BookASeat();
                    break;
                case 'C':
                    s1.EditSeatDetails();
                    break;
                case 'D':
                    s1.EditCustomerDetails();
                    break;
                case 'E':
                    s1.SeatAvailabilityCheck();
                    break;
                case 'F':
                    whileLoop = 1;
                    System.out.println("Thank you for using our van booking system");
                    System.out.println("Hope you visit us again");
                    break;
                default:
                    System.out.println("Please check your input");
                    System.out.println();
            }
        }
    }
}