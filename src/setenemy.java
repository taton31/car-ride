import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class setenemy {
    static long time = 0l;
    static boolean two = false;
    static Queue<Enemy> queue = new LinkedList<>();

    static void setEnemy(long t) {
        if (!two && t - time > 3000000l * (Player.LVL*Player.LVL*Player.LVL*4.52-45.25*Player.LVL*Player.LVL+121.7*Player.LVL) && (new Random()).nextInt(1000) > 980) {
            queue.offer(new Enemy((new Random()).nextInt(2), 2.6, 3.1));
            if (t - time < 6000000l * (Player.LVL*Player.LVL*Player.LVL*4.52-45.25*Player.LVL*Player.LVL+121.7*Player.LVL) ) two = true;
            time = t;
        } else if (t - time > 6000000l * (Player.LVL*Player.LVL*Player.LVL*4.52-45.25*Player.LVL*Player.LVL+121.7*Player.LVL) ) {
            two = false;
        }
    }

    static void checkonwindow() {
        if (!queue.isEmpty() && queue.peek().y > 470) queue.poll();
    }


    static void update() {
        for (Enemy en : queue) {
            en.y += en.speed + Player.LVL + 1;
            checkcrach(en);
        }
        checkonwindow();
    }

    static void checkcrach (Enemy enemy){
        for (Enemy en: queue){
            if (enemy.YD + enemy.y==en.YD + en.y) return;
            while (IMAGE.intersects(enemy.YD + enemy.y-5, enemy.YU + enemy.y+5, enemy.XL + enemy.x, enemy.XR + enemy.x, en.YD + en.y-5, en.YU + en.y+5, en.XL + en.x, en.XR + en.x)) {
                if (enemy.YU>en.YU) break;
                enemy.y-=1;
            }
        }
    }


    static void render(Graphics2D gg) {
        for (Enemy en : queue) {
            en.render(gg);
        }
    }
}

