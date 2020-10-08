import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver 
{
	public static void main(String[] args) throws Exception
	{
		ArrayList<BibleBook> theBooks = new ArrayList<BibleBook>();
		Scanner input = new Scanner(new File(System.getProperty("user.dir") + "/src/data.dat"));
		while(input.hasNext())
		{
			theBooks.add(new BibleBook(input.nextLine()));
		}
		input.close();
		
		Driver.searchSummaries(theBooks);
	}
	
	static void searchSummaries(ArrayList<BibleBook> theBooks)
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a search term: ");
		String term = input.nextLine();
		//python: for aBook in theBooks
		for(BibleBook aBook : theBooks)
		{
			if(aBook.searchSummary(term))
			{
				System.out.println(aBook.getName());
				break;
			}
		}
	}
}
