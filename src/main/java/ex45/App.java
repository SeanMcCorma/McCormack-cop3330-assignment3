package ex45;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Sean McCormack
 */
public class App {
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("What is the name of the output file? ");
        String output_name = scan.nextLine();
        scan.close();
        File input_file = new File("src/main/java/ex45/exercise45_input.txt");
        File out_file = new File("src/main/java/ex45/"+output_name+".txt");
        String original= "";
        String out_string = "";
        try{
            scan = new Scanner(input_file);
            int x =0;
            while(x==0){
                if(scan.hasNextLine()){
                    original=scan.nextLine();
                    int y=0;
                    while(y==0){
                        if(original.contains("utilize")){
                            int yy = original.indexOf("utilize");
                            original = original.substring(0,yy) +"use"+ original.substring(yy+7);
                        }else if(original.contains("Utilize")){
                            int yy = original.indexOf("Utilize");
                            original = original.substring(0,yy) +"use"+ original.substring(yy+7);
                        }else{
                            y++;
                        }
                    }
                    out_string+=original+"\n";
                }else{
                    x=1;
                }
            }
            out_file.createNewFile();
            FileWriter writer = new FileWriter(out_file);
            writer.write(out_string);
            writer.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
