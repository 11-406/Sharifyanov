package src;

import java.util.Random;

public class Ferma {
    public static void main(String[] args) {
        Random random = new Random();

        int p =101;
        int n = random.nextInt(1,p-1);
        System.out.println(n);
        System.out.println("----------------Sqrt test----------------");
        System.out.println(prost(p));

        System.out.println("----------------Ferma test----------------");
        for(int i = 0; i < 6; i++) {
            int h = random.nextInt(1,p-1);
            System.out.println(checkFerma(h,p) + " " + h + ":" + powerNumber(h,p-1) % p);
        }
    }

    public static boolean prost(int p) {
        if(p % 2 ==0) {
            return false;
        } else {
            for (int i = 2; i*i < p ; i++) {
                if (p % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }


    public static int powerNumber(int n , int p) {
        int res = 1;
        while (p > 0) {
            if (p % 2 != 0) {
                res *= n;
                n *= n;
                p /= 2;
            } else {
                n *= n;
                p /= 2;
            }
        }
        return res;
    }


    public static boolean checkFerma(int n, int p) {
        if(powerNumber(n,p-1) % p == 1) {
            return true;
        } else {
            return false;
        }
    }

}
