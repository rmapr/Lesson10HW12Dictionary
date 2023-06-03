package hw12Dictionary;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        FileNavigator fileNavigator = new FileNavigator();

        fileNavigator.add(new FileData("/HW/Lesson1/", "firstApp.java", 50));
        fileNavigator.add(new FileData("/HW/Lesson1/", "firstApp.txt", 20));
        fileNavigator.add(new FileData("/HW/Lesson2/", "firstApp.pdf", 1500));
        fileNavigator.add(new FileData("/HW/Lesson3/", "doc.doc", 1000));
        fileNavigator.add(new FileData("/HW/Lesson2/", "music.mp3", 20000));
        fileNavigator.add(new FileData("/HW/Lesson1/", "video.mp4", 100200));

        String pathFind = "/HW/Lesson1/";
        print(fileNavigator);
//        printfind(fileNavigator.find(pathFind), pathFind);
        int size =1500;
        printfind(fileNavigator.filterBySize(size), "всюди, відсортовані по size не перевищує " + size + " байт");
    }

    private static void print(FileNavigator fileNavigator) {
        for (Map.Entry<String, List<FileData>> map : fileNavigator.getFileDataMap().entrySet()) {
            List<FileData> list = map.getValue();
            int count = 0;
            System.out.print("\n" + map.getKey() + ": ");
            for (FileData fd : list) {
                count++;
                System.out.print(count + ") " + fd.getFileName() + "| " + fd.getSize() + " байт; ");
            }
        }
    }

    private static void printfind(List<FileData> fileDataList, String path) {
        System.out.println("\nПо шляху " + path);
//        if (fileDataList.isEmpty()) {
        if (fileDataList ==null) {
            System.out.println("Файлів не знайдено.");
        } else {
            System.out.println("Наступні файли:");
            int count = 0;
            for (FileData fd : fileDataList) {
                count++;
                System.out.print(count + ") " + fd.getFileName() + "| " + fd.getSize() + " байт;\n");
            }
        }
    }
}
