import java.util.Random;

/**
 * Created by Xlv QT on 11/28/2016.
 */
public class Spawn {

    private Handler handler;
    private HUD hud;
    private Random r=new Random();
    private int scoreKeep=0;
    private int count=0;

    public Spawn (Handler handler,HUD hud){
        this.handler=handler;
        this.hud=hud;
    }

    public void tick(){
        scoreKeep++;
        count++;
        if(count>=500) {
            hud.setLevel(hud.getLevel() + 1);
            count=0;
        }
        if(scoreKeep>=65){
            scoreKeep = 0;
            if(r.nextInt(30)%2==0){
                handler.addObject(new BasicEnemy(16+r.nextInt(Game.WIDTH-54),-100,ID.BasicEnemy,handler));
                if(r.nextInt(30)%2==0)
                    handler.addObject(new BasicEnemy(16+r.nextInt(Game.WIDTH-54),-250,ID.BasicEnemy,handler));
                else
                    handler.addObject(new FastEnemy(16+r.nextInt(Game.WIDTH-54),-250, ID.FastEnemy, handler));
            }else {
                handler.addObject(new FastEnemy(16+r.nextInt(Game.WIDTH-54),-100, ID.FastEnemy, handler));
                if(r.nextInt(30)%2==0)
                    handler.addObject(new BasicEnemy(16+r.nextInt(Game.WIDTH-54),-250,ID.BasicEnemy,handler));
                else
                    handler.addObject(new FastEnemy(16+r.nextInt(Game.WIDTH-54),-250, ID.FastEnemy, handler));
            }
        }else
        if(scoreKeep>=3000){
            scoreKeep = 0;
            if(r.nextInt(30)%2==0){
                handler.addObject(new BasicEnemy(16+r.nextInt(Game.WIDTH-54),-150,ID.BasicEnemy,handler));
                handler.addObject(new FastEnemy(16+r.nextInt(Game.WIDTH-54),-100, ID.FastEnemy, handler));
                if(r.nextInt(30)%2==0)
                    handler.addObject(new BasicEnemy(16+r.nextInt(Game.WIDTH-54),-250,ID.BasicEnemy,handler));
                else
                    handler.addObject(new FastEnemy(16+r.nextInt(Game.WIDTH-54),-250, ID.FastEnemy, handler));
            }else {
                handler.addObject(new BasicEnemy(16+r.nextInt(Game.WIDTH-54),-150,ID.BasicEnemy,handler));
                handler.addObject(new FastEnemy(16+r.nextInt(Game.WIDTH-54),-100, ID.FastEnemy, handler));
                if(r.nextInt(30)%2==0)
                    handler.addObject(new BasicEnemy(16+r.nextInt(Game.WIDTH-54),-250,ID.BasicEnemy,handler));
                else
                    handler.addObject(new FastEnemy(16+r.nextInt(Game.WIDTH-54),-250, ID.FastEnemy, handler));
            }
        }
    }
}
