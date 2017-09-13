import java.awt.*;

/**
 * Created by Xlv QT on 11/25/2016.
 */
public class Trail extends GameObject {

    private float alpha=1;
    private Handler handler;
    private Color color;
    private int width, height;
    private float life;// life=0.001-0.1

    public Trail(float x,float life, float y, ID id,Color color,Handler handler,int width, int height) {
        super(x, y, id);
        this.handler=handler;
        this.color=color;
        this.width=width;
        this.height=height;
        this.life=life;
    }

    public Rectangle getBounds() {
        return null;
    }

    public void render(Graphics g) {
        Graphics2D g2d=(Graphics2D)g;
        g2d.setComposite(makeTransparent(alpha));

        g.setColor(color);
        g.fillRect((int)x,(int)y,height,width);

        g2d.setComposite(makeTransparent(1));
    }

    private AlphaComposite makeTransparent(float alpha){
        int type=AlphaComposite.SRC_OVER;
        return (AlphaComposite.getInstance(type, alpha));
    }

    public void tick() {
        if(alpha>life){
            alpha-=(life-0.0001f);
        }else handler.removeObject(this);
    }


}
