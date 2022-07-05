import java.time.DayOfWeek;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FileHandler.loadFromFile();
        Scanner menuChoiceScanner = new Scanner(System.in);
        Scanner dvdChoiceScanner = new Scanner(System.in);
        Scanner editDeleteScanner = new Scanner(System.in);
        Scanner attributeChoiceScanner = new Scanner(System.in);
        Scanner newAttributeScanner = new Scanner(System.in);
        Scanner newDvdScanner = new Scanner(System.in);
        Scanner titleSearchScanner = new Scanner(System.in);
        String[] newDvdAttributes = new String[6];
        String[] attributeLabels = {"Name", "Release Date", "MPAA Rating", "Director's name", "Studio", "Review"};

        while (true) {

            System.out.println("""

                    What would you like to do?
                    1. Add a new entry.
                    2. Select an existing dvd to edit or delete it.
                    3. Print all DVDs.
                    4. Search for a DVD by title.
                    5. Save and Exit.
                    6. Exit.""");
            String currentChoice = menuChoiceScanner.next();

            switch (currentChoice) {
                case "1" -> {
                    for (int i = 0; i < newDvdAttributes.length; i++) {
                        System.out.println(attributeLabels[i] + ": ");
                        newDvdAttributes[i] = newDvdScanner.nextLine();
                    }
                    new DVD(newDvdAttributes);
                }
                case "2" -> {
                    System.out.println("Select a DVD:\n");
                    DVD.printAllDvds();
                    String dvdChoice = dvdChoiceScanner.next();
                    DVD currentDVD = DVD.getDvdById(Integer.parseInt(dvdChoice) - 1);
                    System.out.println("1. Edit DVD\n2. Delete DVD.");
                    String editDeleteChoice = editDeleteScanner.next();
                    switch (editDeleteChoice) {
                        case "1" -> {
                            System.out.println("""
                                    What would you like to modify?
                                    1. Name
                                    2. Release Date
                                    3. MPAA Rating
                                    4. Director's name
                                    5. Studio
                                    6. Review""");
                            String attributeChoice = attributeChoiceScanner.next();
                            System.out.println("Enter new Attribute: ");
                            String newAttribute = newAttributeScanner.nextLine();
                            switch (attributeChoice) {
                                case "1" -> currentDVD.setName(newAttribute);
                                case "2" -> currentDVD.setReleaseDate(newAttribute);
                                case "3" -> currentDVD.setMPAARating(newAttribute);
                                case "4" -> currentDVD.setDirectorName(newAttribute);
                                case "5" -> currentDVD.setStudio(newAttribute);
                                case "6" -> currentDVD.setReview(newAttribute);
                            }
                            DVD.printAllDvds();
                        }
                        case "2" -> {
                            DVD.removeDVD(currentDVD);
                            DVD.printAllDvds();
                        }
                    }
                }
                case "3" -> DVD.printAllDvds();
                case "4" -> {
                    System.out.println("Enter title to search: ");
                    DVD searchedDVD = DVD.getDvdByTitle(titleSearchScanner.nextLine());
                    if (searchedDVD != null) {
                        System.out.println(searchedDVD);
                    } else {
                        System.out.println("There is no DVD with that title.");
                    }
                }
                case "5" -> {
                    System.out.println("Saving data...");
                    FileHandler.saveToFile();
                    System.out.println("Done!");
                    return;
                }
                case "6" -> {
                    System.out.println("Data NOT saved.");
                    return;
                }
            }
        }
    }
}
