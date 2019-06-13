import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;


public class IMAGE {
    BufferedImage image;
    public IMAGE(String SS){
        image=loader.loadimage(SS);
    }
    public BufferedImage cut(int x,int y,int w,int h){
        return image.getSubimage(x,y,w,h);
    }


    public static boolean intersects(int A1y, int A2y, int A1x, int A2x, int B1y,  int B2y, int B1x,  int B2x) {
        return ( A1y < B2y && A2y > B1y && A2x > B1x && A1x < B2x );
    }

    //my try

    public static BufferedImage delwit (BufferedImage im){
          BufferedImage buffer;
          int [] bufferarr;
          Graphics2D buffergraphics;
        buffer=new BufferedImage(32,32,BufferedImage.TYPE_INT_ARGB);
        bufferarr=((DataBufferInt)buffer.getRaster().getDataBuffer()).getData();
        buffergraphics=(Graphics2D)buffer.getGraphics();
        buffergraphics.drawImage(im,0,0,null);
        for (int i=0;i<(bufferarr).length;i++){
            if (bufferarr[i]==0xffffffff) bufferarr[i]=0x00ffffff;
        }
        return buffer;
    }
    ///////////////////////////////////////////////
}
