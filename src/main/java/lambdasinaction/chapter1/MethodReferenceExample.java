package lambdasinaction.chapter1;

import java.io.File;
import java.io.FileFilter;

/**
 * Created by Marius on 2/20/2016.
 */
public class MethodReferenceExample {

    public static void main(String[] args) {

        File[] hiddenFiles = new File("C:\\Users\\Marius").listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isHidden();
            }
        });

        for(File f : hiddenFiles){
            System.out.println(f.getName());
        }

        //I filter the files by using this method as a value (method reference :: syntax).
        //Note that FileFilter is now a functional interface.
        File[] hiddenFilesJ8 = new File("C:\\Users\\Marius").listFiles(File::isHidden);

        for (File f : hiddenFilesJ8) {
            System.out.println(f.getName());
        }
    }

}
