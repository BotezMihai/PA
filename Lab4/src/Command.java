import java.util.List;

public abstract class Command {
    static List<Object>
    public static void help() {
        System.out.println();
        System.out.println("--------------------");
        System.out.println("Commands to use:");
        System.out.println("1. add \"name\" \"smth about\" \"description\" \"image or pdf\" ");
        System.out.println("2. open \"name\"");
        System.out.println("3. exit");
        System.out.println("4. save \"path\"");
        System.out.println("4. load \"path\" or \"name\" ");
        System.out.println("---------------------");
        System.out.println();
    }

}
