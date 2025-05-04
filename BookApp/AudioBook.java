package BookApp;

public class AudioBook extends Book {
    private int bookSize;
    private int playLengthSize;
    private String playArtistName;

    public AudioBook(String title, String yearOfPublishing, String author, int bookSize, int playLengthSize, String playArtistName) {
        super(title, yearOfPublishing, author);
        this.bookSize = bookSize;
        this.playLengthSize = playLengthSize;
        this.playArtistName = playArtistName;
        Validation();
    }

    public void Validation(){
        validateBookSize(bookSize);
        validatePlayLengthSize(playLengthSize);
        validatePlayArtistName(playArtistName);

    }

    private boolean validatePlayArtistName(String playArtistName) {
        boolean isInvalid = playArtistName.isEmpty();
        if(isInvalid){throw new IllegalArgumentException("Invalid play artist name");}
        return true;
    }

    private boolean validatePlayLengthSize(int playLengthSize) {
        boolean isInvalid = playLengthSize <= 0;
        if(isInvalid){throw new IllegalArgumentException("playLengthSize must be greater than 0");}
        return true;
    }

    private boolean validateBookSize(int bookSize) {
        boolean isInvalid = bookSize < 0;
        if (isInvalid) {throw new IllegalArgumentException("Invalid book size");}
        return true;
    }

    public int getBookSize() {
        validateBookSize(bookSize);
        return bookSize;
    }

    public int getPlayLengthSize() {
        validatePlayLengthSize(playLengthSize);
        return playLengthSize;
    }

    public String getPlayArtistName() {
        validatePlayArtistName(playArtistName);
        return playArtistName;
    }

    @Override
    public String createBook(){
        Validation();
        return super.createBook() + "Book Size: " + bookSize + "\nPlay Length: " + playLengthSize + "\nPlay Artist: " + playArtistName;
    }
}
