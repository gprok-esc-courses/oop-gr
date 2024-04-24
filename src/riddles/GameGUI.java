package riddles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameGUI extends JFrame implements ActionListener {

    private Game game;
    private JTextField usernameField;
    private JButton submitUsernameBtn;

    private JLabel scoreLabel;
    private JButton playAgainBtn;
    private JButton newUserBtn;
    private JButton exitBtn;
    private JLabel questionLabel;
    private JTextField answerField;
    private JButton submitAnswerBtn;

    private String username;

    public GameGUI() {
        JPanel north = usernameFrame();
        add(north, BorderLayout.NORTH);
        JPanel south = bottomPanel();
        add(south, BorderLayout.SOUTH);
        JPanel center = riddlePanel();
        add(center, BorderLayout.CENTER);

        setBounds(100, 100, 500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public JPanel usernameFrame() {
        JPanel panel = new JPanel();
        JLabel username = new JLabel("Username: ");
        usernameField = new JTextField(8);
        submitUsernameBtn = new JButton("Submit Username");
        submitUsernameBtn.addActionListener(this);
        panel.add(username);
        panel.add(usernameField);
        panel.add(submitUsernameBtn);
        return panel;
    }

    public JPanel bottomPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JPanel scorePanel = new JPanel();
        JLabel label = new JLabel("Score:");
        scoreLabel = new JLabel("/");
        scorePanel.add(label);
        scorePanel.add(scoreLabel);
        JPanel buttonsPanel = new JPanel();
        playAgainBtn = new JButton("Play Again");
        playAgainBtn.addActionListener(this);
        playAgainBtn.setEnabled(false);
        newUserBtn = new JButton("New User");
        newUserBtn.setEnabled(false);
        newUserBtn.addActionListener(this);
        exitBtn = new JButton("EXIT");
        exitBtn.addActionListener(this);
        buttonsPanel.add(playAgainBtn);
        buttonsPanel.add(newUserBtn);
        buttonsPanel.add(exitBtn);
        panel.add(scorePanel);
        panel.add(buttonsPanel);
        return panel;
    }

    public JPanel riddlePanel() {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createLineBorder(Color.darkGray));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JPanel labelPanel = new JPanel();
        JLabel riddleLabel = new JLabel("");
        riddleLabel.setText("<html><h1>RIDDLE</h1></html>");
        labelPanel.add(riddleLabel);
        JPanel questionPanel = new JPanel();
        JLabel question = new JLabel("Question:");
        questionLabel = new JLabel("-");
        questionLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
        questionPanel.add(question);
        questionPanel.add(questionLabel);
        JPanel answerPanel = new JPanel();
        JLabel answer = new JLabel("Answer:");
        answerField = new JTextField(15);
        answerPanel.add(answer);
        answerPanel.add(answerField);
        JPanel btnPanel = new JPanel();
        submitAnswerBtn = new JButton("Submit Answer");
        submitAnswerBtn.addActionListener(this);
        submitAnswerBtn.setEnabled(false);
        btnPanel.add(submitAnswerBtn);

        panel.add(labelPanel);
        panel.add(questionPanel);
        panel.add(answerPanel);
        panel.add(btnPanel);

        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submitUsernameBtn) {
            usernameSubmitted();
        }
        else if(e.getSource() == submitAnswerBtn) {
            answerSubmitted();
        }
        else if(e.getSource() == playAgainBtn) {
            playAgainSubmitted();
        }
        else if(e.getSource() == newUserBtn) {
            newUserSubmitted();
        }
        else if(e.getSource() == exitBtn) {
            System.exit(0);
        }
    }


    public void playAgainSubmitted() {
        game = new Game(4);
        displayNextRiddle();
        scoreLabel.setText("/");
        answerField.setText("");
        submitAnswerBtn.setEnabled(true);
        playAgainBtn.setEnabled(false);
        newUserBtn.setEnabled(false);
    }

    public void newUserSubmitted() {
        usernameField.setText("");
        usernameField.grabFocus();
        scoreLabel.setText("/");
        answerField.setText("");
        submitUsernameBtn.setEnabled(true);
        playAgainBtn.setEnabled(false);
        newUserBtn.setEnabled(false);
    }

    public void usernameSubmitted() {
        String usernameFieldContent = usernameField.getText();
        if(usernameFieldContent.length() > 0) {
            username = usernameFieldContent;
            game = new Game(4);
            displayNextRiddle();
            submitUsernameBtn.setEnabled(false);
            submitAnswerBtn.setEnabled(true);
            // TODO: activate and deactivate buttons
        }
        else {
            System.out.println("Username is empty");
        }
    }

    public void displayNextRiddle() {
        String question = game.getNextQuestion();
        questionLabel.setText("<html><div style='width: 200px'>" + question + "</div></html>");
    }

    public void answerSubmitted() {
        String answerFieldContent = answerField.getText();
        if(answerFieldContent.length() > 0) {
            game.checkUserResponse(answerFieldContent);
            if(game.gameOver()) {
                int score = game.getScore();
                scoreLabel.setText(score + " / 4");
                game.saveScoreToDB(username);
                submitAnswerBtn.setEnabled(false);
                playAgainBtn.setEnabled(true);
                newUserBtn.setEnabled(true);
            }
            else {
                answerField.setText("");
                answerField.grabFocus();
                displayNextRiddle();
            }
        }
        else {
            System.out.println("Answer is empty");
        }
    }
}
