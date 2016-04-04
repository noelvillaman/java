package assignment1;

import java.util.*;

public class BookAuthorTest {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		Set<Books> books = new HashSet<Books>();
		
		Books book1 = new Books();
		book1.setName("Java in Bloom");
		book1.setPrice(12.34);
		book1.setQuantity(300);
		
		Author author1 = new Author();
		author1.setGender("Male");
		author1.setName("Noel Villaman");
		author1.setEmail("namalliv@hotmial.com");
		
		book1.setAuthor(author1);
		
		Books book2 = new Books();
		Author author2 = new Author();
		
		System.out.print("Enter the name of the book: ");
		book2.setName(in.next());
		
		System.out.print("Enter the price of the book: ");
		book2.setPrice(in.nextDouble());
		System.out.print("Enter the name of the author for "+ book2.getName());
		author2.setName(in.next());
		System.out.print("Enter the email of the author for "+ book2.getName());
		author2.setEmail(in.next());
		System.out.print("Enter the gender of the author for "+ book2.getName());
		author2.setGender(in.next());
		System.out.print("How many books of name " + book2.getName() +" do you have.");
		book2.setQuantity(in.nextInt());
		
		
		//Add books to the set to check for duplicates
		books.add(book1);
		books.add(book2);
		
		//System.out.print("The book: ");
		//System.out.println(book1.toString());
		
		//System.out.print("The Author: ");
		//System.out.println(author1.toString());
		
		String[][] bookList = new String[3][6];//Declare memory for multi-dimensional array
		
		//Add elements to the multi array
		bookList[0][0] = "Title\t";
		bookList[0][1] ="Price\t"; 
		bookList[0][2] ="AuthorName\t";
		bookList[0][3] ="Email\t";
		bookList[0][4] = "Gender\t";
		bookList[0][0] = "Qty";
		
		int i =1;
		
		for(Books temp: books){
			int j = 0;
			while(j < 6){
				if(j == 0){
					bookList[i][j] = temp.getName();
				}else if(j == 1){
					bookList[i][j] = ""+ temp.getPrice();
				}else if(j == 2){
					bookList[i][j] = temp.getAuthor().getName();
				}else if(j == 3){
					bookList[i][j] = temp.getAuthor().getEmail();
				}else if(j == 4){
					bookList[i][j] = temp.getAuthor().getEmail();
				}else if(j == 5){
					bookList[i][j] = "" + temp.getQuantity();
				}
				j++;
			}
			i++;
		}
		
		for(int x = 0; i < 3; i++){
			for(int j = 0; j < 6; j++){
				System.out.println(bookList[x][j]);
			}
		}
	}

}
