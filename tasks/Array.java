package src.tasks;


public class Array {
    public static void main(String[] args) {

    }

    public static void getNum1() {
        int n = 10;
        int[] a = {1,2,4,5,6,7,8,9,10};
        boolean[] b = new boolean[n];

        for(int i = 0; i < a.length-1; i++) {
            b[a[i]] = true;
        }
        int c = 0;
        for(int k = 0; k < b.length; k++) {
            if(b[k] == false) {
                c = k;
            }
        }
        System.out.println(c);
    }

    public static void getDa2() {
        int sum = 0;
        int[] a = new int[99];
        int[] fullA = new int[100];
        for(int i = 0; i < a.length; i++) {
            sum +=a[i];
        }
        int n = a.length + 1;
        int sumA =n*(n+1)/100;

        System.out.println(sumA - sum);
    }

    public static void DoubleMin() {
        int[] a = {7,4,8,5};
        int min = a[0];
        int min2 = a[0];
        for(int i = 0; i < a.length; i++) {
            if(a[i] < min) {
                min2 = min;
                min = a[i];
            }
            if(a[i] < min2 || a[i] > min) {
                min2 = a[i];
            }
        }
        System.out.println(min);
        System.out.println(min2);
    }


}
