import javax.imageio.ImageIO;
import java.io.File;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class loader {
    public static final String path="res/";
    public static BufferedImage loadimage(String ddd){
        BufferedImage im=null;
        try {
            im = ImageIO.read(new File(path + ddd));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return im;
    }
}
