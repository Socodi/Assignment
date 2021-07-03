import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class AppWindow {
        private JPanel MainPanel;
        private JButton btnRun;
        private JButton btnReset;
        private JComboBox cmbPlayers;
        private JTextArea txtPlayers;
        private JTextArea txtResults;
        private JButton btnImport;
        private JLabel lblPlayers;
        private JProgressBar prgsProgress;
        private JScrollPane scrltxtPlayers;

        public AppWindow() {
                btnReset.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                txtPlayers.setText("");
                                txtResults.setText("");
                                prgsProgress.setValue(0);
                                cmbPlayers.setSelectedIndex(0);
                        }
                });
                btnRun.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                tournament tourny = new tournament();

                                txtResults.append(tourny.runRound());
                        }
                });
                btnImport.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                txtPlayers.setText("");

                                String jsonFile = "Data/players.json";

                                Gson gson = new Gson();

                                FileReader fileReader = null;
                                try {
                                        fileReader = new FileReader(jsonFile);
                                        JsonReader jsonReader = new JsonReader(fileReader);

                                        ReadJson[] data = gson.fromJson(jsonReader, ReadJson[].class);

//                                        for (ReadJson readJson  : data)
//                                        {
//                                                System.out.println(readJson);
//                                        }

                                        ArrayList<player> players = new ArrayList<player>();
//                                        for (ReadJson readJson : data)
//                                        {
//                                                player newPlayer = new player(readJson.getId(), readJson.getFirst_name(), readJson.getLast_name());
//                                                players.add(newPlayer);
//                                        }

                                        int playersAmount = Integer.parseInt(cmbPlayers.getSelectedItem().toString());
                                        System.out.println(playersAmount);
                                        int i = 1;

                                        float progressDivide = prgsProgress.getMaximum() / playersAmount;

                                        for (ReadJson readJson : data)
                                        {
                                                if (i < playersAmount + 1)
                                                {
                                                        player newPlayer = new player(readJson.getId(), readJson.getFirst_name(), readJson.getLast_name());
                                                        players.add(newPlayer);

                                                        i += 1;
                                                }
                                        }

//                                        for (player existingPlayer : players)
//                                        {
//                                                System.out.println(existingPlayer.id + " " + existingPlayer.firstName + " " + existingPlayer.lastName);
//                                                System.out.println("------------------");
//                                        }

                                        for (player player : players)
                                        {
                                                txtPlayers.append(player.id + ": " + player.firstName + " " + player.lastName + "\n");

                                                float progress = prgsProgress.getValue();

                                                float progressNew = progress + progressDivide;

                                                prgsProgress.setValue((int) Math.rint(progressNew));
                                        }

                                        prgsProgress.setValue(100);

                                } catch (FileNotFoundException fileNotFoundException) {
                                        fileNotFoundException.printStackTrace();
                                }
                        }
                });
        }

        public static void main(String[] args) {
                JFrame frame = new JFrame("AppWindow");

                frame.setContentPane(new AppWindow().MainPanel);

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                frame.pack();

                frame.setSize(600,400);

                frame.setVisible(true);
        }
}
