public class Book {
    private String bookID;
    private String title;
    private String author;
    private String publisher;
    private String yearOfPublication;
    private String grade;
    private int numberOfCopies;

    public Book(String bookID, String title, String author, String publisher, String yearOfPublication, String grade, int numberOfCopies) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.yearOfPublication = yearOfPublication;
        this.grade = grade;
        this.numberOfCopies = numberOfCopies;
    }

    public String getBookID() {
        return bookID;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getYearOfPublication() {
        return yearOfPublication;
    }

    public String getGrade() {
        return grade;
    }

    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setYearOfPublication(String yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setNumberOfCopies(int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }
}
