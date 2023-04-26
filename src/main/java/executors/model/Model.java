package executors.model;

import executors.utils.ComputedFileImpl;
import executors.utils.Pair;

import java.util.List;

public interface Model {
    ComputedFileImpl getResult();
    void setup(int limit, int maxL, int numIntervals);

    void addResults(List<Pair<String, Integer>> results);
}
