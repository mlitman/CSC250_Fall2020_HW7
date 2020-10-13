import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver 
{
	public static void main(String[] args)
	{
		BibleBookCollection theNewTestament = new BibleBookCollection("data.dat");
		//theNewTestament.display();
		theNewTestament.bubbleSortOnBookName();
		theNewTestament.display();
		
	}
}
