package Diary;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Diaries implements Serializable {
  private List<Diary> diaries = new ArrayList<>();
  private static final long serialVersionUID = 1L;

  public void createDiary(String username, String password) {
    if (findDiary(username) != null) {
      throw new IllegalArgumentException("Diary.Diary with username '" + username + "' already exists");
    }
    Diary diary = new Diary(username, password);
    diaries.add(diary);
  }

  public Diary findDiary(String username) {
    for (Diary diary : diaries) {
      if (diary.getUsername().equals(username)) {
        return diary;
      }
    }
    return null;
  }
}