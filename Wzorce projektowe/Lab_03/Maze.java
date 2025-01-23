import java.awt.Image;
import java.util.ArrayList;
import java.util.Iterator;

public class Maze 
{
    public Maze() {}

    public void addRoom(Room room) 
    {
        rooms.add(room);
    }

    public void addWall(Wall wall) 
    {
        walls.add(wall);
    }
    
    public ArrayList<Room> getRooms() 
    {
        return rooms;
    }

    public ArrayList<Wall> getWalls() 
    {
        return walls;
    }
    
    public Room roomNo(int nr) 
    {
        Iterator<Room> it = rooms.iterator();
        Room r;

        while(it.hasNext()) 
        {
            r = it.next();
            if (r.getRoomNumber() == nr) return r;
        }
        return null;
    }

    public Image drawMaze(Image image) 
    {
        Iterator<Room> it = rooms.iterator();
        Room r;

        while (it.hasNext()) 
        {
            r = it.next();
            r.draw(image);
        }

        Iterator<Wall> it2 = walls.iterator();
        Wall w;

        while (it2.hasNext()) 
        {
            w = it2.next();
            w.draw(image);
        }
        
        return image;
    }

    private ArrayList<Room> rooms = new ArrayList<>();
    private ArrayList<Wall> walls = new ArrayList<>();

}
