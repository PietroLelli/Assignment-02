package executors.model;

import executors.controller.Controller;
import executors.utils.ComputedFileImpl;
import executors.utils.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class FolderSearchTask extends RecursiveTask<List<Pair<String, Integer>>> {
    private final Folder folder;

    public FolderSearchTask(Folder folder) {
        super();
        this.folder = folder;
    }
    
    @Override
    protected List<Pair<String, Integer>> compute() {
        List<RecursiveTask<Pair<String, Integer>>> DocumentsForks = new LinkedList<>();
        List<RecursiveTask<List<Pair<String, Integer>>>> SubfolderForks = new LinkedList<>();

        List<Pair<String, Integer>> results = new ArrayList<>();

        for (Folder subFolder : folder.getSubFolders()) {
            FolderSearchTask task = new FolderSearchTask(subFolder);
            SubfolderForks.add(task);
            task.fork();
        }
        
        for (Document document : folder.getDocuments()) {
            DocumentSearchTask task = new DocumentSearchTask(document);
            DocumentsForks.add(task);
            task.fork();
        }

        for (RecursiveTask<Pair<String, Integer>> task : DocumentsForks) {
            Pair<String, Integer> pair = task.join();
            results.add(pair);
        }

        return results;
    }
}
    