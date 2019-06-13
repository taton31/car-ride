import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Arrays;


public class frame extends JFrame {
    public static Canvas list;
    public static BufferedImage buffer;
    public static int [] bufferarr;
    public static Graphics buffergraphics;
    public static int clearColor=0xff0000ff;
    public static JFrame window ;


    public static void created (){
        window=new JFrame("Monsters cars");
        list=new Canvas();
        menu();

        list.setPreferredSize(new Dimension(230,550));
        window.setSize(230,550);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.getContentPane().add(list);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setVisible(true);
        buffer=new BufferedImage(230,550,BufferedImage.TYPE_INT_ARGB);
        buffergraphics=buffer.getGraphics();
        bufferarr=((DataBufferInt)buffer.getRaster().getDataBuffer()).getData();
        ((Graphics2D)buffergraphics).setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);    //сглаживание

    }
    public static void clear(){
        Arrays.fill(bufferarr,clearColor);
    }



    public static void swapBuffers(){
        (list.getGraphics()).drawImage(buffer,0,0,null);
    }

    public static void destroy() {
        window.dispose();
    }
    public static void settit(String s){
        window.setTitle(s);
    }

    public static Graphics2D getgraphic(){
        return (Graphics2D)buffergraphics;
    }

    public static void addinput (input iii){
        window.add(iii);
    }




    public static void menu(){
        JMenuBar menu=new JMenuBar();
        JMenu fs = new JMenu("Скорость игры");
        JMenu flymod = new JMenu("Режим fly");
        JMenu flymen=new JMenu("ON");
        JMenu flyme=new JMenu("OFF");
        JMenu men=new JMenu("Быстро");
        JMenu me=new JMenu("Нормально");
        JMenu m=new JMenu("Медленно");
        flymen.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Player.flynow=false;
                Player.flymod=true;
            }
        });
        flyme.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Player.flynow=false;
                Player.flymod=false;
            }
        });

        men.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                game.fastversion();
            }
        });
        me.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                game.slowversion();
            }
        });
        m.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                game.veryslowversion();
            }
        });
        fs.add(m);
        fs.add(me);
        fs.add(men);
        flymod.add(flyme);
        flymod.add(flymen);
        menu.add(fs);
        menu.add(flymod);

        window.setJMenuBar(menu);
    }



}
