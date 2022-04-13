package tema1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.regex.Pattern;

public class RegexMain 
{

    private JFrame frame;
    private JTextField regexText;
    private JTextArea textString;

    public JFrame getFrame() 
    {
        return frame;
    }

    public void setFrame(JFrame frame) 
    {
        this.frame = frame;
    }

    public RegexMain() 
    {
    	 setFrame(new JFrame("Regular Expression"));
         getFrame().getContentPane().setBackground(new Color(202, 188, 0));
         getFrame().setBounds(400, 200, 450, 500);
         getFrame().setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
         getFrame().getContentPane().setLayout(null);

         JLabel labeltextString = new JLabel("String to check :");
         labeltextString.setBounds(50, 150, 300, 36);
         getFrame().add(labeltextString);

         textString = new JTextArea();
         textString.setBounds(50, 200, 300, 65);
         getFrame().getContentPane().add(textString);
         textString.setColumns(10);
         
         JLabel labelregexText = new JLabel("Regex :");
         labelregexText.setBounds(50, 50, 300, 36);
         getFrame().add(labelregexText);

         regexText = new JTextField();
         regexText.setBounds(50, 100, 300, 30);
         getFrame().getContentPane().add(regexText);
         regexText.setColumns(10);

         JButton btnCheck = new JButton("Check");
         btnCheck.addActionListener(this::actionButtonSubmit);

         btnCheck.setBounds(50, 300, 100, 30);
         getFrame().getContentPane().add(btnCheck);

         JButton btnClear = new JButton("Clear");
         btnClear.addActionListener(this::actionButtonClear);

         btnClear.setBounds(250, 300, 100, 30);
         getFrame().getContentPane().add(btnClear);
    }
    
    private void actionButtonClear(ActionEvent e) 
    {
    	regexText.setText(null);
    	textString.setText(null);
    }

    private void actionButtonSubmit(ActionEvent e) 
    {
    	
    	JDialog result = new JDialog(frame, "Results", true);
    	result.setBounds(400, 200, 200, 100);
    	result.setLocationRelativeTo(frame);
    	
    	if ((regexText.getText().isEmpty() == false) && (textString.getText().isEmpty()) == false) 
    	{
	    	
	    	boolean isRegexInvalid = false;
	    	
	    	Pattern pattern = null;
	    	
	    	try 
	    	{
	    		pattern = Pattern.compile(regexText.getText());
		    } 
	    	catch (Exception x)
	    	{
		      isRegexInvalid = true;
		    }
	    	
		    if (isRegexInvalid)
		    {
		    	result.add(new JLabel("Invalid pattern!"));
		    } 
		    else 
		    {
		        if (pattern.matcher(textString.getText()).matches()) 
		        {
		        	result.add(new JLabel("Match found!"));
		        } 
		        else 
		        {
		        	result.add(new JLabel("No match found."));
		        }
		    }
    	}
    	else
    	{
    		
        	
        	result.add(new JLabel("Regex or string not available"));
    	}
    	
	    result.setVisible(true);
    }

    
    
    public static void main(String[] args) 
    {

        try 
        {
        	RegexMain app = new RegexMain();
        	app.getFrame().setVisible(true);
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    
}