package com.github.budison.javafilesearch;

import java.util.concurrent.ThreadFactory;

/**
 * @author Kevin Nowak
 */
class DaemonThread implements ThreadFactory {
    private int count = 1;

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, "searchThread " + count++);
        t.setDaemon(true);
        return t;
    }
}
