package com.company;

import com.company.model.ModelManager;
import com.company.view.View;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ModelManager.getInstance().populate();
        View view = new View();
        Scanner keyboard = new Scanner(System.in);
        view.DisplayMenu();
        view.setView(keyboard.nextInt());
        System.out.println("Ahoj adam");
    }
}
