class Experiment2 {
    private final boolean[] results;
    private int count;

    public Experiment2(int totalQuestions) {
        this.results = new boolean[totalQuestions];
        this.count = 0;
    }

    public boolean recordAnswer(boolean isCorrect) {
        if (this.count < this.results.length) {
            this.results[this.count] = isCorrect;
            this.count++;
            return true;
        }
        return false;
    }

    public int getScore() {
        int correctCount = 0;
        for (int i = 0; i < this.count; i++) {
            if (this.results[i]) {
                correctCount++;
            }
        }
        return correctCount;
    }

    public static void main(String[] args) {
        Experiment2 sc = new Experiment2(4);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("Score: " + sc.getScore());
    }
}