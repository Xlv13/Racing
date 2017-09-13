import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by Xlv QT on 11/24/2016.
 */
public class KeyInput extends KeyAdapter {

    private Handler handler;
    private boolean[] keyDown=new boolean[2];
    public KeyInput(Handler handler){
        this.handler=handler;
        keyDown[0]=false;
        keyDown[1]=false;
    }

    public void keyPressed(KeyEvent e){
        int key=e.getKeyCode();
        for(int i=0;i<handler.object.size();i++){
            GameObject tempObject=handler.object.get(i);
            if(tempObject.getID()==ID.Player){
                if(key==KeyEvent.VK_RIGHT){
                tempObject.setVelX(5);
                keyDown[0]=true;
            }
            if(key==KeyEvent.VK_LEFT){
                tempObject.setVelX(-5);
                keyDown[1]=true;
            }
            }
        }
    }

    public void keyReleased(KeyEvent e){
        int key=e.getKeyCode();

        for(int i=0;i<handler.object.size();i++) {
            GameObject tempObject = handler.object.get(i);
            if (tempObject.getID() == ID.Player) {


                if (key == KeyEvent.VK_RIGHT) keyDown[0] = false;//tempObject.setVelY(0);
                if (key == KeyEvent.VK_LEFT) keyDown[1] = false;
                if (keyDown[0]) {
                    if (!keyDown[1])
                        tempObject.setVelX(5);
                } else if (keyDown[1])
                    tempObject.setVelX(-5);
                else
                    tempObject.setVelX(0);

            }
        }
    }

}
