import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import java.util.*;
import javafx.scene.text.Text;
import javafx.scene.control.ScrollPane;
import java.io.FileInputStream;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;



class global
{
  static ArrayList<String> checkin= new ArrayList<>();
  static ArrayList<String> checkop= new ArrayList<>();
  static ArrayList<String> passengerin= new ArrayList<>();
  static ArrayList<String> passengerop= new ArrayList<>();
  static ArrayList<String> cancelin= new ArrayList<>();
  static ArrayList<String> cancelop= new ArrayList<>();
}

public class GADAR extends Application
{

	   Stage window;
	    Scene scene1, scene2,scene3,scene4,scene5;
	    Scene scene6;

	    Button button1,button2,button3,button4,button5;
	    Button cancel;
	    public static void main(String[] args) {
	        launch(args);
	    }
	    @Override
	    public void start(Stage primaryStage) {
					ArrayList<passenger> plist =new ArrayList<passenger>();
     			create c= new create();
     			c.create_station();
     			c.create_train();
	        window = primaryStage;
	        //Button 1

	        Text label1 = new Text("Please Choose One Of The Following Options");

	        button1 = new Button("1.VIEW TRAINS");
	        button1.setOnAction(e -> window.setScene(scene2));


	        //button 3
	        button3=new Button("2.BOOK TICKET");
	        button3.setOnAction(e -> window.setScene(scene3));


          //button 4
          button4=new Button("3.CANCEL TICKET");
	        button4.setOnAction(e -> window.setScene(scene4));


          //Layout 1 this is for scene 1
	        GridPane layout1 = new GridPane();
          layout1.setHgap(5);
          layout1.setVgap(20);
          layout1.setStyle("-fx-background-color:#FFFFFF; -fx-opacity:1;");

          try {
            FileInputStream input = new FileInputStream("C:\\Users\\hp\\Documents\\JAVA_files\\Java project\\ussop.png");
            Image image = new Image(input);
            ImageView imageView = new ImageView(image);
            layout1.add(imageView,40,0);
          }
          catch (Exception e){
            System.out.println(e);
          }

	        layout1.add(label1,40,1);
          layout1.add(button1,40,2);
          layout1.add(button3,40,3);
          layout1.add(button4,40,4);



	        scene1 = new Scene(layout1, 600, 500);


	         //Button 2 this button is in scene 2
	         button2 = new Button("Next");

	         //Layout 2 this is for scene 2
           GridPane layout2 = new GridPane();
           layout2.setHgap(5);
           layout2.setVgap(10);

           Label label2 = new Label("Please Fill The Following Fields");
           Label BS = new Label("Boarding Station");
           Label DS = new Label("Destination Station");
           Label ldd = new Label("Date");
           Label lmm = new Label("Month");
           Label lyy = new Label("Year");

	         TextField viewboard = new TextField();
	         TextField viewdestination = new TextField();
           TextField dd = new TextField();
           dd.setMaxWidth(40);

           TextField mm = new TextField();
           mm.setPrefWidth(40);

           TextField yy = new TextField();
           yy.setMaxWidth(50);

           layout2.add(BS, 1, 1);
           layout2.add(DS, 3, 1);
           layout2.add(ldd, 1, 4);
           layout2.add(lmm, 2, 4);
           layout2.add(lyy, 4, 4);
           layout2.add(label2, 0, 0);
           layout2.add(viewboard, 1, 2);
           layout2.add(viewdestination, 3, 2);
           layout2.add(dd, 1, 5);
           layout2.add(mm, 2, 5);
           layout2.add(yy, 4, 5);
           layout2.add(button2, 2, 15);

           button2.setOnAction(ActionEvent ->{
        	   System.out.println(viewboard.getText());
        	   System.out.println(viewdestination.getText());
        	   System.out.println(dd.getText());
        	   System.out.println(mm.getText());
        	   System.out.println(yy.getText());
        	   System.out.println("This is to confirm that everything is entering the console");
						 global.checkin.add(viewboard.getText());
          	global.checkin.add(viewdestination.getText());
          	global.checkin.add(dd.getText());
          	global.checkin.add(mm.getText());
          	global.checkin.add(yy.getText());
						check che= new check();
          	che.inputc();
          	che.check(c.t);

						GridPane layout5=new GridPane();
						 layout5.setHgap(10);
						 layout5.setVgap(10);
		         Label label5 = new Label();


						 for(int i=0; i<global.checkop.size(); i++){
							 Text t = new Text();
							 t.setText(global.checkop.get(i));
							 layout5.add(t,1,i+1);
						 }

		         Button main=new Button("Main Menu");
		         main.setOnAction(e -> window.setScene(scene1));
		         layout5.add(label5,0,0);
						 layout5.add(main, 2,15);

             ScrollPane sc2 = new ScrollPane();
             sc2.setContent(layout5);

		         scene5 = new Scene(sc2, 600, 300);


        	   window.setScene(scene5);
           });

           scene2 = new Scene(layout2, 600, 300);



           //LAYOUT 3 this is for scene 3
              GridPane layout3 = new GridPane();
              layout3.setHgap(5);
              layout3.setVgap(10);

	         Label label3 = new Label("Enter The Following Fields");
	         //layout3.getChildren().add(label3);

	         Label CN = new Label("CLIENT NAME");
           Label CARGO = new Label("CARGO");
           Label BOARDING = new Label("BOARDING STATION");

           Label DEST = new Label("DESTINATION STATION");
           Label TRAIN_NO=new Label("TRAIN NO.");
           Label WT=new Label("WEIGHT OF CARGO");
           Label l2dd = new Label("Date");
           Label l2mm = new Label("Month");
           Label l2yy = new Label("Year");
           Button BOOK=new Button("BOOK");
           BOOK.setOnAction(e-> window.setScene(scene6));

	         TextField clname = new TextField();
	         TextField ncargo = new TextField();
	         TextField board = new TextField();
	         TextField destination = new TextField();
	         TextField trainno = new TextField();
	         TextField wncargo = new TextField();
           TextField dd2 = new TextField();
           dd2.setMaxWidth(40);

           TextField mm2 = new TextField();
           mm2.setMaxWidth(40);

           TextField yy2 = new TextField();
           yy2.setMaxWidth(50);

           layout3.add(CN, 1, 1);
           layout3.add(clname, 1, 2);
           layout3.add(CARGO, 3, 1);
           layout3.add(ncargo, 3, 2);
           layout3.add(BOARDING,1,3);
           layout3.add(board, 1, 4);
           layout3.add(DEST, 3, 3);
           layout3.add(destination, 3,4);
           layout3.add(TRAIN_NO, 1, 5);
           layout3.add(trainno, 1, 6);
           layout3.add(label3, 0, 0);
           layout3.add(WT, 3,5);
           layout3.add(wncargo, 3,6);
           layout3.add(l2dd, 1, 7);
           layout3.add(dd2, 1,8);
           layout3.add(l2mm, 2, 7);
           layout3.add(mm2,  2, 8);
           layout3.add(l2yy, 4, 7);
           layout3.add(yy2, 4, 8);
           layout3.add(BOOK, 2, 11);

           BOOK.setOnAction(ActionEvent ->{
        	   System.out.println(clname.getText());
        	   System.out.println(ncargo.getText());
        	   System.out.println(board.getText());
        	   System.out.println(destination.getText());
        	   System.out.println(trainno.getText());
        	   System.out.println(wncargo.getText());
        	   System.out.println(dd2.getText());
        	   System.out.println(mm2.getText());
        	   System.out.println(yy2.getText());
        	   System.out.println("This is to confirm that everything is entering the console");
						 global.passengerin.add(clname.getText());
          global.passengerin.add(ncargo.getText());
          global.passengerin.add(board.getText());
          global.passengerin.add(destination.getText());
          global.passengerin.add(trainno.getText());
          global.passengerin.add(wncargo.getText());
          global.passengerin.add(dd2.getText());
          global.passengerin.add(mm2.getText());
          global.passengerin.add(yy2.getText());
					passenger p=new passenger();
          plist.add(p);
          p.inputb();
          p.book(c.t);
          p.time(c.t);
          p.cost(c.t);
          display d= new display();
          d.displayticket(p);
          passenger p2=plist.get(0);
          System.out.println(p2.pnr);
          System.out.println(p2.namep);

          GridPane layout6 = new GridPane();
          layout6.setHgap(10);
          layout6.setVgap(10);

          Label label6 =new Label("BOOKING SUCESSFULL");

          for(int i=0; i<global.passengerop.size(); i++){
            Text t = new Text();
            t.setText(global.passengerop.get(i));
            layout6.add(t,1,i+1);
          }

          Label labela =new Label("Name of Client:-");
          layout6.add(labela,0,1);

          Label labelb =new Label("Name of Cargo:-");
          layout6.add(labelb, 0 ,2);

          Label labelc =new Label("Name of Train:-");
          layout6.add(labelc, 0 ,3);

          Label labeld =new Label("Boarding Station:-");
          layout6.add(labeld, 0,4);

          Label labele =new Label("Destination Station:-");
          layout6.add(labele, 0,5);

          Label labelf =new Label("Weight of Cargo:-");
          layout6.add(labelf, 0,6);

          Label labelg =new Label("PNR Number:-");
          layout6.add(labelg, 0,7);

          Label labelh =new Label("Train Number:-");
          layout6.add(labelh, 0,8);

          Label labeli =new Label("Date of Journey:-");
          layout6.add(labeli, 0,9);

          Label labelj =new Label("Time of Departure:-");
          layout6.add(labelj, 0,10);

          Label labelk =new Label("Time of Arrival:-");
          layout6.add(labelk, 0,11);

          Label labell =new Label("Cost of Ticket:-");
          layout6.add(labell, 0,12);


          Button bz=new Button("Main Menu");
          bz.setOnAction(e -> window.setScene(scene1));
          layout6.add(label6, 0 ,0);
          layout6.add(bz, 5, 15);

          ScrollPane sc1 = new ScrollPane();
          sc1.setContent(layout6);
          scene6 = new Scene(sc1, 600, 300);

        	   window.setScene(scene6);
           });//button event closes


	         scene3 = new Scene(layout3, 600, 350);


	        //LAYOUT4 this is for scene 4
	        VBox layout4 = new VBox(50);
	        Label label4 = new Label("Please  Enter Your 10 Digit PNR Number");
	        TextField pnr = new TextField();
	        cancel=new Button("Cancel Ticket");
	        cancel.setOnAction( e -> {

            global.cancelin.add(pnr.getText());
						cancel ca= new cancel();
        		ca.cancel(plist);
            isInt(pnr, pnr.getText());
					});
	        Button mainmenu2=new Button("Main Menu");
	        mainmenu2.setOnAction(e-> window.setScene(scene1));

	        layout4.getChildren().addAll(label4,pnr,cancel,mainmenu2);
	        layout4.setPadding(new Insets(20, 20, 20, 20));
	        scene4 = new Scene(layout4, 600, 300);

	        //Display scene 1 at first
	        window.setScene(scene1);
	        window.setTitle("RAILWAY RESERVATION SYSTEM");
	        window.show();

	    }

