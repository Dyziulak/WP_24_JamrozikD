import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class RoomWithBomb extends Room 
{
    public RoomWithBomb(int nr, int x, int y) 
    {
        super(nr, x, y);
    }

    @Override
    public void draw(Image image) 
    {
        super.draw(image);
        
        Graphics g = image.getGraphics();
        int roomCenterX = getX() + MapSite.LENGTH / 2;
        int roomCenterY = getY() + MapSite.LENGTH / 2;

        g.setColor(Color.RED);

        g.drawString("B", roomCenterX - 5, roomCenterY + 5);
    }

    public boolean hasBomb() 
    {
        return true;
    }
}
