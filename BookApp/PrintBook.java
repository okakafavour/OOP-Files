package BookApp;

public class PrintBook extends Book{
    private String publisher;
    private String ISBN;

    public PrintBook(String title, String author, String yearOfPublishing, String publisher, String ISBN) {
        super(title, author, yearOfPublishing);
    }

    public void Validation(){
       validatePublisher(publisher);
       validateISBN(ISBN);

    }
    public boolean validatePublisher(String publisher){
        boolean isInvalid = publisher.trim().isEmpty();
        if(isInvalid){throw new IllegalArgumentException("Invalid publisher");}
        return true;
    }

    public boolean validateISBN(String ISBN){
        boolean isInvalid = ISBN.trim().isEmpty();
        if(isInvalid){throw new IllegalArgumentException("Invalid ISBN");}
        return true;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getISBN() {
        return ISBN;
    }
    
    @Override
    public String createBook() {
        return super.createBook() + "Publisher name: " + publisher + "\nISBN: " + ISBN;
    }
}
