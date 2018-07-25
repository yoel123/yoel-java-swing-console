package librery_manger;

public class main_menu {

	public static void do_comands(librery that) 
	{
		//back to screen at any tme
		if(that.yin.equals("exit")) {that.reset(); return;}

		//set that.op only if there is no that.op
		if(that.op ==0)
		{
			that.op = Integer.parseInt(that.yin);
		}

		//show all
		if( that.op==1)
		{
			that.show_all_books();
		}
		//borrow
		if( that.op==2)
		{
			that.borrow_book(true);
		}//end borrow

		//return book
		if( that.op==3)
		{
			that.borrow_book(false);
		}//end return book
		
		//add book
		if( that.op==4)
		{
			that.add_book();
		}//end add book
		
		//remove books
		if( that.op==5)
		{
			that.delete_book();
		}
		//end remove books
		
		//user mangment menu
		if(that.op == 6)
		{
			//show user menu only when op2 is 0 (meaning no item was selected from secondery menu
			if(that.op2==0) {that.user_mangment_menu();}
			that.do_commands_user_mangment();
		}
		//end user mangment menu
		
		//check single book
		if( that.op==7)
		{
			that.get_single_book_info();

		}//end //check single book

		if( that.op>8 || that.op<0){that.op=0;}//just in case somone typs an that.op bigger then what we have (or smaller)

	}//end do comands
}