	    public boolean isInt(TextField noInput, String message)
	    {
              System.out.println(global.cancelop.get(0));
              String con=global.cancelop.get(0);
	            Alert alert = new Alert(AlertType.WARNING);
	            alert.setTitle("Confirmation Dialogc Box");
	            alert.setHeaderText(null/*"ATTENTION!!!!!"*/);
	            alert.setContentText(con);
	            alert.showAndWait();
	            return true;
	    }

	}

	class station//for storing info of station
{
  String station_name;
  int station_id;
}

class train extends station//for storing info of trains
{
  String train_name;
  int train_no;
  int[] cost= new int[10];//for cost of all stations
  String time[]=new String[10];//for timing
  String stations[]=new String[10];//for stations
  int days[]=new int[7];//for days starting with sunday
  int maxload;
  ArrayList<StringBuilder> dates= new ArrayList<>();
}

class create
{
  station[] s= new station[6];
  train[] t=new train[9];
  public void create_station()//for creating stations
  {

    for(int i=0;i<6;i++)
    s[i]= new station();

    s[0].station_name="KOLKATA";
   s[0].station_id=12345;

   s[1].station_name="JAIPUR";
   s[1].station_id=54321;

   s[2].station_name="AHMEDABAD";
   s[2].station_id=67891;

   s[3].station_name="MUMBAI";
   s[3].station_id=23133;

   s[4].station_name="DELHI";
   s[4].station_id=45096;

   s[5].station_name="CHENNAI";
   s[5].station_id=66059;

  }

