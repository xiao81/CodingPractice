package Assignments;

import java.util.*;

class Assignment3 {
    //Q1
    TreeNode prevNode1;
    TreeNode dummyHead;
    public void flatten(TreeNode root) {
        dummyHead = new TreeNode(0);
        prevNode1 = dummyHead;
        flattenHelper(root);
        root = dummyHead.right;
        printList(root, true);
        printList(prevNode1, false);
    }

    private void flattenHelper(TreeNode root) {
        if (root == null) return;
        flattenHelper(root.left);
        prevNode1.right = root;
        root.left= prevNode1;
        prevNode1 = prevNode1.right;
        flattenHelper(root.right);
    }
    void printList(TreeNode root, boolean dir) {
        TreeNode currNode = root;
        while (currNode != null) {
            System.out.print(currNode.val + " ");
            if (dir){
                currNode = currNode.right;
            } else {
                currNode = currNode.left;
            }
        }
        System.out.println();
    }

    //Q2
    public void convertBT(TreeNode root) {
        convertBTHelper(root);
    }

    private int convertBTHelper(TreeNode root) {
        if (root == null) return 0;
        int originalValue = root.val;
        root.val = convertBTHelper(root.left) + convertBTHelper(root.right);
        return originalValue + root.val;
    }

    //Q3
    int sum;
    public TreeNode convertBST(TreeNode root) {
        sum = 0;
        convertBSTHelper(root);
        return root;
    }

    private void convertBSTHelper(TreeNode root) {
        if (root == null) return;
        convertBSTHelper(root.right);
        sum += root.val;
        root.val = sum;
        convertBSTHelper(root.left);
    }

    //Q4

    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> rightView = new LinkedList<>();
        List<Integer> leftView = new LinkedList<>();
        List<Integer> topView = new LinkedList<>();
        TreeNode currNode;
        if (root == null) return rightView;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                currNode = queue.poll();
                if (size - 1 == 0) {
                    topView.add(currNode.val);
                }
                if (i == size - 1) {
                    rightView.add(currNode.val);
                    topView.add(size - 1, currNode.val);
                }
                if (i == 0) {
                    leftView.add(currNode.val);
                    topView.add(0, currNode.val);
                }
                if (currNode.left != null) queue.offer(currNode.left);
                if (currNode.right != null) queue.offer(currNode.right);
            }
        }
        System.out.println(leftView.toString());
        System.out.println(rightView.toString());
        System.out.println(topView.toString());
        return rightView;
    }

    //Q5
    private List<String> kPaths;
    private int k;
    public List<String> binaryTreeKNodesPaths(TreeNode root) {
        kPaths = new LinkedList<>();
        k = 0;
        if (root == null) {
            return kPaths;
        }
        binaryTreeKNodesPathsHelper(root, "", k);
        return kPaths;
    }

    private void binaryTreeKNodesPathsHelper(TreeNode root, String path, int length) {
        path += root.val + "->";
        length += 1;
        if (length == k) {
            paths.add(path.substring(0,path.length()-2));
        }
        if (root.left != null) {
            binaryTreeKNodesPathsHelper(root.left, path, length);
        }
        if (root.right != null) {
            binaryTreeKNodesPathsHelper(root.right, path, length);
        }

    }
    //Q6

    private List<String> paths;
    public List<String> binaryTreePaths(TreeNode root) {
        paths = new LinkedList<>();
        if (root == null) {
            return paths;
        }
        binaryTreePathsHelper(root, "");
        return paths;
    }

    private void binaryTreePathsHelper(TreeNode root, String path) {
        path +=root.val+"->";
        if (root.left == null && root.right == null) {
            paths.add(path.substring(0,path.length()-2));
        }
        if (root.left != null) {
            binaryTreePathsHelper(root.left, path);
        }
        if (root.right != null) {
            binaryTreePathsHelper(root.right, path);
        }

    }
    //Q7
    ArrayList<Integer> result;
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        result = new ArrayList<>();
        searchRangeHelper(root,k1,k2);
        return result;
    }

    public void searchRangeHelper(TreeNode root, int k1, int k2) {
        if (root == null) return;
        searchRangeHelper(root.left,k1,k2);
        if (root.val >= k1 && root.val <= k2) result.add(root.val);
        searchRangeHelper(root.right,k1,k2);
    }

    //Q8
    List<TreeNode> mistakenNodeList;
    TreeNode firstNode;
    TreeNode secondNode;
    TreeNode prevNode;
    public void recoverTree(TreeNode root) {
        mistakenNodeList = new LinkedList<>();
        prevNode = new TreeNode(Integer.MIN_VALUE);
        recoverTreeHelper(root);
        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;

    }
    private void recoverTreeHelper(TreeNode root) {
        if (root == null) return;
        recoverTreeHelper(root.left);
        if (firstNode == null && prevNode.val >= root.val) {
            firstNode = prevNode;
        }
        if (firstNode != null && prevNode.val >= root.val) {
            secondNode = root;
        }
        prevNode = root;
        recoverTreeHelper(root.right);
    }

}

