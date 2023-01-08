package org.example.iamstevol;

import java.io.*;
import java.net.*;

public class FactorialClient {

    public static void main(String[] args) {

        System.out.println("<--Client started-->");
        try {
            Socket client = new Socket("127.0.0.1", 9001);
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Type in a number to get the factorial: ");
            int number = Integer.parseInt(in.readLine());
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            out.println(number);
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            System.out.println(in.readLine());
        } catch(IOException e) {
            e.printStackTrace();
        }

    }
}
