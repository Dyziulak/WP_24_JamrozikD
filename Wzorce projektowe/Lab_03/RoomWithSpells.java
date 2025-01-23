import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

public class RoomWithSpells extends Room 
{

    private static final char[] SPELL_SYMBOLS = {'!', '$', '@'};
    private static final Random RANDOM = new Random();

    public RoomWithSpells(int nr, int x, int y) 
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

        g.setColor(Color.GREEN);

        char spellSymbol = SPELL_SYMBOLS[RANDOM.nextInt(SPELL_SYMBOLS.length)];

        g.drawString(String.valueOf(spellSymbol), roomCenterX - 5, roomCenterY + 5);
    }
}
