public class Counter {
    protected int count;
    protected int minimumCount;
    protected int maximumCount;
    private static final int DEFAULT_MINIMUM = 0;
    private static final int DEFAULT_MAXIMUM = 999;

    public Counter() {
        minimumCount = DEFAULT_MINIMUM;
        maximumCount = DEFAULT_MAXIMUM;
        count = minimumCount;
    }

    public Counter(int minCount, int maxCount) {
        minimumCount = minCount;
        maximumCount = maxCount;
        count = minimumCount;
    }

    public int maximumCount() {

        return maximumCount;
    }

    public int minimumCount() {

        return minimumCount;
    }

    public int count() {

        return count;
    }

    public boolean isAtMinimum() {

        return (count == minimumCount);
    }

    public boolean isAtMaximum() {

        return (count == maximumCount);
    }

    public void reset() {

        count = minimumCount;
    }

    public void incrementCount() {

        count++;
    }
}
