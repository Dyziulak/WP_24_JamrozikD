
import java.util.ArrayList;
import java.util.Iterator;

public class MazeGame 
{
    public Maze createMaze(MazeFactory factory) 
    {
        Maze aMaze = factory.makeMaze();
        
        Room r1 = factory.makeRoom(1, 50, 100);
        Room r2 = factory.makeRoom(2, 100, 100);
        Room r3 = factory.makeRoom(3, 100, 150);
        Room r4 = factory.makeRoom(4, 100, 200);
        Room r5 = factory.makeRoom(5, 150, 200);
        Room r6 = factory.makeRoom(6, 200, 200);
        Room r7 = factory.makeRoom(7, 250, 200);
        Room r8 = factory.makeRoom(8, 150, 100);
        Room r9 = factory.makeRoom(9, 200, 100);
        Room r10 = factory.makeRoom(10, 200, 50);

        aMaze.addRoom(r1);
        aMaze.addRoom(r2);
        aMaze.addRoom(r3);
        aMaze.addRoom(r4);
        aMaze.addRoom(r5);
        aMaze.addRoom(r6);
        aMaze.addRoom(r7);
        aMaze.addRoom(r8);
        aMaze.addRoom(r9);
        aMaze.addRoom(r10);

        Door door = factory.makeDoor(r1, r2);
        Door door2 = factory.makeDoor(r2, r3);
        Door door3 = factory.makeDoor(r3, r4);
        Door door4 = factory.makeDoor(r4, r5);
        Door door5 = factory.makeDoor(r5, r6);
        Door door6 = factory.makeDoor(r6, r7);
        Door door7 = factory.makeDoor(r2, r8);
        Door door8 = factory.makeDoor(r8, r9);
        Door door9 = factory.makeDoor(r10, r9);
        
        return aMaze;
    }
    public Maze createBombedMaze(BombedMazeFactory factory) 
    {
        Maze aMaze = factory.makeMaze();
        
        Room r1 = factory.makeRoom(1, 50, 100);
        Room r2 = factory.makeRoom(2, 100, 100);
        Room r3 = factory.makeRoom(3, 100, 150, true);
        Room r4 = factory.makeRoom(4, 100, 200);
        Room r5 = factory.makeRoom(5, 150, 200);
        Room r6 = factory.makeRoom(6, 200, 200, true);
        Room r7 = factory.makeRoom(7, 250, 200);
        Room r8 = factory.makeRoom(8, 150, 100);
        Room r9 = factory.makeRoom(9, 200, 100, true);
        Room r10 = factory.makeRoom(10, 200, 50);

        aMaze.addRoom(r1);
        aMaze.addRoom(r2);
        aMaze.addRoom(r3);
        aMaze.addRoom(r4);
        aMaze.addRoom(r5);
        aMaze.addRoom(r6);
        aMaze.addRoom(r7);
        aMaze.addRoom(r8);
        aMaze.addRoom(r9);
        aMaze.addRoom(r10);

        Door door = factory.makeDoor(r1, r2);
        Door door2 = factory.makeDoor(r2, r3);
        Door door3 = factory.makeDoor(r3, r4);
        Door door4 = factory.makeDoor(r4, r5);
        Door door5 = factory.makeDoor(r5, r6);
        Door door6 = factory.makeDoor(r6, r7);
        Door door7 = factory.makeDoor(r2, r8);
        Door door8 = factory.makeDoor(r8, r9);
        Door door9 = factory.makeDoor(r10, r9);

        Wall wall = factory.makeWall(50, 100, Directions.North, true);
        Wall wall2 = factory.makeWall(50, 100, Directions.West, true);

        aMaze.addWall(wall);
        aMaze.addWall(wall2);
        
        return aMaze;
    }

    public Maze createEnchantedMaze(SpellsMazeFactory factory) 
    {
        Maze aMaze = factory.makeMaze();
        
        Room r1 = factory.makeRoom(1, 50, 100);
        Room r2 = factory.makeRoom(2, 100, 100);
        Room r3 = factory.makeRoom(3, 100, 150, true);
        Room r4 = factory.makeRoom(4, 100, 200);
        Room r5 = factory.makeRoom(5, 150, 200);
        Room r6 = factory.makeRoom(6, 200, 200, true);
        Room r7 = factory.makeRoom(7, 250, 200);
        Room r8 = factory.makeRoom(8, 150, 100);
        Room r9 = factory.makeRoom(9, 200, 100);
        Room r10 = factory.makeRoom(10, 200, 50);

        aMaze.addRoom(r1);
        aMaze.addRoom(r2);
        aMaze.addRoom(r3);
        aMaze.addRoom(r4);
        aMaze.addRoom(r5);
        aMaze.addRoom(r6);
        aMaze.addRoom(r7);
        aMaze.addRoom(r8);
        aMaze.addRoom(r9);
        aMaze.addRoom(r10);

        Door door = factory.makeDoor(r1, r2);
        Door door2 = factory.makeDoor(r2, r3);
        Door door3 = factory.makeDoor(r3, r4);
        Door door4 = factory.makeDoor(r4, r5);
        Door door5 = factory.makeDoor(r5, r6);
        Door door6 = factory.makeDoor(r6, r7);
        Door door7 = factory.makeDoor(r2, r8);
        Door door8 = factory.makeDoor(r8, r9);
        Door door9 = factory.makeDoor(r10, r9);
        
        return aMaze;
    }
    
    public Maze destroyMaze(BombedMazeFactory factory) 
    {
        Maze bombedMaze = createBombedMaze(factory);
        Maze aMaze = factory.makeMaze();

        ArrayList<Room> rooms = bombedMaze.getRooms();

        Iterator<Room> it = rooms.iterator();
        Room r;

        while(it.hasNext()) 
        {
            r = it.next();
            if (r.hasBomb()) 
            {
                int x = r.getX();
                int y = r.getY();

                Wall wall = factory.makeWall(x, y, Directions.North, true);
                Wall wall2 = factory.makeWall(x, y, Directions.West, true);
                Wall wall3 = factory.makeWall(x + MapSite.LENGTH, y, Directions.East, true);
                Wall wall4 = factory.makeWall(x, y + MapSite.LENGTH, Directions.South, true);

                aMaze.addWall(wall);
                aMaze.addWall(wall2);
                aMaze.addWall(wall3);
                aMaze.addWall(wall4);
            } 
            else 
            {
                aMaze.addRoom(r);
            }
        }
        
        return aMaze;
    }    
    
}
