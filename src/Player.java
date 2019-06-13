import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class Player {
    BufferedImage image;
    static int LVL=3;
    static int x;
    static int y;
    static int XL;
    static int YU;
    static int XR;
    static int YD;
    static boolean flynow=false;
    static boolean flymod=true;
    long time=0l;
    long time1=0l;
    long time2=0l;
    long time3=0l;
    long timefly=0l;
    boolean sp=true;
    boolean sp1=true;
    boolean sp2=true;
    boolean sp3=true;
    public Player(String ss,int x,int y,double XX,double YY){
        image=resize.RESIZE(IMAGE.delwit(new IMAGE(ss).image),IMAGE.delwit(new IMAGE(ss).image).getWidth()*XX,IMAGE.delwit(new IMAGE(ss).image).getHeight()*YY);
        this.x=x;
        this.y=y;
        GetX(); GetY();

    }



    public void update(input in){
        int newx=x;

        if (in.getkey(KeyEvent.VK_UP)) {
            sp2=sp3=false;
            fast1(780000000l);
        }
        else {
            sp=false;
            slow1(1200000000l);
            if (in.getkey(KeyEvent.VK_DOWN))  slow2(650000000l);
            else fast2(1200000000l);
        }



        if (in.getkey(KeyEvent.VK_LEFT)) newx-=2+LVL/3;
        if (in.getkey(KeyEvent.VK_RIGHT)) newx+=2+LVL/3;
        if (flymod && in.getkey(KeyEvent.VK_SPACE) && System.nanoTime()-timefly>7000000000l) {
                flynow=true; timefly=System.nanoTime();
        }
        if (newx<-3) newx=-3; else if (newx>153) newx=153;

        x=newx;
    }

    public void fast1(long t){
        if (sp) {time=System.nanoTime(); sp=false;}
        if (System.nanoTime()-time>t) { if (LVL<6) LVL++; time=System.nanoTime();}
    }

    public void fast2(long t){
        if (sp) {time1=System.nanoTime(); sp1=false;}
        if (System.nanoTime()-time1>t) { if (LVL<3) LVL++; time1=System.nanoTime();}
    }


    public void slow1(long t){
        if (sp2) {time2=System.nanoTime(); sp2=false;}
        if (System.nanoTime()-time2>t) { if (LVL>3) LVL--; time2=System.nanoTime();}
    }

    public void slow2(long t){
        if (sp3) {time3=System.nanoTime(); sp3=false;}
        if (System.nanoTime()-time3>t) { if (LVL>1) LVL--; time3=System.nanoTime();}
    }

    public void render(Graphics2D gg){

        if (flynow) {
            if (System.nanoTime()-timefly<1200000000l) ggfly(gg);
            else flynow=false;
        }
        else gg.drawImage(image,x,y,null);
    }

    public void GetX (){
        for(int i=3;i<80;i++){
            if( image.getRGB(i,50)!=0)
            {
                XL=i;
                break;
            }}
        for(int i=82;i>0;i--)
            if( image.getRGB(i,50)!=0)
            {
                XR=i;
                break;
            }


    }

    public void GetY (){
        for(int i=0;i<98;i++){
            if( image.getRGB(41,i)!=0)
            {
                YD=i;
                break;
            }}
        for(int i=98;i>0;i--)
            if( image.getRGB(41,i)!=0)
            {
                YU=i;
                break;
            }
    }

    public void ggfly(Graphics2D gg){gg.drawImage(image,(int)(x*(1-0.22*(Math.sin(  ((System.nanoTime()-timefly)/1200000000f  )* Math.PI  )))),y,(int)(image.getWidth()*(1+0.4*(Math.sin(  ((System.nanoTime()-timefly)/1200000000f  )* Math.PI  )))),(int)(image.getHeight()*(1+0.4*(Math.sin(  ((System.nanoTime()-timefly)/1200000000f  )* Math.PI  )))),null);}
}
