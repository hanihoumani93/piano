

import org.jfugue.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Piano extends JPanel implements ActionListener {

    public static void main(String[] args) {
        Player p = new Player(); //make a new Object
        new Piano();

    }

    private final JButton play; //The play button that play the notes that are saved in the Text
    private final JTextArea text;//Text where the notess are put wen we play on the piano
    public static  JFrame frame;
    private final JButton[] jb = new JButton[21];//Array of 21 button of the paino Keys
    private final String[] notes = new String[]{"C4", "D4", "E4", "F4", "G4", "A4", "B4", "C5", "D5", "E5", "F5", "G5", "A5", "B5", "C6", "D6", "E6", "F6", "G6", "A6", "B6"};
    private final String[] sharpNotes = new String[]{"C#4", "D#4", "F#4", "G#4", "A#4", "C#5", "D#5", "F#5", "G#5", "A#5", "C#6", "D#6", "F#6", "G#6", "A#6",};
  

    public Piano() {

        frame = new JFrame();
        frame.setLayout(new FlowLayout());

         
        Container mainPanel = frame.getContentPane();
        mainPanel.setLayout(null);

        JLayeredPane pianoKeyPanel = makeKeys();//JLayeredPane adds depth to a JFC/Swing container, allowing components to overlap each other when needed
        mainPanel.add(pianoKeyPanel);
        Insets insets = mainPanel.getInsets();//insert Action for each button
        Dimension size = pianoKeyPanel.getMaximumSize();
        pianoKeyPanel.setBounds(0,0, size.width, size.height);

        JLabel notesLabel = new JLabel("Notes");
        notesLabel.setForeground(Color.black);

        text = new JTextArea();
        text.setColumns(65);
        text.setRows(1);
        text.setOpaque(true);
        text.setForeground(Color.black);

        play = new JButton("Play");
        play.setName("Play");
        play.addActionListener(this);
        play.setForeground(Color.BLACK);

        mainPanel.add(play);
        size = play.getMaximumSize();
        play.setBounds(470 + insets.left, 200 + insets.top, size.width, size.height);

        mainPanel.add(notesLabel);
        size = notesLabel.getMaximumSize();
        notesLabel.setBounds(120 + insets.left, 180 + insets.top, size.width, size.height);

        mainPanel.add(text);
        size = text.getPreferredSize();
        text.setBounds(165 + insets.left, 180 + insets.top, size.width, size.height);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 300);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        
        

    }

    public JLayeredPane makeKeys() {  //Class how to make the note tone of each Key

        int x = 55;
        int y = 0;

        JLayeredPane keyBoard = new JLayeredPane();

        for (int j = 0; j < 21; j++) {
            jb[j] = new JButton();  //New Button
            jb[j].addActionListener(this);  //each button from 21 has an ActionLitener Class
            jb[j].setText(notes[j]);  //move the event of the button to the text of play
            jb[j].setFont(new Font("Arial",Font.PLAIN,8));  //set font to each Key
            jb[j].setActionCommand(notes[j]);  //what should it do when we press this button

            jb[j].setBackground(Color.white);  //the color of the key is white
            jb[j].setBounds(x, y, 44, 150);  //cordinate of the key
            keyBoard.add(jb[j], new Integer(1)); //Each key will be add as (jb 1,1)for the first key..) in the KeyBoard Object in order to save it and send it using Runnabel class object to Text in order to let it play when we press the paly button.
            x += 44; 

        }
        for (int i = 0; i < 3; i++) {


            JButton jb0 = new JButton();  //craet j0 button
            
            jb0.addActionListener(this);  //a class for j0 to let it make somthing when we press on it.  
            jb0.setBackground(Color.black);  //make j0 black
            jb0.setActionCommand(sharpNotes[0 + (i * 5)]); //Whats it make when we press on j0?
            JButton jb1 = new JButton(); //same j0......
            jb1.addActionListener(this);
           jb1.setBackground(Color.black);
            jb1.setActionCommand(sharpNotes[1 + (i * 5)]);
            JButton jb2 = new JButton();
            jb2.addActionListener(this);
            jb2.setBackground(Color.black);
            jb2.setActionCommand(sharpNotes[2 + (i * 5)]);
            JButton jb3 = new JButton();
            jb3.addActionListener(this);
            jb3.setBackground(Color.black);
            jb3.setActionCommand(sharpNotes[3 + (i * 5)]);
            JButton jb4 = new JButton();
            jb4.addActionListener(this);
            jb4.setBackground(Color.black);
            jb4.setActionCommand(sharpNotes[4 + (i * 5)]);
            jb0.setContentAreaFilled(false);  //you are telling the button that it should not paint it's content area.
            jb0.setOpaque(true);  //show panel Original color

            jb1.setContentAreaFilled(false);
            jb1.setOpaque(true);

            jb2.setContentAreaFilled(false);
            jb2.setOpaque(true);

            jb3.setContentAreaFilled(false);
            jb3.setOpaque(true);

            jb4.setContentAreaFilled(false);
            jb4.setOpaque(true);

            jb0.setBounds(90 + (307 * i), y, 22, 100);
            keyBoard.add(jb0, new Integer(2));

            jb1.setBounds(130 + (307 * i), y, 22, 100);
            keyBoard.add(jb1, new Integer(2));

            jb2.setBounds(218 + (307 * i), y, 22, 100);
            keyBoard.add(jb2, new Integer(2));

            jb3.setBounds(264 + (307 * i), y, 22, 100);
            keyBoard.add(jb3, new Integer(2));

            jb4.setBounds(309 + (307 * i), y, 22, 100);
            keyBoard.add(jb4, new Integer(2));
        }
        return keyBoard;
    }

    @Override

    public void actionPerformed(ActionEvent action) { //the Action of each Button when we press on it
        JButton but;
        char[] name = new char[3]; //Array of three character 
        Player player = new Player();  //Object
        Object obj = action.getSource();  //get the source of this button from Jfugue Library
        but = (JButton) obj;  //save the name of this button in obj object to use it in the text when we press the play button.
        player.play(action.getActionCommand());  //get the Action of this button when its play (get the ton of the button)

        String command = but.getActionCommand();  //get the tone of the button from but object and play its tone when we press play Button.

        if ("Play".equals(but.getName())) {
            player.play(text.getText());  //get the name of the tone and put it in the Text when we press play button
        }

        if (!"Play".equals(but.getName())) {
            text.append(command + " ");  //make a space between each note wen we press play button
        }

    }

}
hhhhhhhhhhhhhhhhhhhhhhh
