import java.awt.*;

public class Door extends MapSite 
{
    public Door(Room r1, Room r2) 
    {
        super(-1, -1);
        roomOne = r1;
        roomTwo = r2;

        int x1 = r1.getX();
        int x2 = r2.getX();

        int y1 = r1.getY();
        int y2 = r2.getY();

        if(x1 == x2) 
        {
            setX(x1);
            setY(y1 > y2 ? y1 : y2);
        }
        else 
        {
            setX(x1 > x2 ? x1 : x2);
            setY(y1);
        }
    }

    @Override
    public void draw(Image image) 
    {
        Graphics g = image.getGraphics();
        int x1 = roomOne.getX();
        int y1 = roomOne.getY();
        int x2 = roomTwo.getX();
        int y2 = roomTwo.getY();
        int x;
        int y;

        g.setColor(Color.BLUE);

        if (x1 == x2) 
        {
            y  = (y1 > y2) ? y1 : y2;
            g.drawLine(x1, y, x1 + MapSite.LENGTH/3, y);
            g.drawLine(x1 + 2*MapSite.LENGTH/3, y, x1 + MapSite.LENGTH, y);
        } 
        else 
        {
            x = (x1 > x2) ? x1 : x2;
            g.drawLine(x, y1, x, y1 + MapSite.LENGTH/3);
            g.drawLine(x, y1 + 2*MapSite.LENGTH/3, x, y1 + MapSite.LENGTH);
        }
    }

    private Room roomOne;
    private Room roomTwo;

}