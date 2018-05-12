package com.company.view;

import com.company.controller.FirstStationController;
import com.company.controller.SecondStationController;
import com.company.model.ModelManager;

import java.util.Scanner;

/**
 * Created by Libcoo on 11.05.2018.
 */
public class View2 extends View {
    private Scanner keyboard= new Scanner(System.in);
    private SecondStationController controller = new SecondStationController();

    public View2(){
        while(true){
            System.out.println("if you want to stop type in exit else press enter");
            keyboard.nextLine();
            String flag= keyboard.nextLine();
            if (flag.equals("exit"))
            {
                break;
            } else{

                disAssembleCar();
            }
        }

    }
    private void disAssembleCar(){
        System.out.println("write in the license plate of the car you want to dismantle");
        String licensePlate = keyboard.nextLine();
        controller.dismantleTheCar(licensePlate);
    }
}
