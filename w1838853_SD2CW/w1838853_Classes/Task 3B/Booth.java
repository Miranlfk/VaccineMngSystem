import java.io.*;
import java.util.*;


public class Booth {
    private static int boothNum = 0;
    static int num = 0;


    public static void setBoothNum(int num){
        boothNum = num;
    }

    public static int getBoothNum(){
        return boothNum;
    }

    

    /**
     * method to view all Vaccination booths - will display the first name and last name of Patient when occupied
     * @param ServiceCenter
     */
    public static void viewAllVaccinationBooths(Patient[] ServiceCenter){
        for (int x = 0; x < 6; x++ )
        {
            System.out.println("Booth " + x + " occupied by " + (ServiceCenter[x].getFirstName() + " " + ServiceCenter[x].getLastName()));
        }
    }

    /**
     * method to view all empty booths
     * @param ServiceCenter
     */
    public static void viewEmptyVaccinationBooths(Patient[] ServiceCenter){
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
     * method to add Patient to a booth, 
     * patient is there after allocated to a booth based on vaccine preference 
     * User is notified to which booth Patient was added or if booth is occupied user is notified again
     * @param ServiceCenter
     */
    public static void addPatient(Patient[] ServiceCenter){
        Scanner input = new Scanner(System.in);
        int counter=0;
        String userVal;
        do {
            try{
                System.out.println("Enter any letter to add patient to a booth or 'ext' to stop:" );
                userVal = input.next();


                if (userVal.equalsIgnoreCase("ext")){
                    break;
                }
                System.out.println("Enter customer's First name: " ) ;
                String x = input.next();

                System.out.println("Enter customer's Last name: ") ;
                String y = input.next();

                System.out.println("Enter customer's Age: " ) ;
                int a = Integer.parseInt(input.next());

                System.out.println("Enter which City customer resides in:" ) ;
                String city = input.next();

                System.out.println("Enter customer's NIC: " ) ;
                int id = Integer.parseInt(input.next());
                
                System.out.println("Customer may choose Vaccination Type from 'AstraZeneca' or 'Sinopharm' or 'Pfizer'");
                System.out.println("Enter customer's preferred vaccine: " ) ;
                String vt = input.next();

                if (vt.equalsIgnoreCase("AstraZeneca")){
                    if (ServiceCenter[0].getFirstName().equals("empty")){
                        ServiceCenter[0].setFirstName(x);
                        ServiceCenter[0].setLastName(y);
                        ServiceCenter[0].setAge(a);
                        ServiceCenter[0].setCityName(city);
                        ServiceCenter[0].setNIC(id);
                        ServiceCenter[0].setVaccineType(vt);
                        System.out.println("Patient has been added to Booth 0");

                    }else if (ServiceCenter[1].getFirstName().equals("empty")){
                        ServiceCenter[1].setFirstName(x);
                        ServiceCenter[1].setLastName(y);
                        ServiceCenter[1].setAge(a);
                        ServiceCenter[1].setCityName(city);
                        ServiceCenter[1].setNIC(id);
                        ServiceCenter[1].setVaccineType(vt);
                        System.out.println("Patient has been added to Booth 1");

                    }else{
                        System.out.println("Booths are currently occupied, We will put Patient in Waiting"); //Mentioned that patients put in waiting as just a message to user only
                    }
                    counter++;
                }
                

                if (vt.equalsIgnoreCase("Sinopharm")){
                    if (ServiceCenter[2].getFirstName().equals("empty")){
                        ServiceCenter[2].setFirstName(x);
                        ServiceCenter[2].setLastName(y);
                        ServiceCenter[2].setAge(a);
                        ServiceCenter[2].setCityName(city);
                        ServiceCenter[2].setNIC(id);
                        ServiceCenter[2].setVaccineType(vt);
                        System.out.println("Patient has been added to Booth 2");

                    }else if (ServiceCenter[3].getFirstName().equals("empty")){
                        ServiceCenter[3].setFirstName(x);
                        ServiceCenter[3].setLastName(y);
                        ServiceCenter[3].setAge(a);
                        ServiceCenter[3].setCityName(city);
                        ServiceCenter[3].setNIC(id);
                        ServiceCenter[3].setVaccineType(vt);
                        System.out.println("Patient has been added to Booth 3");

                    }else{
                        System.out.println("Booths are currently occupied, We will put Patient in Waiting"); //Mentioned that patients put in waiting as just a message to user only
                    }
                    counter++;
                }

                if (vt.equalsIgnoreCase("Pfizer")){
                    if (ServiceCenter[4].getFirstName().equals("empty")){
                        ServiceCenter[4].setFirstName(x);
                        ServiceCenter[4].setLastName(y);
                        ServiceCenter[4].setAge(a);
                        ServiceCenter[4].setCityName(city);
                        ServiceCenter[4].setNIC(id);
                        ServiceCenter[4].setVaccineType(vt);
                        System.out.println("Patient has been added to Booth 4");

                    }else if (ServiceCenter[5].getFirstName().equals("empty")){
                        ServiceCenter[5].setFirstName(x);
                        ServiceCenter[5].setLastName(y);
                        ServiceCenter[5].setAge(a);
                        ServiceCenter[5].setCityName(city);
                        ServiceCenter[5].setNIC(id);
                        ServiceCenter[5].setVaccineType(vt);
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
            } catch (NumberFormatException e){
                System.out.println("Enter an Integer Value!");
                break;
            }
        }while (!(userVal.equals("ext")));
    
    }



    /**
     * method to remove Patient from a booth based on entered booth number by user
     * User notified if Patient was successfully removed 
     * @param ServiceCenter
     */
    public static void removePatient(Patient[] ServiceCenter){
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
                ServiceCenter[getBoothNum()].setFirstName("empty");
                ServiceCenter[getBoothNum()].setLastName("");
                ServiceCenter[getBoothNum()].setAge(0);
                ServiceCenter[getBoothNum()].setCityName("");
                ServiceCenter[getBoothNum()].setNIC(0);
                ServiceCenter[getBoothNum()].setVaccineType("");

                System.out.println("Patient was successfully removed from Booth!");

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
     * Sorting the patients in ascending order of Patient's First Name using bubble sort
     * @param boothArray
     * @param ServiceCenter
     */
    public static void orderedPatients(Patient[] boothArray, Patient[] ServiceCenter){

        for(int i=0; i< ServiceCenter.length; i++ ){
            boothArray[i] = ServiceCenter[i];
        }

        int x = boothArray.length;
        Patient temp;
        boolean swap;
        for (int i=0; i < x;i++){
            swap=false;
            for (int j=i+1; j < x; j++){
                if ((boothArray[j].getFirstName()).compareToIgnoreCase((boothArray[i].getFirstName())) < 0){
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
            System.out.print(boothArray[i].getFirstName() + " " + boothArray[i].getLastName() + '\n');
        }
        System.out.println();
    }

    /**
     * Storing booth occupancy in file called Booth.txt - referred to w3schools.com
     * User notified when file created
     * @param boothArray
     */
    public static void storeProgramData(Patient[] boothArray){
        try {

            FileWriter boothFile = new FileWriter("Booth.txt");


            for (int i = 0; i < 6; i++) {
                boothFile.write(boothArray[i].getFirstName() + " " +boothArray[i].getLastName() + ": " + boothArray[i].getAge() + ", "
                        + boothArray[i].getCityName() + ", " + boothArray[i].getNIC() + ", " + boothArray[i].getVaccineType() + '\n');
            }
            boothFile.close();
            System.out.println("Booth.txt has been created!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reading data from file Booth.txt and displaying to user - referred to w3schools.com
     */
    public static void loadProgramData(){

        try {
            File myObj = new File("Booth.txt");
            Scanner fileReader = new Scanner(myObj);
            while (fileReader.hasNextLine()) {
                String vaccineData = fileReader.nextLine();
                System.out.println("Patient: "+ vaccineData);
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred. File Not Found!");
            e.printStackTrace();
        }

    }

}
