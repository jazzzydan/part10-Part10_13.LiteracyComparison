public class Entry implements Comparable<Entry>{
    private String country;
    private int year;
    private String gender;
    private double percentage;

    public Entry(String country, int year, String gender, double percentage) {
        this.country = country;
        this.year = year;
        this.gender = gender;
        this.percentage = percentage;
    }

    @Override
    public int compareTo(Entry another) {
        // Use Double.compare to avoid issues with precision and comparison logic
        return Double.compare(this.percentage, another.percentage);
    }

    @Override
    public String toString() {
        return country + " (" + year + "), " + gender + ", " + percentage;
    }
}
