package Professional_friends;
import java.util.*;

public class Day13 {
    public String solution(String str,int k){
        StringBuilder sb=new StringBuilder();
        for(char c:str.toCharArray()){
            if(Character.isLowerCase(c)) sb.append((char)('a'+(c-'a'+k)%26));
            else if(Character.isDigit(c)) sb.append((char)(c-'0'+k)%10);
            else if (Character.isUpperCase(c)) sb.append((char)('A'+(c-'A'+k)%26));
            else sb.append((char)(c+k));
        }
        return sb.toString();
    }
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        int k=sc.nextInt();
        sc.nextLine();
        String str=sc.nextLine();
        Day13 d=new Day13();
        if(k<=0){
            System.out.println("Invalid Input");
        }else{
            System.out.println(d.solution(str,k));
        }
    }
}
