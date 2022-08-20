
/**
 * Library Class
 *
 * @author Louis Pike
 * 
 */

public class Library
{
    // instance variables 
    private TextBook[] bookShelf;
    private int NextBook = 0;
    private int Borrowers = 0; // 
    private int n = 0; //index variable for loop
    private int limit = 3; //fixed borrowing limit 
    private static int cardRefNum = 0; // for ordering cards sequentially
    private String cardReferenceNum; // to hold converted variable above
    private TextBook CurrentBook; // temp variable to hold current book before making spot null in array
    private static int BooksLeft = 0; //to count how many books the library has
    /**
     * Constructor for objects of class Library
     */
    public Library(int MaxBooks, String nameoftextbook, int chapters)
    {
        bookShelf = new TextBook[MaxBooks];
        while (n < MaxBooks) {
            bookShelf[n] = new TextBook((nameoftextbook + " " + n), chapters); //name of textbook + int to different names of books
            n = n+1; //next
        }
        BooksLeft = MaxBooks;
    }

    //Methods
    public LibraryCard issueCard()
    {
        Borrowers = (Borrowers + 1); //counts borrowers
        cardReferenceNum = Integer.toString(cardRefNum) + 1; //turns static variable to string so it can be input into library card. The +1 is so that the number doesn't start at 0
        cardRefNum = cardRefNum + 1; //adds one to the static variable - means next card issued is numbered sequentially
        return new LibraryCard((limit), cardReferenceNum); //creates librarycard
    }

    public TextBook borrowBook(LibraryCard card)
    {
        if (card.expired() == true){
            System.out.println("Library card is expired");  //error message for if card is expired
            return null;}
        else if (NextBook +1 > bookShelf.length) {
            System.out.println("No more books");   
            return null;
        }
        else if (bookShelf[NextBook] != null ){       
            CurrentBook = (bookShelf[NextBook]);
            bookShelf[NextBook] = null;
            NextBook = NextBook + 1;
            BooksLeft = BooksLeft - 1;
            card.swipe();
        }
        return CurrentBook;
    }

    public void returnBook(TextBook book, LibraryCard card)
    {
        book.closeBook();
        bookShelf[(NextBook -1)] = book;
        card.Borrowed = (card.Borrowed - 1); //asks for what library card book is borrowed to, so  it can decrease borrowed
        BooksLeft = BooksLeft + 1;

    }

    public void describe()
    {   
        System.out.println("The library has " + BooksLeft + " books left on the shelf and has issued " + cardRefNum + " library cards.");
    }
}

