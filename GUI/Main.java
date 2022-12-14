import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        printString("a");
    }

    private static void printString(String input) {
        String startingString = new String();
        int count = 0;

        for(int i = 0; i < input.length(); i++)
        {
            for(int j = 0; j < (int)input.charAt(i); j++)
            {
                startingString += "+";
            }

            count = (int)input.charAt(i);
            startingString += ".>";
        }

        try
        {
            FileWriter brainFuckFile = new FileWriter("brainfuck.bf");
            brainFuckFile.write(startingString);
            brainFuckFile.close();

            Runtime.getRuntime().exec("brainfuck brainfuck.bf");
        }

        catch(Exception e) {
            // Error
        }
    }
}