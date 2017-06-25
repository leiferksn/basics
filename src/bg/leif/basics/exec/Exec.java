package bg.leif.basics.exec;

import bg.leif.basics.queue.QueueOfStrings;
import bg.leif.basics.gcd.GCDCalc;
import bg.leif.basics.queue.QueueOfStringsARR;
import bg.leif.basics.stack.StackOfStrings;
import bg.leif.basics.stack.StackOfStringsARR;
import bg.leif.basics.stack.StackOfStringsLL;
import bg.leif.basics.queue.QueueOfStringsLL;
import bg.leif.basics.unionfind.QuickFind;
import bg.leif.basics.unionfind.QuickUnion;
import bg.leif.basics.unionfind.UnionFind;

import java.io.*;

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

    public static String readFromFile(String pathToFile) throws IOException {
        StringBuffer sb = new StringBuffer();
        BufferedReader reader = new BufferedReader(new FileReader(new File(pathToFile)));
        String line = null;
        while((line = reader.readLine()) != null) {
            sb.append(line);
            sb.append(",");
        }
        return sb.toString();
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

    public static void main(String[] args) {
        if (args.length <= 1) {
            return;
        }

        String whatToDo = (String) args[0];
        Exec exec = new Exec();

        if (whatToDo.equals("gcd")) {
            exec.calculateGreatestCommonDivisor();
        }

        if (whatToDo.equals("uf")) {
            if (args.length == 3) {
                boolean lazy = ((String) args[1]).equals("1") ? true : false;
                int numberOfElements = (int) Integer.parseInt(args[2]);
                exec.unionFind(lazy, numberOfElements);
            }
        }

        if (whatToDo.equals("stack")) {
            String typeOfStack = (String) args[1];
            StackOfStrings sos = null;
            switch (typeOfStack) {
                case "ll":
                    sos = new StackOfStringsLL();
                    break;
                case "arr":
                    sos = new StackOfStringsARR();
                    break;
                default:
                    sos = new StackOfStringsLL();
            }

            String pathToInputFile = (String) args[2];
            String[] testStrings = null;
            try {
                testStrings = readFromFile(pathToInputFile).split(",");

            } catch (IOException ioe) {
                System.out.println("Can't read from file: " + pathToInputFile);
                System.exit(0);
            }

            for (String s : testStrings) {
                if (s.contains("-")) {
                    sos.pop();
                } else {
                    sos.push(s);
                }
                System.out.println("Empty? " + sos.isEmpty() + " " + sos.toString());
            }
        }

        if (whatToDo.equals("q")) {
            String typeOfQueue = (String) args[1];
            QueueOfStrings qos = null;
            switch (typeOfQueue) {
                case "ll":
                    qos = new QueueOfStringsLL();
                    break;
                case "arr":
                    qos = new QueueOfStringsARR();
                    break;
                default:
                    qos = new QueueOfStringsLL();
                    break;
            }

            String pathToInputFile = (String) args[2];
            String[] testStrings = null;
            try {
                testStrings = readFromFile(pathToInputFile).split(",");

            } catch (IOException ioe) {
                System.out.println("Can't read from file: " + pathToInputFile);
                System.exit(0);
            }

            for (String s : testStrings) {
                if (s.equals("-")) {
                    qos.dequeue();
                } else {
                    qos.enqueue(s);
                }
                System.out.println("Empty? " + qos.isEmpty() + " " + qos.toString());
            }
        }


    }
}
