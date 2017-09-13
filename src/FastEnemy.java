import java.awt.*;

import static java.lang.System.exit;

/**
 * Created by Xlv QT on 11/24/2016.
 */
public class FastEnemy extends GameObject {
    private Handler handler;
    public FastEnemy(int x, int y, ID id,Handler handler){
        super(x,y,id);
        this.handler=handler;
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
        y+=(int)velY*16/12;
        if(y>1000)
            handler.removeObject(this);
        collision();
    }

    private void collision() {
        Rectangle[] r1 = getBounds();
        Rectangle[] r2;
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            if (tempObject.getID() == ID.BasicEnemy || tempObject.getID()==ID.FastEnemy)
                if(tempObject!=this){
                r2 = tempObject.getBounds();
                for (int j = 0; j < 6; j++)
                    //System.out.println("asd");
                    for (int k = 0; k < 6; k++)
                        if (r1[j].intersects(r2[k])) {
                            handler.removeObject(this);
                            handler.removeObject(tempObject);
                        }
            }
        }
    }
    public void render (Graphics g){
        g.setColor(Color.cyan);
        g.fillRect((int)x+16,(int)y+16,16,16);
        g.fillRect((int)x-16,(int)y+16,16,16);
        g.fillRect((int)x,(int)y+32,16,16);
        g.fillRect((int)x+16,(int)y+48,16,16);
        g.fillRect((int)x-16,(int)y+48,16,16);
        g.fillRect((int)x,(int)y+64,16,16);
    }
}
