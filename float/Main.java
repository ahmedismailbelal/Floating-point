
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Abdelrahman Hany
 */
public class Main {

    static HashMap<Character, Integer> map_prob = new HashMap<Character, Integer>();

    public static void getprop(String data) {

        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            Integer val = map_prob.get(c);
            if (val != null) {
                map_prob.put(c, new Integer(val + 1));
            } else {
                map_prob.put(c, 1);
            }
        }
    }

    public static double srearchlow(node[] arr, char symbol) {
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getSympol() == symbol) {
                index = i;
            }
        }
        return arr[index].getLow_Range();
    }

    public static double srearchhigh(node[] arr, char symbol) {
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getSympol() == symbol) {
                index = i;
            }
        }
        return arr[index].getHigh_Range();
    }

    public char searchrange(node[] arr, double range) {
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (range > arr[i].getLow_Range() && range < arr[i].getHigh_Range()) {
                index = i;
            }
        }
        return arr[index].getSympol();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Data");
        String data = input.next();
        Main man = new Main();

        getprop(data);

        Set<Character> keySet = map_prob.keySet();
        ArrayList<Character> chararr = new ArrayList<Character>(keySet);
        Collection<Integer> values = map_prob.values();
        ArrayList<Integer> frqarr = new ArrayList<Integer>(values);
        System.out.println("frequancy");
        System.out.println(chararr + " " + frqarr);

        int n = chararr.size();
        int datasize = data.length();
        node[] arr = new node[n];
        double f = frqarr.get(0) / (double) datasize;

        arr[0] = new node(chararr.get(0), 0, f);
        for (int i = 1; i < n; i++) {
            f = frqarr.get(i) / (double) datasize;
            double high = arr[i - 1].getHigh_Range() + f;
            arr[i] = new node(chararr.get(i), arr[i - 1].getHigh_Range(), high);
        }
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i].toString());
        }
        double out = 0;
        double low = 0;
        double range = 1;

        out = man.compress(data, arr, out, low, range);
        int choice = 0;
        System.out.println(" Enter 1 to Decompress ");
        choice = input.nextInt();
        if (choice == 1) {
            man.dcompress(out, arr, datasize, range, low);
        }

        //  System.out.println(srearchlow(arr,'C'));
        // System.out.println(srearchhigh(arr,'A'));
    }

    private double compress(String data, node arr[], double out, double low, double range) {
        char symbol;
        double lower = 0;
        double upper = 0;
        for (int i = 0; i < data.length(); i++) {
            symbol = data.charAt(i);
            lower = low + range * srearchlow(arr, symbol);
            upper = low + range * srearchhigh(arr, symbol);
            range = upper - lower;

            low = lower;
            double up = upper;
            System.out.println("Sympol " + symbol);
            System.out.println("lower " + lower);
            System.out.println("upper " + upper);
        }
        out = lower + 0.00000001;
        System.out.println("output " + out);
        return out;

    }

    private void dcompress(double code, node[] arr, int n, double range, double low) {
        double lower = 0;
        double upper = 0;
        char symbol;
        for (int i = 0; i < n; i++) {
            double codee = (code - low) / range;
            symbol = searchrange(arr, codee);
            System.out.print(symbol);
            lower = low + range * srearchlow(arr, symbol);
            upper = low + range * srearchhigh(arr, symbol);
            range = upper - lower;
            low = lower;
            double up = upper;
        }
    }
}
