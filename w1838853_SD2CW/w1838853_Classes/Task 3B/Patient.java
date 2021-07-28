public class Patient extends Booth {

    private String firstName;
    private String lastName;
    private int age;
    private String cityName;
    private int nic;
    private String vaccineType;


    Patient(String x, String y, int a, String city, int id, String vt) {
        firstName = x;
        lastName = y;
        age = a;
        cityName = city;
        nic = id;
        vaccineType = vt;
    }

    /**
     * Setter method to set first name of Patient using String parameter 
     * @param name
     */

    public void setFirstName(String name){
        firstName= name;
    }

    /**
     * Getter method to get first name of Patient
     * @return 
     */
    public String getFirstName(){
        return firstName;
    }

    /**
     * Setter method to set first name of Patient using String parameter
     * @param name
     */
    public void setLastName(String name) {
        lastName = name;

    }

    /**
     * Getter method to get last name of Patient
     * @return
     */
    public String getLastName(){
        return lastName;
    }


    /**
     * Setter method to set age of Patient using Integer parameter
     * @param a
     */
    public void setAge(int a){
        age = a;
    }

    /**
     * Getter method to get age of Patient
     * @return
     */
    public int getAge(){
        return age;
    }

    /**
     * Setter method to set city of Patient using String parameter
     * @param city
     */
    public void setCityName(String city) {
        cityName = city;

    }

    /**
     * Getter method to get city of Patient
     * @return
     */
    public String getCityName(){
        return cityName;
    }

    /**
     * Setter method to set NIC of Patient using Integer parameter
     * @param id
     */
    public void setNIC(int id){
        nic = id;
    }

    /**
     * Getter method to get NIC of Patient
     * @return
     */
    public int getNIC(){
        return nic;
    }

    /**
     * Setter method to set vaccine type of Patient using String parameter
     * @param vt
     */
    public void setVaccineType(String vt) {
        vaccineType = vt;

    }

    /**
     * Getter method to get vaccine type of Patient
     * @return
     */
    public String getVaccineType(){
        return vaccineType;
    }


}
