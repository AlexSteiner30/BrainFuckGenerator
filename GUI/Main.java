import javax.swing.*;
import java.awt.event.*;

import java.io.*;

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
            Process code = Runtime.getRuntime().exec("g++ ReadBinary.cpp");
            code.waitFor();

            Process output = Runtime.getRuntime().exec("./a.out");
            output.waitFor();

            GenerateBrainFuckCode();
        }

        catch (Exception e) {
            System.out.println("An error occurred: " + e.getLocalizedMessage());
        }
    }

    private static void GenerateBrainFuckCode() {
        try {
            BufferedReader input = new BufferedReader(new FileReader("input.txt"));
            FileWriter output = new FileWriter("brainfuck.bf");

            char nextChar;
            String line;

            while ((line = input.readLine()) != null) {
                for (int j = 0; j <= line.length() - 8; j += 9) {
                    nextChar = (char) Integer.parseInt(line.substring(j, j + 8), 2);

                    for (int k = 0; k < (int) nextChar; k++) {
                        output.write("+");
                    }

                    output.write(".>");
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