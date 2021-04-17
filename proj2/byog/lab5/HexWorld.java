package byog.lab5;
import javafx.geometry.Pos;
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
    private static final int WIDTH = 80;
    private static final int HEIGHT = 80;

    private static final long SEED = 2873123;
    private static final Random RANDOM = new Random(SEED);

    private static final int MIN_SIZE = 2;
    private static final int SIZE = 3;

    private static class Position {
        int x;
        int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }

    /**
     * Add a row to the world
     * @param world The tiles for the world
     * @param position The position for the left corner of the row
     * @param size The width of the hex
     * @param tile The name of the tile
     */
    private static void addRow(TETile[][] world, Position position, int size, TETile tile) {
        for (int x = position.x; x < position.x + size; x++) {
            world[x][position.y] = tile;
        }
    }

    /**
     * Add a hexagon to the world
     * @param world The tiles for the world
     * @param position The position for the lower-left corner of the hex
     * @param size The size of the hex
     * @param tile The name of the tile
     */
    public static void addHexagon(TETile[][] world, Position position, int size, TETile tile) {
        if (size < MIN_SIZE) {
            System.out.println("Size should be greater than " + MIN_SIZE);
            return;
        }

        // draw lower half
        for (int i = 0; i < size; i++) {
            addRow(world, new Position(position.x - i, position.y + i), size + i * 2, tile);
        }

        // draw upper half
        for (int i = 0; i < size; i++) {
            addRow(world, new Position(position.x - i, position.y + size * 2 - i - 1), size + i * 2, tile);
        }
    }

    private static TETile randomTile() {
        int tileNum = RANDOM.nextInt(6);
        switch (tileNum) {
            case 0: return Tileset.GRASS;
            case 1: return Tileset.FLOWER;
            case 2: return Tileset.MOUNTAIN;
            case 3: return Tileset.TREE;
            case 4: return Tileset.SAND;
            case 5: return Tileset.WATER;
            default: return Tileset.NOTHING;
        }
    }

    private static void addColOfHexagons(TETile[][] world, Position position, int count) {
        for (int i = 0; i < count; i++) {
            addHexagon(world, new Position(position.x, position.y + SIZE * 2 * i), SIZE, randomTile());
        }
    }

    public static void addTesselationOfHexagon(TETile[][] world, Position position, int count) {
        // left half
        for (int i = 1; i <= count / 2; i++) {
            addColOfHexagons(world, new Position(position.x - SIZE * i * 2 + i, position.y + SIZE * i), count - i);
        }

        addColOfHexagons(world, new Position(position.x, position.y), count);

        // right half
        for (int i = 1; i <= count / 2; i++) {
            addColOfHexagons(world, new Position(position.x + SIZE * i * 2 - i, position.y + SIZE * i), count - i);
        }
    }

    public static void initializeTiles(TETile[][] world) {
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

        addTesselationOfHexagon(world, new Position(25, 25), 6);
        ter.renderFrame(world);
    }
}
