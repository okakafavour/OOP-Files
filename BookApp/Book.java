package BookApp;

public class Book {
    private String title;
    private String yearOfPublication;
    private String author;

    public Book(String title, String yearOfPublication, String author) {
        this.title = title;
        this.yearOfPublication = yearOfPublication;
        this.author = author;
        Validation();
    }

    public void Validation(){
        validateTitle();
        validateYearOfPublication();
        validateAuthor();
    }

    public boolean validateTitle(){
        boolean isInvalid = title.trim().isEmpty();
        if(isInvalid){throw new IllegalArgumentException("Invalid title");}
        return true;
    }

    public boolean validateYearOfPublication(){
        boolean isInvalid = yearOfPublication.trim().isEmpty();
        if(isInvalid){throw new IllegalArgumentException("Invalid year of publication");}
        return true;
    }

    public boolean validateAuthor(){
        boolean isInvalid = author.trim().isEmpty();
        if(isInvalid){throw new IllegalArgumentException("Invalid author");}
        return true;
    }

    public String getTitle(){
        return title;
    }

    public String getYearOfPublication(){
        validateYearOfPublication();
        return yearOfPublication;
    }

    public String getAuthor(){
        validateAuthor();
        return author;
    }

    public String createEachBook(){
        Validation();
        return createBook();
    }
    public String createBook(){
        Validation();
        return "Author: " + author + "\nTitle: " + title + "\nYear of Publication: " + yearOfPublication;
    }
}
