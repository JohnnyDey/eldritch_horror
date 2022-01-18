package com.jd.eldritch.model;


import java.util.ConcurrentModificationException;
import java.util.concurrent.atomic.AtomicReference;

public class GameLock {
    private final static String UNLOCKED = "unlocked";
    private final AtomicReference<String> lock = new AtomicReference<>(UNLOCKED);

    public void lock(String uid) {
        boolean result = lock.compareAndSet(UNLOCKED, uid);
        if (!result) throw new ConcurrentModificationException("Другой игрок делает ход");
    }

    public void unlock(String uid) {
        boolean result = lock.compareAndSet(uid, UNLOCKED);
        if (!result) throw new ConcurrentModificationException("Другой игрок делает ход");
    }
}