  public void create_train()//for creating trains
  {
    for(int i=0;i<9;i++)
    t[i]= new train();

    t[0].train_name="AHMEDABAD 10";
   t[0].train_no=17925;
   //for days on which train operate
   t[0].days[0]=0;
   t[0].days[1]=1;
   t[0].days[2]=0;
   t[0].days[3]=1;
   t[0].days[4]=0;
   t[0].days[5]=1;
   t[0].days[6]=0;
   // for adding stations to train
   t[0].stations[0]="AHMEDABAD";
   t[0].stations[1]="MUMBAI";
   // for adding time of stations
   t[0].time[0]="11:00";
   t[0].time[1]="20:00";
   //for adding cost
   t[0].cost[0]=0;
   t[0].cost[1]=50000;
   t[0].maxload=400;

   t[1].train_name="SUPER LINK EXPRESS";
   t[1].train_no=12567;
   //for days on which train operate
   t[1].days[0]=1;
   t[1].days[1]=1;
   t[1].days[2]=1;
   t[1].days[3]=1;
   t[1].days[4]=1;
   t[1].days[5]=1;
   t[1].days[6]=1;
   // for adding stations to train
   t[1].stations[0]="KOLKATA";
   t[1].stations[1]="JAIPUR";
   t[1].stations[2]="AHMEDABAD";
   // for adding time of stations
   t[1].time[0]="23:00";
   t[1].time[1]="6:00";
   t[1].time[2]="15:00";
   //for adding cost
   t[1].cost[0]=0;
   t[1].cost[1]=70000;
   t[1].cost[2]=40000;
   t[1].maxload=6000;


   t[2].train_name="THE FALCON";
   t[2].train_no=12313;
   //for days on which train operate
   t[2].days[0]=1;
   t[2].days[1]=0;
   t[2].days[2]=0;
   t[2].days[3]=1;
   t[2].days[4]=0;
   t[2].days[5]=0;
   t[2].days[6]=1;
   // for adding stations to train
   t[2].stations[0]="MUMBAI";
   t[2].stations[1]="AHMEDABAD";
   t[2].stations[2]="JAIPUR";
   // for adding time of stations
   t[2].time[0]="14:55";
   t[2].time[1]="18:30";
   t[2].time[2]="22:00";
   //for adding cost
   t[2].cost[0]=0;
   t[2].cost[1]=54000;
   t[2].cost[2]=32000;
   t[2].maxload=400;

   t[3].train_name="THE MAIL";
   t[3].train_no=12515;
   //for days on which train operate
   t[3].days[0]=1;
   t[3].days[1]=1;
   t[3].days[2]=0;
   t[3].days[3]=0;
   t[3].days[4]=0;
   t[3].days[5]=0;
   t[3].days[6]=1;
   // for adding stations to train
   t[3].stations[0]="JAIPUR";
   t[3].stations[1]="AHMEDABAD";
   t[3].stations[2]="KOLKATA";
   t[3].stations[3]="DELHI";
   // for adding time of stations
   t[3].time[0]="21:25";
   t[3].time[1]="4:00";
   t[3].time[2]="23:55";
   t[3].time[3]="19:20";
   //for adding cost
   t[3].cost[0]=0;
   t[3].cost[1]=74000;
   t[3].cost[2]=22000;
   t[3].cost[3]=42500;
   t[3].maxload=400;

   t[4].train_name="CARGO CARRIERS";
   t[4].train_no=51231;
   //for days on which train operate
   t[4].days[0]=1;
   t[4].days[1]=0;
   t[4].days[2]=1;
   t[4].days[3]=0;
   t[4].days[4]=0;
   t[4].days[5]=1;
   t[4].days[6]=0;
   // for adding stations to train
   t[4].stations[0]="DELHI";
   t[4].stations[1]="KOLKATA";
   t[4].stations[2]="CHENNAI";
   // for adding time of stations
   t[4].time[0]="6:00";
   t[4].time[1]="17:35";
   t[4].time[2]="23:30";
   //for adding cost
   t[4].cost[0]=0;
   t[4].cost[1]=73000;
   t[4].cost[2]=25000;
   t[4].maxload=400;

   t[5].train_name="INDIA 38";
   t[5].train_no=12890;
   //for days on which train operate
   t[5].days[0]=1;
   t[5].days[1]=1;
   t[5].days[2]=1;
   t[5].days[3]=1;
   t[5].days[4]=1;
   t[5].days[5]=1;
   t[5].days[6]=1;
   // for adding stations to train
   t[5].stations[0]="JAIPUR";
   t[5].stations[1]="AJMER";
   t[5].stations[2]="MUMBAI";
   t[5].stations[3]="DELHI";
   t[5].stations[4]="CHENNAI";
   t[5].stations[5]="KOLKATA";
   // for adding time of stations
   t[5].time[0]="8:00";
   t[5].time[1]="9:30";
   t[5].time[2]="16:20";
   t[5].time[3]="20:45";
   t[5].time[4]="2:15";
   t[5].time[5]="9:10";
   //for adding cost
   t[5].cost[0]=0;
   t[5].cost[1]=73000;
   t[5].cost[2]=25000;
   t[5].cost[3]=25000;
   t[5].cost[4]=25000;
   t[5].cost[5]=27000;
   t[5].maxload=450;

   t[6].train_name="BOMBAY 21";
   t[6].train_no=12414;
   //for days on which train operate
   t[6].days[0]=1;
   t[6].days[1]=0;
   t[6].days[2]=1;
   t[6].days[3]=1;
   t[6].days[4]=1;
   t[6].days[5]=0;
   t[6].days[6]=0;
   // for adding stations to train
   t[6].stations[0]="MUMBAI";
   t[6].stations[1]="CHENNAI";
   t[6].stations[2]="DELHI";
   // for adding time of stations
   t[6].time[0]="9:40";
   t[6].time[1]="5:00";
   t[6].time[2]="22:50";
   t[6].maxload=400;
   //for adding cost
   t[6].cost[0]=0;
   t[6].cost[1]=73000;
   t[6].cost[2]=25000;

   //premiuim trains
   t[7].train_name="TEJ EXPRESS (PREMIUIM)";
   t[7].train_no=12004;
   //for days on which train operate
   t[7].days[0]=1;
   t[7].days[1]=0;
   t[7].days[2]=1;
   t[7].days[3]=0;
   t[7].days[4]=1;
   t[7].days[5]=0;
   t[7].days[6]=0;
  // for adding stations to train
  t[7].stations[0]="MUMBAI";
  t[7].stations[1]="AJMER";
  // for adding time of stations
  t[7].time[0]="13:40";
  t[7].time[1]="17:00";
  t[7].maxload=400;
  //for adding cost
  t[7].cost[0]=0;
  t[7].cost[1]=95890;

  //2ND PREMIUIM trains

  t[8].train_name="BIJLI (PREMIUIM)";
  t[8].train_no=12904;
  //for days on which train operate
  t[8].days[0]=1;
  t[8].days[1]=0;
  t[8].days[2]=1;
  t[8].days[3]=1;
  t[8].days[4]=1;
  t[8].days[5]=0;
  t[8].days[6]=1;
  // for adding stations to train
  t[8].stations[0]="KOLKATA";
  t[8].stations[1]="DELHI";
  t[8].stations[2]="JAIPUR";
  t[8].stations[3]="AJMER";
  // for adding time of stations
  t[8].time[0]="11:35";
  t[8].time[1]="16:05";
  t[8].time[2]="17:25";
  t[8].time[3]="18:58";
  t[8].maxload=400;
  //for adding cost
  t[8].cost[0]=0;
  t[8].cost[1]=94890;
	t[8].cost[2]=94890;
	t[8].cost[3]=94890;
  }
}
class display extends passenger//for displaying info
{
    String ta,td;
    int i,j,pa,pd,cost,ticketcost;
    void displayt(train t,String board, String destination)//for displaying info of train
    {
        System.out.print("\n");
        global.checkop.add(t.train_name);
        global.checkop.add(String.valueOf(t.train_no));
        global.checkop.add(String.valueOf(t.maxload));
        //for displaying time
        for(j=0;j<10;j++)// for finding time of boarding station
            if(board.equalsIgnoreCase(t.stations[j]))
            {
                pa=j;
                ta=t.time[j];
                break;
            }
        for(j=0;j<10;j++)// for finding time of destination station
            if(destination.equalsIgnoreCase(t.stations[j]))
            {
                pd=j;
                td=t.time[j];
                break;
            }
            //end of time
        global.checkop.add(ta);
        global.checkop.add(td);
        //for displaying cost
        for(j=0;j<10;j++)// for finding time of boarding station
            if(board.equalsIgnoreCase(t.stations[j]))
            {
                pa=j;
                break;
            }
        for(j=0;j<10;j++)// for finding time of destination station
            if(destination.equalsIgnoreCase(t.stations[j]))
            {
                pd=j;
                break;
            }
        for(j=pa+1;j<=pd;j++)//for calculating cost
        {
            cost=cost+t.cost[j];
        }
        ticketcost=cost;
        global.checkop.add(String.valueOf(ticketcost));

        //end of cost
        global.checkop.add("-------------------------------------------------------------------");
    }
    void displayticket(passenger p)
    {
        String date= new String(" ");
        date=date.concat(String.valueOf(p.d));
        date=date.concat("-");
        date=date.concat(String.valueOf(p.m));
        date=date.concat("-");
        date=date.concat(String.valueOf(p.y));
        global.passengerop.add(p.namep);
        global.passengerop.add(p.nameg);
        global.passengerop.add(p.namet);
        global.passengerop.add(p.board);
        global.passengerop.add(p.destination);
        global.passengerop.add(String.valueOf(p.goodl));
        global.passengerop.add(String.valueOf(p.pnr));
        global.passengerop.add(String.valueOf(p.trainno));
        global.passengerop.add(date.trim());
        global.passengerop.add(p.ta);
        global.passengerop.add(p.td);
        global.passengerop.add(String.valueOf(p.ticketcost));
    }
}
class calender//for finding out day on a date
{
  static int dayofweek(int d,int m,int y)
  {
    int t[]={0,3,2,5,0,3,5,1,4,6,2,4};
    y-=(m<3)?1:0;
    return(y+y/4-y/100+y/400+t[m-1]+d)%7;
  }
}
class check extends create//for storing info of passengers
{
    String board,destination;
    int day,m,d,y;
    StringBuilder sb= new StringBuilder();
    void inputc()//for taking input for availability of trains
    {
        board=global.checkin.get(0);
        destination=global.checkin.get(1);
        d=Integer.valueOf(global.checkin.get(2));
        m=Integer.valueOf(global.checkin.get(3));
        y=Integer.valueOf(global.checkin.get(4));
        sb.append(d);
        sb.append(m);
        sb.append(y);
        day=calender.dayofweek(d,m,y);
    }
    void check(train[] t)//for checking available trains
    {
        int fb=-1,fd=-1,j,bp=-1,dp=-1,i,ft=0,mul;
        for(i=0;i<9;i++)//for trains
        {
            fb=-1;
            fd=-1;
            bp=-1;
            dp=-1;
            mul=0;


                if(t[i].days[day]==1)//train days loop
                {
                    j=0;
                    while(j<10)//checking for boarding
                    {
                        if(board.equalsIgnoreCase(t[i].stations[j]))
                        {
                            fb=1;
                            bp=j;
                            break;
                        }
                        j++;
                    }
                    j=0;
                    while(j<10)//checking for destination
                    {
                        if(destination.equalsIgnoreCase(t[i].stations[j]))
                        {
                            fd=1;
                            dp=j;
                            break;
                        }
                        j++;
                    }

                    mul=fb*fd;//using mul for checking flag
                    if(mul==1)//for displaying the train
                    {
                        if(bp<dp)
                        {
                            ft=1;
                            display d= new display();
                            d.displayt(t[i],board,destination);
                        }

                    }
                }//end of train days loop

        }//end of train loop
        if(ft==0)
            global.checkop.add("No trains available");
    }//end of check function
}//end of check class

