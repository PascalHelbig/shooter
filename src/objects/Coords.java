package objects;

public class Coords {

	private float x,y;
	
	public Coords(float _x, float _y){
		this.x=_x;
		this.y=_y;
	} 
	
	public float getX(){
		return this.x;
	}
	
	public float getY(){
		return this.y;
	}
	
	public void setX(float _x){
		this.x =_x;
	}
	
	public void setY(float _y){
	    this.y =_y;
	}
}
