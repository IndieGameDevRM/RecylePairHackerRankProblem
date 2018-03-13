import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    public static int checkingRecylePair(int number){
        int num=number,digit=0,last,storedvalue,firstdigit,seconddigit;
        while(num>0){
            num=num/10;
            digit++;
        }
        try{
        if(number<10){
                return number;
        }
        int first=(int)Math.pow(10,digit-1);
        int second=(int)Math.pow(10,digit-2);
        firstdigit=number/first;
        seconddigit=number/second-firstdigit*10;
        if(firstdigit>seconddigit){
            return number;
        }
        while(firstdigit<seconddigit){
             storedvalue=number;
            if(firstdigit>seconddigit){
                number=storedvalue;
            }
           
            num=number/10;
            last=(number-num*10);
            number=num;
            number=last*first+number;
            firstdigit=number/first;
            seconddigit=number/second-firstdigit*10;
            
        }
        }catch(ArithmeticException e){
            
        }
        return number;
    }
    static long uniqueRecycledPairs(int[] A) {
         int count=0;
        for(int i=0;i<A.length;i++){
             int l1=checkingRecylePair(A[i]);
            for(int j=i+1;j<A.length;j++){
                if(A[i]==A[j]){
                 break;
                }else{
                int l2=checkingRecylePair(A[j]);
                if(l2==l1){ 
                    count++;
                }  
            }
            }
        }
        return count;
    }
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(scan.nextLine().trim());

        int[] A = new int[n];

        String[] AItems = scan.nextLine().split(" ");

        for (int AItr = 0; AItr < n; AItr++) {
            int AItem = Integer.parseInt(AItems[AItr].trim());
            A[AItr] = AItem;
        }

        long result = uniqueRecycledPairs(A);

        bw.write(String.valueOf(result));
        bw.newLine();

        bw.close();
    }
}
