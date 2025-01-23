import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame 
{
    private MyJPanel panel;
    private Image image;
    MazeGame maze;
    BombedMazeFactory bombedMazeFactory = new BombedMazeFactory();
    SpellsMazeFactory spellsMazeFactory;
    
    public App() 
    {
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new MyJPanel();
        JButton button_draw = new JButton("Draw");
        JButton button_spells = new JButton("Enchanted Maze");
        JButton button_bombs = new JButton("Maze with Bombs");
        JButton button_destroyed = new JButton("Detonate Bombs");

        button_draw.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                buildMaze();
            }
        });

        button_spells.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                buildEnchantedMaze();
            }
        });

        button_bombs.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                buildBombedMaze();
            }
        });

        button_destroyed.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                buildDestroyedMaze();
            }
        });
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        buttonPanel.add(button_draw);
        buttonPanel.add(button_spells);
        buttonPanel.add(button_bombs);
        buttonPanel.add(button_destroyed);


        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.NORTH);
    }

    public void clearImage() 
    {
        if (image != null) 
        {
            Graphics g = image.getGraphics();
            g.setColor(panel.getBackground());
            g.fillRect(0, 0, image.getWidth(null), image.getHeight(null));
            g.dispose();
        }
    }

    public void buildBombedMaze() 
    {
        clearImage();
        maze = new MazeGame();
        bombedMazeFactory = new BombedMazeFactory();

        Maze aMaze = maze.createBombedMaze(bombedMazeFactory);
        
        image = panel.getImage();

        aMaze.drawMaze(image);

        panel.repaint();
    }

    public void buildEnchantedMaze() 
    {
        clearImage();
        maze = new MazeGame();
        spellsMazeFactory = new SpellsMazeFactory();

        Maze aMaze = maze.createEnchantedMaze(spellsMazeFactory);

        image = panel.getImage();

        aMaze.drawMaze(image);

        panel.repaint();
    }

    public void buildMaze() 
    {
        clearImage();
        maze = new MazeGame();
        bombedMazeFactory = new BombedMazeFactory();

        Maze aMaze = maze.createMaze(bombedMazeFactory);

        image = panel.getImage();

        aMaze.drawMaze(image);

        panel.repaint();
    }

    public void buildDestroyedMaze() 
    {
        clearImage();
        maze = new MazeGame();

        Maze aMaze = maze.destroyMaze(bombedMazeFactory);

        image = panel.getImage();

        aMaze.drawMaze(image);

        panel.repaint();
    }

    public static void main(String[] args) 
    {
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            @Override
            public void run() 
            {
                new App().setVisible(true);
            }
        });
    }
}
