package lb.pro3ect.lb5.ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class ConsoleController implements UIController {

    @Override
    public void setFileToRead(String filePath) {

        if (files.contains(filePath))
            return;

        try {
            files.push(filePath);
            scanners.push(scanner);
            scanner = new Scanner(new File(filePath));
            fileMode = true;
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());

            scanner = scanners.pop();
            files.pop();
            fileMode = scanners.size() > 0;
        }

    }

    @Override
    public boolean isFileMode() {
        return fileMode;
    }

    public void validateFilesReading() {

        scanner = scanners.pop();
        if (files.size() > 0)
            files.pop();

        fileMode = scanners.size() > 0;

    }

    @Override
    public void show(String message) {
        System.out.println(message);
    }

    @Override
    public void show(String message, boolean showInFileMode) {
        if(showInFileMode || !fileMode)
            show(message);
    }

    @Override
    public String readString(String message) {

        if (!fileMode)
            System.out.print(message);

        if (scanner.hasNextLine()) {
            String res = scanner.nextLine().trim();
            return res.isEmpty() ? null : res;
        }

        if (fileMode)
            validateFilesReading();
        else
            skipWrongInput();

        return readString(message);
    }

    @Override
    public double readDouble(String message) {

        if (!fileMode)
            System.out.print(message);

        if (scanner.hasNextDouble()) {
            double res = scanner.nextDouble();
            scanner.nextLine();
            return res;
        }

        if (fileMode)
            validateFilesReading();
        else
            skipWrongInput();

        return readDouble(message);

    }

    @Override
    public int readInteger(String message) {

        if (!fileMode)
            System.out.print(message);

        if (scanner.hasNextInt()) {
            int res = scanner.nextInt();
            scanner.nextLine();
            return res;
        }

        if (fileMode)
            validateFilesReading();
        else
            skipWrongInput();

        return readInteger(message);

    }

    @Override
    public long readLong(String message) {

        if (!fileMode)
            System.out.print(message);

        if (scanner.hasNextLong()) {
            long res = scanner.nextLong();
            scanner.nextLine();
            return res;
        }

        if (fileMode)
            validateFilesReading();
        else
            skipWrongInput();

        return readLong(message);

    }

    @Override
    public float readFloat(String message) {

        if (!fileMode)
            System.out.print(message);

        if (scanner.hasNextFloat()) {
            float res = scanner.nextFloat();
            scanner.nextLine();
            return res;
        }

        if (fileMode)
            validateFilesReading();
        else
            skipWrongInput();

        return readFloat(message);

    }

    private void skipWrongInput() {
        scanner.next();
    }

    private Scanner scanner = new Scanner(System.in);

    private Stack<Scanner> scanners = new Stack<Scanner>();
    private Stack<String> files = new Stack<String>();
    private boolean fileMode = false;

}
