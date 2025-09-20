package pckg;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;

public class Layout extends JFrame {

    public Layout() {
        setTitle("Library App");
        setSize(500,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

      
        JPanel bookshelfPanel = new JPanel();
        bookshelfPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 150)); 
  

        // -------- Buttons --------
        //--leave alone:--
        JButton button2 = new JButton("Exit");
        button2.addActionListener(e -> System.exit(0));
        // Create button
        JButton button1 = new JButton("Print first 10 books");
        JButton button3 = new JButton("Sort Books");
        JButton button4 = new JButton("Book Search");

        //Button actions:
        button1.addActionListener(e -> {
            JFrame listFrame = new JFrame("Top 10 Books");
            listFrame.setSize(400, 300);
            listFrame.setLocationRelativeTo(null);
            listFrame.setLayout(null);

            JTextArea textArea = new JTextArea();
            textArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setBounds(20, 20, 350, 220);
            listFrame.add(scrollPane);

            // Print the first 10 books
            int count = 0;
            for (Book book : Main.list) {
                textArea.append((count + 1) + ". " + book.authors + " - " + book.title + "\n");
                count++;
                if (count >= 10) break; // Only top 10
            }

            listFrame.setVisible(true);

            Timer timer = new Timer(300_000, ev -> listFrame.dispose());
            timer.setRepeats(false);
            timer.start();
        });
        button4.addActionListener(e -> { // Book Search button
            JFrame listFrame = new JFrame("Book Search");
            listFrame.setSize(400, 300);
            listFrame.setLocationRelativeTo(null);
            listFrame.setLayout(null);

            JLabel label = new JLabel("Enter Book ID or ISBN:");
            label.setBounds(30, 20, 200, 30);
            listFrame.add(label);

            JTextField searchField = new JTextField();
            searchField.setBounds(200, 20, 150, 30);
            listFrame.add(searchField);

            JButton searchButton = new JButton("Search");
            searchButton.setBounds(150, 60, 100, 30);
            listFrame.add(searchButton);

            JTextArea textArea = new JTextArea();
            textArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setBounds(30, 100, 320, 150);
            listFrame.add(scrollPane);

            searchButton.addActionListener(ev -> {
                String input = searchField.getText().trim();
                if (input.isEmpty()) {
                    JOptionPane.showMessageDialog(listFrame, "Please enter a Book ID or ISBN.");
                    return;
                }

                Book foundBook = null;

                try {
                    int bookId = Integer.parseInt(input);
                    
                    ArrayList<Book> convertedList = new ArrayList<Book>(Main.list);
                    
                    foundBook = Search.byID(convertedList, bookId);
                } catch (NumberFormatException nfe1) {
                    try {
                        String isbn = input;
                        ArrayList<Book> convertedList = new ArrayList<Book>(Main.list);
                        
                        foundBook = Search.byISBN(convertedList, isbn);
                    } catch (NumberFormatException nfe2) {
                        textArea.setText("Invalid input. Enter a number for Book ID or ISBN.");
                        return;
                    }
                }

                if (foundBook != null) {
                    textArea.setText("Found: " + foundBook.title + " by " + foundBook.authors +
                                    "\nBook ID: " + foundBook.bookID +
                                    "\nISBN: " + foundBook.isbn);
                } else {
                    textArea.setText("Book not found.");
                }
            });

            listFrame.setVisible(true);
        });
        button3.addActionListener(e -> {
            JFrame newFrame = new JFrame("Sort");
            newFrame.setSize(400, 300);
            newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            newFrame.setLocationRelativeTo(null);

            JPanel panel = new JPanel();
            panel.setLayout(null);

            JLabel newLabel = new JLabel("How do you want to sort:");
            newLabel.setBounds(50, 10, 500, 30);
            panel.add(newLabel);

            JButton button5 = new JButton("Sort by Author Ascending");
            button5.setBounds(50, 50, 200, 30);
            panel.add(button5);

                button5.addActionListener(e2 -> {
                    JFrame listFrame = new JFrame("Sorted List");
                    listFrame.setSize(300, 400);
                    listFrame.setLocationRelativeTo(null);

                    JTextArea textArea = new JTextArea();
                    textArea.setEditable(false);

                    List<Book> sortedList = Sort.alphabeticallyAscending(Main.list);

                    // Print the sorted list to the text area
                    for (Book book : sortedList) {
                        textArea.append(book.authors + " - " + book.title + "\n"); 
                    }

                    listFrame.add(new JScrollPane(textArea));
                    listFrame.setVisible(true);

                    // Timer to close after a few seconds
                    Timer timer = new Timer(2000, ev -> listFrame.dispose());
                    timer.setRepeats(false);
                    timer.start();
                });
            
            JButton button6 = new JButton("Sort by Author Descending");
            button6.setBounds(50, 100, 200, 30);
            panel.add(button6);

                button6.addActionListener(e3 -> {

                    JFrame listFrame = new JFrame("Sorted List");
                    listFrame.setSize(300, 400);
                    listFrame.setLocationRelativeTo(null);

                    JTextArea textArea = new JTextArea();
                    textArea.setEditable(false);

                    List<Book> sortedList = Sort.alphabeticallyDescending(Main.list);

                    // Print the sorted list to the text area
                    for (Book book : sortedList) {
                        textArea.append(book.authors + " - " + book.title + "\n"); 
                    }

                    listFrame.add(new JScrollPane(textArea));
                    listFrame.setVisible(true);

                    // Timer to close after a few seconds
                    Timer timer = new Timer(2000, ev -> listFrame.dispose());
                    timer.setRepeats(false);
                    timer.start();
                });
            JButton button7 = new JButton("Sort by ISBN Ascending");
            button7.setBounds(50, 150, 200, 30);
            panel.add(button7);

            // commented out until isbnAscending is implemented
//                button7.addActionListener(e4 -> {
//                    JFrame listFrame = new JFrame("Sorted List");
//                    listFrame.setSize(300, 400);
//                    listFrame.setLocationRelativeTo(null);
//
//                    JTextArea textArea = new JTextArea();
//                    textArea.setEditable(false);
//
//                    sort sorter = new sort();
//                    sorter.isbnAscending();
//
//                    // Print the sorted list to the text area
//                    for (BookReader book : BookReader.booksList) {
//                        textArea.append(book.isbn + " - " + book.title + "\n"); 
//                    }
//
//                    listFrame.add(new JScrollPane(textArea));
//                    listFrame.setVisible(true);
//
//                    // Timer to close after a few seconds
//                    Timer timer = new Timer(2000, ev -> listFrame.dispose());
//                    timer.setRepeats(false);
//                    timer.start();
//                });
            JButton button8 = new JButton("Sort by ISBN Descending");
            button8.setBounds(50, 200, 200, 30);
            panel.add(button8);

//                button8.addActionListener(e5 -> {
//                    JFrame listFrame = new JFrame("Sorted List");
//                    listFrame.setSize(300, 400);
//                    listFrame.setLocationRelativeTo(null);
//
//                    JTextArea textArea = new JTextArea();
//                    textArea.setEditable(false);
//
//                    sort sorter = new sort();
//                    sorter.isbnDescending();
//
//                    // Print the sorted list to the text area
//                    for (BookReader book : BookReader.booksList) {
//                        textArea.append(book.isbn + " - " + book.title + "\n"); 
//                    }
//
//                    listFrame.add(new JScrollPane(textArea));
//                    listFrame.setVisible(true);
//
//                    // Timer to close after a few seconds
//                    Timer timer = new Timer(2000, ev -> listFrame.dispose());
//                    timer.setRepeats(false);
//                    timer.start();
//                });

            newFrame.add(panel);
            newFrame.setVisible(true);
        });
        // Disable layout manager so we can set coordinates manually
        bookshelfPanel.setLayout(null);


        int shelfHeight = 40;
        int shelfIndex = 2;
        int buttonWidth = 200;
        int buttonHeight = 30;
        int xPos = 50; // horizontal 
        int yPos = shelfIndex * shelfHeight + (shelfHeight - buttonHeight)/2; 
        button1.setBounds(xPos, yPos, 160, buttonHeight);
        button2.setBounds(290, yPos, 80, buttonHeight);
        button3.setBounds(xPos, 245, 120, buttonHeight);
        button4.setBounds(290, 245, 130, buttonHeight);

        bookshelfPanel.add(button1);
        bookshelfPanel.add(button2);
        bookshelfPanel.add(button3);
        bookshelfPanel.add(button4);
        add(bookshelfPanel, BorderLayout.CENTER);
        setVisible(true);
    }
}
