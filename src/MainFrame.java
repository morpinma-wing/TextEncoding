import javax.swing.*;

public class MainFrame extends JFrame{

    MainFrame(){

        JPanel panel = new MainPanel();

        // Creating Object of "boxlayout" in
        // X_Axis from left to right
        BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.Y_AXIS);

        // to set the box layout
        panel.setLayout(boxlayout);

        this.add(panel);

        this.setSize(600,800);//400 width and 500 height
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);//making the frame visible

    }

    public static void main(String[] args) {

        new MainFrame();

    }

}
