package librery_manger;

import java.util.ArrayList;

import yconsole.yconsole_action;

public class librery extends yconsole_action {

	static ArrayList<user> UserList = new ArrayList<user>();
	static ArrayList<book> BookList = new ArrayList<book>();
	public book b;//book holder for diffrent operations
	public user u;

public int op2=0;//for sub menu

public librery() {
	super();
	UserList = new ArrayList<user>();
	BookList = new ArrayList<book>();
	test_books() ;
}//end constructor

public void test_books() 
{
	BookList = new ArrayList<book>();
	BookList.add(new book("1","book1","some name","some cat"));
	BookList.add(new book("2","book21","some name2","some cat"));
	BookList.add(new book("3","book213","some name","some cat"));

	UserList = new ArrayList<user>();
	UserList.add(new user("jon doe","1"));
}

@Override
public void yinit() {

	super.yinit();
}//end yinit

public void load() {}//end load
public void save() {}//end load

@Override
public void do_commands() //used in parent class
{
	main_menu.do_comands(this);

}//end do_commands

public void do_commands_user_mangment() //used in main_menu class
{
	menu_user_mangment.do_comands(this);

	
}//end do_commands_user_mangment

public void do_commands_book_search() //used in show_all_books() method
{
	menu_book_search.do_comands(this);
}

@Override
public void menu() 
{
	ycf.o("");
	ycf.o("1)show all books");
	ycf.o("2)borrow book");
	ycf.o("3)return book");
	ycf.o("4)add book");
	ycf.o("5)delete book");
	ycf.o("6)user_mangment");
	ycf.o("7)get single book");
	ycf.o("");
}//end menu

public void books_search_menu() 
{	
	ycf.o("");
	ycf.o("7)search by name");
	ycf.o("8)search by cat (unimplemented)");
	ycf.o("9)search by author");
	ycf.o("10)search by user name");
	ycf.o("11)return to main menu");
}

public void user_mangment_menu() 
{

	ycf.o("");
	ycf.o("12)show all users");
	ycf.o("13)add user");
	ycf.o("14)remove user");
	ycf.o("15)get single user");
	ycf.o("16)return to main menu \n");

}//end user_mangment_menu

public void show_all_books() 
{
	book b;
	ycf.o("-------------------------all books-----------------------");
	for (int i = 0; i < BookList.size(); i++)
	{
		b = BookList.get(i);
		String binfo = b.displayBook();
		ycf.o(binfo);
	}
	ycf.o("-------------------------end all books-----------------------");

	//sub menu
	books_search_menu();
	do_commands_book_search();
	//reset();
}//end show_all_books
public void borrow_book(boolean borrow) 
{
	if(yi==0) 
	{
		ycf.o("book name:\n");
		yi++;
		return;
	}

	if(yi==1) 
	{
		b = search_by_title(yin); 
		if(b !=null && (b.is_avilble || !borrow) ) 
			//if book not null and is avilble or not borowing (simple truth table)
			//basicly always chack if thers a book then check either its avilble or
			//not borrowing (meaning its for returning a book in that case it dosnt
			//matter if its avilble or not so false or true=true)
		{
			ycf.o("book found and avilble please enter user name: \n");
		}
		else 
		{
			ycf.o("no such book in librery or not avilable");
			reset();
			return;
		}
		yi++;
		return;	
	}//end yi==1

	//get user
	if(yi==2) 
	{
		if(yin.equals("exit")) {reset();}
		
		if(borrow)
		{
			user_borrow();
		}else 
		{
			yser_return_book();
		}
	}//end get user

}//end borrow_book

//main menu methods
public void yser_return_book() 
{
	user u = search_user(yin);
	//if current book and user is not null and user can borrow
	if(b !=null && u !=null) 
	{
		u.return_book(b);
		ycf.o(u.name+" returnd: "+b.title);
		reset();
	}
}//end show_all


public void get_single_book_info() 
{
	if(yi==0)
	{
		ycf.o("input book name or id:");
		yi++;
		return;
	}
	if(yi==1)
	{
		book b = search_by_title(yin);
		if(b !=null) 
		{
			String binfo = b.displayBook();
			ycf.o(binfo);
		}else 
		{
			ycf.o("*********book not found*********");
		}

		reset();
	}
}//end get_single_book_info
public void add_book() 
{

	if(yi==0)
	{
		b = new book();
		//get last book id and increment it
		int new_id = Integer.parseInt(BookList.get(BookList.size()-1).id)+1;
		b.id = Integer.toString(new_id);
		
		ycf.o("book title:");
		yi++;
		return;
	}
	if(yi==1)
	{
		b.title = yin;
		ycf.o(yin);
		ycf.o("\n author:");
		yi++;
		return;
	}
	if(yi==2)
	{
		b.author = yin;
		ycf.o(yin);
		ycf.o("\n publisher:");
		yi++;
		return;
	}
	if(yi==3)
	{
		b.publisher = yin;
		ycf.o(yin);
		ycf.o("\n publication year:");
		yi++;
		return;
	}
	
	if(yi==4)
	{
		b.publicationYear = yin;
		ycf.o(yin);
		ycf.o("\n done");
		BookList.add(b);
		reset();
		return;
	}
}//end add_book
public void delete_book() 
{
	if(yi==0)
	{
		ycf.o("book name or id:");
		yi++;
		return;
		
	}
	
	if(yi==1)
	{
		b = search_by_title(yin); 
		if( b !=null)
		{
			remove_book(b);
		}else 
		{
			ycf.o("no such book");
		}
		reset();
	}
	
	
	
}//end delete_book
public void user_mangment() {}//end delete_book

/////////search book menu methods/////////
public void search_by_author() 
{
	if(yi==0) 
	{
		ycf.o("author name:");
		yi++;
		return;
	}
	
	if(yi==1) 
	{
		ArrayList<book> bauthor = search_by_author(yin); 
		if( bauthor.size()>0)
		{
			ycf.o("\n-------books by: "+yin+"-----------\n");
			for(book b2 : bauthor) 
			{
				
				ycf.o(b2.displayBook());
				
			}//end loop
			ycf.o("-------end books by: "+yin+"-----------\n");
		}else 
		{
			ycf.o("*********no such books*************");
		}
		reset();
	}
}//end search_by_author

public void search_by_user() 
{
	if(yi==0) 
	{
		ycf.o("user name:");
		yi++;
		return;
	}
	//get user books
	if(yi==1) 
	{
		user u = search_user(yin);
		ycf.o("\n----------books of user: "+u.name+"------------");
		for(book b2 : u.books) 
		{
			ycf.o(b2.displayBook());
		}
		ycf.o("\n----------end books of user: "+u.name+"------------");
		reset();
	}
}//end search_by_user

/////////////end search book menu methods//////////////

/////////user mangment menu/////////
public void show_all_users() 
{
	ycf.o(" ------------all users----------------");
	for(user u2 : UserList) 
	{
		ycf.o(u2.display_user());
	}
	ycf.o(" ------------end all users----------------");
	reset();
}//end show_all_users

public void add_user()
{
	
	if(yi==0) 
	{
		u = new user("","");
		ycf.o("new user name:\n");
		yi++;
		return;
	}
	
	if(yi==1) 
	{
		ycf.o(yin+"\n");
		u.name = yin;
		ycf.o("new user last name:\n");
		yi++;
		return;
	}
	
	if(yi==2) 
	{
		ycf.o(yin+"\n");
		u.last_name = yin;
		
		int new_id = Integer.parseInt(UserList.get(UserList.size()-1).user_id)+1;
		u.user_id = Integer.toString(new_id);
		UserList.add(u);
		ycf.o("add user: "+u.name+" "+u.last_name);
		reset();
	}
}//end add_user

public void remove_user()
{
	user u = new user("","");
	String name_or_id;
	if(yi==0) 
	{
		
		ycf.o("user name or id to deleate:\n");
		yi++;
		return;
	}
	
	if(yi==1) 
	{
		
		name_or_id = yin;
		
		//search for user
		for(user u2 : UserList) 
		{
			if(u2.name.equals(name_or_id) || u2.user_id.equals(name_or_id)) 
			{
				u=u2;
			}
		}
		
		if(!u.name.equals("")) 
		{
		   ycf.o("user "+u.name+" was removed");
		   UserList.remove(u);
		   reset();
		}
		else 
		{
			ycf.o("no such user");
			reset();
		}
		
	}
	
}//end remove_user
public void get_single_user() {}//end get_single_user
/////////end user mangment menu/////////

//borrow_book methods
public void user_borrow() 
{
	user u = search_user(yin);

	//if current book and user is not null and user can borrow
	if(b !=null && u !=null && u.can_brrow) 
	{
		if(u.borrow(b)) 
		{
			ycf.o(u.name+" borrowed: "+b.title);
			reset();
		}
	}
	else 
	{
		ycf.o(u.name+"couldnt borrowed: "+b.title);
		reset();
	}
}//end user_borrow


//////utils//////
public void user_select() {}//end user_select

public book search_by_title(String title) 
{
	for(book b : BookList) {
		//search by title or id
		if (b.title.equals(title) ||b.id.equals(title)) 
		{
			return b;
		}
	}//end loop
	return null;
}//search_by_title

public ArrayList<book> search_by_author(String author) 
{
	//books araylist
	ArrayList<book> bauthor = new ArrayList<book>();
	for(book b2 : BookList) {
		if (b2.author.equals(author)) 
		{
			bauthor.add(b2);
		}
	}//end loop
	return bauthor;
}//end search_by_author

public book search_by_cat(String category2) 
{
	for(book b : BookList) {
		if (b.category.equals(category2)) 
		{
			return b;
		}
	}//end loop
	return null;
}//end search_by_cat


public user search_user(String name) 
{
	for(user u : UserList) {
		//if name or id match we found the user return him
		if (u.name.equals(name) || u.user_id.equals(name)) 
		{
			return u;
		}
	}//end loop
	return null;
}//end search_user

public void remove_book(book b2) 
{
	//get book info before delete
	String binfo = b2.displayBook();
	//delete from arraylist
	BookList.remove(b2);
	//display book info
	ycf.o("removed:\n"+binfo);
}//end remove_book

public int get_input_num() 
{
	int iyin;
	
	//check if input is numbers
	if(yin.matches(".*\\d+.*")) {
	   iyin = Integer.parseInt(yin);
	}else 
	{
		iyin = 000;//if its not a number put random val
	}
	
	return iyin;
}

@Override
public void reset() {
	op2=0;//reset sub menus
	b=null;//reset current book
		super.reset();
	}//end reset





}
