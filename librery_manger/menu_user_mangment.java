package librery_manger;

public class menu_user_mangment {
	public static void do_comands(librery that) 
	{
		int iyin = that.get_input_num();
		
	
		
		//set op only if there is no op
		if(that.op2 ==0 && (iyin > 11 && iyin <17))//dont want to set op2 to 1
		{
			that.op2 = iyin;
		}
		
		//get all users
		if(that.op2 ==12)
		{
			that.show_all_users();
		}
		
		//add user
		if(that.op2 ==13)
		{
			that.add_user();
		}//end add user
		
		//Delete user
		if(that.op2 ==14)
		{
			that.remove_user();
		}//end //Delete user
		//get single user
		if(that.op2 ==15){}//end get single user
		
		//back to main menu
		if(that.op2 ==16)
		{
			that.reset();
		}
		
		
	}//end do_comands
}
