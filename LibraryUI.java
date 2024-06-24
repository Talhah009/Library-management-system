import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class LibraryUI extends JFrame implements ActionListener {
    private JLabel label1, label2, label3, label4, label5, label6, label7;
    private JTextField textField1, textField2, textField3, textField4, textField5, textField6, textField7;
    private JButton addButton, viewButton, editButton, deleteButton, clearButton, exitButton;
    private JPanel panel;
    private Library library;

    public LibraryUI() {
        library = new Library();

        setTitle("Library Management System");
        setSize(600, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        label1 = new JLabel("Book ID");
        label2 = new JLabel("Book Title");
        label3 = new JLabel("Author");
        label4 = new JLabel("Publisher");
        label5 = new JLabel("Year of Publication");
        label6 = new JLabel("Grade");
        label7 = new JLabel("Number of Copies");

        textField1 = new JTextField(10);
        textField2 = new JTextField(20);
        textField3 = new JTextField(20);
        textField4 = new JTextField(20);
        textField5 = new JTextField(10);
        textField6 = new JTextField(20);
        textField7 = new JTextField(10);

        addButton = new JButton("Add");
        viewButton = new JButton("View");
        editButton = new JButton("Edit");
        deleteButton = new JButton("Delete");
        clearButton = new JButton("Clear");
        exitButton = new JButton("Exit");

        addButton.addActionListener(this);
        viewButton.addActionListener(this);
        editButton.addActionListener(this);
        deleteButton.addActionListener(this);
        clearButton.addActionListener(this);
        exitButton.addActionListener(this);

        panel = new JPanel(new GridLayout(10, 2));
        panel.add(label1);
        panel.add(textField1);
        panel.add(label2);
        panel.add(textField2);
        panel.add(label3);
        panel.add(textField3);
        panel.add(label4);
        panel.add(textField4);
        panel.add(label5);
        panel.add(textField5);
        panel.add(label6);
        panel.add(textField6);
        panel.add(label7);
        panel.add(textField7);
        panel.add(addButton);
        panel.add(viewButton);
        panel.add(editButton);
        panel.add(deleteButton);
        panel.add(clearButton);
        panel.add(exitButton);

        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String bookID = textField1.getText();
            String title = textField2.getText();
            String author = textField3.getText();
            String publisher = textField4.getText();
            String year = textField5.getText();
            String grade = textField6.getText();
            int numberOfCopies = Integer.parseInt(textField7.getText());

            Book book = new Book(bookID, title, author, publisher, year, grade, numberOfCopies);
            library.addBook(book);
            
            JOptionPane.showMessageDialog(this, "Book added successfully");
            clearFields();
        } else if (e.getSource() == viewButton) {
            ArrayList<Book> books = library.getBooks();
            String[] columns = {"Book ID", "Book Title", "Author", "Publisher", "Year of Publication", "Grade", "Number of Copies"};
            Object[][] data = new Object[books.size()][7];

            for (int i = 0; i < books.size(); i++) {
                Book book = books.get(i);
                data[i][0] = book.getBookID();
                data[i][1] = book.getTitle();
                data[i][2] = book.getAuthor();
                data[i][3] = book.getPublisher();
                data[i][4] = book.getYearOfPublication();
                data[i][5] = book.getGrade();
                data[i][6] = book.getNumberOfCopies();
            }

            JTable table = new JTable(data, columns);
            JScrollPane scrollPane = new JScrollPane(table);
            JFrame frame = new JFrame("View Books");
            frame.add(scrollPane);
            frame.setSize(800, 400);
            frame.setVisible(true);
        } else if (e.getSource() == editButton) {
            String bookID = JOptionPane.showInputDialog(this, "Enter book ID to edit:");
            Book book = library.findBookByID(bookID);
            if (book != null) {
                book.setTitle(textField2.getText());
                book.setAuthor(textField3.getText());
                book.setPublisher(textField4.getText());
                book.setYearOfPublication(textField5.getText());
                book.setGrade(textField6.getText());
                book.setNumberOfCopies(Integer.parseInt(textField7.getText()));

                JOptionPane.showMessageDialog(this, "Book edited successfully");
                clearFields();
            } else {
                JOptionPane.showMessageDialog(this, "Book not found");
            }
        } else if (e.getSource() == deleteButton) {
            String bookID = JOptionPane.showInputDialog(this, "Enter book ID to delete:");
            boolean removed = library.removeBook(bookID);
            if (removed) {
                JOptionPane.showMessageDialog(this, "Book deleted successfully");
                clearFields();
            } else {
                JOptionPane.showMessageDialog(this, "Book not found");
            }
        } else if (e.getSource() == clearButton) {
            clearFields();
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }

    private void clearFields() {
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
        textField4.setText("");
        textField5.setText("");
        textField6.setText("");
        textField7.setText("");
    }
}
