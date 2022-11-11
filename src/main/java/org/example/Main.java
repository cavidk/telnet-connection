package org.example;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8081);
        Socket input = serverSocket.accept();
        Scanner in = new Scanner(input.getInputStream());
        PrintWriter out = new PrintWriter(input.getOutputStream());
        Scanner send = new Scanner(System.in);

        while(in.hasNext()){

            System.out.println("Data is come from client");
            System.out.println(in.nextLine());

            System.out.print("Please write what you want to send to client: ");
            String s = send.nextLine();

            out.println(s);
            out.flush();
        }

        out.close();
        in.close();
        input.close();
        serverSocket.close();
    }
}