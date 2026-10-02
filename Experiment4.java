import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class Question {
    protected String questionText;
    protected String correctAnswer;
    protected String studentAnswer;
    protected double points;

    public Question(String questionText, String correctAnswer, String studentAnswer, double points) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public abstract String getType();
    public abstract double evaluate();
}

class MCQQuestion extends Question {
    public MCQQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public String getType() {
        return "MCQ";
    }

    @Override
    public double evaluate() {
        return correctAnswer.equalsIgnoreCase(studentAnswer) ? points : 0.0;
    }
}

class TFQuestion extends Question {
    public TFQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public String getType() {
        return "TF";
    }

    @Override
    public double evaluate() {
        return correctAnswer.equalsIgnoreCase(studentAnswer) ? points : 0.0;
    }
}

class EssayQuestion extends Question {
    public EssayQuestion(String questionText, String correctAnswer, String studentAnswer, double points) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    public String getType() {
        return "ESSAY";
    }

    @Override
    public double evaluate() {
        String[] keywords = correctAnswer.split(",");
        int matchedCount = 0;
        String lowerStudentAns = studentAnswer.toLowerCase();

        for (String kw : keywords) {
            String trimmedKw = kw.trim().toLowerCase();
            if (!trimmedKw.isEmpty() && lowerStudentAns.contains(trimmedKw)) {
                matchedCount++;
            }
        }

        if (matchedCount >= 2) {
            return points * 0.75;
        } else if (matchedCount == 1) {
            return points * 0.50;
        } else {
            return 0.0;
        }
    }
}

public class Experiment4 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String firstLine = reader.readLine();
        if (firstLine == null || firstLine.trim().isEmpty()) return;

        int n = Integer.parseInt(firstLine.trim());
        List<Question> questions = new ArrayList<>();

        // Regex parsing 4 double-quoted strings followed by an integer points value
        Pattern pattern = Pattern.compile("^(\\S+)\\s+\"(.*)\"\\s+\"(.*)\"\\s+\"(.*)\"\\s+(\\d+)$");

        for (int i = 0; i < n; i++) {
            String line = reader.readLine();
            if (line == null) break;

            Matcher matcher = pattern.matcher(line.trim());
            if (matcher.matches()) {
                String type = matcher.group(1);
                String qText = matcher.group(2);
                String cAns = matcher.group(3);
                String sAns = matcher.group(4);
                double pts = Double.parseDouble(matcher.group(5));

                switch (type) {
                    case "MCQ":
                        questions.add(new MCQQuestion(qText, cAns, sAns, pts));
                        break;
                    case "TF":
                        questions.add(new TFQuestion(qText, cAns, sAns, pts));
                        break;
                    case "ESSAY":
                        questions.add(new EssayQuestion(qText, cAns, sAns, pts));
                        break;
                }
            }
        }

        double totalScore = 0.0;
        for (Question q : questions) {
            double score = q.evaluate();
            totalScore += score;
            System.out.printf("%s: %.2f\n", q.getType(), score);
        }
        System.out.printf("Total Score: %.2f\n", totalScore);
    }
}