package org.example;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.List;

public class Service {
    protected static ArrayList<Integer> parseJson(String in) throws ParseException {
        //{"numbers": "10, 22, 11, -94, 33, 0, 5"}
        ArrayList<Integer> list = new ArrayList<>();
        JSONParser parser = new JSONParser();
        JSONObject obj = (JSONObject) parser.parse(in);
        //like Scala Any, specify type that's justifiable
        String str = (String) obj.get("numbers");
        String[] N = str.split(",");
        for(String s: N){
            System.out.println(s);
            list.add(Integer.parseInt(s));
        }
        return list;
    }
    public static int run(ArrayList<Integer> list){
        //array[0]=10; array[1]=22; array[2]=11; array[3]=-94; array[4]=33; array[5]=0; array[6]=5;
        int i = 1; //index
        int z = list.get(0); //max
        int res = getMin(list, i, z);
        System.out.println("min: " + res);
        return res;
    }
    public static int getMin(ArrayList<Integer> input, int i, int z){
        if(input.size() == 0){
            throw new ArrayIndexOutOfBoundsException("fail");
        }
        else if (i <= input.size() - 2){
            if(input.get(i) < z){
                z = input.get(i);
            }
            return getMin(input, i + 1, z);
        }
        return z;
    }
}
