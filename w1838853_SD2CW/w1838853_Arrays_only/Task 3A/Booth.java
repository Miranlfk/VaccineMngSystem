import java.io.*;
import java.util.*;


public class Booth {
    private String customerName;

    private static int boothNum = 0;
    static int num = 0;


    Booth(String x){

        customerName = x;

    }

    public static void setBoothNum(int num){
        boothNum =num;
    }

    public static int getBoothNum(){
        return boothNum;
    }

    public void setFirstName(String name){
        customerName = name;
    }

    public String getFirstName(){
        return customerName;
    }


    /**
     * method to view all Vaccination booths 
     * @param ServiceCenter
     * @param LastNames
     */
    public static void viewAllVaccinationBooths(Booth[] ServiceCenter, String[] LastNames){
        for (int x = 0; x < 6; x++ )
        {
            System.out.println("Booth " + x + " occupied by " + ServiceCenter[x].getFirstName() + " " + LastNames[x]);
        }
    }

    /**
     * method to view all empty booths
     * @param ServiceCenter
     */
    public static void viewEmptyVaccinationBooths(Booth[] ServiceCenter){
        int counter = 0;

        for (int x = 0; x < 6; x++ )
        {
            if ((ServiceCenter[x].getFirstName()).equals("empty")){
                System.out.println("Booth " + x + " is empty");
                counter++;
            }

        }
        if (counter == 0){
            System.out.println("All booths are occupied.");
        }

    }


    /**
     * method to add Patient to a booth based on Vaccine preference entered by the user
     * User is notified to which Booth Patient was added to
     * @param ServiceCenter
     * @param LastNames
     * @param VaccineTypes
     */
    public static void addPatient(Booth[] ServiceCenter, String[] LastNames, String[] VaccineTypes){
        Scanner input = new Scanner(System.in);
        int counter=0;
        String userVal;
        do {
            
            System.out.println("Enter any letter to add patient to a booth or 'ext' to stop:" );
            userVal = input.next();


            if (userVal.equalsIgnoreCase("ext")){
                break;
            }
            System.out.println("Enter customer's First name: " ) ;
            String x = input.next();

            System.out.println("Enter customer's Last name: ") ;
            String y = input.next();

            System.out.println("Customer may choose Vaccination Type from 'AstraZeneca' or 'Sinopharm' or 'Pfizer'");
            System.out.println("Enter customer's preferred vaccine: " ) ;
            String vt = input.next();

            if (vt.equalsIgnoreCase("AstraZeneca")){
                if (ServiceCenter[0].getFirstName().equals("empty")){
                    ServiceCenter[0].setFirstName(x);
                    LastNames[0] = y;
                    VaccineTypes[0]= vt;
                    System.out.println("Patient has been added to Booth 0");

                }else if (ServiceCenter[1].getFirstName().equals("empty")){
                    ServiceCenter[1].setFirstName(x);
                    LastNames[1] = y;
                    VaccineTypes[1]= vt;
                    System.out.println("Patient has been added to Booth 1");

                }else{
                    System.out.println("Booths are currently occupied, We will put Patient in Waiting"); //Mentioned that patients put in waiting as just a message to user only
                }
                counter++;
            }

            if (vt.equalsIgnoreCase("Sinopharm")){
                if (ServiceCenter[2].getFirstName().equals("empty")){
                    ServiceCenter[2].setFirstName(x);
                    LastNames[2] = y;
                    VaccineTypes[2]= vt;
                    System.out.println("Patient has been added to Booth 2");

                }else if (ServiceCenter[3].getFirstName().equals("empty")){
                    ServiceCenter[3].setFirstName(x);
                    LastNames[3] = y;
                    VaccineTypes[3]= vt;
                    System.out.println("Patient has been added to Booth 3");

                }else{
                    System.out.println("Booths are currently occupied, We will put Patient in Waiting"); //Mentioned that patients put in waiting as just a message to user only
                }
                counter++;
            }

            if (vt.equalsIgnoreCase("Pfizer")){
                if (ServiceCenter[4].getFirstName().equals("empty")){
                    ServiceCenter[4].setFirstName(x);
                    LastNames[4] = y;
                    VaccineTypes[4]= vt;
                    System.out.println("Patient has been added to Booth 4");

                }else if (ServiceCenter[5].getFirstName().equals("empty")){
                    ServiceCenter[5].setFirstName(x);
                    LastNames[5] = y;
                    VaccineTypes[5]= vt;
                    System.out.println("Patient has been added to Booth 5");

                }else{
                    System.out.println("Booths are currently occupied, We will put Patient in Waiting"); //Mentioned that patients put in waiting as just a message to user only
                }
                counter++;
            }

            if (!(vt.equalsIgnoreCase("Pfizer") || vt.equalsIgnoreCase("Sinopharm") || vt.equalsIgnoreCase("AstraZeneca"))){
                System.out.println("Enter a Valid Vaccination Type from 'AstraZeneca' or 'Sinopharm' or 'Pfizer'");
            }


            if (counter==6){
                System.out.println("All booths are occupied! Please exit this function by entering 'ext' and continue");
            }
        
        }while (!(userVal.equals("ext")));
    }



