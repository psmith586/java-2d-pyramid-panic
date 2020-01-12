package PyramidPanic.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Utilities {

    public static String loadFileToString(String path){

        StringBuilder builder = new StringBuilder();

        try{

            BufferedReader b = new BufferedReader(new FileReader(path));
            String l;

            while((l = b.readLine()) != null){
                builder.append(l + "\n");
            }

            b.close();

        }catch(IOException e){
            e.printStackTrace();
        }

        return builder.toString();
    }

    public static int safeParse(String x){
        try{
            return Integer.parseInt(x);

        }catch(NumberFormatException e){

            e.printStackTrace();

            return 0;
        }
    }
}
