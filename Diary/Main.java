package Diary;

import java.util.Scanner;

public class Main {
      private static Scanner input = new Scanner(System.in);
      private static Diaries diaries = new Diaries();
    private static Diary diary = null;

    public static void main(String[] args) {
        showMenu();
    }

    public static void showMenu() {
        while (true) {
            System.out.println("""
                    \nDiary.Diary App Menu
                    1. -> Create a new diary
                    2. -> Add an entry to the diary
                    3. -> Update an entry
                    4. -> Delete an entry
                    5. -> Lock a diary
                    6. -> Unlock a diary
                    7. -> View all entries in a diary
                    8. -> Exit
                    """);

            System.out.print("Choose an option from the menu: ");
            String choice = input.nextLine();

            switch (choice) {
                case "1":
                    createDiary();
                    break;
                case "2":
                    addEntry();
                    break;
                case "3":
                    updateEntry();
                    break;
                case "4":
                    deleteEntry();
                    break;
                case "5":
                    lockDiary();
                    break;
                case "6":
                    unlockDiary();
                    break;
                case "7":
                    viewEntries();
                    break;
                case "8":
                    exitProgram();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void createDiary() {
        String username = promptUsername();
        String password = promptPassword();
        try {
            diaries.createDiary(username, password);
            diary = diaries.findDiary(username);
            System.out.println("Diary.Diary created successfully");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void addEntry() {
        if (!ValidationForDiary()) return;
        String title = promptEntryTitle();
        String body = promptEntryBody();
        try {
            diary.createEntry(title, body);
            System.out.println("Estore.Entry added successfully");
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void updateEntry() {
        if (!ValidationForDiary()) return;
        int id = promptEntryId();
        String newTitle = promptNewEntryTitle();
        String newBody = promptNewEntryBody();
        try {
            diary.updateEntry(id, newTitle, newBody);
            System.out.println("Estore.Entry updated successfully");
        } catch (IllegalArgumentException  e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void deleteEntry() {
        if (!ValidationForDiary()) return;
        int id = promptEntryId();
        try {
            diary.deleteEntry(id);
            System.out.println("Estore.Entry deleted successfully");
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void lockDiary() {
        if (!checkDiaryExists()) return;
        diary.lockDiary();
        System.out.println("Diary.Diary locked successfully");
    }

    public static void unlockDiary() {
        if (!checkDiaryExists()) return;
        System.out.print("Enter password to unlock diary: ");
        String password = input.nextLine();
        try {
            diary.unlockDiary(password);
            System.out.println("Diary.Diary unlocked successfully");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void viewEntries() {
        if (!ValidationForDiary())
            return;
        try {
            diary.viewAllEntries();
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void exitProgram() {
        System.out.println("Exiting...");
        input.close();
    }

    public static boolean checkDiaryExists() {
        if (diary == null) {
            System.out.println("No diary exists. Please create a diary first (option 1).");
            return false;
        }
        return true;
    }

    public static String promptUsername() {
        String username;
        do {
            System.out.print("Enter username: ");
            username = input.nextLine();
            if (username.trim().isEmpty()) {
                System.out.println("Username cannot be empty. Please try again.");
            }
        } while (username.trim().isEmpty());
        return username;
    }

    public static String promptPassword() {
        String password;
        do {
            System.out.print("Enter password: ");
            password = input.nextLine();
            if (password.trim().isEmpty()) {
                System.out.println("Password cannot be empty. Please try again.");
            }
        } while (password.trim().isEmpty());
        return password;
    }

    public static String promptEntryTitle() {
        String title;
        do {
            System.out.print("Enter entry title: ");
            title = input.nextLine();
            if (title.trim().isEmpty()) {
                System.out.println("Title cannot be empty. Please try again.");
            }
        } while (title.trim().isEmpty());
        return title;
    }


    private static String promptNewEntryTitle() {
        String title;
        do {
            System.out.print("Enter the new entry title: ");
            title = input.nextLine().trim();
            if (title.isEmpty()) {
                System.out.println("Title cannot be empty. Please try again.");
            }
        } while (title.isEmpty());
        return title;
    }

    private static String promptNewEntryBody() {
        String body;
        do {
            System.out.print("Enter the new entry body: ");
            body = input.nextLine().trim();
            if (body.isEmpty()) {
                System.out.println("Body cannot be empty. Please try again.");
            }
        } while (body.isEmpty());
        return body;
    }

    public static String promptEntryBody() {
        String body;
        do {
            System.out.print("Enter body: ");
            body = input.nextLine();
            if (body.trim().isEmpty()) {
                System.out.println("Body cannot be empty. Please try again.");
            }
        } while (body.trim().isEmpty());
        return body;
    }

    private static Integer promptEntryId() {
        while (true) {
            System.out.print("Enter the ID of the entry: ");
            String id = input.nextLine().trim();
            try {
                return Integer.parseInt(id);
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid ID format. Please try again.");
            }
        }
    }

    private static boolean ValidationForDiary() {
        if (diary == null) {
            System.out.println("No diary exists. Please create a diary first (option 1).");
            return false;
        }
        if (diary.isLocked()) {
            System.out.println("Diary.Diary is locked. Please unlock it first (option 6).");
            return false;
        }
        return true;
    }
}