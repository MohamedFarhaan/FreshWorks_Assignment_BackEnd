/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import freshworks.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Mohamed Farhaan
 */

class FreshWorks
{
    public static void main(String[] args)
    {
        Thread t = new FreshWorksE();
        t.start();
        
    }
}

class FreshWorksE extends Thread {

    /**
     * @param args the command line arguments
     */
    
    @Override
    public void run()
    {
        try {
            startIt();
        } catch (JSONException ex) {
            Logger.getLogger(FreshWorksE.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FreshWorksE.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(FreshWorksE.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    static long getFolderSize(File folder) 
    {
        if(!folder.exists())
        {
            folder.mkdirs();
        }
    long length = 0;
    File[] files = folder.listFiles();
 
    int count = files.length;
 
    for (int i = 0; i < count; i++) {
        if (files[i].isFile()) {
            length += files[i].length();
        }
        else {
            length += getFolderSize(files[i]);
        }
    }
    return length;
    }
    
        void startIt() throws JSONException, FileNotFoundException, IOException, ParseException {
       String str = new String();
       Scanner scan = new Scanner(System.in);
       while(true)
       {
           System.out.println("Menu:");
           System.out.println("1  Create\n2   Read\n3   Delete\n4   Exit");
           System.out.print("Please provide your option : ");
           String option = scan.nextLine();
           if(option.equals(""+4))
               break;
           else
           {
                switch(option)
                {
                    case "1":
                    {
                        BigInteger ei = new BigInteger(""+8);
                        BigInteger f = new BigInteger(""+getFolderSize(new File("./Data/")));
                        BigInteger gbsize = new BigInteger(""+1073741824);
                        gbsize = gbsize.multiply(ei);
                        if(f.compareTo(gbsize)==-1)
                        {
                            Create c = new Create();
                            c.create();
                            break;
                        }
                        else
                        {
                            System.out.println("DataStore Size Exceeded. Please Delete Data to continue.");
                            break;
                        }
                    }
                    case "2":
                    {
                        ReadWorks rd = new ReadWorks();
                        rd.readWork();
                        break;
                    }
                    case "3":
                    {
                        DeleteWorks dw = new DeleteWorks();
                        dw.deleteWork();
                        break;
                    }
                    default:
                    {
                        System.out.println("\n\nPlease Provide a Correct Option\n");
                         System.out.println("Menu:");
                         System.out.println("1  Create\n2   Read\n3   Delete\n4   Exit");
                         System.out.println("Please provide your option : ");
                         option = scan.nextLine();
                         break;
                    }
                }
           }
       }
       scan.close();
    }
    
}
