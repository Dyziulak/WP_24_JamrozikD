import java.awt.*;

public class Room extends MapSite 
{
    /**
     * tworzy obiekt reprezentujacy pokoj
     * @param x wspolrzedna x lewego gornego wierzcholka
     * @param y wspolrzedna y lewego gornego wierzcholka
     */
    public Room(int nr, int x, int y) 
    {
        super(x,y);
        this.nr = nr;
    }
    public void setSite(Directions d, MapSite mapSite) 
    {
        switch (d) 
        {
            case North, West:
                if(mapSite instanceof Wall) 
                {
                    mapSite.setX(getX());
                    mapSite.setY(getY());
                }
                if (d == Directions.North) 
                {
                    sites[0] = mapSite;
                } 
                else 
                {
                    sites[3] = mapSite;
                }
                break;
            case South:
                if(mapSite instanceof Wall) 
                {
                    mapSite.setX(getX());
                    mapSite.setY(getY() + LENGTH);
                    sites[2] = mapSite;
                }
                break;
            case East:
                if(mapSite instanceof Wall) 
                {
                    mapSite.setX(getX()+ LENGTH);
                    mapSite.setY(getY());
                    sites[1] = mapSite;
                }
                break;
            default:
                break;
        }
    }

    public boolean hasBomb() 
    {
        return false;
    }

    @Override
    public void draw(Image image) 
    {
        for (MapSite mapSite : sites) 
        {
            if (mapSite != null) 
            {
                mapSite.draw(image);
            }
        }
        Graphics g = image.getGraphics();
        
        int roomX = getX();
        int roomY = getY();

        g.drawString(Integer.toString(nr), roomX + 5, roomY + 15);
    }

    public int getRoomNumber() 
    {
        return nr;
    }

    private int nr; //numer pokoju
    private MapSite[] sites = new MapSite[4]; //tablica zawieraja elementy ktore reprezentuja boki pokoju

}