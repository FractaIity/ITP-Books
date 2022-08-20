
/**
 * TextBook Class
 *
 * @author Louis Pike
 * 
 */
public class TextBook
{
    // instance variables - book name + chapter length
    private String BookName;
    private int ChapterLength;
    private int LastChaptRead;

    /**
     * Constructor for objects of class TextBook
     */
    public TextBook(String nameoftextbook, int chapters)
    {
        // initialise instance variables 
        // name of text book
        // chapter length
        // last chapt read initialised to 0
        BookName = nameoftextbook;
        ChapterLength = chapters;
        LastChaptRead = 0;

    }

    //** methods //

    public String getTitle()
    {
        //Method to return book name
        return BookName;
    }

    public void ReadNextChapter()
    {
        //Adds 1 to last chapter read if it is smaller than chapter length
        //error if last chapter read is equal to chapt length
        if (LastChaptRead < ChapterLength) {
            LastChaptRead = (LastChaptRead + 1); }
        else { 
            System.out.println("Error! You have finished the book. Cannot Read another chapter"); }

    }

    public boolean isFinished()
    {
        return (ChapterLength == LastChaptRead);
    }

    public void closeBook()
    {
        LastChaptRead = 0;
    }

    public void describe()
    {
        System.out.println(BookName + " with " + (ChapterLength - LastChaptRead) + " chapters left to read.");
    }
}
