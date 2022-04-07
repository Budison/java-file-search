package com.github.budison.javafilesearch;

import java.io.File;

/**
 * @author Kevin Nowak
 */
record SearchThread(String path) implements Runnable {

    @Override
    public void run() {
        FileSearch fileSearch = new FileSearch();
        fileSearch.searchDirectory(new File(path));
        int count = fileSearch.getResult().size();
        if (count == 0) {
            System.out.println("\nNo result found in " + path);
        } else {
            StringBuilder stringBuilder = new StringBuilder("\nFound " + count + " results!\n");
            for (String matched : fileSearch.getResult()) {
                stringBuilder.append("\nFound ").append(matched);
            }
            System.out.println(stringBuilder);
        }
    }
}
