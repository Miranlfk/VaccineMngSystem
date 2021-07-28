import java.io.*;
import java.util.*;

public class Task1 {

    /**
     * method used to initialise the ServiceCenter
     */
    private static void initialise(String[] hotelRef) {
        for (int x = 0; x < 6; x++){
            hotelRef[x] = "empty";

        }
    }

    /**
     * method to view all Vaccination booths
     * @param ServiceCenter
     */
    public static void viewAllVaccinationBooths(String[] ServiceCenter){
        for (int x = 0; x < 6; x++ )
        {
            System.out.println("Booth " + x + " occupied by " + ServiceCenter[x]);
        }
    }

    /**
     * method to view all empty booths
     * @param ServiceCenter
     */
    public static void viewEmptyVaccinationBooths(String[] ServiceCenter){
        int counter = 0;

        for (int x = 0; x < 6; x++ )
        {
            if (ServiceCenter[x].equals("empty")){
                System.out.println("Booth " + x + " is empty");
                counter++;
            }

        }
        if (counter == 0){
            System.out.println("All booths are occupied.");
        }

    }

    /**
     * method to add Patient to a booth based on entered value by the user, if booth value not integer the function ends
     * User is notified if patient is added successfully
     * @param customerName
     * @param ServiceCenter
     * @param boothNum
     */
    public static void addPatient(String customerName, String[] ServiceCenter, int boothNum){
        Scanner input = new Scanner(System.in);
        int counter=0;
        while (boothNum < 6) {
            try{
                System.out.println("Enter booth number (0-5) to add patient to or 6 to stop:" );
                boothNum = Integer.parseInt(input.next());

                if (boothNum == 6){
                    break;
                }
                System.out.println("Enter customer name for booth " + boothNum +" :" ) ;
                customerName = input.next();
                ServiceCenter[boothNum] = customerName;
                System.out.println("Patient succesfully added to the Booth!");
                counter++;

                if (counter==6){
                    System.out.println("All booths are occupied! Please exit this function by entering '6' and continue");
                }
            } catch (NumberFormatException e){
                System.out.println("Enter an Integer Value!");
                break;
            }
        }
        viewAllVaccinationBooths(ServiceCenter);
    }

    /**
     * method to remove Patient from a booth based on entered value by the user,  if booth value not integer the function ends
     * User is notified if patient is added successfully
     * @param ServiceCenter
     * @param boothNum
     */
    public static void removePatient(String[] ServiceCenter, int boothNum){
        Scanner input = new Scanner(System.in);
        int counter=0;
        while (boothNum < 6) {
            try{
                System.out.println("Enter booth number (0-5) to remove patient from or 6 to stop:" );
                boothNum = Integer.parseInt(input.next());
                if (boothNum == 6){
                    break;
                }
                ServiceCenter[boothNum] = "empty";
                System.out.println("Patient succesfully removed from Booth!");
                counter++;
                if (counter==6){
                    System.out.println("All booths are empty! Please exit this function by entering '6' and continue");
                }
            } catch (NumberFormatException e){
                System.out.println("Number Format Exception; Please enter an Integer Value!");
                break;
            }

        }
        viewAllVaccinationBooths(ServiceCenter);
    }


    /**
     * Sorting the patients in ascending order using bubble sort
     * Contets from main array ServiceCenter is duplicated to boothArray and the sorting algorithm is applied 
     * @param boothArray
     * @param ServiceCenter
     */
    public static void orderedPatients(String[] boothArray, String[] ServiceCenter){

        for(int i=0; i< ServiceCenter.length; i++ ){
            boothArray[i] = ServiceCenter[i];
        }

        int x = boothArray.length;
        String temp;
        boolean swap;

        for (int i=0; i < x;i++){
            swap=false;
            for (int j=i+1; j < x; j++){
                if (boothArray[j].compareToIgnoreCase(boothArray[i]) < 0){
                    temp = boothArray[i];
                    boothArray[i] = boothArray[j];
                    boothArray[j] = temp;
                    swap=true;

                }
            }
            if (!swap){
                break;
            }
        }

        for(int i=0; i< boothArray.length; i++ ){
            System.out.print(boothArray[i] + " " + '\n');
        }
        System.out.println();
    }


