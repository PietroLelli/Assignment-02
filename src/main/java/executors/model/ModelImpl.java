package executors.model;

import executors.utils.ComputedFileImpl;
import executors.utils.Pair;

import java.util.List;

import static java.util.Collections.reverseOrder;
import static java.util.Comparator.comparing;

public class ModelImpl implements Model{
    private ComputedFileImpl results;

    public void setup(int limit, int maxL, int numIntervals) {
        this.results = new ComputedFileImpl(limit, maxL, numIntervals);
    }

    @Override
    public void addResults(List<Pair<String, Integer>> results) {
        results.addAll(results);
    }

    @Override
    public ComputedFileImpl getResult() {
        return results;
    }

}
