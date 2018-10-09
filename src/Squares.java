

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JLabel;

import gfx.Animation;
import gfx.SpriteSheet;


public class Squares extends JFrame implements Runnable{


	
	private Image dbimage;
	private Graphics dbg;
	
	Image Allens;
	
	BufferedImage playerShipOne[];
	Random randHP = new Random();
	static Animation anim;

	static Animation playerAnim;

	//-------------------GAME FUNCTION VARIABLES----------------------------------
	
	public static boolean isGameOver = false;
	

	
	boolean MouseClicked = false;
	
	
	public static boolean StartProgram = true;
	
	public static boolean GameRunning = false;
	public static boolean RestartGame = false;
	
	
	public static int BulletSpeed = 10;
	
	
	public static boolean BossSP = false;
	
	public static boolean BossRespawn = true;
	
	public static boolean BossMove = false;
	
	
	public static boolean MinionMove = false;
	
	
	public static int ThreadCount = 0;
  
        
       //---------additional-------------- 
        
        public static int TempScore = 0;
        
        public static int Timer = 0;
        
        public static int MinionWaveCount = 0;
        
        public  int MobsLevel = 0;
        
	public static boolean FisrtRun = true;
        
        public static int MobsSpeed = 1;
        
        public static int MobsBulletSpeed = 5;
        
        public static int MinionSpeed = 5;
        
        public static boolean MobsXmove = true;
        
        public static boolean MobsDive = false;
        
        public static int Minions = 5;
	//----------------------------------------------------------------------------
	
	
	public int speed = 15;
		
        boolean mouseDragged ;
        
        int step = 0;
     
        int  mobsSteps = 0;
       
        int TotalDMG = 0;
        
        //mobs
        Rectangle Mob;
        int mobx=250,moby=100;
         Random r = new Random();
         
         int mobsX =1000  , mobsY=0;
        
         boolean mobsgoleft = true  ,mobsGoUP= true;
         boolean mobsIsAlive = false;
         
        //mobs HP
        int mobhp = 500;
         
        boolean MinionWaveReady = true;
        
         
     //Minion properties
        
        int minion1Xinitial= 0;
        int minion1Y = -800;
        int minion1X = 20;
        
        boolean Minion1ReadyToGo = true;
        boolean Minion1Move = false;
        int MinionHP = randHP.nextInt((10-5)+1)+5;
        
        int minion2Xinitial= 0;
        int minion2Y = -800;
        int minion2X = 120;
        
        boolean Minion2ReadyToGo = true;
        boolean Minion2Move = false;
        int MinionHP2 = randHP.nextInt((10-5)+1)+5;
        

        int minion3Xinitial= 0;
        int minion3Y = -800;
        int minion3X = 220;
        
        boolean Minion3ReadyToGo = true;
        boolean Minion3Move = false;
        int MinionHP3 = randHP.nextInt((10-5)+1)+5;
        
      
        int minion4Xinitial= 0;
        int minion4Y = -800;
        int minion4X = 320;
        
        boolean Minion4ReadyToGo = true;
        boolean Minion4Move = false;
        int MinionHP4 = randHP.nextInt((10-5)+1)+5;
       
       
        int minion5Xinitial= 0;
        int minion5Y = -800;
        int minion5X = 420;
        
        boolean Minion5ReadyToGo = true;
        boolean Minion5Move = false;
        int MinionHP5 = randHP.nextInt((10-5)+1)+5;
        
        
     
        //mouse coordinate
        int mx,my;
        
        
        boolean start = true;
        
        
        //mobs bullet
        
        int mobsBulletXinitial = 0;
        int mobsBulletY = 500;
        int mobsBulletX = 500; 
        boolean mobsReadyToFire = true;
        boolean mobsmoveBullet = true;
        
       //bullet coordinate
        int BulletXinitial = 0;
        int BulletY = 450;
        int BulletX = 0; 
        boolean ReadyToFire = true;
        boolean moveBullet = false;
        
        
        int BulletXinitial1 = 0;
        int BulletY1 = 450;
        int BulletX1 = 0;
        boolean ReadyToFire1 = false;
        boolean moveBullet1 = false;
        
        int BulletXinitial2 = 0;
        int BulletY2 = 450;
        int BulletX2 = 0;
        boolean ReadyToFire2 = false;
        boolean moveBullet2 = false;
        
        
        int BulletXinitial3 = 0;
        int BulletY3 = 450;
        int BulletX3 = 0;
        boolean ReadyToFire3 = false;
        boolean moveBullet3 = false;
        
        
        int BulletXinitial4 = 0;
        int BulletY4 = 450;
        int BulletX4 = 0;
        boolean ReadyToFire4 = false;
        boolean moveBullet4 = false;
        
       
        int BulletXinitial5 = 0;
        int BulletY5 = 450;
        int BulletX5 = 0;
        boolean ReadyToFire5 = false;
        boolean moveBullet5 = false;
        
       
        int BulletXinitial6 = 0;
        int BulletY6 = 450;
        int BulletX6 = 0;
        boolean ReadyToFire6 = false;
        boolean moveBullet6 = false;
        
        
        int BulletXinitial7 = 0;
        int BulletY7 = 450;
        int BulletX7 = 0;
        boolean ReadyToFire7 = false;
        boolean moveBullet7 = false;
  
        
        int BulletXinitial8 = 0;
        int BulletY8 = 450;
        int BulletX8 = 0;
        boolean ReadyToFire8 = false;
        boolean moveBullet8 = false;
        
       
        int BulletXinitial9 = 0;
        int BulletY9 = 450;
        int BulletX9 = 0;
        boolean ReadyToFire9 = false;
        boolean moveBullet9 = false;
        
        
     
        
        
     // --------------re innitialize the variable to restart the game------------------------------------------------------------------------
        
