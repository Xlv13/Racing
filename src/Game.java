import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;


/**
 * Created by Xlv QT on 11/23/2016.
 */
public class Game extends Canvas implements Runnable {


    private static final long serialVersionUID = 3382877282005793312L;
    public static final int WIDTH=320, HEIGHT=WIDTH/6*10;
    private Thread thread;
    private boolean running=false;
    private HUD hud;
    private Spawn spawner;
    private Random r;
    private Handler handler;
    public Menu menu;
    public enum STATE {
        Menu,
        Help,
        Game
    };

    public STATE gameState=STATE.Menu;

    public Game() {
        handler = new Handler();
        menu = new Menu(this, handler);
        this.addKeyListener(new KeyInput(handler));
        this.addMouseListener(menu);

        AudioPlayer.load();
        
        AudioPlayer.getMusic("music").loop();
        
        new Window(WIDTH, HEIGHT, "Formula 1", this);
        hud = new HUD();
        spawner = new Spawn(handler, hud);
        r = new Random();
        if (gameState == STATE.Game) {
            handler.addObject(new Player(WIDTH/2-32,HEIGHT-92,ID.Player,handler,this));
        }
        else{
            for(int i=0;i<15;i++)
                handler.addObject(new MenuParticle(r.nextInt(WIDTH),r.nextInt(HEIGHT),ID.MenuParticle,handler));
        }
    }

    public void setListener(KeyInput x){
        this.addKeyListener(x);
    }

    public synchronized void start(){
        thread=new Thread(this);
        thread.start();
        running=true;
    }

    public synchronized void stop(){
        try{
            thread.join();
            running=false;
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void run () {
            this.requestFocus();
            long lastTime = System.nanoTime();
            double amountOfTicks = 60.0;
            double ns = 1000000000 / amountOfTicks;
            double delta = 0;
            long timer = System.currentTimeMillis();
            int frames = 0;
            while (running) {
                long now = System.nanoTime();
                delta += (now - lastTime) / ns;
                lastTime = now;
                while (delta >= 1) {
                    tick();
                    delta--;
                }
                if (running)
                    render();
                frames++;

                if (System.currentTimeMillis() - timer > 1000) {
                    timer += 1000;
                    System.out.println("FPS: " + frames);
                    frames = 0;
                }
            }
            stop();
        }

    private void tick(){
        handler.tick();
        if(gameState==STATE.Game){
            hud.tick();
            spawner.tick();
        }else if(gameState==STATE.Menu || gameState==STATE.Help){
            menu.tick();
        }
    }

    private void render(){
        BufferStrategy bs=this.getBufferStrategy();
        if(bs==null){
            this.createBufferStrategy(3);
            return;
        }

        Graphics g=bs.getDrawGraphics();

        g.setColor(Color.black);
        g.fillRect(0,0,WIDTH,HEIGHT);

        handler.render(g);
        if(gameState==STATE.Game){
            hud.render(g);
        }
        else if(gameState==STATE.Menu || gameState==STATE.Help){
            menu.render(g);
        }

        g.dispose();
        bs.show();
    }



    public static int clamp(int var, int min, int max){
        if(var>=max)
            return var=max;
        else if(var<=min) return var=min;
        else
            return var;
    }

    public static void main(String[] args) {
        new Game();
    }
}

