package ex41;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Sean McCormack
 */

/* Pseudocode
Take input
Read file
Put into a list, Last name then first name
Split list into two arrays of just first name and just last name
Get total number of names
Aphabetize the list of all names based of last name
if last names are equal compare first names
print out each name last name then first name in alphabetical order to file with comma in between
 */
public class App {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        try {
            File input = new File("src/main/java/ex41/exercise41_input.txt");
            Scanner scan = new Scanner(input);
            while (scan.hasNextLine()) {
                names.add(scan.nextLine());
            }
            //String[] in = scan.delimiter().split(", ");
            scan.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int name_amount = names.size();
        String[] Last_name = split_String(names, 0);
        String[] First_name = split_String(names, 1);
        List<String> alpha_names = alpha(First_name,Last_name);
        String output_file_String ="Total of "+ name_amount+" names\n-----------------";
        for(int x = 0; x<alpha_names.size();x++){
            output_file_String = output_file_String+"\n"+alpha_names.get(x);
        }
        File out = new File("src/main/java/ex41/exercise41_output.txt");
        try {
            out.createNewFile();
            FileWriter writer = new FileWriter(out);
            writer.write(output_file_String);
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static String[] split_String(List<String> names,int x){
        String[] name_return=new String[names.size()];
        for(int xx = 0; xx < names.size(); xx++){
            String[] temp = names.get(xx).split(", ");
            name_return[xx]=temp[x];
        }
        return name_return;
    }

    public static List<String> alpha(String[] First_name, String[] Last_name){
        List<String> alpha_names = new ArrayList<>();
        int size = Last_name.length;
        for(int x = 0; x < size-1;x++){
            for(int y = x+1; y<size;y++){
                if(Last_name[x].compareTo(Last_name[y])>0){
                    First_name = flip(First_name, x, y);
                    Last_name = flip(Last_name, x, y);
                }if(Last_name[x].compareTo(Last_name[y])==0){
                    if(First_name[x].compareTo(First_name[y])>0){
                        First_name=flip(First_name,x,y);
                        Last_name=flip(Last_name,x,y);
                    }
                }
            }
        }
        alpha_names = fill(First_name, Last_name);
        return alpha_names;
    }

    public static String[] flip(String[] names, int first, int second){
        String temp = names[first];
        names[first] = names[second];
        names[second] = temp;
        return names;
    }
    public static List<String> fill(String[] First_name, String[] Last_name){
        List<String> names = new ArrayList<String>();
        for(int x = 0; x < First_name.length; x++){
            String temp = Last_name[x]+", "+First_name[x];
            names.add(temp);
        }
        return names;
    }
}