        public void Restart() {
        	
        	
        	 speed = 15;
        	
        	BulletSpeed = 10;

             step = 0;
           
            
             mobsSteps = 0;
           
            
             TotalDMG = 0;
            
            //mobs
             Mob =null;
             mobx=250;
             moby=100;
          //   Random r = new Random();
             
             
              mobsX =1000  ;
              mobsY=130;
            
              mobsgoleft = true ;
              mobsGoUP= true;
              mobsIsAlive = false;
             
            //mobs HP
             mobhp = 400;
            
            BossSP = false;
            
             MinionWaveReady = true;
            
             
             
             
             
             
             
              BulletSpeed = 10;
	
	
	 BossSP = false;
	
	 BossRespawn = true;
	
	 BossMove = false;
	
	
	 MinionMove = false;
	
	
	 ThreadCount = 0;
  
        
       //---------additional-------------- 
        
         TempScore = 0;
        
         Timer = 0;
        
         MinionWaveCount = 0;
        
         MobsLevel = 0;
        
	 FisrtRun = true;
        
         MobsSpeed = 1;
        
         MobsBulletSpeed = 5;
        
         MinionSpeed = 5;
        
         MobsXmove = true;
        
         MobsDive = false;
             
         Minions = 5;
             
             
           
         //Minion coordinate
            
             minion1Xinitial= 0;
             minion1Y = -1300;
             minion1X = 20;
            
             Minion1ReadyToGo = true;
             Minion1Move = false;
             MinionHP = randHP.nextInt((10-5)+1)+5;;
            
            
            
             minion2Xinitial= 0;
             minion2Y = -800;
             minion2X = 120;
            
             Minion2ReadyToGo = true;
             Minion2Move = false;
             MinionHP2 = randHP.nextInt((10-5)+1)+5;;
            

             minion3Xinitial= 0;
             minion3Y = -800;
             minion3X = 220;
            
             Minion3ReadyToGo = true;
             Minion3Move = false;
             MinionHP3 = randHP.nextInt((10-5)+1)+5;;
            
         
             minion4Xinitial= 0;
             minion4Y = -800;
             minion4X = 320;
            
             Minion4ReadyToGo = true;
             Minion4Move = false;
             MinionHP4 = randHP.nextInt((10-5)+1)+5;;
           
             minion5Xinitial= 0;
             minion5Y = -800;
             minion5X = 420;
            
             Minion5ReadyToGo = true;
             Minion5Move = false;
             MinionHP5 = randHP.nextInt((10-5)+1)+5;;
            
           
            //mouse coordinate
             mx=0;
             my=0;
            
            
             start = true;
            
          
            //mobs bullet
             mobsBulletXinitial = 0;
             mobsBulletY = 450;
             mobsBulletX = 0; 
             mobsReadyToFire = true;
             mobsmoveBullet = true;
                                 
            
            //bullet coordinate
             BulletXinitial = 0;
             BulletY = 450;
             BulletX = 0; 
             ReadyToFire = true;
             moveBullet = false;
                        
             BulletXinitial1 = 0;
             BulletY1 = 450;
             BulletX1 = 0;
             ReadyToFire1 = false;
             moveBullet1 = false;
            
             BulletXinitial2 = 0;
             BulletY2 = 450;
             BulletX2 = 0;
             ReadyToFire2 = false;
             moveBullet2 = false;
                        
             BulletXinitial3 = 0;
             BulletY3 = 450;
             BulletX3 = 0;
             ReadyToFire3 = false;
             moveBullet3 = false;
                        
             BulletXinitial4 = 0;
             BulletY4 = 450;
             BulletX4 = 0;
             ReadyToFire4 = false;
             moveBullet4 = false;
            
             BulletXinitial5 = 0;
             BulletY5 = 450;
             BulletX5 = 0;
             ReadyToFire5 = false;
             moveBullet5 = false;
            
             BulletXinitial6 = 0;
             BulletY6 = 450;
             BulletX6 = 0;
             ReadyToFire6 = false;
             moveBullet6 = false;
             
             BulletXinitial7 = 0;
             BulletY7 = 450;
             BulletX7 = 0;
             ReadyToFire7 = false;
             moveBullet7 = false;
             
             BulletXinitial8 = 0;
             BulletY8 = 450;
             BulletX8 = 0;
             ReadyToFire8 = false;
             moveBullet8 = false;
             
             BulletXinitial9 = 0;
             BulletY9 = 450;
             BulletX9 = 0;
             ReadyToFire9 = false;
             moveBullet9 = false;
             
             
        }
        
        
        
        
        //-------------------------
        
      
        public void move(){
        
        // mobs direction
        	
        ThreadCount++;
        	
       	
        	
        if(TotalDMG > 1000) {
        	BulletSpeed = 10;
        }	
     	
        	
        if(StartProgram == true)	
        {
        }
        
       if (GameRunning == true) {
    	   
    	   System.out.println("1 "+MinionHP);
    	   System.out.println("2 "+MinionHP2);
    	   System.out.println("3 "+MinionHP3);
    	   System.out.println("4 "+MinionHP4);
    	   System.out.println("5 "+MinionHP5);
    	   if(ThreadCount%100 == 0)
                  Timer++;
               
           if(Timer == 5)
    		  MinionMove = true;
               
               
           if(MinionWaveCount == 10){
                   
                 MobsLevel++;
                 MinionMove = false;
                 mobsIsAlive = true;
                 MinionWaveCount = 0;
                 
                 if(MobsLevel >6){
                 MinionSpeed++;
                 MobsBulletSpeed++;
                 MobsSpeed++;
                 
                 MinionMove = true;
                 
                 }
                 
               //  System.out.println(MobsLevel);
               }
    	   if(MobsLevel <=3)
               MobsSpeed = 1;
           if(MobsLevel ==3)
               MinionSpeed = 9;
           
           if(MobsLevel ==4){
               MobsSpeed = 5;
               MinionSpeed = 10;
           }
           if(MobsLevel ==5){
               MobsBulletSpeed = 6;
               MobsSpeed = 6;
               MinionSpeed = 11;
           }
          
               
    	   			if(mobsIsAlive == true) {
    	   
    	  
    	   				if(BossRespawn == true) {
    		
    	   					mobsX = 250;
    	   					mobsY = -100;
    	   					BossRespawn = false;
    	   					BossMove = true;
    	   				}
    	
    	   				if(BossMove == true) {
    		
    	   					mobsY += 1 ;
    		
    	   					if(mobsY == 100)
    	   						BossMove = false;
    	   				}
    	   				if(BossMove == false) { 
    	   
        
    	   					if( MobsLevel <= 5) { 
    		
    	   						if(mobsX >= 480) {
    	   							mobsgoleft = true;
    	   						}
        
    	   						if(mobsX<=0) {
    	   							mobsgoleft = false;
    	   						}	
    		
    	   						if(mobsgoleft == true) {	
    	   							mobsX-= MobsSpeed;
    	   						}
    	   						else{
    	   							mobsX+= MobsSpeed;
    	   						}
        
       		
    	   						if(MobsLevel == 2){
    	   						
    	   							if(mobsY >= 130 ) {
    	   								mobsGoUP = true;
    	   							}
        
    	   							if(mobsY <= 50) {
    	   								mobsGoUP = false;
    	   							}
    	
    	   							if(mobsGoUP == true) {
    	   								mobsY-= MobsSpeed;
    	   							}
    	   							else {
    	   								mobsY+= MobsSpeed;
    	   							}
       		
    	   						}
    	   						
                                                        
                                                        if(MobsLevel >= 3){
       	
    	   							if(mobsY >= 470 ) {
    	   								mobsGoUP = true;
    	   							}
        
    	   							if(mobsY <= 50) {
    	   								mobsGoUP = false;
    	   							}
    	
    	   							if(mobsGoUP == true) {
    	   								mobsY-= MobsSpeed;
    	   							}
    	   							else {
    	   								mobsY+= MobsSpeed;
    	   							}
       		
    	   						}
    	   					}
                                                
                                                
                                                if(MobsLevel >= 6){
                                                    
                                                    
                                                    
                                                    if(MobsXmove == true){
                                                        
                                                        if(mobsX >= 480) {
                                                        mobsgoleft = true;}

                                                        if(mobsX<=0) {
                                                        mobsgoleft = false;}	

                                                        if(mobsgoleft == true) {	
                                                            mobsX-= MobsSpeed;}

                                                        if(mobsgoleft == false){
                                                            mobsX+= MobsSpeed;}
                                                    }
                                                    
                                                                if(mobsY >= 470 ) {
    	   								mobsGoUP = true;
                                                                       
    	   							}
        
    	   							if(mobsY <= 50) {
    	   								mobsGoUP = false;
                                                                         MobsXmove = true;
    	   							}
    	
    	   							if(mobsGoUP == true) {
                                                                   	mobsY-= MobsSpeed;
    	   							}
    	   							else {
                                                                        if(MobsXmove == false)
                                                                            mobsY+= MobsSpeed * 2;
                                                                        else
                                                                            mobsY+= MobsSpeed;
    	   							}
                                                    
                                                    
                                                    if((mobsX +10) >= mx  &&  (mobsX -10) <= mx ){
                                                     MobsXmove=false;
                                                     mobsGoUP = false;}
                                                }
                                                
                                          
                                                
    	   				}			
    	   			}
 	
    	
    	   			
    	   			
    	 //------------------mobs bullet--------------------------------------------
    
    
    
    	   			if (mobsBulletY > 500 && BossMove == false){
    	   			
    	   				mobsBulletY = mobsY;
    	   				mobsReadyToFire = true;
    	   			}
  	
  	
    	   			if(mobsBulletY > 500 ){
    	   				mobsmoveBullet = true;
    	   			}
       
    	   			if (mobsmoveBullet == true && BossMove == false){
    	   				mobsBulletY += 7;
    	   			}
       
     
       
       
       //---------------------minion movement---------------------------------------
        
    	   if(MinionMove == true) {
                        if(MinionWaveReady== true){
                                minion1Y+=MinionSpeed;
    	   			minion2Y+=MinionSpeed;
    	   			minion3Y+=MinionSpeed;
    	   			minion4Y+=MinionSpeed;
    	   			minion5Y+=MinionSpeed;
                        }
                        
                        if(Minions == 0){
                            mobsSteps = 130;
                            Minions = 5;
                        }
                            
                      
                      
    	   }
  
            
        // ----------------Bullet movement -------------------------------
  
        
    	   			if(step== 0   ||  ((BulletSpeed == 10) && step == 0) ) {   
    	   				moveBullet = true;}
        
    	   			if(moveBullet == true){
    	   				BulletY -= BulletSpeed;}
            
       
    	   			if(BulletY == 10){
    	   				BulletY=450;
    	   				moveBullet = false;
    	   			}
        
                                
        //-----------------------bullet5 movement-------------------------------
                        
            	   		if( step== 9    ||  ((BulletSpeed == 10) && step == 4) ) {   
    	   				moveBullet5 = true;}
       
    	   			if(moveBullet5 == true){
    	   				BulletY5 -= BulletSpeed;}
               
    	   			if(BulletY5 == 10){
    	   				BulletY5=450;
    	   				moveBullet5 = false;
    	   			}
      
   
        //------------------------bullet1 movement--------------------------------
        
          
      
         
    	   			if( step== 18 ||  ((BulletSpeed == 10) && step == 8) ) {   
    	   				moveBullet1 = true;
    	   			}
         
        
         
    	   			if(moveBullet1 == true){
    	   				BulletY1 -= BulletSpeed;
    	   			}
            
       
    	   			if(BulletY1 == 10){
    	   				BulletY1=450;
    	   				moveBullet1 = false;
    	   			}
        
        
        
        //--------------------------bullet6 movement---------------------------------
        
        
        
        
    	   			if( step== 27   ||  ((BulletSpeed == 10) && step == 12) ) {   
    	   				moveBullet6 = true;
    	   			}
       
    	   			if(moveBullet6 == true){
    	   				BulletY6 -= BulletSpeed;}
          
    	   			if(BulletY6 == 10){
    	   				BulletY6=450;
    	   				moveBullet6 = false;
    	   			}
        
   
        
        //--------------------bullet2 movement------------------------
        
        
        
    	   			if(  step== 36   ||  ((BulletSpeed == 10) && step == 16) ) {   
    	   				moveBullet2 = true;
    	   			}
        
    	   			if(moveBullet2 == true){
    	   				BulletY2 -= BulletSpeed;}
                                if(BulletY2 == 10){
    	   				BulletY2=450;
    	   				moveBullet2 = false;
    	   			}
        
        
        
    	//------------------------bullet7 movement------------------------
    
    	   			if( step== 45    ||  ((BulletSpeed == 10) && step == 20) ) {   
    	   				moveBullet7 = true;
    	   			}
     
    	   			if(moveBullet7 == true){
    	   				BulletY7 -= BulletSpeed;}
  
    	   			if(BulletY7 == 10){
    	   				BulletY7=450;
    	   				moveBullet7 = false;
         
    	   			}
        
        
        
        //--------------------------bullet 3 movement-----------------------------------
        
    	   			if( step== 54    ||  ((BulletSpeed == 10) && step == 24) ) {   
    	   				moveBullet3 = true;}
         
    	   			if(moveBullet3 == true){
    	   				BulletY3 -= BulletSpeed;}
            
    	   			if(BulletY3 == 10){
    	   				BulletY3=450;
    	   				moveBullet3 = false;
    	   			}
        
        
        
    //-----------------------------------bullet8 movement----------------------------
        
        
    	   			if( step== 63      ||  ((BulletSpeed == 10) && step == 28) ) {   
    	   				moveBullet8 = true;
    	   			}
       
    	   			if(moveBullet8 == true){
    	   				BulletY8 -= BulletSpeed;}
          
    	   			if(BulletY8 == 10){
    	   				BulletY8=450;
    	   				moveBullet8 = false;
    	   			}
        
         
    //------------------------------------bullet 4 movement-------------------------
        
    	   			if(   step== 72 ||  ((BulletSpeed == 10) && step == 32) ) {   
    	   				moveBullet4 = true;
    	   			}
    	   		
    	   			if(moveBullet4 == true){
    	   				BulletY4 -= BulletSpeed;}
    	   			
    	   			if(BulletY4 == 10){
    	   				BulletY4=450;
    	   				moveBullet4 = false;
    	   			}
        
       
  //------------------------------bullet9 movement--------------------------------
        
       
    	   			if( step== 81 ||  ((BulletSpeed == 10) && step == 36) ) {   
    	   				moveBullet9 = true;
    	   			}
     	   			if(moveBullet9 == true){
    	   				BulletY9 -= BulletSpeed;}
 
                                if(BulletY9 == 10){
    	   				BulletY9=450; 
    	   				moveBullet9 = false;
    	   			}
        
        
                                if(MinionMove == true)    
    	   			mobsSteps +=1; 
    	   			step += 1; 
        
    	   			 if(mobsSteps >= 140){
        	
    	   				mobsSteps=0;
        	
   	   				minion1Y=-10;
    	   				minion2Y=-10;
    	   				minion3Y=-10;
    	   				minion4Y=-10;
    	   				minion5Y=-10;
        	
   	   				minion1X=20;
    	   				minion2X=120;
    	   				minion3X=220;
    	   				minion4X=320;
    	   				minion5X=420;
        	
  	   				MinionHP =  randHP.nextInt((10-5)+1)+5;;
    	   				MinionHP2 = randHP.nextInt((10-5)+1)+5;;
    	   				MinionHP3 = randHP.nextInt((10-5)+1)+5;;
    	   				MinionHP4 = randHP.nextInt((10-5)+1)+5;;
    	   				MinionHP5 = randHP.nextInt((10-5)+1)+5;;
                                        
                                        Minions = 5;
                                        if(MinionMove == true && mobsIsAlive==false )
                                        MinionWaveCount++;
    	   			}
    	   			else {}
        
  	   			if(step == 88    ||  ((BulletSpeed == 10) && step == 44) ){
    	   				step = 0;
    	   			}
         
       }
        
    }
        

        
        
