import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
public class Main implements ActionListener {
    public static void main(String[] args){
        Main window = new Main();
    }

    // Window Builder
    Main()
    {
        // Create Frane
        JFrame frame = new JFrame();

        // Create Components
        JLabel label = new JLabel("Write here you code in C++");
        JTextArea input = new JTextArea();  
        JButton button =new JButton("Convert");  
        
        // Button
        button.addActionListener(this);

        // Set Bounds
        label.setBounds(26,25, 200,30);  
        input.setBounds(25,55, 400,350);  
        button.setBounds(20,415, 100,30);  

        // Add Componnets
        frame.add(label);
        frame.add(input);
        frame.add(button);

        // Run window
        frame.setSize(500,500);
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
    private static void CompileCode()
    {
        
    }
}