//OO design
//Q1.	Design	a	parking	lot.
abstract class ParkingLot {
    private ArrayList<ParkingFloor> floors;
    private int parkingLotID;
    private int capacity;
    private int availableParkingSpaces;

    public abstract boolean park(Car car, int floorNumber, int parkingSpaceNumber);
    public abstract Car getCarInfo(String scanedResult);
    //getters ans setters

    private class Car {
        private String make;
        private String color;
        private String plate;
        private boolean handicap;
        //getters and setters
    }

    private abstract class ParkingSpace {
        private Car car;
        private int locationId;
        private boolean available;
        private boolean handicap;

        public abstract boolean park(Car car);
        //getters ans setters
    }

    private abstract class ParkingFloor {
        private ArrayList<ParkingSpace> parkingSpaceList;
        private ArrayList<ParkingSpace> parkingSpacesHandicapList;
        private int capacity;
        private int availableSpaceCount;
        private int floorNumber;
        private boolean available;

        public abstract ArrayList<ParkingSpace> availableParkingSpaces();
        public abstract ArrayList<ParkingSpace> availableParkingSpacesHandicap();
        public abstract int availableParkingSpacesCount();
        public abstract int availableParkingSpacesHandicapCount();
        //getters ans setters
    }
}
//Q2.	Design	a	snake	ladder	game.

abstract class SnakeAndLadder {
    private ArrayList<Player> playerList;
    private Space[][] board;
    private int[] startLocation;
    private int[] homeLocation;
    public enum Type{SNAKE, LADDER};

    public abstract void createBoard(int row, int coloum);
    public abstract void addItem(Type type, int[] startLocation);
    public abstract void restartGame();
    public abstract boolean nextRound();
    public abstract int[] nextLocation();

    private abstract class Item {
        private int[] startLocation;
        private int[] endLocation;
        private Type type;
        //getters ans setters
    }

    private abstract class Space {
        private Item item;
        private int number;
        private int[] location;
    }

    private abstract class Player {
        private String name;
        private int playerId;
        private int[] playerLocation;
        private boolean win;

        public abstract boolean move();
    }
}
//Q3.	Design	a	chess	game.

abstract class ChessGame {
    public enum Type{KING, QUEEN, ROOK, BISHOP, KNIGHT, PAWN};
    private Player player1;
    private Player player2;
    private Space[][] board;

    public abstract void createBoard(int row, int coloum);
    public abstract void addItem(Type type, int[] location);
    public abstract void restartGame();
    public abstract boolean nextRound();
    public abstract int[] nextLocation();

    private abstract class Piece {
        private Type type;
        private int id;
        private boolean side; //true: black, false: white
        private int[] location;
    }

    private abstract class Space {
        private Piece piece;
        private int[] location;
    }

    private abstract class Player {
        private ArrayList<Piece> pieceList;
        private String name;
        private int playerId;
        private boolean side;
        private boolean win;

        public abstract boolean move(Piece piece, int[] location);
    }

}
//Q4.	Design	a	music	juke	box.

