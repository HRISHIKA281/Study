package Professional_friends;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Arrays;

public class Day14 {
    public static boolean isPalindrome(String str){
        int i=0;
        int j=str.length()-1;
        while(i<j){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++;j--;
        }
        return true;
    }

    public int noOfUnique(String str){
        HashSet<Character> set =new HashSet<>();
        int count=0;
        for(int i=0;i<str.length();i++){
            if(!set.contains(str.charAt(i))){
                count++;
                set.add(str.charAt(i));
            }
        }
        return count;
    }

    public static String findNonRepeatingChar(String str){
        int []freq=new int[26];
        for(char c:str.toCharArray()){
            freq[c-'a']++;
        }
        for(int i=0;i<str.length();i++){
            char curr=str.charAt(i);
            if(freq[curr-'a']==1) return ""+curr;
        }
        return "-1";
    }

    public static boolean isAnagram(String str1,String str2){
        if(str1.length()!=str2.length()) return false;

//        Method1
//        char []s1=str1.toCharArray();
//        char []s2=str2.toCharArray();
//        Arrays.sort(s1);
//        Arrays.sort(s2);
//
//       for(int i=0;i<s1.length;i++){
//           if(s1[i] != s2[i]){
//               return false;
//           }
//       }
//       return true;

        //Method 2
        int []freq=new int[26];
        for(int i=0;i<str1.length();i++){
            char c=str1.charAt(i);
            freq[c-'a']++;
            char c2=str2.charAt(i);
            freq[c2-'a']--;
        }
        for(int i=0;i<freq.length;i++){
            if(freq[i] != 0){
                return false;
            }
        }
        return true;
    }

    public static String reverseSpecial(String str){
        StringBuilder sb =new StringBuilder(str);

        int i=0;
        int j=sb.length()-1;
        while(i<j){
            char c1=sb.charAt(i);
            char c2=sb.charAt(j);
            if(Character.isLetter(c1) && Character.isLetter(c2)){
                char temp =c1;
                sb.setCharAt(i,c2);
                sb.setCharAt(j,temp);
                i++;j--;
            }else if(!Character.isLetter(c1) && Character.isLetter(c2)){
                i++;
            }else if(Character.isLetter(c1) && !Character.isLetter(c2)){
                j--;
            }else{
                // dono he letter nahi hai
                i++;j--;
            }
        }
        return sb.toString();
    }


    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
//        String str=sc.nextLine();
//        boolean result=isPalindrome(str);
//        if(result) System.out.println("YES");
//        else System.out.println("NO");

//        String str2=sc.nextLine();
//        Day14 d= new Day14();
//        System.out.println(d.noOfUnique(str2));

//        String str=sc.nextLine();
//        System.out.println(findNonRepeatingChar(str));

//        String str1=sc.nextLine();
//        String str2=sc.nextLine();
//        boolean result=isAnagram(str1,str2);
//        if(result) System.out.println("YES");
//        else System.out.println("NO");

        String s=sc.nextLine();
        System.out.println(reverseSpecial(s));
    }
}
