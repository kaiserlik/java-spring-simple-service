package org.example;

public class Tasks {
    public static void main(String[] args){
        run();
    }
    public static void run(){
        int[] array = new int[7];
        array[0]=10; array[1]=22; array[2]=11; array[3]=-94; array[4]=33; array[5]=0; array[6]=5;
        int i = 1; //index
        int z = array[0]; //max
        int res = getMin(array, i, z);
        System.out.println("min: " + res);
    }
    public static int getMin(int[] input, int i, int z){
        if(input.length == 0){
            throw new ArrayIndexOutOfBoundsException("fail");
        }
        else if (i <= input.length - 2){
            if(input[i] < z){
                z = input[i];
        }
            return getMin(input, i + 1, z);
        }
        return z;
    }
}
