/*
 * Fork-Join example, adapted from
 * http://www.oracle.com/technetwork/articles/java/fork-join-422606.html
 * 
 */
package executors.model;

import executors.utils.ComputedFileImpl;
import executors.utils.Pair;

import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class LinesCounter {

    private final ForkJoinPool forkJoinPool = new ForkJoinPool();

    public List<Pair<String, Integer>> countOccurrencesInParallel(Folder folder) {
        return forkJoinPool.invoke(new FolderSearchTask(folder));
    }

}
