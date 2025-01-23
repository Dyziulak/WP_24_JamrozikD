import java.awt.Image;

enum Directions 
{
        North, East, South, West;

        public Directions opposite() 
        {
            switch (this) 
            {
                case North: return South;
                case East: return West;
                case South: return North;
                case West: return East;
                default: throw new IllegalStateException("Unexpected value: " + this);
            }
        }
    }
/**
 * Klasa reprezentuje element labiryntu
 */

public abstract class MapSite 
{
    public MapSite(int x, int y) 
    {
        this.x = x;
        this.y = y;
    }

    /**
     * ustawia wartosc wspolrzednej x
     * @param newX nowa wartosc x
     */
    public void setX(int newX) 
    {
        x = newX;
    }

    /**
     * ustawia wartost wspolrzednej y
     * @param newY nowa wartosc y
     */
    public void setY(int newY) 
    {
        y = newY;
    }
   /**
     * Zwraca wspolrzedna x punktu
     * @return wspolrzedna x
     */
    public int getX() 
    {
        return x;
    }

    /**
     * Zwraca wspolrzedna y punktu
     * @return wspolrzedna y
     */
    public int getY() 
    {
        return y;
    }

    /**
     * Metoda rysuje element labiryntu na ekranie,
     * @param image - obiekt ktory rysujemy
     */
    public void draw(Image image) 
    {

    }

    public static final int LENGTH = 50;
    private int x,y;
}
