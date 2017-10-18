import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.beans.*;

public class XmlWrite  
{
   	XMLEncoder xe;
        myJPanel mp;
        gamePanel gp;
        XMLDecoder de;
	String name;
	int time;

	JButton p1,b2;
	public XmlWrite(myJPanel mainPanel, gamePanel gamePan )
	{
            mp = mainPanel;
            gp = gamePan;
//read
                      try {
              de = new XMLDecoder(new BufferedInputStream(new FileInputStream("info.xml")));
             }
          catch(Exception xx) {xx.printStackTrace();}
          try {
			 name = (String)de.readObject();
			 time = (Integer)de.readObject();
			 
            }
          catch(Exception xx) {xx.printStackTrace();}
          try {
             de.close();
            }
          catch(Exception xx) {xx.printStackTrace();}

//========== 
  //compare 
          if(time >= gp.i)
          {
              time = gp.i;
              name = mp.text_response;
          }
//  writing        
           try {
              xe = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("info.xml")));
             }
           catch(Exception xx) {xx.printStackTrace();}

           try {
			 xe.writeObject(name);
			 xe.writeObject(time);
            }
           catch(Exception xx) {xx.printStackTrace();}

           try {
             xe.close();
            }
           catch(Exception xx) {xx.printStackTrace();}
           //b2.setText("Info Saved OK - check the XML file to see the results");
     	 }
}