class generatepnr//to generate a 10 digit random no.
{
  long generate()
 {
   long  sum=0,t,i;
   Random rand= new Random();
   for(i=0;i<10;i++)
      {
        t=rand.nextInt(9);
        sum=sum*10+t;
      }
    return sum;
  }
}

class passenger extends create//for stroing info of passenger
{
  String namep,nameg,namet;
  String board,destination;
  int goodl;
  long pnr;
  int trainno;
  int d,m,y;
  String ta,td;
  StringBuilder sb= new StringBuilder();
  int ticketcost;
  void inputb()//for taking input while booking a tarin
  {
    namep=global.passengerin.get(0);
    nameg=global.passengerin.get(1);
    goodl=Integer.valueOf(global.passengerin.get(5));
    trainno=Integer.valueOf(global.passengerin.get(4));
    board=global.passengerin.get(2);
    destination=global.passengerin.get(3);
    d=Integer.valueOf(global.passengerin.get(6));
    m=Integer.valueOf(global.passengerin.get(7));
    y=Integer.valueOf(global.passengerin.get(8));
    sb.append(d);
    sb.append(m);
    sb.append(y);
  }
  void book(train[] t)
  {
    int i,flag=0;
    for(i=0;i<9;i++)
    if(trainno==t[i].train_no)
    {
      flag=1;
      break;
    }
    if(flag==1)
    {
      namet=t[i].train_name;
      generatepnr g= new generatepnr();
      pnr=g.generate();
      t[i].dates.add(sb);
    }
    else
    {
      System.out.println("Wrong train no.");
    }
  }
  void time(train[] t)// for assigning time
  {
    int pa,pd;
    int i,j,flag=0;
    for(i=0;i<9;i++)
    if(trainno==t[i].train_no)
    {
      flag=1;
      break;
    }
    if(flag==1)
    {
      for(j=0;j<10;j++)// for finding time of boarding station
      if(board.equalsIgnoreCase(t[i].stations[j]))
      {
        pa=j;
        ta=t[i].time[j];
        break;
      }
      for(j=0;j<10;j++)// for finding time of destination station
      if(destination.equalsIgnoreCase(t[i].stations[j]))
      {
        pd=j;
        td=t[i].time[j];
        break;
      }
    }
    else
    {
      System.out.println("train not found");
    }
  }//end of time function

