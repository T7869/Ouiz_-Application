JButton deleteUserButton = new JButton("Delete User");
deleteUserButton.setBounds(250, 350, 150, 30);
frame.add(deleteUserButton);

deleteUserButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String usernameToDelete = JOptionPane.showInputDialog(frame, "Enter the username to delete:");
        if (usernameToDelete != null && !usernameToDelete.isEmpty()) {
            if (registeredUsers.containsKey(usernameToDelete)) {
                registeredUsers.remove(usernameToDelete);
                JOptionPane.showMessageDialog(frame, "User deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "User not found.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Please provide a username.", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }
});


