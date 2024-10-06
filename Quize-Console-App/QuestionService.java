
import java.util.Scanner;

public class QuestionService {
    String selection[] = new String[5];
    Question[] questions = new Question[5];

    public QuestionService() {
        questions[0] = new Question(1, "Which was the first purely OOP language developed?", "a. Java", "b. Cpp", "c. SmallTalk","d. Kotlin", "c");
        questions[1] = new Question(2, "When OOP concept did first came into picture?", "a. 1980's", "b. 1995", "c. 1970's","d. 1993", "c");
        questions[2] = new Question(3, "Which feature of OOP indicates code reusability?", "a. Abstraction", "b. Polymorphism", "c. Encapsulation","d. Inheritance", "d");
        questions[3] = new Question(4, "Why Java is Partially OOP language?", "a. It allows code to be written outside classes", "b. It supports usual declaration of primitive data types", "c. It does not support pointers","d. It doesn’t support all types of inheritance", "b");
        questions[4] = new Question(5, "In multilevel inheritance, which is the most significant feature of OOP used?", "a. Code efficiency", "b. Code readability", "c. Flexibility","d. Code reusability", "d");
    }

    public void playQuize(){
        int i = 0;
        for(Question q : questions) {
            System.out.println("Question no. : " + q.getId());
            System.out.println(q.getQuestion());
            System.out.println(q.getOpt1());
            System.out.println(q.getOpt2());
            System.out.println(q.getOpt3());
            System.out.println(q.getOpt4());
            System.out.println("Your Answer : - ");
            Scanner sc = new Scanner(System.in);
            selection[i++] = sc.nextLine();
        }

        for(String s : selection ) {
            System.out.println(s);
        }
    }

    public void printScore() {
        int score = 0;

        for(int i = 0; i<questions.length; i++) {
            Question que = questions[i];
            String actualAnswer = que.getAnswer();
            String userAnswer = selection[i];

            if(actualAnswer.equals(userAnswer)) {
                score++;
            }
        }
        System.out.println("Your Score is : " + score);
    }

}
