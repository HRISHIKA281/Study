package Professional_friends;

import java.util.*;
class Day8 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        // {  15 ; -8;  27 ; 3 ; -12 ;  9 }
        String s=sc.nextLine();
        int curr=0;
        int maxInt=Integer.MIN_VALUE;
        boolean isNegative=false;

        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(Character.isDigit(c)){
                curr=curr*10+(c-'0');
            }else if (c==';' || c=='}'){
                if(isNegative){
                    curr*=-1;
                }
                maxInt=Math.max(maxInt,curr);
                isNegative=false;
                curr=0;
            }else if(c=='-'){
                isNegative=true;
            }
        }
        System.out.println(maxInt);
    }
}