abstract class MusicJukeBox {
    private ArrayList<Page> musicPageList;
    private Page currPage;
    private boolean status; //playing music or reading for next song
    private int price;
    private int inputAmount;

    public abstract boolean takeCoin(); // return true when inputAmount == price
    public abstract boolean selectMusic(String id);
    public abstract boolean nextPage();

    private class Music {
        private String id;
        private String musicInfo;
        private int duration;
    }

    private class Page {
        private int id;
        private ArrayList<Music> musicList;
    }
}
//Q5.	Design	tic	tac	toe	game.
abstract class TicTacToe {
    private int[][] board;
    private Player player1;
    private Player player2;
    private int size;
    public abstract boolean nextRound();
    public abstract boolean validateGame();

    private abstract class Player {
        private int id;
        private String name;
        private boolean side;
        public abstract boolean move(int[] location);
    }
}

//Q6.	Design	an	in-memory	cache
abstract class Cache {
    Hashtable<MatchInfo, Data> indexTable;

    public abstract int getData(String address);
    protected abstract int retreiveFromRAM(MatchInfo info);
    protected abstract Data retreiveFromTable(MatchInfo info);
    protected abstract void updateTable();

    private abstract class MatchInfo {
        private int index;
        private int tag;
    }
    private abstract class Data {
        private int value;
        private boolean existInTable;
    }
}

//Multithreading
//Q1
class OddEvenPrinter {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread t1 = new Thread(new OddEvenPrinterThread(true, 10, printer));
        Thread t2 = new Thread(new OddEvenPrinterThread(false, 10, printer));
        t1.start();
        t2.start();
    }
}

class OddEvenPrinterThread implements Runnable {
    Printer printer;
    boolean isOdd;
    int size;
    OddEvenPrinterThread(boolean isOdd, int size, Printer printer) {
        this.isOdd = isOdd;
        this.size = size;
        this.printer = printer;
    }
    @Override
    public void run() {
        if (isOdd) {
            for (int i = 1; i <= size; i += 2) {
                try {
                    printer.printOdd(i);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        } else {
            for (int i = 2; i <= size; i += 2) {
                try {
                    printer.printEven(i);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}

class Printer {
    boolean isEven = true;
    void printOdd(int num) throws InterruptedException{
        synchronized (this) {
            while (!isEven) wait();
            System.out.println("Odd: " + num);
            isEven = false;
            notify();
        }
    }
    void printEven(int num) throws InterruptedException{
        synchronized (this) {
            while (isEven) wait();
            System.out.println("Even: " + num);
            isEven = true;
            notify();
        }
    }
}

//Q2
class ProducerCosumerProbelm {
    public static void main(String[] args) throws InterruptedException{
        PC pc = new PC(5);
        Thread t1 = new Thread(new ProducerCosumerThread(true, pc));
        Thread t2 = new Thread(new ProducerCosumerThread(false, pc));
        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}

class ProducerCosumerThread implements Runnable {
    boolean isProducer;
    PC pc;
    ProducerCosumerThread(boolean isProducer, PC pc) {
        this.isProducer = isProducer;
        this.pc = pc;
    }

    @Override
    public void run() {
        if (isProducer) {
            try {
                pc.produce(10);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        } else {
            try {
                pc.consume();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

}
class PC {
    Queue<Integer> buffer;
    Integer capacity;

    PC(int capacity) {
        buffer = new LinkedList<>();
        this.capacity = capacity;
    }

    void produce(int num) throws InterruptedException{
        int value = 0;
        while (true) {
            synchronized (this) {
                while (capacity == buffer.size()) wait();
                System.out.println("Produce: " + value);
                buffer.offer(value++);
                notify();
                Thread.sleep(1000);
            }
        }
    }

    void consume() throws InterruptedException{
        while (true) {
            synchronized (this) {
                while (buffer.size() == 0) wait();
                int value = buffer.poll();
                System.out.println("Comsume: " + value);
                notify();
                Thread.sleep(1000);
            }
        }

    }

}