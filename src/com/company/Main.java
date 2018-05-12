package com.company;
import com.company.view.*;
import com.company.model.*;
import com.company.controller.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ModelManager.getInstance().populate();
        View view = new View();
        Scanner keyboard = new Scanner(System.in);
        view.DisplayMenu();
        view.setView(keyboard.nextInt());
    }
}
