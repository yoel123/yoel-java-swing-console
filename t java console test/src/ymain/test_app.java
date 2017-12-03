package ymain;

import yconsole.yconsole_action;

public class test_app extends yconsole_action {

	
	@Override
	public void yinit() 
	{
		yi=0;// global counter attribute(int)
		ycf.o("");
		ycf.o("whats your name?");
		ycf.o("");
	}//end yinit

	@Override
	public void do_commands() 
	{
		
		if(yin.equals("again"))
		{
			
			yinit();
			return;
		}
		
		if(yi == 0)
		{
			ycf.o("hello "+yin);
			ycf.o("");
			ycf.o("whats your age?");
			yi++;
			return;
			
		}
		
		if(yi == 1)
		{
			ycf.o("");
			ycf.o("your age is: "+yin);
			yi++;
			return;
			
		}
		
	
		
		
		
	}//end do_commands
	
}
