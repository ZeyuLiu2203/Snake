import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;

public class SnakeApp {
	public void init(){
		
		Grid grid = new Grid(Config.GRID_WIDTH, Config.GRID_HEIGHT);
		JFrame window = new JFrame("Zeyu's snake game");
		Container contentPane = window.getContentPane();
		
		GameView gameView = new GameView(grid);
        gameView.init();
        gameView.getCanvas().setPreferredSize(new Dimension(Config.GRID_WIDTH, Config.GRID_HEIGHT));

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
        snakeApp.init();
    }
}