    public Squares(Animation anim) throws IOException{
		//LOAD IMAGE
//           ImageIcon a   = new ImageIcon ("C:/Users/xtrik/OneDrive/Documents/NetBeansProjects/Squares/src/squares/allens2.png") ;  
//           Allens = a.getImage();
    	
   	this.anim=anim;
     
		// GAME PROPERTIES
    	playerAnim = new Animation(200, playerShipOne);
	addMouseMotionListener(new Squares.MS());
	addKeyListener(new Squares.KA());
        
        
        setLayout(new BorderLayout());
	JLabel background=new JLabel(new ImageIcon("C:/Users/ASUS/Documents/GitHub/Square/res/background.jpg"));
	add(background);
	background.setLayout(new FlowLayout());
        
        
    	setTitle("SQUARES");
    	setSize(500,500);
    	setResizable(false);
    	setVisible(true);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
    	setLocationRelativeTo(null);
 
        
    }
    
  
    @Override
		public void paint (Graphics g){
//    	 File bg = new File(Squares.class.getResource("background.jpg").getFile());
//	     try {
//			BufferedImage bgs = ImageIO.read(bg);
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		dbimage = createImage(getWidth(), getHeight());
		dbg = dbimage.getGraphics();
		try {
			
			paintComponent(dbg);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		g.drawImage(dbimage, 0, 0, this);
	}

		public void paintComponent (Graphics g)throws IOException{
			 File playerShip = new File(Squares.class.getResource("playerShip.png").getFile());
		     BufferedImage player = ImageIO.read(playerShip);
		
		     SpriteSheet playerCut = new SpriteSheet(player);
		     	     
		 	//Player
		 	playerShipOne = new BufferedImage[4];
		 	
		 	
		 	
		 	playerShipOne[0] = playerCut.grabImage(1, 1, 64, 64);
		 	playerShipOne[1] = playerCut.grabImage(2, 1, 64, 64);
		 	playerShipOne[2] = playerCut.grabImage(3, 1, 64, 64);
		 	playerShipOne[3] = playerCut.grabImage(4, 1, 64, 64);
		 	
			playerAnim = new Animation(200,playerShipOne);
		 	
			  g.drawString("PRESS ENTRER TO START GAME",150 ,250);
			  if(mouseDragged){
				
				  GameRunning = true;
				  
				 
			  }
			  
			  
	if(GameRunning == true)	{	

			  Rectangle Bortakloi = new Rectangle(mx,450, 63, 30);
			
                if(mouseDragged){
                    g.setColor(Color.DARK_GRAY);
                    g.fillRect(0, 0, getWidth(), getHeight());
                    g.setColor(Color.LIGHT_GRAY);
                    g.fillRect(Bortakloi.x,450, 40, 30);
                    g.drawImage(getPlayerAnimation(),  Bortakloi.x,430,this);
                   
                    if(mx<=433) {
                    	 System.out.println("captuer");
                    	Bortakloi.x=430;
                    }else if(mx>=0) {
                    	Bortakloi.x=0;
                    }
                    
                    
                    isGameOver = false;
                   
                } 
                else{
                	
                    g.setColor(Color.BLACK);
                    g.fillRect(0, 0, getWidth(), getHeight());
                    g.setColor(Color.LIGHT_GRAY);
                    g.fillRect(Bortakloi.x,450, 63, 30);
                    g.drawImage(getPlayerAnimation(),  Bortakloi.x,430,this);
                    if(mx>=433) {
                    	System.out.println(mx+" captuer");
                    	mx=433;
                    }else if(mx<=0) {
                    	mx=0;
                    }
                   
                }

                    //bullet initial X coordinate and ready to fire
                    
                    int BulletX = mx;
                    
                    if (BulletY == 450)
                        BulletXinitial = mx;
                        
                    
                    if (BulletY <= 449 ){
                        BulletX = BulletXinitial;
                        
                    }

                    
                    // bullet1 initial X coordinate and ready to fire
                    
                    int BulletX1 = mx;
                    
                    if (BulletY1 == 450)
                        BulletXinitial1 = mx;
                    
                    if (BulletY1 <= 449 ){
                        BulletX1 = BulletXinitial1;
                        ReadyToFire1 = true;
                    }
        
                    // bullet2 initial X coordinate and ready to fire
                    
                    int BulletX2 = mx;
                    
                    if (BulletY2 == 450)
                        BulletXinitial2 = mx;
                    
                    if (BulletY2 <= 449 ){
                        BulletX2 = BulletXinitial2;
                        ReadyToFire2 = true;
                    }
                  
                    
           // bullet3 initial X coordinate and ready to fire
                    
                    int BulletX3 = mx;
                    
                    if (BulletY3 == 450)
                        BulletXinitial3 = mx;
                    
                    if (BulletY3 <= 449 ){
                        BulletX3 = BulletXinitial3;
                        ReadyToFire3 = true;
                    }

                    
           // bullet4 initial X coordinate and ready to fire
                    
                    int BulletX4 = mx;
                    
                    if (BulletY4 == 450)
                        BulletXinitial4 = mx;
                    
                    if (BulletY4 <= 449 ){
                        BulletX4 = BulletXinitial4;
                        ReadyToFire4 = true;
                    }
            
                    
                    int BulletX5 = mx;
                    
                    if (BulletY5 == 450)
                        BulletXinitial5 = mx;
                    
                    if (BulletY5 <= 449 ){
                        BulletX5 = BulletXinitial5;
                        ReadyToFire5 = true;
                    }
            
                    
                    
                    int BulletX6 = mx;
                    
                    if (BulletY6 == 450)
                        BulletXinitial6 = mx;
                    
                    if (BulletY6 <= 449 ){
                        BulletX6 = BulletXinitial6;
                        ReadyToFire6 = true;
                    }
            

                    
                    int BulletX7 = mx;
                    
                    if (BulletY7 == 450)
                        BulletXinitial7 = mx;
                    
                    if (BulletY7 <= 449 ){
                        BulletX7 = BulletXinitial7;
                        ReadyToFire7 = true;
                    }
            
                    
                    
                    int BulletX8 = mx;
                    
                    if (BulletY8 == 450)
                        BulletXinitial8 = mx;
                    
                    if (BulletY8 <= 449 ){
                        BulletX8 = BulletXinitial8;
                        ReadyToFire8 = true;
                    }
            
                    
                    int BulletX9 = mx;
                    
                    if (BulletY9 == 450)
                        BulletXinitial9 = mx;
                    
                    if (BulletY9 <= 449 ){
                        BulletX9 = BulletXinitial9;
                        ReadyToFire9 = true;
                    }
              
                   
            // mobs Bullet

            // mobs bullet initial X coordinate and ready to fire
                    
                     mobsBulletX = mobsX;
                    
                    if (mobsReadyToFire == true) {
                        mobsBulletXinitial = mobsX + 25 ;
                        mobsReadyToFire = false;
                    }
                    
                    if (mobsBulletY <= 500 ){
                        mobsBulletX = mobsBulletXinitial;}
                    
                   
             //-------------- MINION physicalization-----------------------------
                    
                    File enemyOne = new File(Squares.class.getResource("enemyOne.png").getFile());
          		     BufferedImage enemyO = ImageIO.read(enemyOne);
          		     
                    Rectangle MINION1 = new Rectangle(minion1X,minion1Y, 90, 30);
                    g.setColor(Color.YELLOW);
                    g.fillRect(MINION1.x, MINION1.y, MINION1.width, MINION1.height);
                    g.drawImage(enemyO,  MINION1.x-8, MINION1.y-14,this);
                    
                    Rectangle MINION2 = new Rectangle(minion2X,minion2Y, 90, 30);
                    g.setColor(Color.YELLOW);
                    g.fillRect(MINION2.x, MINION2.y, MINION2.width, MINION2.height);
                    g.drawImage(enemyO,  MINION2.x-8, MINION2.y-14,this);
                    
                    Rectangle MINION3 = new Rectangle(minion3X,minion3Y, 90, 30);
                    g.setColor(Color.YELLOW);
                    g.fillRect(MINION3.x, MINION3.y, MINION3.width, MINION3.height);
                    g.drawImage(enemyO,  MINION3.x-8, MINION3.y-14,this);
                    
                    Rectangle MINION4 = new Rectangle(minion4X,minion4Y, 90, 30);
                    g.setColor(Color.YELLOW);
                    g.fillRect(MINION4.x, MINION4.y, MINION4.width, MINION4.height);
                    g.drawImage(enemyO,  MINION4.x-8, MINION4.y-14,this);                    
                    
                    Rectangle MINION5 = new Rectangle(minion5X,minion5Y, 90, 30);
                    g.setColor(Color.YELLOW);
                    g.fillRect(MINION5.x, MINION5.y, MINION5.width, MINION5.height);
                    g.drawImage(enemyO,  MINION5.x-8, MINION5.y-14,this);  
                    
                    
                    
                    //Bullet physicalization
                    File playerProjectile = new File(Squares.class.getResource("bullet.png").getFile());
       		     BufferedImage playerP = ImageIO.read(playerProjectile);
                    
                    Rectangle Bullet = new Rectangle(BulletX,BulletY, 10, 10);
//                    g.setColor(Color.WHITE);
//                    g.fillRect(Bullet.x, Bullet.y, Bullet.width, Bullet.height);
                    g.drawImage(playerP,  Bullet.x+22,Bullet.y-20,this);
                    //Bullet1 physicalization
                    Rectangle Bullet1 = new Rectangle(BulletX1,BulletY1, 10, 10);
//                    g.setColor(Color.WHITE);
//                    g.fillRect(Bullet1.x, Bullet1.y, Bullet1.width, Bullet1.height);
                    g.drawImage(playerP,  Bullet1.x+22,Bullet1.y-20,this);
                     
                    //Bullet2 physicalization
                    Rectangle Bullet2 = new Rectangle(BulletX2,BulletY2, 10, 10);
//                    g.setColor(Color.WHITE);
//                    g.fillRect(Bullet2.x, Bullet2.y, Bullet2.width, Bullet2.height);
                    g.drawImage(playerP,  Bullet2.x+22,Bullet2.y-20,this);
                    
                    //Bullet3 physicalization
                    Rectangle Bullet3 = new Rectangle(BulletX3,BulletY3,  10, 10);
//                    g.setColor(Color.WHITE);
//                    g.fillRect(Bullet3.x, Bullet3.y, Bullet3.width, Bullet3.height);
                    g.drawImage(playerP,  Bullet3.x+22,Bullet3.y-20,this);
                    
                    //Bullet4 physicalization
                    Rectangle Bullet4 = new Rectangle(BulletX4,BulletY4,  10, 10);
//                  g.setColor(Color.WHITE);
//                  g.fillRect(Bullet4.x, Bullet4.y, Bullet4.width, Bulle4.height);
                    g.drawImage(playerP,  Bullet4.x+22,Bullet4.y-20,this);
                     
                    //Bullet5 physicalization
                    Rectangle Bullet5 = new Rectangle(BulletX5,BulletY5,  10, 10);
//                    g.setColor(Color.WHITE);
//                    g.fillRect(Bullet5.x, Bullet5.y, Bullet5.width, Bullet5.height);
                    g.drawImage(playerP,  Bullet5.x+22,Bullet5.y-20,this);
                    
                    //Bullet6 physicalization
                    Rectangle Bullet6 = new Rectangle(BulletX6,BulletY6,  10, 10);
//                    g.setColor(Color.WHITE);
//                    g.fillRect(Bullet6.x, Bullet6.y, Bullet6.width, Bullet6.height);
                    g.drawImage(playerP,  Bullet6.x+22,Bullet6.y-20,this);    
                    
                    //Bullet7 physicalization
                    Rectangle Bullet7 = new Rectangle(BulletX7,BulletY7, 10, 10);
//                    g.setColor(Color.WHITE);
//                    g.fillRect(Bullet7.x, Bullet7.y, Bullet7.width, Bullet7.height);
                    g.drawImage(playerP,  Bullet7.x+22,Bullet7.y-20,this);
                     
                    //Bullet8 physicalization
                    Rectangle Bullet8 = new Rectangle(BulletX8,BulletY8,  10, 10);
//                    g.setColor(Color.WHITE);
//                    g.fillRect(Bullet8.x, Bullet8.y, Bullet8.width, Bullet8.height);
                    g.drawImage(playerP,  Bullet8.x+22,Bullet8.y-20,this);
                                      
                    //Bullet9 physicalization
                    Rectangle Bullet9 = new Rectangle(BulletX9,BulletY9,  10, 10);
//                    g.setColor(Color.WHITE);
//                    g.fillRect(Bullet9.x, Bullet9.y, Bullet9.width, Bullet9.height);
                    g.drawImage(playerP,  Bullet9.x+22,Bullet9.y-20,this);
                                         
                  /*  
                   
                    g.setColor(Color.RED);
                    String a = Integer.toString(BulletX);
                    String b = Integer.toString(Bullet.y);
                    String c = Integer.toString(mobhp);
                    String d = Integer.toString(step);
                    String f = Integer.toString(MinionHP);
                    String h = Integer.toString(ThreadCount);
                    g.drawString("mobHP="+c+" Step="+d+" MobsLevel="+MobsLevel+" MobX="+mobsX+" MX="+MinionMove+" MWC="+MinionWaveCount, 20, 100);
                  
                  */
                    
                    
                    String tm = "";
                    if(Timer == 1)
                        tm = "3";
                    if(Timer == 2)
                        tm = "2";
                    if(Timer == 3)
                        tm = "1";
                    if(Timer == 4)
                        tm = "GO";
                    g.setFont(new Font("Agency FB", Font.BOLD, 25));
                    g.setColor(Color.RED);
                    if(Timer <= 4 && FisrtRun == true)
                        g.drawString(""+tm,250,250);
                    else{FisrtRun = false;}

                    //  Mobs Bullet physicalization
                    
                    Rectangle mobsBullet = new Rectangle(mobsBulletX,mobsBulletY, 15, 15);
                   
                    g.setColor(Color.MAGENTA);
                    g.fillRect(mobsBullet.x, mobsBullet.y, mobsBullet.width, mobsBullet.height);
                      
                    
                    g.setFont(new Font("Agency FB", Font.BOLD, 17));
                    g.setColor(Color.RED);
                    g.drawString("SCORE "+TotalDMG , 400, 50);
                    
                     
                 //mobs hp counter and displacement
                    
                 if(mobhp > 0)
                      Mob = new Rectangle(mobsX,mobsY,50,50);
                    
                 
                    if(mobhp < 0){
                       mobsIsAlive = false;
                       mobsX = 550;
                       mobsSteps = 140;
                      // MinionMove = true;
                       BossRespawn = true;
                       mobhp = 100 + (MobsLevel*200);
                       ThreadCount = 0;
                       Timer = 0;
                       
                    }
                    else{
                        if(Mob.intersects(Bortakloi)){
                             isGameOver = true;
                        }
                        
                        if(Bullet.intersects(Mob)) {
                            BulletY = 450;
                            ReadyToFire = false;
                            moveBullet = false;
                            g.setColor(Color.red);                       
                            mobhp -= 10;
                            
                            TotalDMG = TotalDMG +10;
                            
                        }
                        else if(Bullet1.intersects(Mob)){
                            BulletY1 = 450;
                            ReadyToFire1 = false;
                            moveBullet1 = false;
                            g.setColor(Color.red);                       
                             mobhp -= 10;
                             TotalDMG = TotalDMG +10;
                             
                        }
                        else if(Bullet2.intersects(Mob)){
                            BulletY2 = 450;
                            ReadyToFire2 = false;
                            moveBullet2 = false;
                            g.setColor(Color.red);                       
                             mobhp -= 10;
                             
                             TotalDMG = TotalDMG +10;
                        }
                        else if(Bullet3.intersects(Mob)){
                            BulletY3 = 450;
                            ReadyToFire3 = false;
                            moveBullet3 = false;
                            g.setColor(Color.red);                       
                             mobhp -= 10;
                             
                             TotalDMG = TotalDMG +10;
                        }
                        else if(Bullet4.intersects(Mob)){
                            BulletY4 = 450;
                            ReadyToFire4 = false;
                            moveBullet4 = false;
                            g.setColor(Color.red);                       
                             mobhp -= 10;
                             
                             TotalDMG = TotalDMG +10;
                     	
                        }
                        else if(Bullet5.intersects(Mob)){
                            BulletY5 = 450;
                            ReadyToFire5 = false;
                            moveBullet5 = false;
                            g.setColor(Color.red);                       
                             mobhp -= 10;
                             
                             TotalDMG = TotalDMG +10;
                     	
                        }
                        else if(Bullet6.intersects(Mob)){
                            BulletY6 = 450;
                            ReadyToFire6 = false;
                            moveBullet6 = false;
                            g.setColor(Color.red);                       
                             mobhp -= 10;
                             
                             TotalDMG = TotalDMG +10;
                     	
                        }
                        else if(Bullet7.intersects(Mob)){
                            BulletY7 = 450;
                            ReadyToFire7 = false;
                            moveBullet7 = false;
                            g.setColor(Color.red);                       
                             mobhp -= 10;
                             
                             TotalDMG = TotalDMG +10;
                     	
                        }
                        else if(Bullet8.intersects(Mob)){
                            BulletY8 = 450;
                            ReadyToFire8 = false;
                            moveBullet8 = false;
                            g.setColor(Color.red);                       
                             mobhp -= 10;
                             
                             TotalDMG = TotalDMG +10;
                     	
                        }
                        else if(Bullet9.intersects(Mob)){
                            BulletY9 = 450;
                            ReadyToFire9 = false;
                            moveBullet9 = false;
                            g.setColor(Color.red);                       
                            mobhp -= 10;
                            TotalDMG = TotalDMG +10;
                     	}
                        else{
                             g.setColor(Color.blue);}
                    
                   }
       
                    g.fillRect(mobsX, mobsY, Mob.width, Mob.height);

                    
                    if(MINION1.intersects(Bullet) || MINION1.intersects(Bullet1) || 
                    		MINION1.intersects(Bullet2) || MINION1.intersects(Bullet3)||
                    		MINION1.intersects(Bullet4) || MINION1.intersects(Bullet5)||
                    		MINION1.intersects(Bullet6) || MINION1.intersects(Bullet7)||    		
                    		MINION1.intersects(Bullet8) || MINION1.intersects(Bullet9) ) { 
                    	
                    	
                            if(MINION1.intersects(Bullet)) 
                                   BulletXinitial= -550;
                  
                    	    if(MINION1.intersects(Bullet1)) 
                                   BulletXinitial1= -550;
             		
                            if(MINION1.intersects(Bullet2)) 
                    		   BulletXinitial2= -550;
                    		
                            if(MINION1.intersects(Bullet3)) 
                                   BulletXinitial3= -550;
                    	
                            if(MINION1.intersects(Bullet4)) 
                    		   BulletXinitial4= -550;
                    	
                    	    if(MINION1.intersects(Bullet5)) 
                                   BulletXinitial5= -550;
                        	
                    	    if(MINION1.intersects(Bullet6)) 
                     		   BulletXinitial6= -550;
                     	
                     	    if(MINION1.intersects(Bullet7)) 
                       		   BulletXinitial7= -550;
                       	   
                            if(MINION1.intersects(Bullet8)) 
                     		   BulletXinitial8= -550;
                     	   
                            if(MINION1.intersects(Bullet9)) 
                      		   BulletXinitial9= -550;
                    	    
                    	    
                        	//-------------- minion1 HP config-----------------
                        	
                        	 TotalDMG = TotalDMG +2;
                        	 
                        	 
                        	 if(MobsLevel >= 5) {
                        		 MinionHP = MinionHP -1;}
                                 else if(MobsLevel ==4 || MobsLevel ==3 ) {
                        		 MinionHP = MinionHP - 2;}
                        	 else if(MobsLevel < 3) {
                                         MinionHP = MinionHP - 3; }
                                 else {}
                        	 
                        	 if(MinionHP < 0) {
                                    minion1X = 560;
                                    Minions--;}
                 	 
                        	 
                     }
                    
                    
                    
                    if(MINION2.intersects(Bullet) || MINION2.intersects(Bullet1) || 
                    		MINION2.intersects(Bullet2) || MINION2.intersects(Bullet3)||
                    		MINION2.intersects(Bullet4) || MINION2.intersects(Bullet5)||
                    		MINION2.intersects(Bullet6) || MINION2.intersects(Bullet7)||    		
                    		MINION2.intersects(Bullet8) || MINION2.intersects(Bullet9) ) { 
                    	
                    	
                    		if(MINION2.intersects(Bullet)) 
                                   BulletXinitial= -550;
                    			
                    		if(MINION2.intersects(Bullet1))
                                   BulletXinitial1 = -550;
                    		
                                if(MINION2.intersects(Bullet2))
                                   BulletXinitial2 = -550;
                    		
                    		if(MINION2.intersects(Bullet3)) 
                                   BulletXinitial3 = -550;
                    			
                    		if(MINION2.intersects(Bullet4)) 
                                   BulletXinitial4 = -550;
                    			
                    		 if(MINION2.intersects(Bullet5)) 
                                   BulletXinitial5= -550;
                        	
                                if(MINION2.intersects(Bullet6)) 
                     		   BulletXinitial6= -550;
                     	
                                if(MINION2.intersects(Bullet7)) 
                       		   BulletXinitial7= -550;
                       	   
                       		if(MINION2.intersects(Bullet8)) 
                     		   BulletXinitial8= -550;
                     	   
                       		if(MINION2.intersects(Bullet9)) 
                      		   BulletXinitial9= -550;
                    	    
                        	
                        	 
                        	 TotalDMG = TotalDMG +2;
                        	 
                        	 
                        //-------------- minion2 HP config-----------------
                         	
                        
                        	 if(MobsLevel >= 5) {
                        		 MinionHP2 = MinionHP2 -1;}
                                 else if(MobsLevel ==4 || MobsLevel ==3 ) {
                        		 MinionHP2 = MinionHP2 - 2;}
                        	 else if(MobsLevel < 3) {
                                         MinionHP2 = MinionHP2 - 3;}
                                 else {}
                    	 
                        	 if(MinionHP2< 0){ 
                                    minion2X = 560;
                                 Minions--;}
                        
                      	 
                     }
                    
       
                    if(MINION3.intersects(Bullet) || MINION3.intersects(Bullet1) || 
                     		MINION3.intersects(Bullet2) || MINION3.intersects(Bullet3)||
                    		MINION3.intersects(Bullet4) || MINION3.intersects(Bullet5)||
                    		MINION3.intersects(Bullet6) || MINION3.intersects(Bullet7)||    		
                    		MINION3.intersects(Bullet8) || MINION3.intersects(Bullet9) ) { 
                    	
                    	
                            if(MINION3.intersects(Bullet)) 
                                   BulletXinitial = -550;
                    			
                            if(MINION3.intersects(Bullet1))
                                   BulletXinitial1 = -550;
                    			
                            if(MINION3.intersects(Bullet2)) 
                                   BulletXinitial2 = -550;
                    			
                            if(MINION3.intersects(Bullet3)) 
                                   BulletXinitial3 = -550;
                    			
                            if(MINION3.intersects(Bullet4)) 
                    		   BulletXinitial4 = -550;
                    		
                    	    if(MINION3.intersects(Bullet5)) 
                        	   BulletXinitial5= -550;
                        	
                    	    if(MINION3.intersects(Bullet6)) 
                     		   BulletXinitial6= -550;
                     	
                     	    if(MINION3.intersects(Bullet7)) 
                       		   BulletXinitial7= -550;
                       	   
                       	    if(MINION3.intersects(Bullet8)) 
                     		   BulletXinitial8= -550;
                     	   
                       	    if(MINION3.intersects(Bullet9)) 
                      		   BulletXinitial9= -550;
                  
                        	 TotalDMG = TotalDMG +2;
                        	 
                        	 
                        	 
                        //-------------- minion3 HP config-----------------
                         	
                        
                        	 
                        	 
                        	if(MobsLevel >= 5) 
                        		 MinionHP3 = MinionHP3 -1;
                        	else if(MobsLevel ==4 || MobsLevel ==3 ) 
                        		 MinionHP3 = MinionHP3 - 2;
                                else if(MobsLevel < 3) 
                                         MinionHP3 = MinionHP3 - 3;
                                else {}
                        	 
                        	
                        	 if(MinionHP3 < 0){
                        	  minion3X = 560;
                                 Minions--;}
                      }
                 
                    if(MINION4.intersects(Bullet) || MINION4.intersects(Bullet1) || 
                     		MINION4.intersects(Bullet2) || MINION4.intersects(Bullet3)||
                    		MINION4.intersects(Bullet4) || MINION4.intersects(Bullet5)||
                    		MINION4.intersects(Bullet6) || MINION4.intersects(Bullet7)||    		
                    		MINION4.intersects(Bullet8) || MINION4.intersects(Bullet9) ) { 
                    	
                        	
                                if(MINION4.intersects(Bullet)) 
                		   BulletXinitial = -550;
                			
                		if(MINION4.intersects(Bullet1)) 
                		   BulletXinitial1 = -550;
                			
                                if(MINION4.intersects(Bullet2)) 
                		   BulletXinitial2 = -550;
                		
                		if(MINION4.intersects(Bullet3)) 
                		   BulletXinitial3 = -550;
                		
                		if(MINION4.intersects(Bullet4)) 
                                   BulletXinitial4 = -550;
                		
                		if(MINION4.intersects(Bullet5)) 
                    		   BulletXinitial5= -550;
                    	
                                if(MINION4.intersects(Bullet6)) 
                 		   BulletXinitial6= -550;
                 	
                                if(MINION4.intersects(Bullet7)) 
                   		   BulletXinitial7= -550;
                   	   
                   		if(MINION4.intersects(Bullet8)) 
                 		   BulletXinitial8= -550;
                 	   
                   		if(MINION4.intersects(Bullet9)) 
                  		   BulletXinitial9= -550;
                	    
                		
                        	 TotalDMG = TotalDMG +2;
                   
                        //-------------- minion4 HP config-----------------
                    
                        	if(MobsLevel >= 5) 
                        		 MinionHP4 = MinionHP4 -1;
                        	else if(MobsLevel ==4 || MobsLevel ==3 ) 
                        		 MinionHP4 = MinionHP4 - 2;
                                else if(MobsLevel < 3) 
                                         MinionHP4 = MinionHP4 - 3;
                                else {}
             
                        	 if(MinionHP4 < 0){
                                    minion4X = 560;
                                 Minions--;}
                 	 
                        	 
                     }
                    
                    
                    if(MINION5.intersects(Bullet) || MINION5.intersects(Bullet1) || 
                            MINION5.intersects(Bullet2) || MINION5.intersects(Bullet3)||
                    		MINION5.intersects(Bullet4) || MINION5.intersects(Bullet5)||
                    		MINION5.intersects(Bullet6) || MINION5.intersects(Bullet7)||    		
                    		MINION5.intersects(Bullet8) || MINION5.intersects(Bullet9) ) { 
                    	
                    	
                    	
                                if(MINION5.intersects(Bullet))
                			BulletXinitial = -550;
                		
                		if(MINION5.intersects(Bullet1)) 
                			BulletXinitial1 = -550;
                		
                		if(MINION5.intersects(Bullet2)) 
                			BulletXinitial2 = -550;
                			
                		if(MINION5.intersects(Bullet3)) 
                			BulletXinitial3 = -550;
                			
                		if(MINION5.intersects(Bullet4)) 
                			BulletXinitial4 = -550;
                		
                                if(MINION5.intersects(Bullet5)) 
                                        BulletXinitial5= -550;
                    	
                                if(MINION5.intersects(Bullet6)) 
                                        BulletXinitial6= -550;
                 	
                                if(MINION5.intersects(Bullet7)) 
                                        BulletXinitial7= -550;
                   	   
                   		if(MINION5.intersects(Bullet8)) 
                                        BulletXinitial8= -550;
                 	   
                   		if(MINION5.intersects(Bullet9)) 
                                        BulletXinitial9= -550;
               	
                        	 TotalDMG = TotalDMG +2;
     	 
                                 
                                 
                  //-------------- minion5 HP config--------------------------------------------------------
                         	 
                        	if(MobsLevel >= 5) 
                        		 MinionHP5 = MinionHP5 -1;
                        	else if(MobsLevel ==4 || MobsLevel ==3 ) 
                        		 MinionHP5 = MinionHP5 - 2;
                                else if(MobsLevel < 3) 
                                         MinionHP5 = MinionHP5 - 3;
                                else {}    
                        	                        	 
                        	                        	 
                        	  if(MinionHP5 < 0){ 
                        	    minion5X = 560;
                                    Minions--;
                                  }
           	 
                     }
   
                    if(Bortakloi.intersects(MINION1)     || Bortakloi.intersects(MINION2)
                    	||Bortakloi.intersects(MINION3)  ||Bortakloi.intersects(MINION4)  
                    	||Bortakloi.intersects(MINION5)     ) {  
                    	isGameOver = true;
                     }
                    
                    if(mobsBullet.intersects(Bortakloi)) {
                    	isGameOver = true; }
                    
                    if(isGameOver == true) {
                    	g.drawString("GAME OVER \n SCORE  "+TotalDMG , 200, 250);}
          }
		repaint();
	}

    @SuppressWarnings("deprecation")
	public static void main(String[] args)throws IOException {
    	Squares M = new Squares(playerAnim);
        
    	
    	
    	
        final  Thread t1 = new Thread(M);
    	
      
    	if(isGameOver == true)
		{
			t1.destroy();
    		
		}
    	else {
    		t1.start();
    	}

    }

    @Override
    public void run() {
               try{
                         while(true){
                             
                                Thread.sleep(15);
                                if(GameRunning == true) {
					if(isGameOver == true)
					{
                                            if(RestartGame == true) {
						Restart();
						isGameOver = false;
						RestartGame = false;
						}
					}
					else {
						move();
					}
				}
			}
		}
		catch(Exception e){
			System.out.print("Error");
		}
    }

    
    
     public class MS extends MouseMotionAdapter {
    	 
        @Override
		public void mouseDragged(MouseEvent e) {
        	
        	
        	if(isGameOver == false) {
        	  mx = e.getX()-10;
                  my = e.getY()-10;
                  e.consume();
                 
        	}
      	}
    
       @Override
	public void mouseMoved(MouseEvent e) {
    	  
    	   if(isGameOver == false) {
    		   mx = e.getX()-10;
    		   my = e.getY()-10;
                   e.consume();
    	   }
         }
       
       public void mousePressed(MouseEvent me)
     	{
    	//   mouseDragged = true;
     	}
     }
   
     public class KA extends KeyAdapter {

 		@Override
		public void keyPressed(KeyEvent e){
 			int keyCode = e.getKeyCode();
                        if(keyCode == KeyEvent.VK_ENTER){
 				if(StartProgram == true && isGameOver == false)
 					GameRunning = true;
 						
 					if(isGameOver == true){
                                            RestartGame = true;
 					}
 			}
                }
 	}
     
     
    
    	 
   public BufferedImage getPlayerAnimation() {
	   return playerAnim.getCurrentFrame();
   } 	 
    	
    	 	
    	 
     
     
     
}

