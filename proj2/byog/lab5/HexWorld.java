package byog.lab5;
import org.junit.Test;
import static org.junit.Assert.*;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {
    private static final int WIDTH = 50;
    private static final int HEIGHT = 50;

    private static final long SEED = 2873123;
    private static final Random RANDOM = new Random(SEED);

    private static final int MIN_SIZE = 2;

    private static class Position {
        int x;
        int y;

        Position(int x, int y){
            this.x = x;
            this.y = y;
        }

        public String toString(){
            return "(" + x + "," + y + ")";
        }
    }

    /**
     * Add a row to the world
     * @param world The tiles for the world
     * @param position The position for the left corner of the row
     * @param size The width of the hex
     */
    private static void addRow(TETile[][] world, Position position, int size) {
        for (int x = position.x; x < position.x + size; x++) {
            world[x][position.y] = Tileset.FLOWER;
        }
    }

    /**
     * Add a hexagon to the world
     * @param world The tiles for the world
     * @param position The position for the lower-left corner of the hex
     * @param size The size of the hex
     */
    public static void addHexagon(TETile[][] world, Position position, int size)  {
        if(size < MIN_SIZE){
            System.out.println("Size should be greater than " + MIN_SIZE);
            return;
        }

        // draw lower half
        for (int i = 0; i < size; i++) {
            addRow(world, new Position(position.x - i, position.y + i), size + i * 2);
        }

        // draw upper half
        for (int i = 0; i < size; i++) {
            addRow(world, new Position(position.x - i, position.y + size * 2 - i - 1), size + i * 2);
        }
    }

    public static void initializeTiles(TETile[][] world){
        for (int x = 0; x < WIDTH; x += 1) {
            for (int y = 0; y < HEIGHT; y += 1) {
                world[x][y] = Tileset.NOTHING;
            }
        }
    }

    public static void main(String[] args) {
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);

        TETile[][] world = new TETile[WIDTH][HEIGHT];
        initializeTiles(world);

        addHexagon(world, new Position(2,30), 2);
        addHexagon(world, new Position(10,30), 3);
        addHexagon(world, new Position(20,30), 4);
        addHexagon(world, new Position(35,30), 5);

        ter.renderFrame(world);

    }
}
