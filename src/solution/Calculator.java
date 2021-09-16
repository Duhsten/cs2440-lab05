package solution;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator
{
private JFrame frame;
private JLabel resultsLabel;


public Calculator()
{
    frame = new JFrame("Calculator");
}


public JFrame getFrame()
{
    return frame;
}
private void updateResultLabel(String text)
{
    resultsLabel.setText(text);
}
public void initCalc()
{
    JFrame fr = getFrame(); // Frame for the Calculator   
    JPanel panel = new JPanel(new GridLayout(2,4)); // Panel that all other panels sit inside
    fr.setLayout(new GridLayout(2, 2));
    
    JPanel buttonPanel = new JPanel(new GridLayout(1,4)); // Button Panel for exec actions;
    JPanel resultPanel = new JPanel(new GridLayout(1,2)); // Results Panel;
    
    
    // BUTTON CONFIG
    JButton button1 = new JButton("+");
    JButton button2 = new JButton("-");
    JButton button3 = new JButton("*");
    JButton button4 = new JButton("/");
    
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
    JTextField textF1 = new JTextField("");
    textF1.setName("leftOperand");
    JTextField textF2 = new JTextField("");
    textF2.setName("rightOperand");
    textPanel.add(textF1);
    textPanel.add(textF2);
    resultPanel.add(resultsLabel);
    resultPanel.add(textPanel);
    
    
    
    panel.add(resultPanel);
    panel.add(buttonPanel, BorderLayout.CENTER);
    
    fr.getContentPane().add(panel);
    fr.pack();
    fr.setVisible(true);
}
public static void main(String[] args)
{
    Calculator calc = new Calculator();
    calc.initCalc();
    
}
}
