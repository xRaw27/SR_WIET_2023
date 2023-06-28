package zookeeper;

import org.apache.zookeeper.KeeperException;

import java.util.Scanner;
import java.io.IOException;

public class Main {

    private static final String ROOT_NODE = "/z";
    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            System.out.println("Wrong args length!");
            return;
        }

        String appName = args[0];
        String connectString = args[1];

        Watcher watcher = new Watcher(ROOT_NODE, appName, connectString);
        userInputLoop(watcher);
    }

    private static void userInputLoop(Watcher watcher) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String line = scanner.nextLine();

            if (line.equals("tree")) {
                watcher.printTree();
            } else if (line.equals("quit")) {
                watcher.stopProcess();
                break;
            } else {
                System.out.println("Unknown command");
            }
        }
    }

}
