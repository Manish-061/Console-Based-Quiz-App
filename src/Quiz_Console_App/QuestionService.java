package Quiz_Console_App;

import java.util.Scanner;

public class QuestionService {
    Question[] questions = new Question[5];
    String[] selection = new String[5];

    public QuestionService() {
        questions[0] = new Question(1, "What is Java?", "Language", "Car", "Bike", "Programming Language", "Programming Language");
        questions[1] = new Question(2, "Which of these is a Java keyword?", "public", "hello", "void", "while", "while");
        questions[2] = new Question(3, "What does JVM stand for?", "Java Variable Manager", "Java Virtual Machine", "Java Verification Module", "Java Visual Machine", "Java Virtual Machine");
        questions[3] = new Question(4, "Which company developed Java?", "Microsoft", "Apple", "Sun Microsystems", "Oracle", "Sun Microsystems");
        questions[4] = new Question(5, "What is the default value of a boolean in Java?", "false", "true", "0", "null", "false");

    }

    public void displayQuestions(){
        int i = 0;

        Scanner sc = new Scanner(System.in);

        for(Question que : questions){
            System.out.println("Question No.: " + que.getId() + " " + que.getQuestion());
            System.out.println("Options : " +  "(a) " + que.getOpt1() + " (b) " + que.getOpt2() + " (c) " + que.getOpt3() + " (d) " + que.getOpt4());

            System.out.print("Enter Your Answer: ");
            selection[i] = sc.nextLine();
            i++;
        }

        System.out.println("\n Your Answers are: ");
        for(String s : selection){
            System.out.println(s);
        }
    }
    public void calculateScore() {
        int score = 0;

        for (int i = 0; i < questions.length; i++) {
            Question que = questions[i];
            String correctAnswer = que.getAnswer();
            String userAnswer = selection[i];
            i++;

            if (correctAnswer.equalsIgnoreCase(userAnswer)) {
                score++;
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect!");
                System.out.println("Correct answer: " + correctAnswer);
            }
        }

        System.out.println("\nFinal Score: " + score + " out of " + questions.length);
        double percentage = (score * 100.0) / questions.length;
        System.out.printf("Accuracy: %.2f%%\n", percentage);
    }
}
