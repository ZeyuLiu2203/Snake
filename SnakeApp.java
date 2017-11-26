import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;

public class SnakeApp implements Runnable{
	@Override
	public void run(){
		
		Grid grid = new Grid(Config.GRID_WIDTH, Config.GRID_HEIGHT);
		JFrame window = new JFrame("Zeyu's snake game");
		
		GameView gameView = new GameView(grid);
        gameView.init();
        int w = Config.GRID_WIDTH * Config.NODE_SIZE;
        int h = Config.GRID_HEIGHT * Config.NODE_SIZE;
        gameView.getCanvas().setPreferredSize(new Dimension(w, h));
        Container contentPane = window.getContentPane();
        contentPane.add(gameView.getCanvas(), BorderLayout.CENTER);
		
		
		window.pack();
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        GameController gameController = new GameController(grid, gameView);
        window.addKeyListener(gameController);
        new Thread(gameController).start();
        
        
        
        
        
	}
	public static void main(String[] args) {
        SnakeApp snakeApp = new SnakeApp();
        snakeApp.run();
    }
	
}
