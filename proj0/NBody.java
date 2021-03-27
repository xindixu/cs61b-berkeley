public class NBody {
    public static final String BACKGROUND = "images/starfield.jpg";

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
            planets[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
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
        int numOfPlanets = planets.length;

        // Animation
        StdDraw.enableDoubleBuffering();

        // Draw the background
        StdDraw.setScale(-radius, radius);

        StdDraw.clear();

        // Animation starts
        int time = 0;
        while(time < T){
            double[] xForces = new double[numOfPlanets];
            double[] yForces = new double[numOfPlanets];
            StdDraw.picture(0, 0, BACKGROUND);

            // Calculate forces
            for (int i = 0; i < numOfPlanets; i++) {
                Planet p = planets[i];
                xForces[i] = p.calcNetForceExertedByX(planets);
                yForces[i] = p.calcNetForceExertedByY(planets);
                p.update(dt, xForces[i], yForces[i]);
                p.draw();
            }

            // Draw planets
            for (int i = 0; i < numOfPlanets; i++) {
                Planet p = planets[i];
                p.update(dt, xForces[i], yForces[i]);
                p.draw();
            }

            StdDraw.show();
            StdDraw.pause(10);
            time += dt;
        }

        // Print the universe after animation ends


        StdOut.printf("%d\n", numOfPlanets);
        StdOut.printf("%.2e\n", radius);

        for (Planet p : planets) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    p.xxPos, p.yyPos, p.xxVel,
                    p.yyVel, p.mass, p.imgFileName);
        }
    }
}
