
import java.util.Scanner;


public class main{
    public static void main(String args[]){

        
        Scanner input = new Scanner(System.in);
        int i = 2;
        int c = 1;

        int fx = 2,fy =  2;

        boolean found = false;

        int n = input.nextInt();
        System.out.print("the prime factor is : ");
        while(n>1){
            

            while (true) { 
                fx = (fx*fx+c)%n;
                fy = (fy*fy+c)%n;
                fy = (fy*fy+c)%n;


                int gcd = gcd(Math.abs(fx-fy), n);
                if(gcd !=n && gcd!= 1){
                    System.out.print(gcd + " ");
                    found = true;
                    n = n/gcd;
                    return;
                }


                if(fx==fy){
                    break;
                }

            }


            if(!found){
                c++;
                fx=2;
                fy=2;
            }

        }


    }
    public static int gcd(int a, int b) {
    
        return a == 0 ? b : gcd(b % a, a);
    }
   
}