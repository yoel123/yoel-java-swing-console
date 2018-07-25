package librery_manger;

import java.util.ArrayList;

public class user {

	public String name,user_id;
	public String last_name;
	public ArrayList<book> books;
	public int max_books=3,books_count=0;
	public boolean can_brrow=true;

	public user(String name2,String user_id2) {
		super();
		books = new ArrayList<book>();
		name = name2;
		user_id = user_id2;
	}//end constructor
	public user(String user_id2,String name2,String last_name2) 
	{
		books = new ArrayList<book>();
		name = name2;
		last_name = last_name2;
		user_id = user_id2;
	}//end constructor
	
	public boolean borrow(book b) 
	{
		if(!can_brrow) {return false;}//if cant borrow exit
		b.borrower = name;
		b.status = "borrowed";
		b.borrowDate ="00,00,00";
		b.returnDate = "30,00,00";//add 30 days from borrow time
		b.is_avilble = false;
		books.add(b);
		books_count++;
		chack_borrow_limit();
		books_to_console() ;
		return true;
		
	}//end borrow
	
	public void return_book(book b) 
	{
		book book_to_remove;
		b.status = "returnd";
		b.borrowDate = null;
		b.returnDate = null;
		b.is_avilble = true;
		books_count--;
		//remove from arraylist
		books.remove(b);
		books_to_console() ;
		/*for(book b2 : books) 
		{
			if(b==b2) 
			{
				//books.remove(b2);
			}
		}*/
		
		
		chack_borrow_limit();
	}//end return_book
	
	public void chack_borrow_limit() 
	{
		if(books_count<0) {books_count=0;}//cant go below 0
		
		if(books_count>max_books) {can_brrow=false;}
	}//end chack_borrow_limit
	
	public void books_to_console() 
	{
		System.out.print("user"+name+" books: \\n");
		for(book b2 : books) 
		{
			System.out.print(b2.title);
			System.out.print(" \n");
		}
		System.out.print("\n");
	}//end books_to_console
	
	public String display_user() 
	{
		String books_names,user_info;
		
		//create book list titles
		books_names="";
		
		for(book b2 : books) 
		{
			books_names +=" "+b2.title+",";
		}
		
		 user_info = " ------------id: "+user_id+"----------------"+
				"\n name:.................."+name+
				"\n last name:.................."+last_name+
				"\n can_brrow:.................."+can_brrow+
				"\n books_count:.................."+books_count+
				"\n books names:"+books_names+
				"\n ----------------------------";
		
		return user_info;
	}
}//end user
