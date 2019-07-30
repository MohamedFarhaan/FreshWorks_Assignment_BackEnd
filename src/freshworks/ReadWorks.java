/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package freshworks;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Mohamed Farhaan
 */
public class ReadWorks {
    Scanner scan = new Scanner(System.in);
    String FileName = new String();
    JSONObject jo = new JSONObject(); 
    
    void getFileName()
    {
        System.out.print("\nEnter the FileName : ");
        FileName = scan.nextLine();
    }
    @SuppressWarnings("unchecked")
    public void readWork() throws FileNotFoundException, IOException, ParseException, JSONException
    {
        while(true)
        {
            getFileName();
            File file1 = new File("./Data/"+FileName+".json");
            if(!file1.exists())
            {
                System.out.println("Invalid Filename, Please Try Again..!");
            }
            else
            {
                JSONParser jsonParser = new JSONParser();
            Object object = jsonParser.parse(new FileReader(file1));
            jo = (JSONObject) object;
                
                Set<String> kes = jo.keySet();
                Iterator<String> keys = kes.iterator();
                while(keys.hasNext()) 
                {
                    String key = keys.next();
                    System.out.println(key+"--"+jo.get(key));
                }
                System.out.println("\n\n");
                break;
            }
        }
    }
}
