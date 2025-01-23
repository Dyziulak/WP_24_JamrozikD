public class SpellsMazeFactory extends MazeFactory 
{
    public Wall makeWall(int x, int y, Directions d, boolean isBombed) 
    {
        if (isBombed) 
        {
            return new BombedWall(x, y, d);
        }
        return new Wall(x, y, d);
        
    }

    public Room makeRoom(int n, int x, int y, boolean SpellsActive) 
    {
        Room r1;
        if (SpellsActive) 
        {
            r1 = new RoomWithSpells(n, x, y);
        } 
        else 
        {
            r1 = new Room(n, x, y);
        }

        r1.setSite(Directions.North, new Wall(x, y, Directions.North));
        r1.setSite(Directions.East, new Wall(x, y, Directions.East));
        r1.setSite(Directions.South, new Wall(x, y, Directions.South));
        r1.setSite(Directions.West, new Wall(x, y, Directions.West));
        
        return r1;
    }
}
