import java.awt.*;

public class Wall extends MapSite
{
    public Wall(int x, int y, Directions d) 
    {
        super(x,y);
        direction = d;
    }
    @Override //nadpisanie metody z klasy bazowej
    public void draw(Image image) 
    {
        Graphics g = image.getGraphics();
        int x = getX();
        int y = getY();
        switch(direction) 
        {
            case North,South: //linia pozioma
                g.drawLine(x, y,x+MapSite.LENGTH, y);
                break;
            default: //linia pionowa
                g.drawLine(x,y,x,y + MapSite.LENGTH);
        }
    }

    public Directions getDirections() 
    {
        return direction;
    }

    private Directions direction;
}