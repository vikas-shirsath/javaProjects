public class Main{
    public static void main(String[] args) {
     
        QuestionService service = new QuestionService();
        System.out.println("---* Welcome to Quize..! *---");
        System.out.println("Choose correct answer.(a/b/c/d)");
        service.playQuize();
        service.printScore();
        System.out.println("---End---");
    }
} 