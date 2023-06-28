package zookeeper;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.List;

public class Watcher implements org.apache.zookeeper.Watcher {

    private static final int SESSION_TIMEOUT = 15000;

    private final String rootNode;
    private final String appName;

    private final ZooKeeper zk;

    private boolean isRunning = false;

    public Watcher(String rootNode, String appName, String connectString) throws IOException {
        this.rootNode = rootNode;
        this.appName = appName;
        this.zk = new ZooKeeper(connectString, SESSION_TIMEOUT, this);
    }


    @Override
    public void process(WatchedEvent event) {
        watchRecursive(rootNode);
        switch (event.getType()) {
            case NodeCreated:
                if (rootNode.equals(event.getPath()))
                    startProcess();
                break;
            case NodeDeleted:
                if (rootNode.equals(event.getPath()))
                    stopProcess();
                break;
            case NodeChildrenChanged:
                System.out.println(rootNode + " node children count: " + childrenCount(rootNode));
                break;
        }
    }

    private void watchRecursive(String node) {
        try {
            if (zk.exists(node, true) != null) {
                List<String> children = zk.getChildren(node, true);
                for (String child : children) {
                    watchRecursive(node + "/" + child);
                }
            }
        } catch (KeeperException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private int childrenCount(String node) {
        int count = 0;

        try {
            if (zk.exists(node, true) != null) {
                List<String> children = zk.getChildren(node, true);
                count += children.size();
                for (String child : children) {
                    count += childrenCount(node + "/" + child);
                }
            }
        } catch (KeeperException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return count;
    }

    public String printRecursive(String node, String pre) {
        StringBuilder result = new StringBuilder();

        try {
            if (zk.exists(node, true) != null) {
                List<String> children = zk.getChildren(node, true);
                int c = 0;
                for (String child : children) {
                    c++;
                    result.append(pre);
                    result.append(" |-- ");
                    result.append(child);
                    result.append("\n");
                    if (c == children.size()) {
                        result.append(printRecursive(node + "/" + child, pre + "    "));
                    } else {
                        result.append(printRecursive(node + "/" + child, pre + " |  "));
                    }
                }
            }
        } catch (KeeperException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return result.toString();
    }

    public void printTree() {
        try {
            if (zk.exists(rootNode, true) != null) {
                String res = printRecursive(rootNode, "");
                System.out.println(rootNode + "\n" + res);
            } else {
                System.out.println(rootNode + " doesn't exist\n");
            }
        } catch (KeeperException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void startProcess() {
        if (isRunning) return;

        System.out.println("Starting App: " + appName);
        String[] cmd = {"/usr/bin/open", "-a", appName};
        try {
            Runtime.getRuntime().exec(cmd);
            isRunning = true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void stopProcess() {
        if (!isRunning) return;

        System.out.println("Stopping App: " + appName);
        String[] cmd = {"pkill", appName};
        try {
            Runtime.getRuntime().exec(cmd);
            isRunning = false;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}