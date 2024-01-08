import java.io.*;
import java.net.*;
public class CalculatorServer {
 public static void main(String[] args) {
 try {
 ServerSocket serverSocket = new ServerSocket(5555);
 System.out.println("Server is waiting for client connection...");
 Socket clientSocket = serverSocket.accept();
 System.out.println("Client connected.");
 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
 while (true) {
 String input = in.readLine();
 if (input.equals("exit")) {
 System.out.println("Server exiting.");
 break;
 }
 String result = calculate(input);
 out.println(result);
 }
 serverSocket.close();
 } catch (IOException e) {
 e.printStackTrace();
 }
 }
 private static String calculate(String input) {
 try {
 String[] parts = input.split(" ");
 double operand1 = Double.parseDouble(parts[0]);
 double operand2 = Double.parseDouble(parts[2]);
 String operator = parts[1];

 double result = switch (operator) {
 case "+" -> operand1 + operand2;
 case "-" -> operand1 - operand2;
 case "*" -> operand1 * operand2;
 case "/" -> operand1 / operand2;
 default -> throw new IllegalArgumentException("Invalid operator: " + operator);
 };
 return Double.toString(result);
 } catch (Exception e) {
 return "Error: " + e.getMessage();
 }
 }
}