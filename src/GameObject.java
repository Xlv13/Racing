import java.awt.*;

/**
 * Created by Xlv QT on 11/23/2016.
 */
public abstract class GameObject {
    protected float x,y;
    public static double incr=0.4;
    protected ID id;
    protected double velX;
    protected double velY=3.9;
    public GameObject(float x, float y, ID id){
        this.x=x;
        this.y=y;
        this.id=id;
        velY=velY+incr;
        incr=incr+0.03;
    }

    public abstract Rectangle[] getBounds();
    public abstract void tick();
    public abstract void render(Graphics g);

    public void setX(int x){
        this.x=x;
    }
    public void setY(int y){
        this.y=y;
    }
    public float getX(){
        return  x;
    }
    public float getY(){
        return y;
    }
    public void setId(ID id){
        this.id=id;
    }
    public ID getID(){
        return id;
    }
    public void setVelX(int velX){
        this.velX=velX;
    }
    public void setVelY(int velY){
        this.velY=velY;
    }
    public double getVelX(){
        return velX;
    }
    public double getVelY(){
        return velY;
    }


}
