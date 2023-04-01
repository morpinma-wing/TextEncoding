import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel implements ActionListener {

    private JButton button;
    private JTextArea entry, result;

    private JRadioButton encodebtn, decodebtn;
    MainPanel(){

        JLabel title = new JLabel("Welcome to the Text Encoder");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel instruction = new JLabel("Enter your text below");
        instruction.setAlignmentX(Component.CENTER_ALIGNMENT);

        button = new JButton("Click to run");//creating instance of JButton
        button.setAlignmentX(Component.CENTER_ALIGNMENT);

        entry = new JTextArea("Enter your Text");

        result = new JTextArea();
        result.setEditable(false);

        encodebtn = new JRadioButton("Encode");
        decodebtn = new JRadioButton("Decode");
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(encodebtn);
        buttonGroup.add(decodebtn);

        JPanel panel = new JPanel();
        // Creating Object of "boxlayout" in
        // X_Axis from left to right
        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);
        // to set the box layout
        panel.setLayout(boxlayout);
        panel.add(button);//adding button in Jpanel;
        panel.add(encodebtn);
        panel.add(decodebtn);

        this.add(title);
        this.add(instruction);
        this.add(entry);
        this.add(panel);
        this.add(result);

        button.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button){
            String text = entry.getText();
            AffineCipher acmachine = new AffineCipher();
            if (encodebtn.isSelected()){
                result.setText(acmachine.encode(text));
            }
            else if (decodebtn.isSelected()){
                result.setText(acmachine.decode(text));
            }
        }
    }
}
