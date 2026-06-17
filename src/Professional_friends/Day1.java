package Professional_friends;

public class Day1 {
    public static boolean isSorted(int []arr){
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]>arr[i+1]){

                return false;
            }
        }
        return true;
    }
    //index return kar raha hai
    public static int sortedBreaker(int []arr){
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]>arr[i+1]){
                return i;
            }
        }
        return 0;
    }

    public static boolean isSorted(int []arr,int start,int end){
        for(int i=start;i<end;i++){
            if(arr[i]>arr[i+1]){
                System.out.println("Break at:"+i);
                return false;
            }
        }
        return true;
    }
    public static boolean isSortedRotated(int []arr){
        int requiredIdx=0;
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]>arr[i+1]){
                requiredIdx=i;
                break;
            }
        }
        boolean flag1=isSorted(arr,0,requiredIdx);
        boolean flag2=isSorted(arr,requiredIdx+1,arr.length-1);
        if(flag1 && flag2 && arr[0] > arr[arr.length-1]) return true;
        return false;
    }
    public static int findMax(int []arr){
        int maxSeen=arr[0];
        for(int i=1;i<arr.length;i++){
            if(maxSeen<arr[i]){
                maxSeen=arr[i];
            }
        }
        return maxSeen;
    }

    public static int secondLargest(int []arr){
        int secondLar=arr[0];
        int firstLar=arr[0];
        int secondsmall=arr[0];
        int firstsmall=arr[0];

        for(int i=1;i<arr.length;i++){
            if(arr[i]>firstLar){
                secondLar=firstLar;
                firstLar=arr[i];
            }else if(arr[i]>secondLar){
                secondLar=arr[i];
            }else if(arr[i]<firstsmall){
                secondsmall=firstsmall;
                firstsmall=arr[i];
            }else if(secondsmall>arr[i]){
                secondsmall=arr[i];
            }
        }
        System.out.println("Second largest:"+secondLar);
        System.out.println("Second smallest:"+secondsmall);
        return secondLar;
    }
    public static void main(String[]args){
        int []arr={1,2,4,3,5,6,7,8
        };

//        System.out.println(secondLargest(arr));
//        secondLargest(arr);
//        System.out.println(sortedBreaker(arr));
        System.out.println(isSortedRotated(arr));
    }
}
//1 2 3 4 6
//k=
//46123
//k=3
//23461
//int count=0;
//for(int i=0;i<arr.length;i++){
//    if(arr[i]>arr[i+1]){
//        count++;
//        }
//        }
//if count<=1 return true;
//else return false;
//
//5678 1234 left 5  right 4 left>right
//first index required
//1  2  4 - 3  5  6  7  8 left 1 right 8 left>right