  void cost(train[] t)//for calculating cost
  {
    int pa=0,pd=0,cost=0;
    int i,j,flag=0;
    for(i=0;i<9;i++)
    if(trainno==t[i].train_no)
    {
      flag=1;
      break;
    }
    if(flag==1)
    {
      for(j=0;j<10;j++)// for finding time of boarding station
      if(board.equalsIgnoreCase(t[i].stations[j]))
      {
        pa=j;
        break;
      }
      for(j=0;j<10;j++)// for finding time of destination station
      if(destination.equalsIgnoreCase(t[i].stations[j]))
      {
        pd=j;
        break;
      }
      for(j=pa+1;j<=pd;j++)//for calculating cost
      {
        cost=cost+t[i].cost[j];
      }
      ticketcost=cost;
    }
    else
    {
      System.out.println("train not found");
    }
  }//end of cost function
}//end of passenger
class cancel
{
  long pnr;
  int flag=0,i;
  Scanner s= new Scanner(System.in);
  void cancel(ArrayList<passenger> plist)
  {
    //System.out.println("enter the pnr of your ticket");
    pnr=Long.valueOf(global.cancelin.get(0));
    for(i=0;i<plist.size();i++)
    {
      passenger p = plist.get(i);
      if(pnr==p.pnr)
      {
        flag=1;
        p=null;
        plist.remove(i);
        break;
      }
    }//end of for
    if(flag==1)
    {
      System.out.println("cancel running");
      global.cancelop.add("Booking Cancelled");
    }
    else
    {
      global.cancelop.add("pnr not found");
    }
  }//end of cancel method
}
class output
{
	void output()
	{
		int i;
		for(i=0;i<global.checkop.size();i++)
		System.out.println(global.checkop.get(i));
	}

  void output2(){
    int i;
		for(i=0;i<global.passengerop.size();i++)
		System.out.println(global.passengerop.get(i));
  }
}
