package Professional_friends;
import java.util.*;

public class Day3 {
    public static List<Integer> findUnion(int []a,int []b){
        int i=0;
        int j=0;
        List<Integer> result=new ArrayList<>();
        while(i<a.length && j<b.length){
            if(a[i]<b[j]){
                if(result.size()>0 && result.get(result.size()-1)==a[i]){
                    i++;
                    continue;
                }
                result.add(a[i++]);
            }else if(a[i]==b[j]){
                if(result.size()>0 && result.get(result.size()-1)==b[j]){
                    j++;i++;
                    continue;
                }
                result.add(a[i++]);
                j++;
            }else if(a[i]>b[j]){
                if(result.size()>0 && result.get(result.size()-1)==b[j]) {
                    j++;
                    continue;
                }
                result.add(b[j++]);
            }
        }
        while(i<a.length){
            if(result.size()>0 && result.get(result.size()-1)==a[i]){
                i++;
                continue;
            }
            result.add(a[i++]);
        }
        while(j<b.length){
            if(result.size()>0 && result.get(result.size()-1)==b[j]) {
                j++;
                continue;
            }
            result.add(b[j++]);
        }

        return result;
    }
    public static void main(String []args){
        int []a={1,2,3,4,5};
        int []b={2,3,4,4,5};
        System.out.println(findUnion(a,b));
    }
}
