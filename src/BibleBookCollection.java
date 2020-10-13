import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class BibleBookCollection 
{
	private ArrayList<BibleBook> theBooks;
	
	public BibleBookCollection()
	{
		this.theBooks = new ArrayList<BibleBook>();
	}
	
	public BibleBookCollection(String filename)
	{
		this();
		try
		{
			Scanner input = new Scanner(new File(System.getProperty("user.dir") + "/src/" + filename));
			while(input.hasNext())
			{
				this.theBooks.add(new BibleBook(input.nextLine()));
			}
			input.close();
		}
		catch(Exception e) { e.printStackTrace();}
	}
	
	//sort theBooks on chapter count from smallest to largest
	public void bubbleSortOnNumberOfChapters()
	{
		BibleBook temp;
		int numberOfSwaps = -1;
		while(numberOfSwaps != 0)
		{
			numberOfSwaps = 0;
			for(int i = 0; i < this.theBooks.size()-1; i++)
			{
				//should we swap bucket i with bucket i + 1?
				if(this.theBooks.get(i).getNumber_of_chapters() > this.theBooks.get(i+1).getNumber_of_chapters())
				{
					temp = this.theBooks.get(i);
					this.theBooks.set(i, this.theBooks.get(i+1));
					this.theBooks.set(i+1, temp);
					numberOfSwaps++;
				}
			}
		}
	}
	
	//sort theBooks on chapter count from smallest to largest
	public void bubbleSortOnBookName()
	{
		BibleBook temp;
		int numberOfSwaps = -1;
		while(numberOfSwaps != 0)
		{
			numberOfSwaps = 0;
			for(int i = 0; i < this.theBooks.size()-1; i++)
			{
				//should we swap bucket i with bucket i + 1?
				if(this.theBooks.get(i).getName().compareTo(this.theBooks.get(i+1).getName()) > 0)
				{
					temp = this.theBooks.get(i);
					this.theBooks.set(i, this.theBooks.get(i+1));
					this.theBooks.set(i+1, temp);
					numberOfSwaps++;
				}
			}
		}
	}
	
	public void display()
	{
		for(BibleBook b : this.theBooks)
		{
			b.display();
		}
	}
	
	public void addBibleBook(BibleBook b)
	{
		this.theBooks.add(b);
	}
	
	public void addBibleBook(String colonDelimitedData)
	{
		this.theBooks.add(new BibleBook(colonDelimitedData));
	}
	
	public BibleBook getFirstBookGivenSearchTerm(String term) throws Exception
	{
		for(BibleBook aBook : this.theBooks)
		{
			if(aBook.searchSummary(term))
			{
				return aBook;
			}
		}
		throw new Exception("Term not found exception");
	}
}
