package org.example;

import java.math.BigInteger;

class Factorial{
    private final int n;
    Factorial(int n){
        this.n = n;
    }

    public BigInteger factorial(){
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= n ; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}

class GetFactorial{
    private int n;
    public static int maxCounterOfFactorial;
    public static BigInteger[] arrayOfFactorials  = new BigInteger[21];
    GetFactorial(int n){
        if (n > 20 || n < 0)
            throw new IllegalArgumentException();
        this.n = n;

    }

    public BigInteger factorial(){
        System.out.println("Current max factorial: " + maxCounterOfFactorial);
        System.out.println("Current cash array: ");

        for (BigInteger i : arrayOfFactorials) {
            System.out.print(i + " ");
        }
        System.out.println();

       if (n <= maxCounterOfFactorial && arrayOfFactorials[n] == null) {
           System.out.println("not from cash");
           arrayOfFactorials[n] = new Factorial(n).factorial();
           maxCounterOfFactorial = Math.max(maxCounterOfFactorial, n);
           return arrayOfFactorials[n];
       }

        if (n < maxCounterOfFactorial && arrayOfFactorials[n] != null) {
            System.out.println("not from cash");
            arrayOfFactorials[n] = new Factorial(n).factorial();
            maxCounterOfFactorial = Math.max(maxCounterOfFactorial, n);
            return arrayOfFactorials[n];
        }

        if (n == maxCounterOfFactorial && arrayOfFactorials[n] != null) {
            System.out.println("From cash");
            maxCounterOfFactorial = Math.max(maxCounterOfFactorial, n);
            return arrayOfFactorials[n];
        }

        if (n > maxCounterOfFactorial && arrayOfFactorials[maxCounterOfFactorial] != null) {
            System.out.println("From cash");
            BigInteger difference = BigInteger.ONE;
            for (int i = maxCounterOfFactorial; i <= n; i++)
                difference = difference.multiply(BigInteger.valueOf(i));

            arrayOfFactorials[n] = arrayOfFactorials[maxCounterOfFactorial]
                    .multiply(difference);
            maxCounterOfFactorial = Math.max(maxCounterOfFactorial, n);
            return arrayOfFactorials[n];
        }

        if (n > maxCounterOfFactorial && arrayOfFactorials[maxCounterOfFactorial] == null) {
            System.out.println("not from cash");
            arrayOfFactorials[n] = new Factorial(n).factorial();
            maxCounterOfFactorial = Math.max(maxCounterOfFactorial, n);
            return arrayOfFactorials[n];
        }
        return arrayOfFactorials[n];

    }

}

public class Main {
    public static void main(String args[]) {
        while (true) {
            int action = DataInput.getInt("Enter action(1 - for factorial, 2 - for cashed factorial, other - for quit: ");
            switch (action) {
                case 1:
                    {
                        int number = DataInput.getNotNegativeInt("Input number: ");
                        Factorial factorial = new Factorial(number);
                        System.out.println(number + "! = " + factorial.factorial());
                        break;
                    }
                case 2:
                    int number = DataInput.getInt("Input number or -1 to stop: ");
                    if (number == -1)
                        break;
                    GetFactorial factorial = new GetFactorial(number);
                    System.out.println("value of factorial: " + factorial.factorial());  // might be in a hash
                    System.out.println();
                    System.out.println("value of factorial: " +  factorial.factorial()); // must be in a hash
                    System.out.println();
                    break;
                default:
                    System.out.println("Invalid action");
                    throw new IllegalArgumentException("Invalid action");
            }
            // input value below 0 or above 20 to receive exception and end while true

        }
    }

}