    /**
     * method to remove Patient from a booth based on booth number entered by the user
     * User is notified if Patient was removed succefully
     * @param ServiceCenter
     * @param LastNames
     * @param VaccineTypes
     */
    public static void removePatient(Booth[] ServiceCenter, String[] LastNames, String[] VaccineTypes){
        Scanner input = new Scanner(System.in);
        int counter=0;
        while (getBoothNum() < 6) {
            try{
                System.out.println("Enter booth number (0-5) to remove patient from or 6 to stop:" );
                num = Integer.parseInt(input.next());
                setBoothNum(num);
                if (getBoothNum() == 6){
                    break;
                }
                ServiceCenter[getBoothNum()].setFirstName("e");
                LastNames[getBoothNum()] =" ";
                VaccineTypes[getBoothNum()] = " ";
                System.out.println("Patient was succefully removed from Booth!");
                counter++;
                if (counter==6){
                    System.out.println("All booths are empty! Please exit this function by entering '6' and continue");
                }
            } catch (NumberFormatException e){
                System.out.println("Please enter an Integer Value!");
                break;
            }

        }
    }

    /**
     * Sorting the Patients in ascending order by first name using bubble sort
     * @param boothArray
     * @param ServiceCenter
     * @param LastNames
     * @param VaccineTypes
     * @param ordLastNames
     * @param ordVaccineTypes
     */
    public static void orderedPatients(Booth[] boothArray, Booth[] ServiceCenter, String[] LastNames, String[] VaccineTypes, String[] ordLastNames, String [] ordVaccineTypes){

        for(int i=0; i< ServiceCenter.length; i++){
            boothArray[i] = ServiceCenter[i];
             ordLastNames[i] = LastNames[i];
             ordVaccineTypes[i] = VaccineTypes[i];
        }

        int x = boothArray.length;
        Booth temp;
        String templname;
        String tempvt;
        boolean swap;

        for (int i=0; i < x;i++){
            swap=false;
            for (int j=i+1; j < x; j++){
                if ((boothArray[j].getFirstName()).compareToIgnoreCase((boothArray[i].getFirstName())) < 0){
                    temp = boothArray[i];
                    templname = ordLastNames[i];
                    tempvt = ordVaccineTypes[i];
                    boothArray[i] = boothArray[j];
                    ordLastNames[i] = ordLastNames[j];
                    ordVaccineTypes[i] = ordVaccineTypes[j];
                    boothArray[j] = temp;
                    ordLastNames[j] = templname;
                    ordVaccineTypes[j] = tempvt;
                    swap=true;

                }
            }
            if (!swap){
                break;
            }
        }

        for(int i=0; i< boothArray.length; i++ ){
            System.out.print(boothArray[i].getFirstName() + " " + ordLastNames[i] + ": " + ordVaccineTypes[i] + '\n');
        }
        System.out.println();
    }

    /**
     * Storing booth occupancy along with last names and vaccination types in file called Booth.txt - referred to w3schools.com
     * User is notified when file created 
     * @param boothArray
     * @param ordLastNames
     * @param ordVaccineTypes
     */
    public static void storeProgramData(Booth[] boothArray, String[] ordLastNames, String [] ordVaccineTypes){
        try {

            FileWriter boothFile = new FileWriter("Booth.txt");


            for (int i = 0; i < 6; i++) {
                boothFile.write(boothArray[i].getFirstName() + " " + ordLastNames[i] + ": " + ordVaccineTypes[i] + "\n");
            }
            boothFile.close();
            System.out.println("Booth.txt file has been created!");
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    /**
     * Reading data from saved file Booth.txt and displaying to user - referred to w3schools.com
     */
    public static void loadProgramData(){

        try {
            File myObj = new File("Booth.txt");
            Scanner fileReader = new Scanner(myObj);
            while (fileReader.hasNextLine()) {
                String vaccineData = fileReader.nextLine();
                System.out.println("Booth occupied by " + vaccineData);
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred. File Not Found!");
            e.printStackTrace();
        }

    }

}
