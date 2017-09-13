import java.awt.*;
import java.util.Random;

/**
 * Created by Xlv QT on 11/24/2016.
 */
public class MenuParticle extends GameObject {

    private Handler handler;
    Random r=new Random();

    private Color col;
    public MenuParticle(float x, float y, ID id,Handler handler){
        super(x,y,id);
        this.handler=handler;

        velX=r.nextInt((7- -7)+ -7);
        velY=r.nextInt((7- -7)+ -7);
        if(velX==0) velX=1;
        if(velY==0) velY=1;
        col=new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255));
    }

    public Rectangle[] getBounds(){
        Rectangle[] rect=new Rectangle[6];
        rect[0]=new Rectangle((int)x+16,(int)y+16,16,16);
        rect[1]=new Rectangle((int)x-16,(int)y+16,16,16);
        rect[2]=new Rectangle((int)x,(int)y+32,16,16);
        rect[3]=new Rectangle((int)x+16,(int)y+48,16,16);
        rect[4]=new Rectangle((int)x-16,(int)y+48,16,16);
        rect[5]=new Rectangle((int)x,(int)y+64,16,16);
        return rect;
    }

    public void tick() {
        y+=velY;

        if(y<=0 || y>=Game.HEIGHT -42) velY*=-1;
        if(x<=0 || x>=Game.WIDTH -16) velX*=-1;

    }

    public void render (Graphics g){
        g.setColor(col);
        g.fillRect((int)x,(int)y,16,16);
    }
}
