package Perpustakaan.util;

import java.util.Random;
import java.util.Scanner;

public class Util {

    public static boolean getYesOrNo(String message){
        Scanner input = new Scanner(System.in);
        String pilihan;
        boolean isLanjutkan = false;

        System.out.print(message);
        pilihan = input.next();
        if (pilihan.equalsIgnoreCase("y")){
            isLanjutkan = true;
        } else if (pilihan.equalsIgnoreCase("n")){
            isLanjutkan = false;
        }

        return isLanjutkan;
    }

    public static int getRandomInt(){
        Random rand = new Random();
        int upperBound = 100;
        int randInt = rand.nextInt(upperBound);
        return randInt;
    }

}
