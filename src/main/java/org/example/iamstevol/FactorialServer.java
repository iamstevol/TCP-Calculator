package org.example.iamstevol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

public class FactorialServer {

    public static void main(String[] args) {
        System.out.println("<--Server started-->");
        try {
            ServerSocket ss = new ServerSocket(9001);
            Socket soc = ss.accept();
            System.out.println("***Successfully connected***");
            BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));    //BufferedReader reads incoming as Strings
            int number = Integer.parseInt(in.readLine());
            PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
            out.println("The factorial of " + number + " is: " + factorial(number));

        } catch(IOException e) {
            e.printStackTrace();
        }

    }

    public static int factorial(int number) {
        int fact = 1;
        for(int i = 1; i <= number; i++) {
            fact *= i;
        }
        return fact;
    }
}
