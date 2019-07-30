/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package freshworks;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Set;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Mohamed Farhaan
 */
public class NewClass {
    public static void main(String[] args) throws IOException, FileNotFoundException, ParseException
    {
        NewClass nc = new NewClass();
        nc.TimeToLive();
    }
    void TimeToLive() throws FileNotFoundException, IOException, ParseException
    {
        while(true)
        {
            File file = new File("./ttl.txt");
            try (BufferedReader br = new BufferedReader(new FileReader(file))) 
            {
                String line;
                while ((line = br.readLine()) != null) 
                {
                   String[] words  = line.split("   ");
                   File f1 = new File("./Data/"+words[0]+".json");
                   if(f1.exists())
                   {
                       long temp =  (System.currentTimeMillis()-file.lastModified())/1000;
                       if(Long.parseLong(words[2]) < temp)
                       {
                           JSONParser jsonParser = new JSONParser();
                            Object object = jsonParser.parse(new FileReader(f1));
                            JSONObject jo = (JSONObject) object;
                
                            jo.remove(words[1]);
                            PrintWriter pw = new PrintWriter(f1);
                            pw.write(jo.toJSONString());
                            pw.flush();
                            pw.close();
                       }

                   }
                }
            }
        }
    }
}
