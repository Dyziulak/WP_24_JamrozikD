import java.awt.*;
import javax.swing.*;

public class MyJPanel  extends JPanel 
{
    private Image image;

    public MyJPanel() {}

    public Image getImage() 
    {
        return image;
    }
    
    @Override
    public void paint(Graphics g) 
    {
        if (image == null) 
        {
            image = createImage(getWidth(),getHeight());
        }
        else 
        {
            g.drawImage(image, 0,0, this);
        }
    }
}