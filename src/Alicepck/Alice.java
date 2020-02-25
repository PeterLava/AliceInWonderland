package Alicepck;

import java.net.*;
import java.io.*;
import java.util.Map;
import java.util.TreeMap;


public class Alice {


    public static void main(String[] args) throws Exception {
        Map<String, Integer> map = new TreeMap<>();
        ValueComparator bvc = new ValueComparator(map);
        TreeMap<String, Integer> sorted_map = new TreeMap<>(bvc);
        String[] allWords = {"to"};
        int[] wordAmmounts = {0};

        URL textfile = new URL("https://www.gutenberg.org/files/11/11.txt");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(textfile.openStream()));

        char character;
        char character2 = 32;
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
String[] words = inputLine.split(" ");
            for (int i = 0; i < words.length; i++) {
words[i] = words[i].toLowerCase();


                    for (char j = 0; j < 97; j++) {
                        character = j;
                        words[i] = words[i].replace(character,character2);
                    }
                    for (char j = 123; j <  128; j++) {
                        character = j;
                        words[i] = words[i].replace(character,character2);
                    }
                    words[i] = words[i].replace(" ","");
                if(words[i].length() != 0) {
                    if (map.containsKey(words[i])) {
                        map.put(words[i], map.get(words[i]) + 1);
                    } else {
                        map.put(words[i], 1);
                    }
                }



            }

        }

        in.close();
        sorted_map.putAll(map);
        int g = 0;
       /* for(Map.Entry<String,Integer>entry:sorted_map.entrySet()){
            if(map.containsKey(entry.getKey()+",")){
              sorted_map.put(entry.getKey(),entry.getValue() + map.get(entry.getKey()+","))  ;
              //  sorted_map.put(entry.getKey(),sorted_map.get(entry.getKey()+","));
            }
        }
*/



        int c = 1;
        System.out.println("TOP 10 WORDS IN ALICE IN WONDERLAND:");
        System.out.println("------------------------------------");
    for(Map.Entry<String,Integer>entry:sorted_map.entrySet()){

        System.out.print(c+". "+entry.getKey());
        for (int i = 10; i > entry.getKey().length()+(c/10); i--) {
            System.out.print(" ");
        }
        System.out.println(entry.getValue()+" Times");
        //System.out.println(entry.getKey()+entry.getValue());
        c++;
        if (c == 11)break;
    }
        System.out.println("------------------------------------");
    }



}