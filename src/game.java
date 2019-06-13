import javax.swing.*;
import java.awt.*;


public class game implements Runnable {
    public boolean running=false;
    public Thread gamethread;
    private Graphics2D g;
    public input Input=new input();
    private Fon fon=new Fon("fon.png",230,1170,0,0,Player.LVL);
    private Player player=new Player("car22.png",75,400,2.6,3.1);
    boolean pause=false;


    private static float rate=60.0f;
    public static void fastversion(){
        rate=100.0f;
    }
    public static void slowversion(){
        rate=60.0f;
    }
    public static void veryslowversion(){
        rate=30.0f;
    }

    public game(){

        running=false;
        frame.created();
        g=frame.getgraphic();
        frame.addinput(Input);


    }

    public synchronized void start(){
        if (running) return;

        running=true;
        gamethread=new Thread(this);
        gamethread.start();

    }

    public void stop(){
        if (!running) return;

        running=false;
        gamethread.interrupt();
        System.exit(0);

    }



    private void rendering(){
        fon.render(g);
        setenemy.render(g);
        player.render(g);
        frame.swapBuffers();
    }


    public void crash (int scor, Enemy en) {
        if (!Player.flynow && IMAGE.intersects(Player.YD + Player.y, Player.YU + Player.y, Player.XL + Player.x, Player.XR + Player.x, en.YD + en.y, en.YU + en.y, en.XL + en.x, en.XR + en.x)) {
            JOptionPane.showMessageDialog(null, "You score is " + scor / 1000, "Game over", JOptionPane.INFORMATION_MESSAGE);
            stop();
        }
    }


    public void run(){
        float delta =0f;
        long count=0;
        int score=0;


        long lasttime= System.nanoTime();
        while(running){
            long razntime=System.nanoTime()-lasttime;
            pause=Input.pau (pause);
            while (pause) {
                try {
                   Thread.sleep(1);
                }
                catch (InterruptedException e){
                   e.printStackTrace();
                }
                pause=Input.pau (pause);
            }

            lasttime=System.nanoTime();
            count+=razntime;
            setenemy.setEnemy(count);
            score+=Player.LVL*(rate*razntime/20000000);
            delta+=  (razntime*rate/1000000000);
            Boolean render=false;
            while (delta>1){
                player.update(Input);
                fon.update();
                setenemy.update();
                for (Enemy en :setenemy.queue){
                    crash(score,en);
                }
                delta--;
                if (!render) render=true;

            }
            if(render) {rendering();}

            else
                try {
                Thread.sleep(1);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }

        }

    }

}
