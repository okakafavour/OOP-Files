package Diary;

import java.util.Scanner;

public class SecondMain {
    private static Scanner input = new Scanner(System.in);
    private static Diaries diaries = new Diaries();
    private static Diary diary = null;

    public static void main(String[] args) {
        showMainMenu();
    }

    public static void showMainMenu() {
        while (true) {
            System.out.println("""
            \nDiary.Diary App Menu
            1. -> Create a Diary.Diary
            2. -> Login into diary
            3. -> Exit
            """);

            System.out.print("Choose an option from the menu: ");
            String choice = input.nextLine();

             if(choice.equals("1")) {createDiary();}
             else if(choice.equals("2")) {loginMenu();}
             else if(choice.equals("3")) {lockDiary();}
             else{System.out.println("Invalid option!");}
        }
    }

    public static void loginMenu() {
        while(true){
            System.out.println("""
              \n Login Menu
              1. -> Create entry 
              2. -> view entry
              3. -> update an entry
              4. -> Delete an entry
              5. -> Lock entry
              6. -> Unlock entry
              7. -> Back to Main menu      
                    """);

            System.out.print("Choose an option from the menu: ");
            String choice = input.nextLine();

            if(choice.equals("1")) {createEntry();}
            else if(choice.equals("2")) {viewEntries();}
            else if(choice.equals("3")) {updateEntry();}
            else if(choice.equals("4")) {deleteEntry();}
            else if(choice.equals("5")) {unlockDiary();}
            else if(choice.equals("6")){exitProgram();}
            else if(choice.equals("7")) {backToMainMenu();}
            else{System.out.println("Invalid option!");}

        }
    }
    public static void createDiary() {
        String username = promptUsername();
        String password = promptPassword();
        try {
            diaries.createDiary(username, password);
            diary = diaries.findDiary(username);
            System.out.println("Diary.Diary created successfully. ");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void createEntry() {
        String title = promptEntryTitle();
        String body = promptEntryBody();
        diary.createEntry(title, body);
        System.out.println("Estore.Entry added successfully");
    }

    public static void updateEntry() {
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
        try {diary.viewAllEntries();} catch (IllegalArgumentException | IllegalStateException e) {System.out.println("Error: " + e.getMessage());}
    }

    public static void backToMainMenu(){showMainMenu();}

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
        String username = "";
        do {System.out.print("Enter username: ");username = input.nextLine();
            if (username.trim().isEmpty()) {System.out.println("Username cannot be empty. Please try again.");}
        } while (username.trim().isEmpty());
        return username;
    }

    public static String promptPassword() {
        String password = "";
        do {System.out.print("Enter password: ");password = input.nextLine();
            if (password.trim().isEmpty()) {System.out.println("Password cannot be empty. Please try again.");}
        } while (password.trim().isEmpty());
        return password;
    }

    public static String promptEntryTitle() {
        String title;
        do {
            System.out.print("Enter entry title: ");
            title = input.nextLine();
            if (title.trim().isEmpty()) {System.out.println("Title cannot be empty. Please try again.");}
        } while (title.trim().isEmpty());
        return title;
    }


    public static String promptNewEntryTitle() {
        String title;
        do {System.out.print("Enter the new entry title: ");title = input.nextLine().trim();
            if (title.isEmpty()) {System.out.println("Title cannot be empty. Please try again.");}
        } while (title.isEmpty());
        return title;
    }

    public static String promptNewEntryBody() {
        while (true){
            try {
                System.out.print("Enter the new entry body: ");
                String body = input.nextLine().trim();
                if (body.isEmpty()) {System.out.println("Body cannot be empty. Please try again.");}
            } catch (IllegalArgumentException e) {System.out.println("Error: " + e.getMessage());}
        }
    }

    public static String promptEntryBody() {
        String body;
        do {System.out.print("Enter entry body: ");body = input.nextLine().trim();
            if (body.isEmpty()) {System.out.println("Body cannot be empty. Please try again.");}
        } while (body.isEmpty());
        return body;
    }

    private static Integer promptEntryId() {
        while (true) {
            System.out.print("Enter the ID of the entry: ");
            String id = input.nextLine().trim();
            try {return Integer.parseInt(id);} catch (NumberFormatException e) {System.out.println("Error: Invalid ID format. Please try again.");}
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