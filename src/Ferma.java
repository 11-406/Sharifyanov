import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random random = new Random();
        int p = random.nextInt(101);
        //sqrt
        double startSqrt = System.nanoTime();
        System.out.println(prost(p));
        double finishSqrt = System.nanoTime();
        System.out.println((finishSqrt - startSqrt) / 100000);
        //log(n)
        double startFerma = System.nanoTime();
        System.out.println(checkFerma(4,p));
        double finishFerma = System.nanoTime();
        System.out.println((finishFerma - startFerma) / 100000);
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

    public static long powerNumber(long n , int p) {
        long res = 1;
        while(p  > 0) {
            if(p % 2 != 0) {
                res *= n;
                n*=n;
                p /=2;
            } else {
                n*=n;
                p /=2;
            }
        }
        return res;

    }

    public static boolean checkFerma(long n, int p) {
        if(powerNumber(n,p-1) % p == 1) {
            return true;
        } else {
            return false;
        }
    }
}
