import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  JLabel firstLabel;
  JLabel secondLabel;

  JTextField farenheitInput;
  JTextField celsiusInput;

  JButton firstButton;
  JButton secondButton;

  JPanel mainPanel;


  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Temperature Converter");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(700,250);
    // shows the window
    frame.setVisible(true);

    //initialize the main panel
    mainPanel = new JPanel();
    mainPanel.setLayout(null);

    //labels here (initialized and located)
    firstLabel = new JLabel("Degrees Farenheit");
    secondLabel = new JLabel("Degrees Celcius");
    firstLabel.setBounds(100,50,300,25);
    secondLabel.setBounds(100,125,300,25);

    //text fields here (initialized and located)
    farenheitInput = new JTextField("");
    celsiusInput = new JTextField("");
    farenheitInput.setBounds(325,50,100,25);
    celsiusInput.setBounds(325,125,100,25);

    //buttons here (initialized and located)
    firstButton = new JButton("F -> C");
    secondButton = new JButton("C -> F");
    firstButton.setBounds(450,50,100,25);
    secondButton.setBounds(450,125,100,25);

    //set the actoin command to know which button was pressed
    firstButton.setActionCommand("celsius");
    secondButton.setActionCommand("farenheit");

    //add action Listeners to the buttons
    firstButton.addActionListener(this);
    secondButton.addActionListener(this);

    //add things to main panel
    mainPanel.add(firstLabel);
    mainPanel.add(secondLabel);
    mainPanel.add(celsiusInput);
    mainPanel.add(farenheitInput);
    mainPanel.add(firstButton);
    mainPanel.add(secondButton);

    //add main panel to the screen
    frame.add(mainPanel); 
    

  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();


    //finds out which button was pressed then grabs the according text and converts it into a double which can then be converted into the opposite Temperature measurement
    if(command.equals("celsius")){
      String farenheitText = farenheitInput.getText();
      double farenheitNumber = Double.parseDouble(farenheitText);
      double celsius = ((farenheitNumber - 32) * 5 / 9);
      celsiusInput.setText("" + celsius);
    } else if(command.equals("farenheit")){
      String celsiusText = celsiusInput.getText();
      double celsiusNumber = Double.parseDouble(celsiusText);
      double farenheit = ((celsiusNumber * 9/5) + 32);
      farenheitInput.setText("" + farenheit);
    }

  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
