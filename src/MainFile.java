import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class MainFile {
    private static List<File> listWithFileNames = new ArrayList<>();

    public static void main(String[] args) {
        getListFiles("D:\\programming\\Java_Projects\\basejava\\basejava\\src");
        for (File file : listWithFileNames) {
            System.out.println(file.getName());
        }
    }

    public static void getListFiles(String str) {
        File f = new File(str);
        for (File s : Objects.requireNonNull(f.listFiles())) {
            if (s.isFile()) {
                listWithFileNames.add(s);
            } else if (s.isDirectory()) {
                getListFiles(s.getAbsolutePath());
            }
        }
    }
}

