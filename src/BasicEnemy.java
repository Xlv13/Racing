import java.awt.*;

/**
 * Created by Xlv QT on 11/24/2016.
 */
public class BasicEnemy extends GameObject {

    private Handler handler;

    public BasicEnemy(float x, float y, ID id,Handler handler){
        super(x,y,id);
        this.handler=handler;
        velX=5;
        velY=5;
    }

    public Rectangle getBounds(){
        return new Rectangle((int)x,(int)y,16,16);
    }
    public void tick() {
        x+=velX;
        y+=velY;
        if(y<=0 || y>=Game.HEIGHT -42) velY*=-1;
        if(x<=0 || x>=Game.WIDTH -16) velX*=-1;

        handler.addObject(new Trail(x,0.05f,y,ID.Trail,Color.red,handler,16,16 ));
    }

    public void render (Graphics g){
        g.setColor(Color.red);
        g.fillRect((int)x,(int)y,16,16);
    }
}
