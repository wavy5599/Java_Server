import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

// Main class for the Java web server
public class server {
    public static void main(String[] args) throws IOException {
        // Create a server socket listening on port 8080
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("✅ Server started on http://localhost:8080");

        // Continuously accept incoming client connections
        while (true) {
            // Accept an incoming connection from a client
            Socket clientSocket = serverSocket.accept();

            // Create input reader to read request from client
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // Create output writer to send response to client
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream());

            // Read the first line of the client's request (e.g., "GET / HTTP/1.1")
            String requestLine = in.readLine();
            System.out.println("📥 Request: " + requestLine);

            // Send basic HTTP headers
            out.println("HTTP/1.1 200 OK");
            out.println("Content-Type: text/html; charset=UTF-8");
            out.println("");

            // Handle the /about page
            if (requestLine.contains("GET /about")) {
                out.println("<html><head><meta charset='UTF-8'><title>About</title>");
                out.println("<style>");
                out.println("body { background: #f4f4f4; color: #333; font-family: Arial, sans-serif; animation: fadeIn 1s ease-in; padding: 40px; }");
                out.println("@keyframes fadeIn { from { opacity: 0; } to { opacity: 1; } }");
                out.println("</style></head><body>");
                out.println("<h1>About Our Application</h1>");
                out.println("<p>This is a demonstration of a clean, professional Java-based server.</p>");
                out.println("<p><a href='/'>Back to Home</a></p>");
                out.println("</body></html>");

                // Handle the /contact page
            } else if (requestLine.contains("GET /contact")) {
                out.println("<html><head><meta charset='UTF-8'><title>Contact</title>");
                out.println("<style>");
                out.println("body { background-color: #fff; color: #222; font-family: 'Segoe UI', sans-serif; padding: 40px; }");
                out.println("form { max-width: 400px; margin: auto; display: flex; flex-direction: column; gap: 10px; }");
                out.println("input, textarea { padding: 10px; border: 1px solid #ccc; border-radius: 4px; }");
                out.println("button { background-color: #007BFF; color: white; padding: 10px; border: none; border-radius: 4px; cursor: pointer; }");
                out.println("button:hover { background-color: #0056b3; }");
                out.println("</style></head><body>");
                out.println("<h1>Contact Us</h1>");
                out.println("<form><input type='text' placeholder='Your Name'><input type='email' placeholder='Your Email'><textarea placeholder='Your Message'></textarea><button type='submit'>Send</button></form>");
                out.println("<p><a href='/'>Back to Home</a></p>");
                out.println("</body></html>");

                // Default homepage
            } else {
                out.println("<html><head><meta charset='UTF-8'><title>Home</title>");
                out.println("<style>");
                out.println("body { background: linear-gradient(to right, #ffffff, #e6e6e6); color: #000; font-family: 'Helvetica Neue', sans-serif; padding: 60px; text-align: center; }");
                out.println("nav a { color: #007BFF; margin: 0 15px; text-decoration: none; font-weight: bold; transition: color 0.3s; }");
                out.println("nav a:hover { color: #0056b3; }");
                out.println("</style></head><body>");
                out.println("<h1>Welcome to Our Java Server</h1>");
                out.println("<p>Explore the features of a clean and professional server implementation.</p>");
                out.println("<nav>");
                out.println("<a href='/about'>About</a> | ");
                out.println("<a href='/contact'>Contact</a>");
                out.println("</nav>");
                out.println("</body></html>");
            }

            // Send response and close connection
            out.flush();
            clientSocket.close();
        }
    }
}
