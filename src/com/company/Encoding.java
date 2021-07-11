package com.company;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Encoding {

    private static final int THREEBYTE_SEQUENCE = 3;
    private static final int TWOBYTE_SEQUENCE = 2;
    private static final int ONEBYTE_SEQUENCE = 1;

    static void Encoding(Config confg) throws IOException{

        FileOutputStream output_file = new FileOutputStream(confg.get_file_name(Config.ConfigGrammar.OUTPUT_FILE.toString()));
        FileInputStream input_file = null;

        try {
            input_file = new FileInputStream(confg.get_file_name(Config.ConfigGrammar.INPUT_FILE.toString()));

            byte[] buffer = new byte[THREEBYTE_SEQUENCE];

            while (input_file.available() > 0) {
                int availableBEFOREreading = input_file.available();
                input_file.read(buffer);
                if (availableBEFOREreading >= ONEBYTE_SEQUENCE && availableBEFOREreading <= TWOBYTE_SEQUENCE)
                    output_file.write(buffer, 0 , availableBEFOREreading);
                else{
                    Rot.ROT(buffer);
                    output_file.write(buffer);}
                }
        }catch(IOException exception)
        {
            CreateLogger.CreateLogger(confg.get_file_name(Config.ConfigGrammar.LOG_FILE.toString()), "Input file not found");
        }finally {
                input_file.close();
                output_file.close();
        }
            /*if (input_file != null)
                input_file.close();
            output_file.close();*/

    }
}
