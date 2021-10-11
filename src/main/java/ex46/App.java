package ex46;

import java.io.File;
import java.io.IOException;
import java.util.*;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Sean McCormack
 */
public class App {
    public static void main(String [] args){
        List<String> words = new ArrayList<>();
        try {
            File input = new File("src/main/java/ex46/exercise46_input.txt");
            Scanner scan = new Scanner(input);
            while(scan.hasNextLine()){
                String[] temp = scan.nextLine().split(" ");
                for (String s : temp) {
                    words.add(s);
                }
            }
            scan.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> words_list = new ArrayList<>();
        List<Integer> words_amount = new ArrayList<>();
        while(words.size() != 0){
            String temp = words.get(0);
            words_amount.add(count(words,temp));
            words_list.add(temp);
            words = remove_list(words, temp);
        }
        int max_length = max_length(words_list);
        List<String> print_ready = add_spaces(words_list, max_length);

        List<String> words_print = new ArrayList<>();
        List<Integer> words_amount_print = new ArrayList<>();
        int temp_high = words_amount.get(0);
        int temp_place = 0;
        int time = print_ready.size();
        for(int x = 0; x < time; x++){
            for(int y = 0; y < words_amount.size(); y++){
                if(temp_high < words_amount.get(y)){
                    temp_high = words_amount.get(y);
                    temp_place=y;
                }
            }
            words_print.add(print_ready.get(temp_place));
            words_amount_print.add(words_amount.get(temp_place));
            print_ready.remove(temp_place);
            words_amount.remove(temp_place);
            if(words_amount.size()<0){
                temp_high = words_amount.get(0);
                temp_place = 0;
            }
        }


        for(int y = 0; y < words_print.size();y++){
            String stars = "";
            for(int yy = 0; yy < words_amount_print.get(y);yy++){
                stars = stars +"*";
            }
            System.out.println(words_print.get(y)+"  "+stars);
        }

    }
    public static int count(List<String> words, String counter){
        int temp = 0;
        for(int x = 0; x < words.size(); x++){
            if(words.get(x).equals(counter)){
                temp++;
            }
        }
        return temp;
    }
    public static List<String> remove_list(List<String> words, String counter){
        for(int x = 0; x < words.size();x++){
            if(words.get(x).equals(counter)){
                words.remove(x);
                words = remove_list(words, counter);
            }
        }
        return words;
    }
    public static int max_length(List<String> words){
        int max = 0;
        for(int x = 0; x < words.size(); x++){
            if(max<words.get(x).length()){
                   max= words.get(x).length();
            }
        }
        return max;
    }
    public static List<String> add_spaces(List<String> words, int longest){
        List<String> please_work = new ArrayList<>();
        String temp = "";
        for(int x = 0; x < words.size(); x++){
            temp = words.get(x)+":";
            if(words.get(x).length() < longest){
                int add = longest-words.get(x).length();
                for(int xx = 0; xx < add; xx++){
                    temp = temp +" ";
                }
            }
            please_work.add(temp);
        }
        return please_work;
    }


}
