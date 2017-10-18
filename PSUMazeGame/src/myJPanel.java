
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import javax.swing.ImageIcon;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rmk5333
 */

    

public class myJPanel extends JPanel implements ActionListener, KeyListener
{
    JButton RTBT = new JButton("Return");
    myJPanel1 p1;
    myJPanel2 p2;
    MyJpanelInstruction p3;
    MyJpanelCreators p4;
    optionPanel o;
    DifficultyButton D;
    gamePanel g;
    JLabel jl;
    MyScores ms;
   
    XmlWrite xw;
  
    String st;
    String st1;
    Image myImage;
    ImageIcon imageLocal;
    JButton fred = new JButton(new ImageIcon("images/psuLion.jpg"));
    int c =100;
    int s = 100;
    
    String text_response;
    
    
    
    
    Rectangle z1,z2,z3,z3_1,z4,z5,z5_1,z6,z7,z8,z9,z10,z11,z12,z13,z14,z15,z16,z17,z18,z19,z20,z21,z22,
            z23,z24,z25,z26,z27,z28,z29,z30,z31,z32,z33,z34,z35,z36,z37,z38,z39,z40,z41,z42,z43,z44,z45,
            z46,z47,z48,z49,z50,z51,z52,z53,z54,z55,z56,z57,z58,z59,z60,z61,z62,z63;
    
    
                          JButton q1 = new JButton();
                          JButton q2 = new JButton();
                          JButton q3 = new JButton();
                          JButton q4 = new JButton();
                          JButton q5 = new JButton();
                          JButton q6 = new JButton();
                          JButton q7 = new JButton();
                          JButton q8 = new JButton();
                          JButton q9 = new JButton();
                          JButton q10 = new JButton();
                          JButton q11 = new JButton();
                          JButton q12 = new JButton();
                          JButton q13 = new JButton();
                          JButton q14 = new JButton();
                          JButton q15 = new JButton();
                          JButton q16= new JButton();
                          JButton q17= new JButton();
                          JButton q18= new JButton();
                          JButton q19= new JButton();
                          JButton q20= new JButton();
                          JButton q21= new JButton();
                          JButton q22= new JButton();
                          JButton q23= new JButton();
                          JButton q24= new JButton();
                          JButton q25= new JButton();
                          JButton q26= new JButton();
                          JButton q27= new JButton();
                          JButton q28= new JButton();
                          JButton q29= new JButton();
                          JButton q30= new JButton();
                          JButton q31= new JButton();
                          JButton q32= new JButton();
                          JButton q33= new JButton();
                          JButton q34= new JButton();
                            JButton q35 = new JButton();
                            JButton q36 = new JButton();
                            JButton q37 = new JButton();
                            JButton q38 = new JButton();
                            JButton q39 = new JButton();
                            JButton q40 = new JButton();
                            JButton q41 = new JButton();
                            JButton q42 = new JButton();
                            JButton q43 = new JButton();
                            JButton q44 = new JButton();
                            JButton q45 = new JButton();
                            JButton q46 = new JButton();
                            JButton q47 = new JButton();
                            JButton q48 = new JButton();
                            JButton q49 = new JButton();
                            JButton q50 = new JButton();
                            JButton q51 = new JButton();
                            JButton q52 = new JButton();
                            JButton q53 = new JButton();
                            JButton q54 = new JButton();
                            JButton q55 = new JButton();
                            JButton q56 = new JButton();
                            JButton q57 = new JButton();
                            JButton q58 = new JButton();
                            JButton q59 = new JButton();
                            JButton q60 = new JButton();
                            JButton q61 = new JButton();
                            JButton q62 = new JButton();
                            JButton q63 = new JButton();   
    
    public myJPanel()
    {
        super();
        
       
        
        setBackground(Color.BLUE);
        
        
        
        setLayout (new BorderLayout());
         p3 = new MyJpanelInstruction ();
         p1 = new myJPanel1();
         p2 = new myJPanel2();
         p4 = new MyJpanelCreators ();
         D  = new DifficultyButton ();
         o = new optionPanel();
         g = new gamePanel(D,o,this);
         ms = new MyScores(g,this);
        
         
        
       
        
        add(p1,"Center");
        add(p2,"South");
        
        p2.b1.addActionListener(this);
        p2.b2.addActionListener(this);
        p2.b3.addActionListener(this);
        p2.b4.addActionListener(this);
        
        o.b1.addActionListener(this);
        o.b2.addActionListener(this);
        o.b3.addActionListener(this);
        
        D.Dif1.addActionListener(this);
        D.Dif2.addActionListener(this);
        D.Dif3.addActionListener(this);

        
        
    }
            public void paintComponent(Graphics g)
                            {
                                super.paintComponent(g);
                                g.drawImage(myImage, 0, 0, this);
                                super.paintComponent(g);
                                requestFocusInWindow();
                            }
   
