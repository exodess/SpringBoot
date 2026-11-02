import java.util.List;

public class Question {
    public Question(String question, List<String> answers, int correct_answer) {
        _question = question;
        _answers = answers;
        _correct_answer = correct_answer;
    }

    final protected int _correct_answer;
    public int getCorrectAnswer() { return _correct_answer; }

    final protected String _question;
    public String getQuestion() { return _question; }

    final protected List<String> _answers;
    public List<String> getAnswers() { return _answers; }
}