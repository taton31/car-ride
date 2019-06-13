import java.awt.image.BufferedImage;

public class resize {
    public static BufferedImage RESIZE (BufferedImage image,double WIGHT,double HEIGHT){
        BufferedImage im=new BufferedImage((int)WIGHT,(int)HEIGHT,BufferedImage.TYPE_INT_ARGB);
        im.getGraphics().drawImage(image,0,0,(int)WIGHT,(int)HEIGHT,null);
        return im;
    }
}
