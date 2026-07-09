package Professional_friends;
import java.util.*;

public class Day12 {
    public static String process(String alice){
        StringBuilder sb1=new StringBuilder();
        for(char c:alice.toCharArray()){
            if(c=='#'){
                if(sb1.length()>0) sb1.deleteCharAt(sb1.length()-1);
            }else{
                sb1.append(c);
            }
        }
        return sb1.toString();
    }




    public List<String> subSequence(String str,String s,List<String> result,int idx){
        if(idx==str.length()){
            if(!s.equals("")) result.add(s);
            return result;
        }
        char c=str.charAt(idx);
        subSequence(str,s+c,result,idx++);
        subSequence(str,s,result,idx++);
        return result;
    }
    /*
    Check each substring

    For every substring:

    Count frequency of each character.
    Count how many characters have odd frequency.
    If odd count ≤ 1
    answer++
     */
    public List<String> substring(List<String> result,String str){
        for(int i=0;i<str.length();i++){
            for(int j=i;j<str.length();j++){
                String sub=str.substring(i,j+1);
                result.add(sub);
            }
        }
        return result;
    }
    public int helperfreq(List<String> result,int answer){
        for(String s:result){
            HashMap<Character,Integer> map=new HashMap<>();
            for(char c:s.toCharArray()){
                map.put(c,map.getOrDefault(c,0)+1);
            }
            int oddCount=0;
            for(char key:map.keySet()){
                if(map.get(key)%2 !=0){
                    oddCount++;
                }
            }
            if(oddCount<=1){
                answer++;
            }
        }
        return answer;
    }
    public static void main(String []args){
        Scanner sc=new Scanner (System.in);

//        String alice=sc.nextLine();
//        String bob=sc.nextLine();
//
//        System.out.println(process(alice).equals(process(bob)));

        String input=sc.nextLine();

        List<String> result=new ArrayList<>();
        Day12 d=new Day12();
        d.substring(result,input);
        System.out.println(d.helperfreq(result,0));
    }
}
