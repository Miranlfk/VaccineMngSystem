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

    public void setCustomerName(String name){
        customerName = name;
    }

    public String getCustomerName(){
        return customerName;
    }


    /**
     * method to view all Vaccination booths
     * @param ServiceCenter
     */
    public static void viewAllVaccinationBooths(Booth[] ServiceCenter){
        for (int x = 0; x < 6; x++ )
        {
            System.out.println("booth " + x + " occupied by " + ServiceCenter[x].getCustomerName());
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
            if ((ServiceCenter[x].getCustomerName()).equals("empty")){
                System.out.println("booth " + x + " is empty");
                counter++;
            }

        }
        if (counter == 0){
            System.out.println("All booths are occupied.");
        }

    }


    /**
     * method to add Customer to a booth based on booth number entered by a user
     * User is notified when Patient is added 
     * @param ServiceCenter
     */
    public static void addPatient(Booth[] ServiceCenter){
        Scanner input = new Scanner(System.in);
        int counter=0;
        do {  
            try{
                System.out.println("Enter booth number (0-5) to add patient to or 6 to stop:" );
            boothNum = Integer.parseInt(input.next());
            setBoothNum(boothNum);
            if (getBoothNum() == 6){
                break;
            }
            System.out.println("Enter customer name for booth " + getBoothNum() +" :" ) ;
            String x = input.next();
            ServiceCenter[boothNum].setCustomerName(x);
            System.out.println("Patient was succefully added to the booth!");
            counter++;
            

            if (counter==6){
                System.out.println("All booths are occupied! Please exit this function by entering '6' and continue");
            }

            }catch(NumberFormatException e){
                System.out.println("Please enter an Integer Value!");
                break;
            }         
            
        
        }while ((getBoothNum()!=6));
    }



    /**
     * method to remove Customer from a booth based on booth number entered by a user
     * User is notified when Patient is removed
     * @param ServiceCenter
     */
    public static void removePatient(Booth[] ServiceCenter){
        Scanner input = new Scanner(System.in);
        int counter=0;
        do {
            try{
                System.out.println("Enter booth number (0-5) to remove patient from or 6 to stop:" );
                num = Integer.parseInt(input.next());
                setBoothNum(num);
                if (getBoothNum() == 6){
                    break;
                }
                ServiceCenter[getBoothNum()].setCustomerName("empty");
                System.out.println("Patient was succefully removed from booth!");
                counter++;
                if (counter==6){
                    System.out.println("All booths are empty! Please exit this function by entering '6' and continue");
                }
            } catch (NumberFormatException e){
                System.out.println("Please enter an Integer Value!");
                break;
            }

        }while (getBoothNum() != 6);
    }

    /**
     * Sorting the Patient in ascending order by name using bubble sort
     * @param boothArray
     * @param ServiceCenter
     */
    public static void orderedPatients(Booth[] boothArray, Booth[] ServiceCenter){

        for(int i=0; i< ServiceCenter.length; i++){
            boothArray[i] = ServiceCenter[i];
             
        }

        int x = boothArray.length;
        Booth temp;
        boolean swap;

        for (int i=0; i < x;i++){
            swap=false;
            for (int j=i+1; j < x; j++){
                if ((boothArray[j].getCustomerName()).compareToIgnoreCase((boothArray[i].getCustomerName())) < 0){
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
            System.out.print(boothArray[i].getCustomerName() + '\n');
        }
        System.out.println();
    }

    /**
     * Storing booth occupancy in file Booth.txt - referred to w3schools.com
     * User is notified once file is created
     * @param boothArray
     */
    public static void storeProgramData(Booth[] boothArray){
        try {

            FileWriter boothFile = new FileWriter("Booth.txt");


            for (int i = 0; i < 6; i++) {
                boothFile.write(boothArray[i].getCustomerName() + "\n");
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
