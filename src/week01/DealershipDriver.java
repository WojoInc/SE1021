package week01;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Purpose:
 *
 * @author:wesolowskitj
 * @version: 1.1
 * Created by wesolowskitj on 2/11/2015 at 3:15 PM.
 */
public class DealershipDriver {
    public static ArrayList<Vehicle> setInitialInventory(){
        Car car1 = new Car("Chevrolet","Camaro","Yellow",1975);
        Car car2 = new Car("Lamborghini","Murcielago","Black",2011);
        Truck truck1 = new Truck("Ford","F-150","Black","Diesel",2007);
        Truck truck2 = new Truck("Chevrolet","Silverado","Blue","Gas",2005);
        ArrayList<Vehicle> inventory = new ArrayList<Vehicle>();
        inventory.add(car1);
        inventory.add(car2);
        inventory.add(truck1);
        inventory.add(truck2);
        return inventory;
    }
    public static ArrayList<Vehicle> sellInventory(ArrayList<Vehicle>inventory){
        Scanner stdIn = new Scanner(System.in);
        Iterator<Vehicle> iterator = inventory.iterator();
        System.out.println("Type the number of the vehicle sold: ");
        inventory.remove(stdIn.nextInt() - 1);

        return inventory;
    }
    public static void printInventory(ArrayList<Vehicle> inventory){
        Iterator<Vehicle> iterator = inventory.iterator();
        int cars = 0;
        int trucks = 0;
        int i = 1;
        //calculate how many of each vehicle type
        for(int j =0; j<inventory.size(); j++){
            if(inventory.get(j).getClass().equals(Car.class)){
                cars++;
            }
            if(inventory.get(j).getClass().equals(Truck.class)){
                trucks++;
            }
        }
        System.out.println();
        System.out.println("*****Current vehicle inventory*****");
        System.out.println("There are currently: " + inventory.size() + " vehicle(s) in inventory.");

        System.out.println("There are: " + cars +" car(s) and " + trucks + " truck(s).");

        while(iterator.hasNext()){
            System.out.println( i +") " + iterator.next());
            i++;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Banner welcome = new Banner(null,"This program will test the use of arraylist by creating a simple vehicle inventory.","wesolowskitj");
        JOptionPane.showMessageDialog(null,welcome);
        System.out.println();
        ArrayList<Vehicle> inventory = setInitialInventory();
        printInventory(inventory);
        inventory = sellInventory(inventory);
        printInventory(inventory);

    }
}
