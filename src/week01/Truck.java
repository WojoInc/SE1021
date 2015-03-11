package week01;

/**
 * Purpose: An extension of the Vehicle class, used to represent a Truck.
 *
 * @author:wesolowskitj
 * @version: 1.1
 * Created by wesolowskitj on 2/11/2015 at 3:33 PM.
 */
public class Truck extends Vehicle {
    private String engineType;

    /**
     * Overrides the Vehicle toString() method.
     * @return the formatted string representing the Truck instance
     */
    @Override
    public String toString() {
        return getModelYear()+" "+getMake()+" "+getModel() + " in " +getColor() + " (" +engineType+")";
    }

    /**
     * Returns the engine type.
     * @return the engine type
     */
    public String getEngineType(){
        return engineType;
    }

    /**
     * Constructor of the Truck class.
     * @param make the make of the truck
     * @param model the model of the truck
     * @param color the color of the truck
     * @param engineType the engine type of the truck
     * @param modelYear the model year of the truck
     */
    public Truck(String make, String model, String color, String engineType,int modelYear) {
        super(make, model, color, modelYear);
        this.engineType = engineType;
    }
}
