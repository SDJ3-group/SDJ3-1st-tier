package com.company.view;

import com.company.controller.FirstStationController;
import com.company.model.Part;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Libcoo on 11.05.2018.
 */
public class View1 extends View {
    private Scanner keyboard= new Scanner(System.in);
    private FirstStationController controller = new FirstStationController();
    public View1(){

        while(true){
            System.out.println("if you want to stop type in exit else press enter");
            keyboard.nextLine();
            String flag= keyboard.nextLine();
            if (flag.equals("exit"))
            {
                break;
            } else{

                registerCar();
            }
        }
    }
    private void registerCar(){
        System.out.println("write in the license plate");
        String licensePlate = keyboard.nextLine();
        System.out.println("write in the model");
        String model = keyboard.nextLine();
        System.out.println("write in the weight");
        float weight = (float) keyboard.nextInt();
        controller.registerCar(licensePlate,model,weight);
        System.out.println("car registered");
        System.out.println(controller.getAllCars());
    }
}
