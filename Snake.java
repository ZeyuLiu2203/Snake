import java.util.LinkedList;

public class Snake {
	private LinkedList<Node> body = new LinkedList<>();
	
	public Node eat(Node food){
		//if food is next to head, then add it into body, return food
		
		if(isNeighbor(getHead(),food)){
			body.addFirst(food);
			return food;
		}
		//otherwise return null;
		else{return null;}
	}
	
	public Node move(Direction d){
		if(d.directionCode() == 0){
			body.addFirst(new Node(getHead().getX(),getHead().getY()+1));
		}
		else if(d.directionCode() == 1){
			body.addFirst(new Node(getHead().getX()+1,getHead().getY()));
		}
		else if(d.directionCode() == 2){
			body.addFirst(new Node(getHead().getX(),getHead().getY()-1));
		}
		else if(d.directionCode() == 3){
			body.addFirst(new Node(getHead().getX()-1,getHead().getY()));
		}
		Node n =  body.getLast();
		body.removeLast();
		return n;
		
	}
	public Node getHead(){
		return body.getFirst();
	}
	public void addTail(Node n){
		body.addLast(n);
	}
	
	private boolean isNeighbor(Node a, Node b) {
        return Math.abs(a.getX() - b.getX()) + Math.abs(a.getY() - b.getY()) == 1;
    }
}
