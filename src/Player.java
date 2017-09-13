import java.awt.*;
import java.util.Random;

/**
 * Created by Xlv QT on 11/23/2016.
 */
public class Player extends GameObject {

    Random r=new Random();
    Handler handler;

    public Player(float x, float y, ID id,Handler handler){
        super(x,y,id);
        this.handler=handler;
    }

    public Rectangle getBounds(){
        return new Rectangle((int)x,(int)y,32,32);
    }

    public void tick(){
        x+=velX;
        y+=velY;

        x=Game.clamp(x,0,Game.WIDTH-37);
        y=Game.clamp(y,0,Game.HEIGHT-60);

        collision();

    }

    private void collision(){
        for(int i=0;i<handler.object.size();i++) {
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getID()==ID.BasicEnemy || tempObject.getID()==ID.FastEnemy || tempObject.getID()==ID.SmartEnemy)
            if(getBounds().intersects((tempObject.getBounds()))){
                HUD.HEALTH-=2;
            }
        }
    }

    @Override
    public void render(Graphics g) {

        g.setColor(Color.white);
        g.fillRect((int)x,(int)y,32,32);
    }



}
