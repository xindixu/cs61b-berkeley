public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    private final double GRAVITATIONAL_CONSTANT = 6.67e-11;
    private static final String IMAGE_PATH_PREFIX = "images/";

    public Planet(double xxPos, double yyPos, double xxVel, double yyVel, double mass, String imgFileName){
        this.xxPos = xxPos;
        this.yyPos = yyPos;
        this.xxVel = xxVel;
        this.yyVel = yyVel;
        this.mass = mass;
        this.imgFileName = imgFileName;
    }

    public Planet(Planet p) {
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }


    public double calcDistance(Planet p) {
        return Math.sqrt(Math.pow(p.xxPos - xxPos, 2) + Math.pow(p.yyPos - yyPos, 2));
    }

    public double calcForceExertedBy(Planet p){
        double r = calcDistance(p);
        return (GRAVITATIONAL_CONSTANT * mass * p.mass) / Math.pow(r, 2);
    }

    public double calcForceExertedByX(Planet p){
        double f = calcForceExertedBy(p);
        double dx = p.xxPos - xxPos;
        double r = calcDistance(p);
        return f * dx / r;
    }

    public double calcForceExertedByY(Planet p){
        double f = calcForceExertedBy(p);
        double dy = p.yyPos - yyPos;
        double r = calcDistance(p);
        return f * dy / r;
    }

    public double calcNetForceExertedByX(Planet[] ps){
        double xxForce = 0;

        for (Planet p : ps){
            if(p.equals(this)) continue;
            xxForce += calcForceExertedByX(p);
        }
        return xxForce;
    }

    public double calcNetForceExertedByY(Planet[] ps){
        double yyForce = 0;

        for (Planet p : ps){
            if(p.equals(this)) continue;
            yyForce += calcForceExertedByY(p);
        }
        return yyForce;
    }

    public void update(double dt, double xxForce, double yyForce){
        double xxAcc = xxForce / mass;
        double yyAcc = yyForce / mass;
        xxVel = xxVel + xxAcc * dt;
        yyVel = yyVel + yyAcc * dt;
        xxPos = xxPos + xxVel * dt;
        yyPos = yyPos + yyVel * dt;
    }

    public void draw(){
        StdDraw.picture(xxPos, yyPos, IMAGE_PATH_PREFIX + imgFileName);
    }
}
