package Regex;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.*;
import java.util.regex.*;

public class Regex {

    public static void main(String args[]){

        String encodedText=new String();
        String decodedText=new String();

        //пробуем работать с файлом
        try
        {
            File file = new File("input.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext())
            {
                encodedText+=scanner.next()+" ";
            }
            scanner.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        // дешифруем текст по заданному правилу
        int r,q;
        if(encodedText.length()%3==0);
        {
            r=encodedText.length()/3-1;
            q=r;
        }
        if(encodedText.length()%3==1)
        {
            r=encodedText.length()/3;
            q=r;
        }
        if (encodedText.length()%3==2)
        {
            r=encodedText.length()/3;
            q=r;
        }

        for(int k=0; k<r; k++)
        {
            int j=k;
            decodedText+=Character.toString(encodedText.charAt(j));
            j+=r;
            decodedText+=Character.toString(encodedText.charAt(j));
            j+=q;
            decodedText+=Character.toString(encodedText.charAt(j));
        }
        //System.out.println(decodedText);

        FileWriter newfile = null;    // пробуем записать в файл
        try
        {
            newfile = new FileWriter("result.txt");
            newfile.append(decodedText);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if(newfile != null)
            {
                try
                {
                    newfile.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }


        //=================================================================================//
        //Регулярщина

        Pattern p = Pattern.compile("it");      //задаем шаблон
        Matcher m = p.matcher(encodedText);     //в этой строке ищем шаблон
        boolean ifMatch = m.find();
        System.out.println(ifMatch);

        String regex = "[A-Z]";     //задаем шаблон
        decodedText=decodedText.replaceAll(regex, "1"); //заменяем по шаблону
        System.out.println(decodedText);
    }
}