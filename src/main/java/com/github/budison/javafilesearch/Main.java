package com.github.budison.javafilesearch;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        DaemonThread daemonThread = new DaemonThread();
        List<Thread> threadList = new ArrayList<>();
        directoryList().forEach(s -> threadList.add(daemonThread.newThread((new SearchThread(s)))));
        threadList.forEach(Thread::start);
    }

    private static List<String> directoryList() {
        File file = new File("/home/kevin/code");
        File[] files = file.listFiles();
        assert files != null;
        return Arrays.stream(files)
                .filter(File::isDirectory)
                .map(File::getAbsolutePath)
                .toList();
    }
}	
