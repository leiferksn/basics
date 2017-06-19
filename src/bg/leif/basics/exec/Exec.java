package bg.leif.basics.exec;

import bg.leif.basics.unionfind.QuickFind;
import bg.leif.basics.gcd.GCDCalc;
import bg.leif.basics.unionfind.QuickUnion;
import bg.leif.basics.unionfind.UnionFind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * The class executes calculations. It works only with integers +/- 2^31
 *
 * Created by leif on 15/03/15.
 */
public class Exec {

    public void unionFind(boolean lazy, int numberOfElements) {
        UnionFind uf;
        if(lazy) {
            uf = new QuickUnion(numberOfElements);
        } else {
            uf = new QuickFind(numberOfElements);
        }
        if (!uf.connected(9,7)) {
            uf.union(9,7);
        };

        uf.outputElements();

        if (!uf.connected(8,1)) {
            uf.union(8,1);
        };

        uf.outputElements();

        if (!uf.connected(9,8)) {
            uf.union(9,1);
        };

        uf.outputElements();
    }

    public void calculateGreatestCommonDivisor() {
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

    public static void main(String[] args){
        if (args.length <= 1) {
            return;
        }

        String whatToDo = (String) args[0];
        Exec exec = new Exec();

        if(whatToDo.equals("gcd")) {
            exec.calculateGreatestCommonDivisor();
        }

        if(whatToDo.equals("uf")) {
            if (args.length == 3) {
                boolean lazy = ((String)args[1]).equals("1") ? true : false;
                int numberOfElements = (int)Integer.parseInt(args[2]);
                exec.unionFind(lazy, numberOfElements);
            }
        }

    }
}
