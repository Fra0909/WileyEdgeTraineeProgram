import java.util.ArrayList;

public class DVD {

    private String name;
    private String releaseDate;
    private String MPAARating;
    private String directorName;
    private String studio;
    private String review;
    public static ArrayList<DVD> DVDs = new ArrayList<>();

    public DVD(String name, String releaseDate, String MPAARating, String directorName, String studio, String review) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.MPAARating = MPAARating;
        this.directorName = directorName;
        this.studio = studio;
        this.review = review;
        DVDs.add(this);
    }

    public DVD(String[] attributes) {
        this.name = attributes[0];
        this.releaseDate = attributes[1];
        this.MPAARating = attributes[2];
        this.directorName = attributes[3];
        this.studio = attributes[4];
        this.review = attributes[5];
        DVDs.add(this);
    }


    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getMPAARating() {
        return MPAARating;
    }

    public void setMPAARating(String MPAARating) {
        this.MPAARating = MPAARating;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void printAllDvds() {
        for (int i = 0; i<DVDs.size();i++) {
            DVD dvd = DVDs.get(i);
//            System.out.println(dvd.toString());
            System.out.println("ID: " + (i+1) + " | Name: " + dvd.getName() + " | Release Date: " + dvd.getReleaseDate() + " | MPAA Rating: " + dvd.getMPAARating()
                + " | Director's Name: " + dvd.getDirectorName() + " | Studio: " + dvd.getStudio() + " | Review: " + dvd.getReview());
        }
    }

    public static DVD getDvdById(int id) {
        return DVDs.get(id);
    }

    public static DVD getDvdByTitle(String title) {
        for (DVD dvd: DVDs) {
            if (dvd.name.equalsIgnoreCase(title)) {
                return dvd;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.getName() + "," + this.getReleaseDate() + "," + this.getMPAARating()
                + "," + this.getDirectorName() + "," + this.getStudio() + "," + this.getReview();

    }


    public static void removeDVD(DVD dvd) {
        DVDs.remove(dvd);
    }

}

