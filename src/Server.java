import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Server {
    static private ServerSocket serverSocket;
    static private Socket socket;
    static private ObjectOutputStream outputStream;
    static private ObjectInputStream inputStream;

    static private  JTextArea jTextAreaJPanel2;

    Server() {
        JFrame jFrame = new JFrame("Ñåðâåð");
//        JPanel jPanel = new JPanel();
        jFrame.setLayout(new GridLayout(1, 1));
        jFrame.setSize(500, 500);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.setLocationRelativeTo(null);

        jTextAreaJPanel2 = new JTextArea();
        JScrollPane scroller2 = new JScrollPane(jTextAreaJPanel2);
        jTextAreaJPanel2.setLineWrap(true);
        scroller2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jTextAreaJPanel2.setEditable(false);

//        jPanel.add(scroller2);
        jFrame.add(scroller2);
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.run();
    }

    public void run() {
        try {
            serverSocket = new ServerSocket(5678, 10);
//            while (true) {
            socket = serverSocket.accept();
            var in = new Scanner(socket.getInputStream());
            System.out.println(in.nextLine());
/*                outputStream = new ObjectOutputStream(socket.getOutputStream());
                inputStream = new ObjectInputStream(socket.getInputStream());
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.replace(0, stringBuffer.length(), (String) inputStream.readObject());
//                jTextAreaJPanel2.append("Âû ïðèñëàëè: " + stringBuffer + "\n");
                System.out.println("Âû ïðèñëàëè: " + stringBuffer.substring(0) + "\n");
//                outputStream.writeObject("Âû ïðèñëàëè: " + inputStream.readObject());*/

//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}