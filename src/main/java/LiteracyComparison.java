
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LiteracyComparison {

    public static void main(String[] args) {

        List<Entry> entries = new ArrayList<>();
        try {
            List<String> rows = new ArrayList<>();
            Files.lines(Paths.get("literacy.csv")).forEach(row -> rows.add(row));

            rows.stream()
                    .map(row -> row.split(","))
                    .map(pieces -> new Entry(pieces[3],
                            Integer.valueOf(pieces[4]),
                            pieces[2].replace("(%)", "").trim(),
                            Double.parseDouble(pieces[5])))
                    .forEach(entry -> entries.add(entry));

//                for (String row : rows) {
//                    String[] pieces = row.split(",");
//                    String country = pieces[3];
//                    int year = Integer.valueOf(pieces[4]);
//                    // Extract and trim the gender, ensuring it handles different formats
//                    String gender = pieces[2].contains("female") ? "female" : pieces[2].contains("male") ? "male" : "unknown";
//                    double percentage = Double.valueOf(pieces[5]);
//                    Entry entry = new Entry(country, year, gender, percentage);
//                    entries.add(entry);
//                }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Collections.sort(entries, (e1, e2) -> e1.getPercentage() - e2.getPercentage());

        Collections.sort(entries);
        entries.stream().forEach(entry -> System.out.println(entry));
    }
}
