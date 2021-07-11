package com.company;

public class Main {

    public static void main(String[] args) {
        if (args.length != 1){
            CreateLogger.CreateLogger("log.log", "Enter 1 configuration file");
            return;
        }
        try {

            Config config = new Config(args[0]);
            Encoding.Encoding(config);

        } catch (Exception exception) {
            if (CreateLogger.mylogger == null){
                CreateLogger.CreateLogger("log.log", "Configuration file not found");
            }
        }
    }
}
