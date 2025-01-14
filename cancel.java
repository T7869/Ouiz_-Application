public class QuizManager {
    private boolean isQuizActive = false;

    public void startQuiz() {
        isQuizActive = true;
        // Logic to start the quiz
    }

    public void cancelQuiz() {
        if (isQuizActive) {
            isQuizActive = false;
            // Logic to cancel the quiz, such as stopping timers or clearing data
            JOptionPane.showMessageDialog(null, "Quiz has been canceled.");
        } else {
            JOptionPane.showMessageDialog(null, "No active quiz to cancel.");
        }
    }

    public void showModeratorInterface() {
        JFrame moderatorFrame = new JFrame("Moderator Interface");
        moderatorFrame.setSize(500, 400);
        moderatorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        moderatorFrame.setLayout(null);

        JButton cancelQuizButton = new JButton("Cancel Quiz");
        cancelQuizButton.setBounds(150, 150, 200, 50);
        cancelQuizButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelQuiz();
            }
        });

        moderatorFrame.add(cancelQuizButton);
        moderatorFrame.setVisible(true);
    }

    public void showCorporateModeratorInterface() {
        // Similar implementation as Moderator Interface with Cancel Quiz feature
    }

    public void showStudentInterface() {
        // Student-specific interface logic
    }
}
