package Commands;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import TableUtils.Table;

public class Open extends Command {
    private static String readFileToString(String filename) {
        try {
            return new String(Files.readAllBytes(Paths.get(filename)));
        } catch (IOException e) {
            System.out.println(Paths.get(filename).toAbsolutePath());
            System.out.println(e);
            System.err.println("Error reading file: " + filename);          
            return null;
        }
    }


    @Override
    public void execute(String[] args) {
        if (args.length < 2) {
            System.out.println("Not enough arguments.");
            return;
        }
        String contents =  readFileToString(args[1]);
        if (contents == null) {
            return;
        }
        try {
            gTable = new Table(contents);
            gFileName = args[1];
        } catch (Exception e) {
            gTable = null;
           
        }
        System.out.println("File " + args[1] + " opened succesfully");
    }
}