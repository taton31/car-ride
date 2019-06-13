import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Enemy {
    private BufferedImage im;
    int x;
    int speed;
    int y=-80;
    int XL;
    int YU;
    int XR;
    int YD;
    public  Enemy (int speed ,double XX,double YY){
        this.speed=1+speed;
        String ss=""+(new Random().nextInt(4)+1);
        im=resize.RESIZE(IMAGE.delwit(new IMAGE("enemy"+ss+".png").image),new IMAGE("enemy"+ss+".png").image.getWidth()*XX,new IMAGE("enemy"+ss+".png").image.getHeight()*YY);
        GetX(); GetY();
        polosa();
    }


    public void polosa () {
        int i = new Random().nextInt(100);
        if (i < 34) {
            x = 9; }
        else if (i < 67) {
            x = 73;}
        else if (i < 100) {
            x = 141;}
    }






    public void render(Graphics2D gg){
        gg.drawImage(im,x,y,null);
    }


    public void GetX (){
        for(int i=3;i<80;i++){
            if( im.getRGB(i,50)!=0)
            {
                XL=i;
                break;
            }}
        for(int i=82;i>0;i--)
            if( im.getRGB(i,50)!=0)
            {
                XR=i;
                break;
            }


    }

    public void GetY () {
        for (int i = 0; i < 98; i++) {
            if (im.getRGB(41, i) != 0) {
                YD = i;
                break;
            }
        }
        for (int i = 98; i > 0; i--)
            if (im.getRGB(41, i) != 0) {
                YU = i;
                break;
            }
    }



    }
