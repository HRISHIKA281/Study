package Professional_friends;

public class Day2 {
    public int[] removeDuplicate(int []arr){
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]==arr[i+1]){
                arr[i]=Integer.MIN_VALUE;
            }
        }
        if(arr.length>=2 && arr[arr.length-2]==arr[arr.length-1]){
            arr[arr.length-2]=Integer.MIN_VALUE;
        }
        int k=0;
        int i=0;
        while(i<arr.length){
            if(arr[i]!=Integer.MIN_VALUE){
                arr[k]=arr[i];
                arr[i]=Integer.MIN_VALUE;
                k++;
            }
            i++;
        }
        System.out.println(k);
        return arr;
    }

    public int[] moveZeros(int []arr){
        int i=0;
        int k=0;
        while(i<arr.length){
            if(arr[i]!=0){
                arr[k]=arr[i];
                k++;
            }
            i++;
        }

        while(k<arr.length){
            arr[k++]=0;
        }
        return arr;
    }
    public static void main(String []args){
        int []arr={1,1,1,2,2};
//        Day2 kaif=new Day2();
//        int []result=kaif.removeDuplicate(arr);
//        for(int i=0;i<result.length;i++){
//            System.out.println(result[i]);
//        }
        int []arr2={0,1,0,3,12};
        Day2 hrishika=new Day2();
        int []result2=hrishika.moveZeros(arr2);
        for(int i=0;i<result2.length;i++){
            System.out.println(result2[i]);
        }
    }
}
