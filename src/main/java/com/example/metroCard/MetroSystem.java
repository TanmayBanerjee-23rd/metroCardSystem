package com.example.metroCard;

import java.io.FileInputStream;
import java.util.Scanner;

import com.example.metroCard.processor.CommandProcessor;

public class MetroSystem {
    public static void main(String[] args) {

        try {

            CommandProcessor processor = new CommandProcessor();

            FileInputStream fs = new FileInputStream(args[0]);

            Scanner scanner = new Scanner(fs);

            while (scanner.hasNextLine()) {
                String command = scanner.nextLine();

                processor.processCommand(command);
            }

            scanner.close();
        } catch (Exception e) {
            System.out.println("Processing failed due to :: " + e.getMessage());
        }
    }
}