import javax.swing.JFrame;

public class SnakeApp {
	public void init(){
		JFrame window = new JFrame("Zeyu's snake game");
		window.pack();
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
	}
	public static void main(String[] args) {
        SnakeApp snakeApp = new SnakeApp();
        snakeApp.init();
    }
}
