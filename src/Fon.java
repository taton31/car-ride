import java.awt.*;
import java.awt.image.BufferedImage;

public class Fon {
    BufferedImage image;
    int LVL;
    int x,y,i=0;
    public Fon(String fon,double WIGHT,double HEIGHT, int x,int y,int LVL){
        image=new IMAGE(fon).image;
        image=resize.RESIZE(image,WIGHT, HEIGHT);
        this.x=x;
        this.y=-600;
        this.LVL=LVL;

    }

    public void setLVL (int LVL){
        this.LVL=LVL;
    }


    public void update ()
    {
        LVL=Player.LVL;
        if (i<49) i++; else {i=0; y-=50*LVL;}
        y+=LVL;

    }

    public void render(Graphics2D gg){
        gg.drawImage(image,x,y,null);
    }
}
