package ex44;

import com.google.gson.*;
import java.io.*;
import java.util.Scanner;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Sean McCormack
 */
public class App {
    public static void main(String [] args){
        JsonParser parser = new JsonParser();
        String[] name;
        String[] price;
        String[] quantity;
        try{
            JsonElement jsontree = parser.parse(new FileReader("src/main/java/ex44/exercise44_input.json"));
            JsonObject je = jsontree.getAsJsonObject();
            JsonArray ja = je.getAsJsonArray("products");
            name = new String[ja.size()];
            price = new String[ja.size()];
            quantity = new String[ja.size()];
            int counter = 0;
            for(Object o : ja){
                JsonObject product = (JsonObject) o;
                name[counter] = product.get("name").getAsString();
                price[counter] = product.get("price").getAsString();
                quantity[counter]=product.get("quantity").getAsString();
                counter++;
            }
            int x =1;

            while(x==1){
                String in = ask_user();
                int compared = compare(name, in);
                if(compared != -1){
                    x++;
                    System.out.println("Name: "+ name[compared]);

                    System.out.println("Price: "+ price[compared]);

                    System.out.println("Quantity: "+ quantity[compared]);
                }else{
                    System.out.println("Sorry, that product was not found in our inventory.");
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    public static String ask_user(){
        Scanner scan = new Scanner(System.in);
        System.out.print("What is the product name? ");
        String in = scan.nextLine();
        return in;
    }
    public static int compare(String[] names, String in){
        int temp = -1;
        for(int x =0; x <names.length; x++){
            if(names[x].equals(in)){
                temp = x;
                x= names.length;
            }
        }
        return temp;
    }
}
