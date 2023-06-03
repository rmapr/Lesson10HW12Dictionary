package hw12Dictionary;

import java.util.*;

public class FileNavigator {
    private Map<String, List<FileData>> fileDataMap;

    public FileNavigator() {
        fileDataMap = new HashMap<>();
    }

    //2. Реалізувати метод add у класі FileNavigator. Цей метод додає файл за вказаним шляхом.
//Якщо шлях вже існує, новий файл необхідно додати до списку, вже пов'язаному з відповідним
//шляхом. ВАЖЛИВО: Шлях – унікальне значення і не повинно повторюватися.
    public boolean add(FileData fileData) {
        if (fileDataMap.containsKey(fileData.getPath())) {
            List<FileData> fileDataList = fileDataMap.get(fileData.getPath());
            fileDataList.add(fileData);
        } else {
            List<FileData> fileDataList = new ArrayList<>();
            fileDataMap.put(fileData.getPath(), fileDataList);
            fileDataList.add(fileData);
        }
        return true;
    }

    //3. Реалізувати метод find у класі FileNavigator. Метод повертає список файлів, пов'язаних
//з шляхом переданим як параметр.
    public List<FileData> find(String pathFind) {
        return fileDataMap.get(pathFind);
    }

// 4. Реалізувати метод filterBySize у класі FileNavigator. Метод повертає список файлів,
// розмір (в байтах) яких не перевищує значення, передане як параметр.
    public List<FileData> filterBySize(int size) {
        List<FileData> fileDataList = new ArrayList<>();
        for (String key : fileDataMap.keySet()) {
            for (FileData fileData : fileDataMap.get(key)) {
                if (fileData.getSize() <= size)
                fileDataList.add(fileData);
            }
        }
        return fileDataList;
    }

    public Map<String, List<FileData>> getFileDataMap() {
        return fileDataMap;
    }

    public void setFileDataMap(Map<String, List<FileData>> fileDataMap) {
        this.fileDataMap = fileDataMap;
    }

    @Override
    public String toString() {
        return "FileNavigator{" +
                "fileDataMap=" + fileDataMap +
                '}';
    }
}