     public void actionPerformed(ActionEvent e)
    {
        Object obj = e.getSource();
        Object obj2 = e.getSource();
      
        if (obj == p2.b2)
        {
           remove(p1);
           remove(p4);
           remove(ms);
           add(p3,"Center");
           validate();
           repaint();
           
        }
        
        if (obj == p2.b3)
        {
           remove(ms);
           remove(p1); 
           remove(p3);
           add(p4,"Center");
           validate();
           repaint();
           
        }
        
        if(obj == p2.b4)
         {
             
             remove(p1);
             remove(p3);
             remove(p4);
             add(ms,"Center");
             
             validate();
             repaint();
         
         }
         if(obj == p2.b1)
        {
               setSize(1280,763);
               
               remove(p3);
               remove(p4);
               remove(ms);
               p1.setLayout(null);
               o.setBounds(550,400,200,200);
               add(p1);
               p1.add(o);
               validate();
               repaint();
               
         
             

                // If statments activated after location has been clicked.
                // Will give the difficulty option
                
        }
       
         if(obj == o.b1  )
          {
                                
                               
                                p1.remove(o);
                                
                                //Sets the layout for the D!
                                
                                //ActionListener
                                
                                setSize(1280,763);
                                p1.setLayout(null);
                                D.setBounds(550,400,200,200);
                                 
                                p1.add(D); 
                                validate();
                                repaint();
                                st = "To Class";
                                imageLocal = new ImageIcon("images/theclass.jpg");
                                
                             }
                        if(obj == o.b2 )
                            {
                                
                                
                                p1.remove(o);
                                //Sets the layout for the D!
                                   
                                 
                                   
                                   
                                setSize(1280,763);
                                p1.setLayout(null);
                                D.setBounds(550,400,200,200);
                              
                               p1.add(D); 
                               validate();
                               repaint();
                               st = "To Football Game";
                               imageLocal = new ImageIcon("images/thegame.jpg");
                            }
                        if(obj == o.b3)
                           {
                               
                                
                               p1.remove(o);
                               
                               //Sets the layout for the D!
                               
                               
                               //Listener
                               
                                setSize(1280,763);
                                p1.setLayout(null);
                                D.setBounds(550,400,200,200);
                                 
                               p1.add(D); 
                               validate();
                                repaint();
                                st = "To Dorm";
                                imageLocal = new ImageIcon("images/thedorm.jpg");
                           }
                             
                        
                       
                             if(obj == D.Dif1)
                            {
                            st1 = "Easy";
                               remove(p1);
                               remove(p2);
                            
                            g.diff=0;
                            setSize(1280,763);
                            
                            JLabel jl = new JLabel("You have chosen: Location: " + st + " Difficulty: " + st1);
                              g.jb1.addActionListener(this);
                              g.add(jl);
                            g.add(g.jb1);
                            
                            add(g);
                            validate();
                            repaint();
                            
                           


                          

                            z1 = new Rectangle(50,30,10,620);
                            z2 = new Rectangle(50,650,300,10);
                            z3 = new Rectangle(350,485,10,175);
                            z4 = new Rectangle(135,185,10,380);
                            z5 = new Rectangle(135,565,135,10);
                            z6 = new Rectangle(270,405,10,170);
                            z7 = new Rectangle(270,405,670,10);
                            z8 = new Rectangle(350,485,135,10);
                            z9 = new Rectangle(485,485,10,175);
                            z10 = new Rectangle(485,650,85,10);
                            z11 = new Rectangle(570,485,10,175);
                            z12 = new Rectangle(195,115,375,10);
                            z13 = new Rectangle(570,485,285,10);
                            z14 = new Rectangle(135,30,835,10);
                            z15 = new Rectangle(570,115,10,150);
                            z16 = new Rectangle(345,265,235,10);
                            z17 = new Rectangle(335,190,10,85);
                            z18 = new Rectangle(250,180,95,10);
                            z19 = new Rectangle(250,190,10,170);
                            z20 = new Rectangle(250,350,435,10);
                            z21 = new Rectangle(675,115,10,245);
                            z22 = new Rectangle(675,115,210,10);
                            z23 = new Rectangle(970,30,10,205);
                            z24 = new Rectangle(885,115,10,205);
                            z25 = new Rectangle(885,320,190,10);
                            z26 = new Rectangle(970,235,190,10);
                            z27 = new Rectangle(1160,235,10,340);
                            z28 = new Rectangle(1075,320,10,255);
                            z29 = new Rectangle(940,405,10,160);
                            z30 = new Rectangle(855,485,10,145);
                            z31 = new Rectangle(855,630,220,10);
                            z32 = new Rectangle(940,565,135,10);

                            q1.setBounds(z1);
                            q2.setBounds(z2);
                            q3.setBounds(z3);
                            q4.setBounds(z4);
                            q5.setBounds(z5);
                            q6.setBounds(z6);
                            q7.setBounds(z7);
                            q8.setBounds(z8);
                            q9.setBounds(z9);
                            q10.setBounds(z10);
                            q11.setBounds(z11);
                            q12.setBounds(z12);
                            q13.setBounds(z13);
                            q14.setBounds(z14);
                            q15.setBounds(z15);
                            q16.setBounds(z16);
                            q17.setBounds(z17);
                            q18.setBounds(z18);
                            q19.setBounds(z19);
                            q20.setBounds(z20);
                            q21.setBounds(z21);
                            q22.setBounds(z22);
                            q23.setBounds(z23);
                            q24.setBounds(z24);
                            q25.setBounds(z25);
                            q26.setBounds(z26);
                            q27.setBounds(z27);
                            q28.setBounds(z28);
                            q29.setBounds(z29);
                            q30.setBounds(z30);
                            q31.setBounds(z31);
                            q32.setBounds(z32);
                            
                           
                         
                             }
                             if(obj == D.Dif2)
                            {
                             st1 = "Medium";
                                remove(p1);
                                remove(p2);
                           
                            g.diff=1;
                            setSize(1280,763);
                            JLabel jl = new JLabel("You have chosen: Location: " + st + " Difficulty: " + st1);
                            g.jb1.addActionListener(this);
                            g.add(jl);
                            g.add(g.jb1);
                            
                            add(g);
                            validate();
                            repaint();
                            
                            ///medium level map
                            //button setup
                            
                          
                             
                             
                             
                             
            
                
                
                
                
                
                
                
//------------Placing------------------------------------
                    // x,y, length, height)
		 z1 = new Rectangle(100,50,700,10);
		 z2 = new Rectangle(50,130,10,300);
		 z3 = new Rectangle(200,50,10,150);
		 z4 = new Rectangle(50,430,10,310);
                 z5 = new Rectangle(50,130,40,10);
                 z6 = new Rectangle(130,190,80,10);
                 z7 = new Rectangle(200,130,450,10);
                 z8 = new Rectangle(720,50,10,150);
                 z9 = new Rectangle(280,190,450,10);
                 z10 = new Rectangle(790,50,10,210);
                 z11 = new Rectangle(450,200,10,130);
                 z12 = new Rectangle(50,250,230,10);
                 z13 = new Rectangle(50,390,230,10);
                 z14 = new Rectangle(110,400,10,75);
                 z15 = new Rectangle(110,465,230,10);
                 z16 = new Rectangle(340,250,10,225);
                 z17 = new Rectangle(120,320,230,10);
                 z18 = new Rectangle(525,250,275,10);
                 z19 = new Rectangle(450,320,275,10);
                 z20 = new Rectangle(500,320,10,155);
                 z21 = new Rectangle(350,400,80,10);
                 z22 = new Rectangle(420,465,80,10);
                 z23 = new Rectangle(570,390,230,10);
                 z24 = new Rectangle(790,320,10,430);
                 z25 = new Rectangle(570,465,160,10);
                 z26 = new Rectangle(570,470,10,75);
                 z27 = new Rectangle(270,535,530,10);
                 z28 = new Rectangle(190,470,10,150);
                 z29 = new Rectangle(50,535,80,10);
                 z30 = new Rectangle(130,610,600,10);
                 z31 = new Rectangle(725,675,70,10);
                 z32 = new Rectangle(50,740,750,10);
                 z33 = new Rectangle(50,675,530,10);
                 z34 = new Rectangle(650,670,10,75);
                
                
		
                
                
		q1.setBounds(z1);
		q2.setBounds(z2);
		q3.setBounds(z3);
		q4.setBounds(z4);
                q5.setBounds(z5);
                q6.setBounds(z6);
                q7.setBounds(z7);
                q8.setBounds(z8);
                q9.setBounds(z9);
                q10.setBounds(z10);
                q11.setBounds(z11);
                q12.setBounds(z12);
                q13.setBounds(z13);
                q14.setBounds(z14);
                q15.setBounds(z15);
                q16.setBounds(z16);
                q17.setBounds(z17);
                q18.setBounds(z18);
                q19.setBounds(z19);
                q20.setBounds(z20);
                
                q21.setBounds(z21);
                q22.setBounds(z22);
                q23.setBounds(z23);
                q24.setBounds(z24);
                q25.setBounds(z25);
                q26.setBounds(z26);
                q27.setBounds(z27);
                q28.setBounds(z28);
                q29.setBounds(z29);
                q30.setBounds(z30);
                
                q31.setBounds(z31);
                q32.setBounds(z32);
                q33.setBounds(z33);
                q34.setBounds(z34);
                
                
                  
                
                
                
                            
                             }
                            if(obj == D.Dif3)
                             {
                                st1 = "Hard";
                                   remove(p1);
                                   remove(p2);
                            
                            g.diff=2;
                            setSize(1280,763);
                            g.jl = new JLabel("You have chosen: Location: " + st + " Difficulty: " + st1);
                            g.jb1.addActionListener(this);
                            g.add(g.jl);
                            g.add(g.jb1);
                            add(g);
                            validate();
                            repaint();
                            
                            // BUTTTTTTOOOONNNSSSSS!
                            
                            
                            z1 = new Rectangle(150,75,875,10);
                            z2 = new Rectangle(150,150,10,175);
                            z3 = new Rectangle(15,255,135,10);
                            z4 = new Rectangle(15,255,10,495);
                            z5 = new Rectangle(15,750,1050,10);
                            z6 = new Rectangle(1055,650,10,100);
                            z7 = new Rectangle(1055,550,200,10);
                            z8 = new Rectangle(1250,175,10,375);
                            z9 = new Rectangle(1025,175,225,10);
                            z10 = new Rectangle(1025,75,10,100);
                            z11 = new Rectangle(150,140,400,10);
                            z12 = new Rectangle(615,75,10,140);
                            z13 = new Rectangle(785,75,10,140);
                            z14 = new Rectangle(625,140,100,10);
                            z15 = new Rectangle(700,205,95,10);
                            z16 = new Rectangle(425,205,200,10);
                            z17 = new Rectangle(360,150,10,60);
                            z18 = new Rectangle(220,205,10,60);
                            z19 = new Rectangle(220,265,910,10);
                            z20 = new Rectangle(690,205,10,60);
                            z21 = new Rectangle(860,140,10,130);
                            z22 = new Rectangle(995,140,30,10);
                            z23 = new Rectangle(930,185,10,80);
                            z24 = new Rectangle(90,325,10,285);
                            z25 = new Rectangle(100,375,350,10);
                            z26 = new Rectangle(160,385,10,80);
                            z27 = new Rectangle(510,275,10,150);
                            z28 = new Rectangle(580,270,10,60);
                            z29 = new Rectangle(580,330,100,10);
                            z30 = new Rectangle(740,275,10,410);
                            z31 = new Rectangle(590,390,160,10);
                            z32 = new Rectangle(440,385,10,245);
                            z33 = new Rectangle(110,680,400,10);
                            z34 = new Rectangle(160,535,10,150);
                            z35 = new Rectangle(230,380,10,245);
                            z36 = new Rectangle(300,445,140,10);
                            z37 = new Rectangle(510,500,10,250);
                            z38 = new Rectangle(300,520,10,160);
                            z39 = new Rectangle(370,560,10,120);
                            z40 = new Rectangle(290,150,10,60);
                            z41 = new Rectangle(1190,230,60,10);
                            z42 = new Rectangle(995,235,10,30);
                            z43 = new Rectangle(1065,235,10,30);
                            z44 = new Rectangle(300,275,10,50);
                            z45 = new Rectangle(370,335,10,40);
                            z46 = new Rectangle(440,275,10,50);
                            z47 = new Rectangle(520,550,60,10);
                            z48 = new Rectangle(580,550,10,140);
                            z49 = new Rectangle(580,690,100,10);
                            z50 = new Rectangle(655,460,10,60);
                            z51 = new Rectangle(590,450,155,10);
                            z52 = new Rectangle(665,580,80,10);
                            z53 = new Rectangle(640,650,10,40);
                            z54 = new Rectangle(820,335,10,420);
                            z55 = new Rectangle(900,275,10,410);
                            z56 = new Rectangle(980,670,10,80);
                            z57 = new Rectangle(980,330,10,260);
                            z58 = new Rectangle(910,330,70,10);
                            z59 = new Rectangle(1050,330,125,10);
                            z60 = new Rectangle(1050,340,10,70);
                            z61 = new Rectangle(1175,330,10,150);
                            z62 = new Rectangle(1085,480,100,10);
                            z63 = new Rectangle(1120,410,60,10);
                            
                            q1.setBounds(z1);
                            q2.setBounds(z2);
                            q3.setBounds(z3);
                            q4.setBounds(z4);
                            q5.setBounds(z5);
                            q6.setBounds(z6);
                            q7.setBounds(z7);
                            q8.setBounds(z8);
                            q9.setBounds(z9);
                            q10.setBounds(z10);
                            q11.setBounds(z11);
                            q12.setBounds(z12);
                            q13.setBounds(z13);
                            q14.setBounds(z14);
                            q15.setBounds(z15);
                            q16.setBounds(z16);
                            q17.setBounds(z17);
                            q18.setBounds(z18);
                            q19.setBounds(z19);
                            q20.setBounds(z20);
                            q21.setBounds(z21);
                            q22.setBounds(z22);
                            q23.setBounds(z23);
                            q24.setBounds(z24);
                            q25.setBounds(z25);
                            q26.setBounds(z26);
                            q27.setBounds(z27);
                            q28.setBounds(z28);
                            q29.setBounds(z29);
                            q30.setBounds(z30);
                            q31.setBounds(z31);
                            q32.setBounds(z32);
                            q33.setBounds(z33);
                            q34.setBounds(z34);
                            q35.setBounds(z35);
                            q36.setBounds(z36);
                            q37.setBounds(z37);
                            q38.setBounds(z38);
                            q39.setBounds(z39);
                            q40.setBounds(z40);
                            q41.setBounds(z41);
                            q42.setBounds(z42);
                            q43.setBounds(z43);
                            q44.setBounds(z44);
                            q45.setBounds(z45);
                            q46.setBounds(z46);
                            q47.setBounds(z47);
                            q48.setBounds(z48);
                            q49.setBounds(z49);
                            q50.setBounds(z50);
                            q51.setBounds(z51);
                            q52.setBounds(z52);
                            q53.setBounds(z53);
                            q54.setBounds(z54);
                            q55.setBounds(z55);
                            q56.setBounds(z56);
                            q57.setBounds(z57);
                            q58.setBounds(z58);
                            q59.setBounds(z59);
                            q60.setBounds(z60);
                            q61.setBounds(z61);
                            q62.setBounds(z62);
                            q63.setBounds(z63);
                            
                            
                            
                             }
                             
                            
                            if(obj == g.jb1)
                           {
                               setFocusable(true);
                               addKeyListener(this);
                               
                               
                               remove(g);
                               setLayout(null);
                               setSize(1280,763);
                               g.timStart.setBounds(1075,50,200,100);
                               g.tim.start();
                               g.finish.setBounds(g.r1);
                               g.finish.setIcon(imageLocal);
                               add(g.finish);
                               add(g.timStart);
                               
                               validate();
                               repaint();
                               
                               add(fred);
                               fred.setBounds(new Rectangle(c,s,40,40));  
                               
                               if(g.diff ==0)
                               {
                                   
                            add(q1);
                            add(q2);
                            add(q3);
                            add(q4);
                            add(q5);
                            add(q6);
                            add(q7);
                            add(q8);
                            add(q9);
                            add(q10);
                            add(q11);
                            add(q12);
                            add(q13);
                            add(q14);
                            add(q15);
                            add(q16);
                            add(q17);
                            add(q18);
                            add(q19);
                            add(q20);
                            add(q21);
                            add(q22);
                            add(q23);
                            add(q24);
                            add(q25);
                            add(q26);
                            add(q27);
                            add(q28);
                            add(q29);
                            add(q30);
                            add(q31);
                            add(q32);
                               }
                               
                               if(g.diff==1)
                               {
                add(q1);
		add(q2);
		add(q3);
		add(q4);
                add(q5);
                add(q6);
                add(q7);
                add(q8);
                add(q9);
                add(q10);
                add(q11);
                add(q12);
                add(q13);
                add(q14);
                add(q15);
                add(q16);
                add(q17);
                add(q18);
                add(q19);
                add(q20);
                add(q21);
                add(q22);
                add(q23);
                add(q24);
                add(q25);
                add(q26);
                add(q27);
                add(q28);
                add(q29);
                add(q30);
                add(q31);
                add(q32);
                add(q33);
                add(q34);
                               
                               }
                               
                               if(g.diff==2)
                               {
                               
                                   add(q1);
                            add(q2);
                            add(q3);
                            add(q4);
                            add(q5);
                            add(q6);
                            add(q7);
                            add(q8);  
                            add(q9);
                            add(q10);
                            add(q11);
                            add(q12);
                            add(q13);
                            add(q14);
                            add(q15);
                            add(q16);
                            add(q17);
                            add(q18);
                            add(q19);
                            add(q20);
                            add(q21);
                            add(q22);
                            add(q23);
                            add(q24);
                            add(q25);
                            add(q26);
                            add(q27);
                            add(q28);
                            add(q29);
                            add(q30);
                            add(q31);
                            add(q32);
                            add(q33);
                            add(q34);
                            add(q35);
                            add(q36);
                            add(q37);
                            add(q38);
                            add(q39);
                            add(q40);
                            add(q41);
                            add(q42);
                            add(q43);
                            add(q44);
                            add(q45);
                            add(q46);
                            add(q47);
                            add(q48);
                            add(q49);
                            add(q50);
                            add(q51);
                            add(q52);
                            add(q53);
                            add(q54);
                            add(q55);
                            add(q56);
                            add(q57);
                            add(q58);
                            add(q59);
                            add(q60);
                            add(q61);
                            add(q62);
                            add(q63);
                               }
                               
                  
                           }
                 
    }
    public void keyPressed(KeyEvent evt) 
  {
  	
    int kk = evt.getKeyCode();
    if(kk ==  evt.VK_LEFT) {c=c-10;;}
    if(kk ==  evt.VK_RIGHT) {c=c+10;}
    if(kk ==  evt.VK_UP) {s=s-10;}
    if(kk ==  evt.VK_DOWN) {s=s+10;}
    fred.setBounds(new Rectangle(c,s,40,40));
    Rectangle r1 = fred.getBounds();
    Rectangle r2 = g.finish.getBounds();
    
    
    
    //finish line intersection
    if(r1.intersects(r2))
    {
        g.tim.stop();
       text_response = (String)JOptionPane.showInputDialog(null,
    		"Enter your name to save your score  ",
    		"You have won!",
    		//JOptionPane.YES_NO_CANCEL_OPTION,
    		JOptionPane.PLAIN_MESSAGE,
    		null,
    		null,
    		null);
       
       RTBT.setLayout(null);
       RTBT.setBounds(1100,750,100,100);
       add(RTBT);
       xw = new XmlWrite(this,g);
        validate();
        repaint();
       
    }
       
         
         if(g.diff == 2)
    {
        if(r1.intersects(z1) || r1.intersects(z3) || r1.intersects(z7) || r1.intersects(z16)||r1.intersects(z19)
        ||r1.intersects(z22)||r1.intersects(z25)||r1.intersects(z29)||r1.intersects(z31)||r1.intersects(z33)||
        r1.intersects(z36)||r1.intersects(z47)||r1.intersects(z49)||r1.intersects(z51)||r1.intersects(z52)||
        r1.intersects(z62)||r1.intersects(z63)||
        
        r1.intersects(z2) || r1.intersects(z4) || r1.intersects(z8) || r1.intersects(z10)|| r1.intersects(z12)
        ||r1.intersects(z13)||r1.intersects(z18)||r1.intersects(z20)||r1.intersects(z21)||r1.intersects(z23)||
        r1.intersects(z24)||r1.intersects(z26)||r1.intersects(z27)||r1.intersects(z30)||r1.intersects(z32)||
        r1.intersects(z34)||r1.intersects(z35)||r1.intersects(z37)||r1.intersects(z38)||r1.intersects(z39)||
        r1.intersects(z48)||r1.intersects(z50)||r1.intersects(z53)||r1.intersects(z54)||r1.intersects(z55)||
        r1.intersects(z56)||r1.intersects(z57)||r1.intersects(z60)||r1.intersects(z61)||
        
        r1.intersects(z5) || r1.intersects(z9)||r1.intersects(z11)||r1.intersects(z14)||r1.intersects(z15)
        ||r1.intersects(z41)||r1.intersects(z42)||r1.intersects(z43)||r1.intersects(z44)||r1.intersects(z45)||
        r1.intersects(z46)||r1.intersects(z58)||r1.intersects(z59)||
        
        r1.intersects(z6)||r1.intersects(z17)||r1.intersects(z28)||r1.intersects(z40))
        {
             if(kk ==  evt.VK_LEFT) {c=c+10;;}
            if(kk ==  evt.VK_RIGHT) {c=c-10;}
            if(kk ==  evt.VK_UP) {s=s+10;}
            if(kk ==  evt.VK_DOWN) {s=s-10;}
            fred.setBounds(new Rectangle(c,s,40,40));
        }
    }
    if(g.diff == 1)
    {
        if(r1.intersects(z1) || r1.intersects(z3) || r1.intersects(z7) || r1.intersects(z16)||r1.intersects(z19)
        ||r1.intersects(z22)||r1.intersects(z25)||r1.intersects(z29)||r1.intersects(z31)||r1.intersects(z33)||
        
        
        r1.intersects(z2) || r1.intersects(z4) || r1.intersects(z8) || r1.intersects(z10)|| r1.intersects(z12)
        ||r1.intersects(z13)||r1.intersects(z18)||r1.intersects(z20)||r1.intersects(z21)||r1.intersects(z23)||
        r1.intersects(z24)||r1.intersects(z26)||r1.intersects(z27)||r1.intersects(z30)||r1.intersects(z32)||
        r1.intersects(z34)||
        
        r1.intersects(z5) || r1.intersects(z9)||r1.intersects(z11)||r1.intersects(z14)||r1.intersects(z15) ||
        
        
        r1.intersects(z6)||r1.intersects(z17)||r1.intersects(z28))
        {
            if(kk ==  evt.VK_LEFT) {c=c+10;;}
            if(kk ==  evt.VK_RIGHT) {c=c-10;}
            if(kk ==  evt.VK_UP) {s=s+10;}
            if(kk ==  evt.VK_DOWN) {s=s-10;}
            fred.setBounds(new Rectangle(c,s,40,40));
        } }
        if(g.diff == 0)
        {
            if(r1.intersects(z1)||r1.intersects(z2)||r1.intersects(z3)||r1.intersects(z4)||r1.intersects(z5)||r1.intersects(z6)||r1.intersects(z7)||
            r1.intersects(z8)||r1.intersects(z9)||r1.intersects(z10)||r1.intersects(z11)||r1.intersects(z12)||r1.intersects(z13)||r1.intersects(z14)||
            r1.intersects(z15)||r1.intersects(z16)||r1.intersects(z17)||r1.intersects(z18)||r1.intersects(z19)||r1.intersects(z20)||r1.intersects(z21)||
            r1.intersects(z22)||r1.intersects(z23)||r1.intersects(z24)||r1.intersects(z25)||r1.intersects(z26)||r1.intersects(z27)||r1.intersects(z28)||
            r1.intersects(z29)||r1.intersects(z30)||r1.intersects(z31)||r1.intersects(z32))
            {
                if(kk ==  evt.VK_LEFT) {c=c+10;;}
                if(kk ==  evt.VK_RIGHT) {c=c-10;}
                if(kk ==  evt.VK_UP) {s=s+10;}
                 if(kk ==  evt.VK_DOWN) {s=s-10;}
                fred.setBounds(new Rectangle(c,s,40,40));
            }
        }
    }  

    @Override
    public void keyTyped(KeyEvent ke) {
      
    }

    @Override
    public void keyReleased(KeyEvent ke) {
     
    }
        
}       


//============================================================================
   

