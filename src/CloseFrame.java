import java.awt.event.*;
import javax.swing.*;

class CloseFrame {

    public static void main(String[] args) {

        Runnable r = new Runnable() {

            public void run() {
                JButton close = new JButton("Close me programmatically");
                final JFrame f = new JFrame("Close Me");
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setContentPane( close );
                close.addActionListener( new ActionListener(){
                    public void actionPerformed(ActionEvent ae) {
                        // make the app. end (programatically)
                        f.dispose();
                    }
                } );
                f.pack();
                f.setLocationByPlatform(true);
                f.setVisible(true);
            }
        };

        SwingUtilities.invokeLater(r);
    }
}