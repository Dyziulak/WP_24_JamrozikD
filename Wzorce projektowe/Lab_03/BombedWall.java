import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class BombedWall extends Wall 
{

    public BombedWall(int x, int y, Directions direction) 
    {
        super(x, y, direction);
    }

    @Override
    public void draw(Image image) 
    {
        Graphics g = image.getGraphics();
        int x = getX();
        int y = getY();

        g.setColor(Color.RED);

        int lineSpacing = 10;
        int lineLength = 10;
        int numLines = 5;

        switch (getDirections()) 
        {
            case North:
                for (int i = 0; i < numLines; i++) 
                {
                    int startX = x + i * lineSpacing;
                    int startY = y;
                    int endX = startX + lineLength;
                    int endY = y + lineLength / 2;
                    g.drawLine(startX, startY, endX, endY);
                }
                break;
            case South:
                for (int i = 0; i < numLines; i++) 
                {
                    int startX = x + i * lineSpacing;
                    int startY = y;
                    int endX = startX + lineLength;
                    int endY = y - lineLength / 2;
                    g.drawLine(startX, startY, endX, endY);
                }
                break;
            case East:
                for (int i = 0; i < numLines; i++) 
                {
                    int startX = x;
                    int startY = y + i * lineSpacing;
                    int endX = x - lineLength / 2;
                    int endY = startY + lineLength;
                    g.drawLine(startX, startY, endX, endY);
                }
                break;
            case West:
                for (int i = 0; i < numLines; i++) 
                {
                    int startX = x;
                    int startY = y + i * lineSpacing;
                    int endX = x + lineLength / 2;
                    int endY = startY + lineLength;
                    g.drawLine(startX, startY, endX, endY);
                }
                break;
        }
    }
}