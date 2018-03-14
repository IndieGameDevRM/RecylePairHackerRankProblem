import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int maxcount=1;
    static int migratoryBirds(int n, int[] ar) {
        int i=0,j=0,temp=0,maxvalue=0,value=0,count=1;
        for(i=0;i<n;i++){
            for(j=0;j<n-1-i;j++){
                if(ar[j]>ar[j+1]){
                    temp=ar[j];
                    ar[j]=ar[j+1];
                    ar[j+1]=temp;
                }                
            }
        }
        i=0,temp=0;
        while(i<n-1){   
            if(ar[i]==ar[i+1]){
                count++;
                value=ar[i];
            }else{
                count=1;
            }
            if(count>1){
                _temp=count;
                }
            if(maxcount<_temp){
                
                maxcount=_temp;
                maxvalue=value;
            }else if(maxcount == _temp){
               maxcount=_temp;
                if(maxvalue>value){
                    maxvalue=maxvalue;                    
                }
            }     
            i++;
        }
        return maxvalue;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = migratoryBirds(n, ar);
        System.out.println(result);
    }
}
