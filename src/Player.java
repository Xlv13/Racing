import java.awt.*;
import java.util.Random;

import static java.lang.System.exit;

/**
 * Created by Xlv QT on 11/23/2016.
 */
public class Player extends GameObject {

    Random r=new Random();
    Handler handler;
    Game game;
    public Player(int x, int y, ID id,Handler handler,Game game){
        super(x,y,id);
        this.game=game;
        this.handler=handler;
    }

    public void tick(){
        x+=velX;

        x=Game.clamp((int)x,16,Game.WIDTH-38);
        //y=Game.clamp(y,0,Game.HEIGHT-60);

        collision();
    }

        public Rectangle[] getBounds(){
            Rectangle[] rect=new Rectangle[6];
            rect[0]=new Rectangle((int)x,(int)y,16,16);
            rect[1]=new Rectangle((int)x+16,(int)y+16,16,16);
            rect[2]=new Rectangle((int)x-16,(int)y+16,16,16);
            rect[3]=new Rectangle((int)x,(int)y+32,16,16);
            rect[4]=new Rectangle((int)x+16,(int)y+48,16,16);
            rect[5]=new Rectangle((int)x-16,(int)y+48,16,16);
            return rect;
        }

    private void collision() {
        Rectangle[] r1 = getBounds();
        Rectangle[] r2;
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            if (tempObject.getID() == ID.BasicEnemy || tempObject.getID()==ID.FastEnemy) {
                r2 = tempObject.getBounds();
                for (int j = 0; j < 6; j++)
                    //System.out.println("asd");
                    for (int k = 0; k < 6; k++)
                        if (r1[j].intersects(r2[k])){
                            game.gameState= Game.STATE.Menu;
                            handler.object.clear();
                            for(int l=0;l<15;l++)
                                handler.addObject(new MenuParticle(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT),ID.MenuParticle,handler));
                            return;
                        }

            }
        }
    }
    @Override
    public void render(Graphics g) {
        if(id==ID.Player)
            g.setColor(Color.blue);
        else if(id==ID.Player2)
            g.setColor(Color.blue);
        g.fillRect((int)x,(int)y,16,16);
        g.fillRect((int)x+16,(int)y+16,16,16);
        g.fillRect((int)x-16,(int)y+16,16,16);
        g.fillRect((int)x,(int)y+32,16,16);
        g.fillRect((int)x+16,(int)y+48,16,16);
        g.fillRect((int)x-16,(int)y+48,16,16);
    }
}