    /**
     * Storing booth occupancy into a file called Booth.txt - referred to w3schools.com
     * @param boothArray
     */
    public static void storeProgramData(String[] boothArray){
        try {

            FileWriter boothFile = new FileWriter("Booth.txt");


            for (int i = 0; i < 6; i++) {
                boothFile.write(boothArray[i] + "\n");
            }
            boothFile.close();
            System.out.println("Booth.txt file has been created!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reading data from file Booth.txt and displaying to the user line by line
     */
    public static void loadProgramData(){

        try {
            File myObj = new File("Booth.txt");
            Scanner fileReader = new Scanner(myObj);
            while (fileReader.hasNextLine()) {
                String vaccineData = fileReader.nextLine();
                System.out.println("Patient: " + vaccineData);
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred. File Not Found!");
            e.printStackTrace();
        }

    }

    /**
     * method to find and display current stock level - informs user if stock level is too low and redirects user to add vaccines to stock
     * @param vaccineStock
     * @param ServiceCenter
     * @param customerName
     * @param boothNum
     */
    public static void remainingVaccinations(int vaccineStock, String[] ServiceCenter, String customerName, int boothNum){

        if (vaccineStock == 20){
            System.out.println("Stock Level of Vaccinations have reached the minimum stock level, Please add to stock first before allocating vaccines to new patients! ");
            addVaccineToStock(vaccineStock, customerName, ServiceCenter, boothNum);

        } else{
            for (int i=0; i < ServiceCenter.length; i++){
                if (!(ServiceCenter[i].equals("empty"))){
                    vaccineStock--;

                }
            }
            System.out.println("Current level of stock: " + vaccineStock);
            
        }


    }

    /**
     * method to add vaccines to the stock of vaccines - if stock is at maximum, user is directed to allocate patients to the booths
     * @param vaccineStock
     * @param customerName
     * @param ServiceCenter
     * @param boothNum
     */
    public static void addVaccineToStock(int vaccineStock, String customerName, String[] ServiceCenter,int boothNum){
        Scanner input = new Scanner(System.in);
        try {
            System.out.print("Enter the number of vaccines to be added to the stock: ");
            int stock = input.nextInt();

            for (int i=0; i < ServiceCenter.length; i++){
                if (!(ServiceCenter[i].equals("empty"))){
                    vaccineStock--;

                }
            }

            if (vaccineStock + stock <= 150) {
                vaccineStock = vaccineStock + stock;
                System.out.println("Current level of stock: " + vaccineStock);

            }
            else {
                System.out.println("Stock Level of Vaccinations have reached the maximum stock level, Please allocate the vaccines to new patients before adding more! ");
                addPatient(customerName, ServiceCenter, boothNum );
            }
        } catch (NumberFormatException e){
            System.out.println("Please enter an Integer Value!");

        }

    }





    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String customerName ="";
        String userInput;
        int vaccineStock = 150;
        int boothNum =0;
        String[] ServiceCenter = new String[6];
        String[] boothArray = new String[6];
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

        do{
            System.out.print("Enter the value: ");
            userInput = input.next();
            if (userInput.equals("100") || userInput.equalsIgnoreCase("VVB")){
                viewAllVaccinationBooths(ServiceCenter);
            }
            else if(userInput.equals("101") || userInput.equalsIgnoreCase("VEB")) {
                viewEmptyVaccinationBooths(ServiceCenter);
            }
            else if (userInput.equals("102") || userInput.equalsIgnoreCase("APB")){
                addPatient(customerName, ServiceCenter, boothNum);
            }
            else if (userInput.equals("103") || userInput.equalsIgnoreCase("RPB")){
                removePatient(ServiceCenter, boothNum);

            }
            else if (userInput.equals("104") || userInput.equalsIgnoreCase("VPS")) {
                orderedPatients(boothArray,ServiceCenter);

            }
            else if (userInput.equals("105") || userInput.equalsIgnoreCase("SPD")) {
                storeProgramData(boothArray);

            }
            else if (userInput.equals("106") || userInput.equalsIgnoreCase("LPD")) {
                loadProgramData();

            }
            else if (userInput.equals("107") || userInput.equalsIgnoreCase("VRV")) {
                remainingVaccinations(vaccineStock,ServiceCenter, customerName, boothNum);

            }
            else if (userInput.equals("108") || userInput.equalsIgnoreCase("AVS")) {
                addVaccineToStock(vaccineStock, customerName, ServiceCenter, boothNum);

            }


        }while(!(userInput.equals("999")) && !(userInput.equalsIgnoreCase("EXT")));

    }

}


