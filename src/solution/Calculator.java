package solution;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Calculator
{
private JFrame frame;
private JLabel resultsLabel;
private JTextField textF1;
private JTextField textF2;

public Calculator()
{
    frame = new JFrame("Calculator");
    initializeComponent();
}


public JFrame getFrame()
{
    return frame;
}
private void updateResultLabel(String text)
{
    resultsLabel.setText("Result = " + text);
}
private String calculate(String text1, String text2, String op)
{
    if(text1.equals("") || text2.equals(""))
    {
        return "Error";
    }
    else if (!isValidNum(textF1.getText()) || !isValidNum(textF2.getText()))
    {
        return "Error";
    }
    double num1 = Double.parseDouble(textF1.getText());
    double num2 = Double.parseDouble(textF2.getText());
    if(op == "add")
    {
      return String.valueOf(num1 + num2);  
    }
    else if(op == "sub")
    {
        return String.valueOf(num1 - num2);  
    }
    else if(op == "mult")
    {
        return String.valueOf(num1 * num2);  
    }
    else if(op == "div")
    {
        if(num1 == 0 || num2 == 0)
        {
           return "Error"; 
        }
        double result = (num1 / num2);
        return String.valueOf(result);  
    }
    return "ERROR";
}

public boolean isValidNum(String num) {
    if (num == null) {
        return false;
    }
    try {
        double d = Double.parseDouble(num);
    } catch (NumberFormatException nfe) {
        return false;
    }
    return true;
}
public void initializeComponent()
{
    JFrame fr = getFrame(); // Frame for the Calculator   
    JPanel panel = new JPanel(new GridLayout(2,4)); // Panel that all other panels sit inside
    fr.setLayout(new GridLayout(2, 2));
    
    JPanel buttonPanel = new JPanel(new GridLayout(1,4)); // Button Panel for exec actions;
    JPanel resultPanel = new JPanel(new GridLayout(1,2)); // Results Panel;
    
    
    // BUTTON CONFIG
    JButton button1 = new JButton("ADD");
    JButton button2 = new JButton("SUB");
    JButton button3 = new JButton("MULT");
    JButton button4 = new JButton("DIV");
    
    button1.setName("addButton");
    button2.setName("subButton");
    button3.setName("multButton");
    button4.setName("divButton");
    

    
    buttonPanel.add(button1);
    button1.setPreferredSize(new Dimension(80,40));
    buttonPanel.add(button2);
    button2.setPreferredSize(new Dimension(80,40));
    buttonPanel.add(button3);
    button3.setPreferredSize(new Dimension(80,40));
    buttonPanel.add(button4);
    button4.setPreferredSize(new Dimension(80,40));
    
    //RESULTS PANEL CONFIG
    
    resultsLabel = new JLabel("Result = N/A");
    resultsLabel.setName("resultLabel");
    JPanel textPanel = new JPanel(new GridLayout(2,1));
    textF1 = new JTextField("");
    textF1.setName("leftOperand");
    textF2 = new JTextField("");
    textF2.setName("rightOperand");
    textPanel.add(textF1);
    textPanel.add(textF2);
    resultPanel.add(resultsLabel);
    resultPanel.add(textF1);
    resultPanel.add(textF2);
    
    
    
   // panel.add(resultPanel);
   // panel.add(buttonPanel, BorderLayout.CENTER);
    
    fr.getContentPane().add(resultPanel);
    fr.getContentPane().add(buttonPanel);
    fr.pack();
    fr.setVisible(true);
    
    
    
    
    // Action Listeners and Helpers
    // BUTTONS
    
    //Add
    button1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String result = calculate(textF1.getText(), textF2.getText(), "add");
            updateResultLabel(result);
        }
    });
    button2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String result = calculate(textF1.getText(), textF2.getText(), "sub");
            updateResultLabel(result);
        }
    });
    button3.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String result = calculate(textF1.getText(), textF2.getText(), "mult");
            updateResultLabel(result);
        }
    });
    button4.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String result = calculate(textF1.getText(), textF2.getText(), "div");
            updateResultLabel(result);
        }
    });
    
    
    
    

    
    
    
}
public static void main(String[] args)
{
    Calculator calc = new Calculator();
    
    
}
}
