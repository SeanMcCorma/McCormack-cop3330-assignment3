package ex42;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Sean McCormack
 */
public class App {
    public static void main (String [] args){
        List<String> input = new ArrayList<>();
        try{
            File File_location = new File("src/main/java/ex42/exercise42_input.txt");
            Scanner scan = new Scanner(File_location);
            while (scan.hasNextLine()) {
                input.add(scan.nextLine());
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        String[] Last_name = split_String(input,0);
        String[] First_name = split_String(input, 1);
        String[] Salary = split_String(input,2);
        System.out.printf("%-10s %-10s %-10s%n-------------------------------%n","Last","First","Salary");
        for(int x=0; x < Last_name.length;x++){
            System.out.printf("%-10s %-10s %-10s%n",Last_name[x], First_name[x], Salary[x]);
        }
    }

    public static String[] split_String(List<String> names,int x){
        String[] fill=new String[names.size()];
        for(int xx = 0; xx < names.size(); xx++){
            String[] temp = names.get(xx).split(",");
            fill[xx]=temp[x];
        }
        return fill;
    }
}
