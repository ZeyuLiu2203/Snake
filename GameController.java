import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameController implements KeyListener,Runnable{
	 private final Grid grid;
	    private final GameView gameView;

	    private boolean running;

	    public GameController(Grid grid, GameView gameView) {
	        this.grid = grid;
	        this.gameView = gameView;
	        this.running = true;
	    }

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();

        switch (code) {
            case KeyEvent.VK_UP:
                grid.changeDirection(Direction.UP);
                break;
            case KeyEvent.VK_DOWN:
                grid.changeDirection(Direction.DOWN);
                break;
            case KeyEvent.VK_RIGHT:
                grid.changeDirection(Direction.RIGHT);
                break;
            case KeyEvent.VK_LEFT:
                grid.changeDirection(Direction.LEFT);
                break;}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		while (running) {
            try {
                Thread.sleep(Config.MOVE_INTERVAL);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            boolean next = grid.nextRound();
            if (next == false) {
                gameView.gameOver();
            }
            gameView.draw();
        }
    }
		
	}
	

