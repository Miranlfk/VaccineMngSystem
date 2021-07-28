import java.util.*;


public class VaccinationCenter {

    private static int vaccineStock = 150;

    public static void setVaccineStock(int stock){
        vaccineStock = stock;

    }

    public static int getVaccineStock() {
        return vaccineStock;
    }


    /**
     * method used to initialise the ServiceCenter array [contains patient objects - patient allocation]
     * @param ServiceCenter
     */
    private static void initialise(Patient[] ServiceCenter) {
        for (int i = 0; i < 6; i++) {
            ServiceCenter[i].setFirstName("empty");
            ServiceCenter[i].setLastName("");

        }
    }


    /**
     * method to find and display current stock level
     * informs user if stock reaches re-order level and informs user to add vaccines to stock
     * when stock reaches 15 user redirected to Add Vaccines to Stock function
     * @param ServiceCenter
     */
    public static void remainingVaccinations(Patient[] ServiceCenter, LinkedList<Patient> waitingList) {

        if (getVaccineStock() == 20) {
            System.out.println("Stock Level of Vaccinations have reached the re-order level, You are advised to add to stock first before allocating vaccines to new patients! ");

        }if (getVaccineStock() == 15){
            System.out.println("Stock Level of Vaccinations have reached the minimum level, To proceed Please add to stock first before allocating vaccines to new patients! ");
            addVaccineToStock(ServiceCenter, waitingList);
        }
        else {
            for (int i = 0; i < ServiceCenter.length; i++) {
                if (!((ServiceCenter[i].getFirstName()).equals("empty"))) {
                    vaccineStock--;

                }
            }
            System.out.println("Current level of stock: " + getVaccineStock());
        }


    }

    /**
     * method to add vaccines to the stock of vaccines
     * if stock is at maximum, user is informed and redirected to allocate patients to the booths
     * @param ServiceCenter
     */
    public static void addVaccineToStock(Patient[] ServiceCenter, LinkedList<Patient> waitingList) {
        Scanner input = new Scanner(System.in);
        try {
            System.out.print("Enter the number of vaccines to be added to the stock: ");
            int stock = Integer.parseInt(input.next());

            if ((getVaccineStock() + stock) > 150) {
                System.out.println("Stock Level of Vaccinations have reached the maximum stock level, Please allocate the vaccines to new patients before adding more! ");
                Booth.addPatient(ServiceCenter, waitingList);

            } else {
                setVaccineStock(vaccineStock + stock);
                System.out.println("Current level of stock: " + getVaccineStock());
            }

        } catch (NumberFormatException e) {
            System.out.println("Please enter an Integer Value!");

        }

    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Patient p0 = new Patient("", "",0,"",0,"");
        Patient p1 = new Patient("", "",0,"",0, "");
        Patient p2 = new Patient("", "",0,"",0, "");
        Patient p3 = new Patient("", "",0,"",0, "");
        Patient p4 = new Patient("", "",0,"",0, "");
        Patient p5 = new Patient("", "",0,"",0, "");


        String userInput;
        Patient[] ServiceCenter = {p0, p1, p2, p3, p4, p5};
        Patient[] boothArray = new Patient[6];
        LinkedList<Patient> waitingList = new LinkedList<>();
        initialise(ServiceCenter);

        System.out.println('\n' + "Welcome to the COVID-19 VACCINATION CENTER PROGRAM!!" + '\n');

        System.out.println("Enter '100' or 'VVB' to view all Vaccination Booths");
        System.out.println("Enter '101' or 'VEB' to view all Empty Booths");
        System.out.println("Enter '102' or 'APB' to add Patient to a Booth");
        System.out.println("Enter '103' or 'RPB' to remove Patient from a Booth");
        System.out.println("Enter '104' or 'VPS' to view Patients sorted in alphabetical order");
        System.out.println("Enter '105' or 'SPD' to store program data into a file");
        System.out.println("Enter '106' or 'LPD' to load program data from a file");
        System.out.println("Enter '107' or 'VRV' to view remaining Vaccinations");
        System.out.println("Enter '108' or 'AVS' to add Vaccination to the Stock");
        System.out.println("Enter '999' or 'EXT' to exit the program");

        do {
            System.out.print("Enter the value: ");
            userInput = input.next();
            if (userInput.equals("100") || userInput.equalsIgnoreCase("VVB")) {
                Booth.viewAllVaccinationBooths(ServiceCenter);
            } else if (userInput.equals("101") || userInput.equalsIgnoreCase("VEB")) {
                Booth.viewEmptyVaccinationBooths(ServiceCenter);
            } else if (userInput.equals("102") || userInput.equalsIgnoreCase("APB")) {
                Booth.addPatient(ServiceCenter, waitingList);
            } else if (userInput.equals("103") || userInput.equalsIgnoreCase("RPB")) {
                Booth.removePatient(ServiceCenter, waitingList);

            } else if (userInput.equals("104") || userInput.equalsIgnoreCase("VPS")) {
                Booth.orderedPatients(boothArray, ServiceCenter);

            } else if (userInput.equals("105") || userInput.equalsIgnoreCase("SPD")) {
                Booth.storeProgramData(boothArray);

            } else if (userInput.equals("106") || userInput.equalsIgnoreCase("LPD")) {
                Booth.loadProgramData();

            } else if (userInput.equals("107") || userInput.equalsIgnoreCase("VRV")) {
                remainingVaccinations(ServiceCenter, waitingList);

            } else if (userInput.equals("108") || userInput.equalsIgnoreCase("AVS")) {
                addVaccineToStock(ServiceCenter, waitingList);

            }

        } while (!(userInput.equals("999")) && !(userInput.equalsIgnoreCase("EXT")));

    }
}


