/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package freshworks;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.lang.instrument.Instrumentation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Calendar;
import java.util.Date;
import net.sourceforge.sizeof.SizeOf;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Mohamed Farhaan
 */
public class Try {
    public static void main(String[] args) throws ParseException, IOException, JSONException
    {
        int size;
        JSONObject jo;
        while(true)
        {
            File file = new File("./Data/Later.json");
            System.out.println((System.currentTimeMillis()-file.lastModified())/1000);
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
            //System.out.println( sdf.format(file.lastModified()));
            Calendar cal = Calendar.getInstance();
            Date date=cal.getTime();
           // System.out.println(cal.getTime());
            //Date current = sdf.parse(str));
            Date objectTime = sdf.parse(sdf.format(date));
           //  System.out.println(Instrumentation.class.);
           // long diffSeconds = (current.getTime() - objectTime.getTime()) / 1000 % 60;
           break;
        }
        //1564478"000"
    
           
    }
}
