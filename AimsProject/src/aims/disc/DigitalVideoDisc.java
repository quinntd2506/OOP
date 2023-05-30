package aims.disc;

public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
    private int id;

    private static int nbDigitalVideoDiscs = 0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId() {
        this.id = nbDigitalVideoDiscs;
		nbDigitalVideoDiscs += 1;
    }


    public static int getnbDigitalVideoDisc() {
        return nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title) {
        this.title = title; //Using ‘this’ keyword to refer current class instance variables
        setId();
    }

    public DigitalVideoDisc(String category, String title, float cost) {
        this(title); //Using this() to invoke current class constructor
        this.category = category;
        this.cost = cost;
    }

    public DigitalVideoDisc(String director, String category, String title, float cost) {
        this(category, title, cost);
        this.director = director;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this(director, category, title, cost);
        this.length = length;
    }

    public String getTitle() {
        return this.title;
    }

    public String setTitle(String title){
        this.title = title;
        return this.title;
    }

    public String getCategory() {
        return this.category;
    }

    public String getDirector() {
        return this.director;
    }

    public int getLength() {
        return this.length;
    }

    public float getCost() {
        return this.cost;
    }

    public boolean isMatch(String title){
        return this.title == title;
    }

    public String toString(){
        return getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + getLength() + ": " + getCost() + "$";
    }

}