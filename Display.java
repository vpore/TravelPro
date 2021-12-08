import java.util.*;

public class Display extends TourInfo{
    static String tourIti;
    static int perPrice;
    static String tourName;
    static String fromDate;
    static String toDate;
    static Scanner sc=new Scanner(System.in);
    static String enter;
    static int c;

    public static void GT(int x, int y){ //Displays Information of Group Tours
        System.out.println("\n");
        tourName=TourNameGT(x, y);
        fromDate=FromDate(x, y);
        toDate=ToDate(x, y);
        System.out.println("From: "+fromDate+"\tTo: "+toDate);
        tourIti=TourIti(x, y);
        System.out.println("\n->Press Enter to know Per Person Price:");
        enter=sc.nextLine();
        perPrice=GTPerPersonPrice(x, y);
        Offers();
        System.out.println("\n->Press Enter to know Inclusions & Exclusions:");
        enter=sc.nextLine();
        InclExcl();
        System.out.println("\n** Want to Proceed & know the Final Total Price? **\n->Press 'Y' to Proceed\n->Press 'N' to Choose Another Tour");
        String ch=sc.nextLine();
        
        if (confirm(ch)){
            InputDetails.InputGTInfo(); //Takes Input of Total People & Travel Mode
            FinalPrice(perPrice, InputDetails.totalPpl, InputDetails.travelMode, discount);
            System.out.println("\n** Want to Confirm? **\n->Press 'Y' to Confirm the Tour Package\n->Press 'N' to Choose Another Tour");
            ch=sc.nextLine();
            if(confirm(ch)){
                InputDetails.InputPersonalInfo(); //Directs to AWT Form
            }
            else{
                InputDetails.totalPpl=0;
                InputDetails.travelMode=0;
                InputDetails.count1=0;
                InputDetails.count2=0;
                ChooseCategories.chooseGT(); //Re-Displays the Tour Options
            }
        }
        else{
            ChooseCategories.chooseGT(); //Re-Displays the Tour Options
        }
    }

    public static void CT(){ //Displays Information of Customized Tours
        System.out.println();
        InputDetails.InputCTInfo(); //Takes input of details
        tourName=TourNameCT();
        fromDate=InputDetails.fromDate;
        toDate=InputDetails.toDate;
        System.out.println("\n->Press Enter to know Per Person Price:");
        enter=sc.nextLine();
        perPrice=CTPerPersonPrice();
        Offers();
        System.out.println("\n->Press Enter to know Inclusions & Exclusions:");
        enter=sc.nextLine();
        InclExcl();
        System.out.println("\n** Want to Proceed & know the Final Total Price?( Inclusive of All Taxes ) **\nPress 'Y' to Proceed\nPress 'N' to Choose Another Tour");
        String ch=sc.nextLine();
        if(confirm(ch)){
            FinalPrice(CTprice, InputDetails.totalPpl, InputDetails.travelMode, discount);
            System.out.println("\n** Want to Confirm? **\n->Press 'Y' to Confirm the Tour Package\n->Press 'N' to Choose Another Tour");
            ch=sc.nextLine();
            if(confirm(ch)){
                InputDetails.InputPersonalInfo();
                //Bill.PrintBill();
            }
            else{
                InputDetails.totalPpl=0;
                InputDetails.travelMode=0;
                InputDetails.count3=0;
                InputDetails.count4=0;
                InputDetails.count5=0;
                InputDetails.count6=0;
                ChooseCategories.choose(); //Re-Displays the Tour Options
            }
        }
        else{
            ChooseCategories.choose(); //Re-Displays the Tour Options
        }
    }

    public static boolean confirm(String s){ //Confirmation to proceed or not
        if(s.equals("Y") || s.equals("y")){return true;}
        else{System.out.println("\n- You will be re-directed to the Main Menu");return false;}
    }
}
