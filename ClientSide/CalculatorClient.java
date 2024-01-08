import java.io.*;
import java.net.*;
public class CalculatorClient {
 public static void main(String[] args) {
 try {
 Socket socket = new Socket("10.140.3.33", 5555);
 BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
 System.out.println("Enter expressions (e.g., 2 + 3) or type 'exit' to quit:");
 while (true) {
 String expression = userInput.readLine();
 out.println(expression);
 if (expression.equals("exit"))
 break;
 String result = in.readLine();
 System.out.println("Result: " + result); }
 socket.close();
 } catch (IOException e) {
 e.printStackTrace();
 }
 }
}