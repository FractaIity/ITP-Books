
/**
 * Write a description of class LibraryCard here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LibraryCard
{
    // instance variables - replace the example below with your own
    private int BookLimit;
    public int Borrowed; ////made borrowed a public int so i could decrease it in library class method when returning a book
    private String CardRef;

    /**
     * Constructor for objects of class LibraryCard
     */
    public LibraryCard(int limit, String referenceNUM)
    {
        // initialise instance variables
        BookLimit = limit;
        Borrowed = 0;
        CardRef = ("cardID " + referenceNUM); 
    }

    //methods
    public void swipe()
    {
        if (Borrowed < BookLimit) {
            Borrowed = (Borrowed + 1); }
        else { 
            System.out.println("Error! Book limit reached. Cannot borrow anymore books"); }
    }

    public boolean expired()
    {
        return (BookLimit == Borrowed);
    }

    public String getCardRef()
    {
        return CardRef;   
    }

    public void describe()
    {
        System.out.println("Library card " + CardRef + " with " + (BookLimit - Borrowed) + " books left");   
    }
}
