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
     * method used to initialise the ServiceCenter array [contains booth objects - patient allocation]
     * LastNames array is initialised
     * @param ServiceCenter
     * @param LastNames
     */
    private static void initialise(Booth[] ServiceCenter, String[] LastNames) {
        for (int i = 0; i < 6; i++) {
            ServiceCenter[i].setFirstName("empty");
            LastNames[i] ="";

        }
    }


    /**
     * method to find and display current stock level 
     * informs user if stock reaches re-order level and informs user to add vaccines to stock, 
     * when stock reaches 15 user redirected to Add Vaccines to Stock function(extra)
     * @param ServiceCenter
     * @param LastNames
     * @param VaccineTypes
     */
    public static void remainingVaccinations(Booth[] ServiceCenter, String[] LastNames, String[] VaccineTypes) {

        if (getVaccineStock() == 20) {
            System.out.println("Stock Level of Vaccinations have reached the re-order level, You are advised to add to stock first before allocating vaccines to new patients! ");

        }if (getVaccineStock() == 15){
            System.out.println("Stock Level of Vaccinations have reached the minimum level, To proceed Please add to stock first before allocating vaccines to new patients! ");
            addVaccineToStock(ServiceCenter, LastNames, VaccineTypes);
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
     * method to add vaccines to the stock of vaccines - if stock is at maximum, 
     * user is informed and redirected to allocate patients to the booths
     * @param ServiceCenter
     * @param LastNames
     * @param VaccineTypes
     */
    public static void addVaccineToStock(Booth[] ServiceCenter, String[] LastNames, String[] VaccineTypes) {
        Scanner input = new Scanner(System.in);
        try {
            System.out.print("Enter the number of vaccines to be added to the stock: ");
            int stock = Integer.parseInt(input.next());

            if ((getVaccineStock() + stock) > 150) {
                System.out.println("Stock Level of Vaccinations have reached the maximum stock level, Please allocate the vaccines to new patients before adding more! ");
                Booth.addPatient(ServiceCenter, LastNames, VaccineTypes);

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

        Booth b0 = new Booth("");
        Booth b1 = new Booth("");
        Booth b2 = new Booth("");
        Booth b3 = new Booth("");
        Booth b4 = new Booth("");
        Booth b5 = new Booth("");


        String userInput;
        Booth[] ServiceCenter = {b0, b1, b2, b3, b4, b5};
        String[] LastNames = new String[6];
        String [] VaccineTypes = new String[6];
        String[] ordLastNames = new String[6];
        String [] ordVaccineTypes = new String[6];
        Booth[] boothArray = new Booth[6];
        initialise(ServiceCenter,LastNames);

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
                Booth.viewAllVaccinationBooths(ServiceCenter, LastNames);
            } else if (userInput.equals("101") || userInput.equalsIgnoreCase("VEB")) {
                Booth.viewEmptyVaccinationBooths(ServiceCenter);
            } else if (userInput.equals("102") || userInput.equalsIgnoreCase("APB")) {
                Booth.addPatient(ServiceCenter, LastNames, VaccineTypes);
            } else if (userInput.equals("103") || userInput.equalsIgnoreCase("RPB")) {
                Booth.removePatient(ServiceCenter, LastNames, VaccineTypes);

            } else if (userInput.equals("104") || userInput.equalsIgnoreCase("VPS")) {
                Booth.orderedPatients(boothArray, ServiceCenter, LastNames, VaccineTypes, ordLastNames, ordVaccineTypes);

            } else if (userInput.equals("105") || userInput.equalsIgnoreCase("SPD")) {
                Booth.storeProgramData(boothArray, ordLastNames, ordVaccineTypes);

            } else if (userInput.equals("106") || userInput.equalsIgnoreCase("LPD")) {
                Booth.loadProgramData();


            } else if (userInput.equals("107") || userInput.equalsIgnoreCase("VRV")) {
                remainingVaccinations(ServiceCenter, LastNames, VaccineTypes);

            } else if (userInput.equals("108") || userInput.equalsIgnoreCase("AVS")) {
                addVaccineToStock(ServiceCenter, LastNames, VaccineTypes);

            }

        } while (!(userInput.equals("999")) && !(userInput.equalsIgnoreCase("EXT")));

    }
}

