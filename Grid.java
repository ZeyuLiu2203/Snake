import java.util.Random;

public class Grid {
	private Snake snake;
	private Node food;
	public final boolean status[][];
	private final int width;
	private final int height;
	private Direction snakeDirection = Direction.LEFT;
	
	
	public Grid(int width, int height){
		this.width = width;
		this.height = height;
		status = new boolean[width][height];

		snake = initSnake(width,height);
		food = createFood(width,height);
	}
	
	private Snake initSnake(int width, int height){
		//length of initial  snake is 1/3 of width of grid
		snake = new Snake();
		// 设置Snake的Body
		for(int i = 0; i<width/3;i++){
			snake.addTail(new Node(width/2+i,height/2));
			status[width/2+i][height/2] = true;
		}
		return snake;
	}
	
	private Node createFood(int width,int height){
		int x,y;
		Random random = new Random();
		x = random.nextInt(width);
		y = random.nextInt(height);
		while(status[x][y]){
			x = random.nextInt(width);
			y = random.nextInt(height);
		}
		Node food = new Node(x,y);
		return food;
	}
	public boolean nextRound(){
		Node nextMove = snake.move(snakeDirection);
		if((snake.getHead().getX() != width || snake.getHead().getX() != 0) && !status[snake.getHead().getX()][snake.getHead().getY()] && (snake.getHead().getY() != height || snake.getHead().getY() != 0)){
			if(snake.getHead().getX() == food.getX() && snake.getHead().getY() == food.getX()){
				status[snake.getHead().getX()][snake.getHead().getY()] = true;
				snake.addTail(nextMove);
				food = createFood(width,height);
				return true;
			}
			else{
				status[nextMove.getX()][nextMove.getY()] = false;
				return true;
			}
		}
		return false;
	}
	public void changeDirection(Direction newDirection) {
	    if (snakeDirection.compatibleWith(newDirection)) {
	        snakeDirection = newDirection;
	    }
	}

	public Node getFood() {
		return food;
	}

	public Snake getSnake() {
		return snake;
	}

	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	
}
