package hw12Dictionary;

import java.util.Objects;

public class FileData {
    private String path;
    private String fileName;
    private int size;

    public FileData(String path, String fileName, int size) {
        this.path = path;
        this.fileName = fileName;
        this.size = size;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileData fileData = (FileData) o;
        return size == fileData.size && Objects.equals(path, fileData.path) && Objects.equals(fileName, fileData.fileName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(path, fileName, size);
    }

    @Override
    public String toString() {
        return "FileData{" +
                "path='" + path + '\'' +
                ", fileName='" + fileName + '\'' +
                ", size=" + size +
                '}';
    }
}
