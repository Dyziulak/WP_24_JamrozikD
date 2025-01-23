abstract class MazeFactory 
{
    public MazeFactory() {}

    public Maze makeMaze() 
    {
        return new Maze();
    }

    public Room makeRoom(int nr, int x, int y) 
    {
        Room r1 = new Room(nr, x, y);
        
        r1.setSite(Directions.North, new Wall(x, y, Directions.North));
        r1.setSite(Directions.East, new Wall(x, y, Directions.East));
        r1.setSite(Directions.South, new Wall(x, y, Directions.South));
        r1.setSite(Directions.West, new Wall(x, y, Directions.West));
        
        return r1;
    }

    public Wall makeWall(int x, int y, Directions direction) 
    {
        return new Wall(x, y, direction);
    }

    public Door makeDoor(Room r1, Room r2) 
    {
        if (r1 != null && r2 != null) 
        {
            Directions direction = commonWall(r1, r2);
            Directions directionTo = direction.opposite();

            Door door = new Door(r1, r2);
            r1.setSite(direction, door);
            r2.setSite(directionTo, door);
            return door;
        } 
        else 
        {
            throw new IllegalArgumentException("Nie można utworzyć drzwi: jeden z pokoi nie istnieje.");
        }
    }

    public Directions commonWall(Room r1, Room r2) 
    {
        
        if (r1 != null && r2 != null) 
        {
            if (r1.getY() == r2.getY()) 
            {
                if (r1.getX() > r2.getX()) 
                {
                    return Directions.West;
                } 
                else 
                {
                    return Directions.East;
                }
            } 
            else if (r1.getX() == r2.getX()) 
            {
                if (r1.getY() > r2.getY()) 
                {
                    return Directions.North;
                } 
                else 
                {
                    return Directions.South;
                }
            }
        }

        throw new IllegalArgumentException("Pokoje nie są sąsiednie, brak wspólnej ściany.");
    }
}
