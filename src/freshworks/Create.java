/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package freshworks;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Set;
import java.lang.*;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Mohamed Farhaan
 */
public class Create {
    Scanner scan = new Scanner(System.in);
    String FileName = new String();
    String key = new String();
    String value = new String();
    JSONObject jo = new JSONObject();
    File file1;
    void menu_FileName()
    {
        System.out.print("Enter Object Name : ");
        FileName = scan.nextLine();
    }
    void getKey(JSONObject ja) throws FileNotFoundException, IOException, ParseException
    {
        System.out.print("Enter the Key : ");
        key = scan.nextLine();
        if(key.length()>=32)
            key = key.substring(0, 31);
        //ReadWorks rd = new ReadWorks();
        try
        {
            if(ja.has(key))
            {
                System.out.println("\nKey already Exists. Try Again");
                getKey(ja);
            }
        }
        catch(Exception e)
        {
            System.out.println();
        }
    }
    void getValue() throws JSONException, IOException
    {
        System.out.print("\nEnter the value for corresponding Key: ");
        value = scan.nextLine();
        System.out.println("\n1   Set Time-to-live\nAny other Key to Continue\nEnter choice :");
        String opt = scan.nextLine();
        if(opt.equals(""+1))
        {
            FileWriter ttl = new FileWriter("./ttl.txt",true);
            System.out.println("Enter Number of Seconds to Live : ");
            String tolive = scan.nextLine();
            String qry = new String(FileName+"   "+key+"   "+tolive+"\n");
            ttl.write(qry);
            ttl.close();
        }
            jo.put(key,value);
    }
    void menu_KeyEntry()
    {
        System.out.print("\n1   Enter Another Key-Value\n2   Exit");
    }
    public void create() throws JSONException, FileNotFoundException, IOException, ParseException
    {
        file1 = new File("./Data/");
        file1.mkdirs();
        while(true)
        {
            menu_FileName();
            file1 = new File("./Data/"+FileName+".json");
            
            if(file1.exists())
                System.out.println("\nA File with Similar name already exists..!\n");
            else
            {
                break;
            }
        }
        while(true)
        {
            ByteArrayOutputStream ostream = new ByteArrayOutputStream ();
            ObjectOutputStream obStream = new ObjectOutputStream(ostream);
            obStream.writeObject(jo.toString());
            byte[] rawObject = ostream.toByteArray();
            ostream.close();
            int size = rawObject.length;
            if(size<128000)
            {
                getKey(jo);
                if(jo.optBoolean(key))
                {
                    System.out.println("\nThe Key Already Exists..! Try Again\n");
                }
                else
                {
                    getValue();
                    System.out.print("\nPress 1 to exit\nAny Other key to continue adding data : ");
                    String option = scan.nextLine();
                    if(option.equals(""+1))
                    {

                        break;
                    }
                }
            }
            else
            {
                System.out.println("Object Limit Exceeded.!");
                break;
            }
        }
        
        file1.createNewFile();
        PrintWriter pw = new PrintWriter(file1);
        pw.write(jo.toString());
        pw.flush(); 
        pw.close(); 
    }
    
}
