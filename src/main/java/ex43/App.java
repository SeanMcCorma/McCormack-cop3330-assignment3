package ex43;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Sean McCormack
 */
public class App {
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Site name: ");
        String name = scan.nextLine();
        System.out.print("Author: ");
        String author = scan.nextLine();
        System.out.print("Do you want a folder for JavaScript? ");
        char JavaScript = scan.next().charAt(0);
        System.out.print("Do you want a folder for CSS? ");
        char CSS = scan.next().charAt(0);
        scan.close();
        String html_path = "src/main/java/ex43/website/"+name;
        System.out.println(createDirectory(html_path,name));
        System.out.println(index(html_path,name,author));
        if(JavaScript == 'y' || JavaScript =='Y'){
            System.out.println(Java(name,html_path));
        }
        if(CSS == 'y' || CSS == 'Y'){
            System.out.println(CSS(name,html_path));
        }

    }

    public static String createDirectory(String html_path,String name){
        String pathing = "";
        try{
            Files.createDirectories(Paths.get(html_path));
            pathing = "Created ./website/"+name;
        } catch (IOException e){
            e.printStackTrace();
        }
        return pathing;
    }

    public static String index(String html_path,String name, String author){
        String index = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "\t<head>\n" +
                "\t\t<meta "+author+">" +
                "\t\t<meta charset=\"utf-8\">\n" +
                "\t\t<title>"+name+"</title>\n" +
                "\t\t<script\n" +
                "\t\t\tid=\"sap-ui-bootstrap\"\n" +
                "\t\t\tsrc=\"/resources/sap-ui-core.js\"\n" +
                "\t\t\tdata-sap-ui-theme=\"sap_bluecrystal\"\n" +
                "\t\t\tdata-sap-ui-modules=\"sap.m.library\"\n" +
                "\t\t\tdata-sap-ui-compatVersion=\"edge\"\n" +
                "\t\t\tdata-sap-ui-preload=\"async\" >\n" +
                "\t\t</script>\n" +
                "\t\t<script>\n" +
                "\t\t\tsap.ui.getCore().attachInit(function () {\n" +
                "\t\t\t\tnew sap.m.Text({\n" +
                "\t\t\t\t\ttext : \"OpenUI5 is loaded successfully!\"\n" +
                "\t\t\t\t}).placeAt(\"content\");\n" +
                "\t\t\t});\n" +
                "\t\t</script>\n" +
                "\t</head>\n" +
                "\t<body class=\"sapUiBody\" id=\"content\">\n" +
                "\t</body>\n" +
                "</html>";
        String output_path =html_path+"/index.html";
        File out = new File(output_path);
        output_path="./website/"+name+"/index.html";
        try{
            out.createNewFile();
            FileWriter writer = new FileWriter(out);
            writer.write(index);
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return "Created " + output_path;
    }

    public static String Java(String name,String html_path){
        String pathing = "";
        html_path = html_path+"/js";
        try{
            Files.createDirectories(Paths.get(html_path));
            pathing = "Created ./website/"+name+"/js/";
        } catch (IOException e){
            e.printStackTrace();
        }
        return pathing;

    }

    public static String CSS(String name, String html_path){
        String pathing = "";
        html_path = html_path+"/css";
        try{
            Files.createDirectories(Paths.get(html_path));
            pathing = "Created ./website/"+name+"/css/";
        } catch (IOException e){
            e.printStackTrace();
        }
        return pathing;

    }
}
