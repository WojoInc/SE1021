package week01;

/**
 * Purpose: An extension of the Vehicle class used to represent a Car.
 *
 * @author:wesolowskitj
 * @version: 1.1
 * Created by wesolowskitj on 2/11/2015 at 3:11 PM.
 */
public class Car extends Vehicle {
    /**
     * Overrides the Vehicle toString() method to output attributes of the Car in a specific format
     * @return the formatted string representing the Car instance
     */
    @Override
    public String toString() {
        return getModelYear()+" "+getMake()+" "+getModel()+" in "+getColor();
    }

    /**
     * Constructor for Car class.
     * @param make the make of the Car
     * @param model the model of the Car
     * @param color the color of the Car
     * @param modelYear the model year of the Car
     */
    public Car(Make make, String model, String color, int modelYear) {
        super(make, model, color, modelYear);
    }
}
