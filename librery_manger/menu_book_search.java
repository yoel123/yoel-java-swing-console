package librery_manger;

public class menu_book_search {
	public static void do_comands(librery that) 
	{
		int iyin = that.get_input_num();
		
	
		
		//set op only if there is no op
		if(that.op2 ==0 && (iyin > 6 && iyin <12))//dont want to set that.op2 to 1 can only chose 7 and up
		{
			that.op2 = iyin;
		}

		if(that.op2 ==7)
		{
			that.get_single_book_info();
		}
		if(that.op2 ==8)
		{
			that.reset();
		}
		if(that.op2 ==9)
		{
			that.search_by_author();
		}
		//)search by user name"
		if(that.op2 ==10)
		{
			that.search_by_user();
		}
		if(that.op2 ==11)
		{
			that.reset();
		}	
		
		
	}//end do_comands
}
