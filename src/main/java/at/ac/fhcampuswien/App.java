package at.ac.fhcampuswien;


import javax.lang.model.type.NullType;
import java.sql.SQLOutput;
import java.text.DecimalFormat;
import java.util.Scanner;

public class App {

    DecimalFormat f = new DecimalFormat("#0.00");

    //todo Task 1
    public void largestNumber(){
        Scanner sc = new Scanner(System.in);
        double max = 0;
        int numbCount = 1;
        System.out.print("Number " + numbCount + ": ");
        double in;
        in = sc.nextDouble();
        if (in < 0){
            System.out.print("No number entered.");
            System.out.println();
            return;
        }
        while (in > 0){
            numbCount++;
            if(in > max){
                max = in;
            }
            System.out.print("Number " + numbCount + ": ");
            in = sc.nextDouble();
        }
        System.out.println("The largest number is " + String.format("%.2f", max));


    }

    //todo Task 2
    public void stairs(){
        Scanner sc = new Scanner(System.in);
        System.out.print("n: ");
        int read = sc.nextInt();
        int count = 1;

        if (read < 0){
            System.out.println("Invalid number!");
            return;
        }

        for(int i = 0 ; i < read; i++){
            for (int u = i; u >= 0; u--){
                System.out.print(count + " ");
                count++;
            }
            System.out.println();
        }
    }

    //todo Task 3
    public void printPyramid(){
        char c = '*';
        final int ROWS = 6;
        int empty = 5;
        int count = 1;

        for(int i = 0; i < ROWS; i++){
            for(int u = empty; u > 0; u--){
                System.out.print(" ");
            }
            for(int cnt = count; cnt > 0; cnt--){
                System.out.print(c);
            }
            System.out.println();
            count += 2;
            empty--;
        }
    }

    //todo Task 4
    public void printRhombus() {
        Scanner scHeight = new Scanner(System.in);
        int height = 0;
        int where = 0;
        int middle = 0;
        int middle2 = 0;
        int empty = 0;
        int empty2 = 1;
        char ascii;

        String asciiSymbols = " !\"#$%&\\'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~";


        System.out.print("h: ");
        height = scHeight.nextInt();
        System.out.print("c: ");
        if (height % 2 == 0) {
            System.out.println("Invalid number!");
            return;
        }

        ascii = scHeight.next().charAt(0);
        where = asciiSymbols.indexOf(ascii);
        middle = height / 2 + 1;
        middle2 = height / 2 ;
        empty = height / 2;

        for (int i = 0; i < middle; i++) {
            for (int x = empty; x > 0; x--){
                System.out.print(" ");
            }
            printAscii(where, i+1);
            empty--;
            System.out.println();
        }
        for (int y = middle; y > 1; y--){
            if(middle2>0){
                for(int z = 0; z < empty2; z++){
                    System.out.print(" ");
                }
                empty2++;
                middle2--;
            }
            printAscii(where, y-1);
            System.out.println();
        }
    }

    public static void printAscii(int symbol, int with) {
        String aSymb = " !\"#$%&\\'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~";
        StringBuilder sb = new StringBuilder();
        int pos = symbol;
        for(int i = 0; i < with; i++){
            if(i == 0){
                sb.append(aSymb.charAt(symbol));
            }
            else{
                sb.append(aSymb.charAt(pos));
                sb.insert(0, aSymb.charAt(pos));
            }
            pos--;
        }
        System.out.print(sb.toString());
    }






    //todo Task 5
    public void marks(){
        Scanner scn = new Scanner(System.in);
        int sum = 0;
        int cntMarks = 2; // just for printing out
        int validMarks = 1;
        int cntFive = 0;
        double average = 0.00;
        System.out.print("Mark 1: ");
        int mark = scn.nextInt();
        if (mark < 0 || mark > 5) {
            System.out.println("Invalid mark!");
            return;
        }
        if (mark == 5) {
            cntFive++;
        }
        sum = sum + mark;
        while (mark > 0) {
            System.out.print("Mark " + cntMarks + ": ");
            mark = scn.nextInt();
            if (mark < 0 || mark > 5) {
                System.out.println("Invalid mark!");
                cntMarks--;
            }
            if (mark == 5) {
                cntFive++;
            }
            if (mark <= 5 && mark > 0) { // checking if the marks are valid
                sum = sum + mark;
                validMarks++;
            }
            cntMarks++;
        }
        average = (double) sum / validMarks;

        System.out.println("Average: " + f.format(average));
        System.out.println("Negative marks: " + cntFive);
    }

    //todo Task 6
    public void happyNumbers(){
        boolean sad = false;
        boolean happy = false;
        int cntfour = 0;
        int cntone = 0;
        int inputNmbr = 0;
        int result = 0;
        String number = "";
        Scanner scn = new Scanner(System.in);
        System.out.print("n: ");
        inputNmbr = scn.nextInt();
        number = Integer.toString(inputNmbr);
        int[] arrNumb = splitter(number);


        while (!sad && !happy) {
            for (int i = 0; i < arrNumb.length; i++) {
                result = (int) (result + Math.pow(arrNumb[i], 2));
                if (result == 4) {
                    cntfour++;
                }
                if (result == 1) {
                    cntone++;
                }

            }
            arrNumb = splitter(Integer.toString(result));
            result = 0;
            if (cntfour > 2) {
                sad = true;
            }
            if (cntone > 10) {
                happy = true;
            }


            if (sad) {
                System.out.println("Sad number!");
                return;
            }
            if (happy) {
                System.out.println("Happy number!");
                return;
            }
        }
    }


    public static int[] splitter(String number) {
        int[] spltArr = new int[number.length()];
        for (int i = 0; i < number.length(); i++) {
            spltArr[i] = Character.getNumericValue(number.charAt(i));
        }
        return spltArr;
    }

    public static void toPrintArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        return;
    }

    public double round(double value, int decimalPoints){
        double d = Math.pow(10, decimalPoints);
        return Math.round(value * d) / d;
    }

    public static void main(String[] args){
        App exercise2 = new App();

        System.out.println("Task 1: Largest Number");
        exercise2.largestNumber();

        System.out.println("\nTask 2: Stairs");
        exercise2.stairs();

        System.out.println("\nTask 3: Pyramide");
        exercise2.printPyramid();

        System.out.println("\nTask 4: Raute");
        exercise2.printRhombus();

        System.out.println("\nTask 5: Notendurchschnitt");
        exercise2.marks();

        System.out.println("\nTask 6: Fröhliche Zahlen");
        exercise2.happyNumbers();
    }
}