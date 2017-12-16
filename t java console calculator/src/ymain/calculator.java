package ymain;

import yconsole.yconsole_action;

public class calculator extends yconsole_action {


	public double result,x,y;

	
	
	@Override
	public void yinit() 
	{
		 menu();
		
	}//end yinit

	@Override
	public void do_commands() 
	{
		//back to screen at any time
		if(yin.equals("exit")) {reset(); return;}
		
		//set op only if there is no op
		if(op ==0 )
		{
		  op = Integer.parseInt(yin);
		}
		
		//can only be 5 or less
		if(op>5 && op>=1) 
		{
			
			op =0;
			return;
		}
		
		//plus
		if( op==1)
		{
			if(has_nums()) 
			{
				result = x+y;
				ycf.o(x+" + "+y+"="+result);
				
				reset();
				 return;
			}
		
		}//end plus
		
		//minus
		if( op==2)
		{
			if(has_nums()) 
			{
				result = x-y;
				ycf.o(x+" - "+y+"="+result);
				
				reset();
				 return;
			}
		}//end minus
		
		//multiply
		if(op==3)
		{
			if(has_nums()) 
			{
				result = x*y;
				ycf.o(x+" x "+y+"="+result);
				
				reset();
				 return;
			}
		}//end multiply
		
		//Divide
		if(op==4)
		{
			if(has_nums()) 
			{
				result = x/y;
				ycf.o(x+" : "+y+"="+result);
				
				reset();
				 return;
			}
		}//end Divide
		
		if(op==5){ycf.console_s =""; reset();}
		
	
		
	}//end do_commands
	
	public void menu() 
	{
		ycf.o("");
		ycf.o("1)plus +");
		ycf.o("2)minus -");
		ycf.o("3)multiply *");
		ycf.o("4)divide /");
		ycf.o("5)clear");
		ycf.o("");
	}//end menu
	

	
	public boolean has_nums() 
	{
		if(yi ==0) 
		{
			ycf.o("select first num:");
			yi++;
			return false;
		}
		if(yi ==1) 
		{
			x = Double.parseDouble(yin);
			ycf.o(yin);
			ycf.o("select second num:");
			yi++;
			return false;
			
		}
		
		if(yi ==2) 
		{
			y = Double.parseDouble(yin);
			ycf.o(yin);
			yi++;
			
			
		}
		
		return true;
	}//end plus

}
