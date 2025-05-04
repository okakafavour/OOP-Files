package Diary;

import Estore.Entry;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Diary implements Serializable {
    private static final long serialVersionUID = 1L;

    private boolean isLocked;
    private final String username;
    private final String password;
    private final List<Entry> entries;

    public Diary(String username, String password) {
        this.username = username;
        this.password = password;
        this.isLocked = true;
        this.entries = new ArrayList<>();
    }

    public void unlockDiary(String password) {
        boolean isValidPassword = password != null && !password.trim().isEmpty() && this.password.equals(password);
        if (isValidPassword) {
            isLocked = false;
        } else {
            throw new IllegalArgumentException("Invalid password");
        }
    }

    public void lockDiary() {
        isLocked = true;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public boolean isUnlocked() {
        return !isLocked;
    }

    public void createEntry(String title, String body) {
        if (title == null || title.trim().isEmpty() || body == null || body.trim().isEmpty()) {
            throw new IllegalArgumentException("Title and body cannot be null or empty");
        }
        int newId = entries.size() + 1;
        Entry entry = new Entry(newId, title, body);
        entries.add(entry);
    }

    public List<Entry> getEntries() {
        return new ArrayList<>(entries);
    }

    public void updateEntry(int id, String newTitle, String newBody) {
        if (newTitle == null || newTitle.trim().isEmpty() || newBody == null || newBody.trim().isEmpty()) {
            throw new IllegalArgumentException("New title and body cannot be null or empty");
        }
        Entry entry = findEntry(id);
        if (entry == null) {
            throw new IllegalArgumentException("Estore.Entry with ID " + id + " not found");
        }
        int index = entries.indexOf(entry);
        entries.set(index, new Entry(id, newTitle, newBody));
    }

    private Entry findEntry(int id) {
        for (Entry entry : entries) {
            if (entry.getId() == id) {
                return entry;
            }
        }
        return null;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public void deleteEntry(int id) {
        if (isLocked) {
            throw new IllegalStateException("Diary.Diary is locked. Unlock it first");
        }
        Entry toRemove = null;
        for (Entry entry : entries) {
            if (entry.getId() == id) {
                toRemove = entry;
                break;
            }
        }
        if (toRemove == null) {
            throw new IllegalArgumentException("Estore.Entry with ID " + id + " not found");
        }
        entries.remove(toRemove);
        for (int i = 0; i < entries.size(); i++) {
            Entry e = entries.get(i);
            entries.set(i, new Entry(i + 1, e.getTitle(), e.getBody()));
        }
    }

    public void viewAllEntries() {
        if ((isLocked)|| (entries.isEmpty())) {
            throw new IllegalStateException("Diary.Diary is locked. Unlock it first or Diary.Diary is empty");
        } else {
            for (Entry entry : entries) {
                System.out.println(entry.getId());
                System.out.println(entry.getTitle());
                System.out.println(entry.getBody());
            }
        }
    }
}