package executors;



import executors.controller.Controller;
import executors.controller.ControllerImpl;
import executors.model.Model;
import executors.model.ModelImpl;
import executors.view.ConsoleView;
import executors.view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final int NUMBER_OF_WORKERS = Runtime.getRuntime().availableProcessors();
    static Controller controller;
    public static void main(String[] args) throws IOException, InterruptedException {
        final Model model = new ModelImpl();
        final View view = new ConsoleView();
        controller = new ControllerImpl(model, view);

        setupConsole();
    }

    private static void setupConsole() throws IOException, InterruptedException {

        /*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Inserisci il path: ");
        String path = bufferedReader.readLine();
        System.out.println("Inserisci il numero di file da visualizzare nella classifica: ");
        int limit = Integer.parseInt(bufferedReader.readLine());
        System.out.println("Inserisci il numero max di linee: ");
        int maxL = Integer.parseInt(bufferedReader.readLine());
        System.out.println("Inserisci il numero di intervalli: ");
        int numIntervals = Integer.parseInt(bufferedReader.readLine());
        */
        controller.start("C:\\Users\\pietr\\Desktop\\ex", 10, 10, 10);
    }
}