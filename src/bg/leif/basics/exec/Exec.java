package bg.leif.basics.exec;

import bg.leif.basics.GCDCalc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * The class executes calculations. It works only with integers +/- 2^31
 *
 * Created by leif on 15/03/15.
 */
public class Exec {

    public static void main(String[] args){

        int m, n;
        String line;
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));

        try{
            while(( line = buf.readLine()) != null){
                String[] params = line.split(",");
                if((params == null || params.length < 2 ) || params[0] == null || params[1] == null ){
                    System.err.println("No valid integers!");
                    return;
                }
                m = Integer.parseInt(params[0]);
                n = Integer.parseInt(params[1]);
                GCDCalc gcdCalc = new GCDCalc(m,n);

                StringBuffer messageBuf = new StringBuffer("Greatest common divisor of the integers ");
                messageBuf.append(m);
                messageBuf.append(" and ");
                messageBuf.append(n);
                messageBuf.append(" is ");
                messageBuf.append(gcdCalc.caclulateGCD());
                messageBuf.append(".");
                System.out.println(messageBuf.toString());
            }
        } catch (IOException ioe){
            System.err.println("Error reading user input.");
        } catch (NumberFormatException nfe){
            System.err.println("Invalid parameters format.");
            nfe.printStackTrace();
        }

        // note that args is not null here. method parameters are initialized.
        // needed if we pass the parameters through args
        /*
        if(args.length == 0 || args[0] == null || args[1] == null){
            System.err.println("No valid integers!");
            return;
        }
        */
        // GCDCalc gcdCalc = new GCDCalc(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
    }
}