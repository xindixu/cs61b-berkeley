public class NBody {
    public static final String BACKGROUND = "images/starfield.jpg";
    public static final String IMAGE_PATH_PREFIX = "images/";

    public static final int SIZE = 512;

    public static double readRadius(String filename) {
        In in = new In(filename);
        in.readInt();
        return in.readDouble();
    }

    public static Planet[] readPlanets(String filename) {
        In in = new In(filename);
        int numOfPlanets = in.readInt();
        in.readDouble();
        Planet[] planets = new Planet[numOfPlanets];
        for (int i = 0; i < numOfPlanets; i++) {
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String imgFileName = in.readString();
            planets[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, IMAGE_PATH_PREFIX + imgFileName);
        }
        return planets;
    }


    public static void main(String[] args) {
        // Read and parse input
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);

        // Draw the background
        StdDraw.setScale(-radius, radius);

        StdDraw.clear();
        StdDraw.picture(0, 0, BACKGROUND);

        // Draw planets
        for (Planet p : planets) {
            p.draw();
        }
    }
}
