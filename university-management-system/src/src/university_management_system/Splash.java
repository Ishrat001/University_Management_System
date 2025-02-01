package university_management_system;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable {
	
	Thread t;
	Splash(){
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/31330792732_ac6b933273_h.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1280, 720, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		//image.setBounds(0, 0, 1000, 700);
		add(image);
		
		//setLayout(null);
		
		/*JLabel lebelwelcome= new JLabel("Welcome to University Management System as an Admin");
		lebelwelcome.setBounds(200, 60, 800, 50);
		lebelwelcome.setFont(new Font("Serif", Font.BOLD, 25)); 
		lebelwelcome.setForeground(Color.decode("#000000"));
		image.add(lebelwelcome);*/
		
		t = new Thread(this);
		t.start();
		
		setLocation(290, 120);
		setSize(1000, 640);
		
		
		setVisible(true);
		
		
		
		
		/*int x=1;
		for(int i=0; i<=600; i+=4, x+=1) {
			setLocation(600 - ((i+x)/2), 350-(i/2));
			setSize(i+3*x, i+x/2);
			
			try {
				Thread.sleep(10);
			}catch(Exception e) {}
		}*/
		
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(2000);
			//setVisible(false);
			
			//will open the next frame
			new Register();
			setVisible(false);
		}catch(Exception e){
			
		}
	}
		
	public static void main(String[] args) {
		new Splash();
	}

		
}
