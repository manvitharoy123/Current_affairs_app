package data.example.edunachal;

public class QuizModel {
    String Explanation;
    int correct;
    String option1;
    String option2;
    String option3;
    String option4;
    String question;

    public QuizModel(String question2, String option12, String option22, String option32, String option42, String explanation, int correct2) {
        this.question = question2;
        this.option1 = option12;
        this.option2 = option22;
        this.option3 = option32;
        this.option4 = option42;
        this.Explanation = explanation;
        this.correct = correct2;
    }

    public QuizModel() {
    }

    public String getQuestion() {
        return this.question;
    }

    public void setQuestion(String question2) {
        this.question = question2;
    }

    public String getOption1() {
        return this.option1;
    }

    public void setOption1(String option12) {
        this.option1 = option12;
    }

    public String getOption2() {
        return this.option2;
    }

    public void setOption2(String option22) {
        this.option2 = option22;
    }

    public String getOption3() {
        return this.option3;
    }

    public void setOption3(String option32) {
        this.option3 = option32;
    }

    public String getOption4() {
        return this.option4;
    }

    public void setOption4(String option42) {
        this.option4 = option42;
    }

    public String getExplanation() {
        return this.Explanation;
    }

    public void setExplanation(String explanation) {
        this.Explanation = explanation;
    }

    public int getCorrect() {
        return this.correct;
    }

    public void setCorrect(int correct2) {
        this.correct = correct2;
    }
}