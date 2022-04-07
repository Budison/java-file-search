package com.github.budison.javafilesearch;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Kevin Nowak
 */
class FileSearch {
    private final List<String> result;

    public FileSearch() {
        result = new ArrayList<>();
    }

    List<String> getResult() {
        return result;
    }

    void searchDirectory(File directory) {
        if (directory.isDirectory()) {
            search(directory);
        } else {
            System.out.println(directory.getAbsoluteFile() + " is not a directory!");
        }
    }

    void search(File file) {
            if (file.canRead()) {
                for (File temp : Objects.requireNonNull(file.listFiles())) {
                    if (temp.isDirectory()) {
                        search(temp);
                    } else if (temp.getName().endsWith(".java")) {
                            result.add(temp.getAbsoluteFile().toString());
                    }
                }
            } else {
                System.out.println(file.getAbsoluteFile() + "Permission denied!");
            }
    }
}
