package librery_manger;

public class book {

	public String title,id;
	public String author;
	public String publisher;
	public String publicationYear;
	public String status;
	public String category;
	public String borrower;
	public String borrowDate;
	public String returnDate;
	public boolean is_avilble = true;
	
	
	
	public book(String id2,String title2,String author2,String category2) 
	{
		title = title2;
		author = author2;
		category = category2;
		id = id2;
	}//end constructor
	public book() 
	{
		
	}


	public String displayBook(){
		 
		String BookInfo = " ------------id: "+id+"----------------"+
						//"\nid:.................."+id+
						"\n Title:.................."+title+
						"\n Author:................."+author+
						"\n Publisher:.............."+publisher+ 
						"\n PublicationYear:........"+publicationYear+
						"\n Status:................."+status+
						"\n Borrower:..............."+borrower+
						"\n Date Borrowed:.........."+borrowDate+
						"\n Return date:............"+returnDate+
						"\n ----------------------------";
		return BookInfo;	
	}
	
}//end book
