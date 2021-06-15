import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppWindow {
        private JPanel MainPanel;
        private JButton btnRun;
        private JButton btnReset;
        private JComboBox cmbPlayers;
        private JTextArea txtPlayers;
        private JTextArea txtResults;
        private JButton btnImport;
        private JLabel lblPlayers;

        public AppWindow() {
                btnReset.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                txtPlayers.setText("");
                                txtResults.setText("");
                        }
                });
                btnRun.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                        }
                });
        }

        public static void main(String[] args) {
                JFrame frame = new JFrame("AppWindow");

                frame.setContentPane(new AppWindow().MainPanel);

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                frame.pack();

                frame.setSize(400,400);

                frame.setVisible(true);
        }
}
