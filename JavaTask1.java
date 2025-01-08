import java.io.*; 
import java.util.Scanner; 

class FileHandlingDemo {

    public static void writeFile(String fileName, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false))) {
            writer.write(content);
            System.out.println("Data written to file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    public static void readFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("Contents of the file:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }

    public static void modifyFile(String fileName, String oldContent, String newContent) {
        File file = new File(fileName);
        StringBuilder fileContent = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
            
                fileContent.append(line.replace(oldContent, newContent)).append(System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
            return;
        }

        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, false))) {
            writer.write(fileContent.toString().trim());
            System.out.println("File modified successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}

public class JavaTask1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fileName = "example.txt";

        System.out.println("Choose an operation:");
        System.out.println("1. Write to file");
        System.out.println("2. Read from file");
        System.out.println("3. Modify file");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter content to write to the file: ");
                String writeContent = scanner.nextLine();
                FileHandlingDemo.writeFile(fileName, writeContent);
                break;
            case 2:
                FileHandlingDemo.readFile(fileName);
                break;
            case 3:
                System.out.print("Enter the content to replace: ");
                String oldContent = scanner.nextLine();
                System.out.print("Enter the new content: ");
                String newContent = scanner.nextLine();
                FileHandlingDemo.modifyFile(fileName, oldContent, newContent);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }

        scanner.close();
    }
}
