import javax.swing.*;
import java.awt.event.*;

import java.io.*;
import java.lang.Math;
import java.util.Scanner;

public class Main implements ActionListener {

    // Create Components
    private static JLabel label = new JLabel("Write here you code in C++");
    private static JTextArea input = new JTextArea();
    private static JButton button = new JButton("Convert");

    public static void main(String[] args) {
        new Main();
    }

    // Window Builder
    Main() {
        // Create Frane
        JFrame frame = new JFrame();

        // Button
        button.addActionListener(this);

        // Set Bounds
        label.setBounds(26, 25, 200, 30);
        input.setBounds(25, 55, 400, 350);
        button.setBounds(20, 415, 100, 30);

        // Add Componnets
        frame.add(label);
        frame.add(input);
        frame.add(button);

        // Run window
        frame.setSize(500, 500);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("BrainFuck GUI Generator");
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        CompileCode();
    }

    // Functions
    private static void CompileCode() {
        try {
            FileWriter cppFile = new FileWriter("code.cpp");
            cppFile.write(input.getText());
            cppFile.close();

            Process code = Runtime.getRuntime().exec("g++ code.cpp");
            code.waitFor();

            ReadBinary();
        }

        catch (Exception e) {
            System.out.println("An error occurred: " + e.getLocalizedMessage());
        }
    }

    private static void ReadBinary() {
        try {
            Process code = Runtime.getRuntime().exec("g++ ReadBinary.cpp -o binary");
            code.waitFor();

            Process output = Runtime.getRuntime().exec("./binary");
            output.waitFor();

            GenerateBrainFuckCode();
        }

        catch (Exception e) {
            System.out.println("An error occurred: " + e.getLocalizedMessage());
        }
    }

    private static void GenerateBrainFuckCode() {
        try {
            FileInputStream inputFile = new FileInputStream("input.txt");
            Scanner input = new Scanner(inputFile);
            FileWriter output = new FileWriter("brainfuck.bf");

            String bytes = "";

            while (input.hasNextLine()) {
                String line = input.nextLine();
                int nextChar = 0;

                int j = 8;
                while (j != 0) {
                    if (line.charAt(8 - j) == '1') {
                        nextChar += Math.pow(2, j - 1);
                    }
                    j--;
                }

                if (nextChar >= 32 && nextChar <= 126) {
                    bytes += (char) nextChar;
                }
            }

            int count = 0;
            for (int i = 0; i < bytes.length(); i++) {
                if (bytes.charAt(i) == 'k' && bytes.charAt(i + 1) == 't') {
                    count = i + 2;
                    while (bytes.charAt(count) != '$') {
                        for (int k = 0; k < ((int) bytes.charAt(count)); k++) {
                            output.write("+");
                        }

                        output.write(".>");
                        count++;
                    }
                }
            }

            input.close();
            output.close();
        }

        catch (Exception e) {
            System.out.println("An error occurred: " + e.getLocalizedMessage());
        }

    }
}