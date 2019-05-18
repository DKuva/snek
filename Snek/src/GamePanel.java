import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.Thread;
import java.util.ArrayList;




public class GamePanel extends JPanel implements Runnable, KeyListener{
		
	
		private static final long serialVersionUID = 1L;
		private static final int width = 800, height = 800;
		private Thread thread;
		private boolean running;
		private boolean right = true, left = false, up = false, down = false;
		private BodyPart b;
		private ArrayList<BodyPart> snake;
		private boolean isApple = false;
		private int xCoor = 10, yCoor = 10, size =  5;
		private int ticks = 0;
		private Apple apple;
		
		
		public GamePanel(){
			setFocusable(true);
			
			setPreferredSize(new Dimension(width, height));
			addKeyListener(this);
			snake = new ArrayList<BodyPart>();
			
		
			start();
		}		
		
		public void start() {
			running= true;
			thread = new Thread(this);
			thread.start();
			
			
		}
		public void stop() {
			running = false;
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		public void tick() {
			if(snake.size() == 0) {
				b = new BodyPart(xCoor, yCoor, 8);
				snake.add(b);
				
			}
			
			ticks ++;
			if (ticks > 500000) {
				if(right) xCoor++;
				if(xCoor > 100) xCoor = 0;
				if(left) xCoor--;
				if(xCoor < 0) xCoor = 100;
				if(up) yCoor--;
				if(yCoor < 0) yCoor = 100;
				if(down) yCoor++;
				if(yCoor > 100) yCoor = 0;
				
				
				ticks = 0;
				
				b= new BodyPart(xCoor, yCoor, 8);
				snake.add(b);
				
				if(snake.size() > size) {
					snake.remove(0);
					
				}
			}
		}
		public void paint(Graphics g) {
			g.clearRect(0, 0, width, height);
			
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, width, height);
			
			
			for(int i = 0; i< width/10; i++) {
				g.drawLine(i*10, 0, i*10, height);
			}
			for(int i = 0; i< height/10; i++) {
				g.drawLine(0, i*10, width, i*10);
			}
			for(int i = 0; i< snake.size(); i++) {
				snake.get(i).draw(g);
			}
			
			if (isApple == false) {
				
				apple = new Apple(8);
				//apple.draw(g);
				isApple = true;		
			}
			apple.draw(g);
			if(xCoor == apple.xACoor && yCoor == apple.yACoor && isApple == true) {
				size++;
				isApple = false;			
			}
		}
		
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			if (key == KeyEvent.VK_RIGHT && !left) {
				right = true;
				up = false;
				down = false;
				
			}
			if (key == KeyEvent.VK_LEFT && !right) {
				left = true;
				up = false;
				down = false;
				
			}
			if (key == KeyEvent.VK_UP && !down) {
				right = false;
				up = true;
				left = false;
				
			}
			if (key == KeyEvent.VK_DOWN && !up) {
				right = false;
				left = false;
				down = true;
				
			}
			
		}
		public void run() {
			while(running) {
				tick();
				repaint();
				
			}
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
}
