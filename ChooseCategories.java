import java.util.Scanner;

public class ChooseCategories extends TourOptions
{
	static String ch;
	static Scanner sc=new Scanner(System.in);
	static int c;
	
	public static void choose() 
	{
		switch(displayCateg()) //Displays Main Tour Options
		{
			case 1 : chooseGT(); break;
			case 2 : chooseCT(); break;
			case 3 : confirm();
					 if(c==0){Exit.goodbye();}
					 else{choose(); break;}
			case 'a': choose(); break;
			default : validOpn();
					  choose();
		}
	}
	public static void chooseGT() 
	{
		switch(displayGTCateg()) //Displays Group Tour Options
		{
			case 1 : chooseST();
			break;
			case 2 : chooseTH();
			break;
			case 3 : chooseWS();
			break;
			case 4 : choose();
			break;
			case 5 : confirm();
					 if(c==0){Exit.goodbye();}
					 else{choose(); break;}
			case 'a': chooseGT(); break;

			default : validOpn();
					  chooseGT();
		}
	}
	public static void chooseST() 
	{
		switch(displaySTCateg()) //Displays Short Trip Options
		{
			case 1 : Display.GT(0, 0);
			break;
			case 2 : Display.GT(1, 0);
			break;
			case 3 : chooseGT();
			break;
			case 4 : choose();
			break;
			case 5 : confirm();
					 if(c==0){Exit.goodbye();}
					 else{choose(); break;}
			case 'a': chooseST(); break;
			default : validOpn();
					  chooseST();
		}
	}
	public static void chooseTH() 
	{
		switch(displayTHCateg()) //Displays Treks&Hikes Options
		{
			case 1 : Display.GT(0, 1);
			break;
			case 2 : Display.GT(1, 1);
			break;
			case 3 : chooseGT();
			break;
			case 4 : choose();
			break;
			case 5 : confirm();
					 if(c==0){Exit.goodbye();}
					 else{choose(); break;}
			case 'a': chooseTH(); break;
			default : validOpn();
					  chooseTH();
		}
	}	

	public static void chooseWS() 
	{
		switch(displayWSCateg()) //Displays WomensSpecials Options
		{
			case 1 : Display.GT(0, 2);
			break;
			case 2 : Display.GT(1, 2);
			break;
			case 3 : chooseGT();
			break;
			case 4 : choose();
			break;
			case 5 : confirm();
					 if(c==0){Exit.goodbye();}
					 else{choose(); break;}
			case 'a': chooseWS(); break;
			default : validOpn();
					  chooseWS();
		}
	}	
	
	public static void chooseCT()
	{
		Display.CT();
	}

	public static void confirm(){ //Confirmation 
		System.out.println("\n** Are You Sure You Want To Exit? **\n->Press'Y' to Exit\n->Press 'N' to Go to Main Menu");
		ch=sc.nextLine();
		if(ch.equals("Y") || ch.equals("y")){c=0;}
		else if(ch.equals("N") || ch.equals("n")){c=1;}
		else{System.out.println("\n--Enter Appropriate Choice 'Y' or 'N'--"); confirm();}
	}

	public static void validOpn(){
		System.out.println("\n--Please enter valid option from above displayed menu--\n");
	}

}
