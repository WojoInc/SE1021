package week01;

/**
 * Purpose: A basic vehicle class that contains the simple methods and attributes relating to a vehicle, and
 * can be extended for use with specific vehicle type classes.
 *
 * @author:wesolowskitj
 * @version: 1.1
 * Created by wesolowskitj on 2/11/2015 at 3:04 PM.
 */
public class Vehicle {
    private Make make;
    private String model;
    private int modelYear;
    private String color;
    private String licenseNumber;

    /**
     * returns the make of the vehicle
     * @return the make of the vehicle
     */
    public String getMake() {
        return make.toString();
    }

    /**
     * returns the model of the vehicle
     * @return the model of the vehicle
     */
    public String getModel() {
        return model;
    }

    /**
     * returns the model year of the vehicle
     * @return the model year
     */
    public int getModelYear() {
        return modelYear;
    }

    /**
     * returns the color of the vehicle
     * @return the color of the vehicle
     */
    public String getColor() {
        return color;
    }

    /**
     * returns the license number of the vehicle
     * @return the license number of the vehicle
     */
    public String getLicenseNumber() {
        return licenseNumber;
    }

    /**
     * sets the vehicle make
     * @param make the vehicle make to set
     */
    public void setMake(Make make) {
        this.make = make;
    }

    /**
     * sets the vehicle model
     * @param model the vehicle model to set
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * sets the vehicle model year
     * @param modelYear the model year to be set
     */
    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    /**
     * sets the vehicle color
     * @param color the color to be set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Returns the License number of the vehicle as a string.
     * @param licenseNumber the license number returned as a string
     */
    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    /**
     * This method overrides the default toString method and provides a convienient means of printing the object to the
     * console
     * @return A string representing the Vehicle
     */
    @Override
    public String toString(){
        return modelYear + " " + make + " " + model;
    }

    /**
     * default constructor for the Vehicle class. Initializes all values to defaults.
     */
    public Vehicle(){
        new Vehicle(null,"","",0);
    }

    /**
     * constructor for Vehicle class
     * @param make the 'make' of the vehicle
     * @param model the model of the vehicle
     * @param color the color of the vehicle
     * @param modelYear the model year of the vehicle
     */
    public Vehicle(Make make, String model, String color, int modelYear) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.modelYear = modelYear;
    }
}
