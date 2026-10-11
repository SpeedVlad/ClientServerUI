# ClientServerUI - JavaFX Chat Client

A Java desktop chat client with a graphical user interface built using JavaFX. This project demonstrates socket-based client communication, multi-threading, and GUI development in Java. It is designed to connect to an external TCP chat server and display incoming messages in a desktop interface.

> Note: This repository contains the client-side application only. It does not include a server implementation in the project itself.

---

## About This Project

ClientServerUI is a JavaFX application that demonstrates:
- JavaFX GUI development
- Socket communication with a remote server
- Multi-threading for background network operations
- Event-driven UI handling
- Stream I/O for sending and receiving data

This project provides a chat client interface for connecting to a compatible server and exchanging messages in real time.

---

## Key Features

### Client Connection
- Connect to a remote chat server using host and port
- Enter a nickname before joining the chat
- Handle connection errors gracefully
- Disconnect cleanly by closing the socket or sending an exit command

### Professional GUI
- Clean, intuitive interface built with JavaFX
- Message history displayed in a ListView
- Input fields for host, port, nickname, and messages
- Status indicator for connection state
- Send button for message submission

### Network Features
- TCP socket communication
- Client-side message sending and receiving
- Connection configuration through the UI
- Real-time display of incoming chat data

### User Experience
- Simple message input flow
- Auto-clear message field after send
- Status updates for connection events
- Chat history tracking in the UI

---

## Technologies Used

| Technology | Purpose |
|-----------|---------|
| Java 19 | Core programming language |
| JavaFX 19 | GUI framework |
| Socket API | Client-server communication |
| Threading | Background message handling |
| Maven | Project build and dependency management |

---

## Project Structure

```text
ClientServerUI/
├── src/main/java/com/example/demo6/
│   ├── HelloApplication.java    # JavaFX application entry point
│   ├── HelloController.java     # Chat client logic and socket handling
│   └── module-info.java         # Java module configuration
├── src/main/resources/
│   ├── com/example/demo6/
│   │   └── hello-view.fxml      # JavaFX layout file
│   └── icon.png                 # Application icon
├── pom.xml                      # Maven configuration
├── mvnw                         # Maven wrapper
├── mvnw.cmd                     # Maven wrapper for Windows
└── README.md                    # This file
```

---

## How to Use

### Installation

1. Install Java 19 or Higher
   - Download from [oracle.com](https://www.oracle.com/java/technologies/downloads/)

2. Install Maven (if not already installed)
   - Download from [maven.apache.org](https://maven.apache.org/download.cgi)

3. Clone the Repository
   ```bash
   git clone https://github.com/SpeedVlad/ClientServerUI.git
   cd ClientServerUI
   ```

4. Build the Project
   ```bash
   mvn clean package
   ```

### Running the Application

```bash
mvn javafx:run
```

Or run the JAR file after building:
```bash
java -jar target/demo6-1.0-SNAPSHOT.jar
```

### Required Server

This repository contains only the client. To use the application, you need a compatible chat server running elsewhere that accepts TCP socket connections and broadcasts messages to connected clients.

---

## How to Use the Chat

### Step-by-Step Guide

1. Start a compatible chat server on a host and port.
2. Enter the server details in the UI:
   - Host: IP address or hostname of the server (for example, `localhost`)
   - Port: Port number the server is listening on
   - Nickname: Your display name in the chat
3. Click the Connect button.
4. Wait for the connection to be established.
5. Type your message into the message field.
6. Click Send or press Enter.
7. Incoming messages from the server appear in the message list.
8. Use the exit command (`exit!`) or close the application to disconnect.

---

## Learning Outcomes

This project demonstrates:

### JavaFX Programming
- FXML layout files
- Controller classes
- Event handling
- Dynamic UI updates

### Network Programming
- Creating TCP socket connections
- Sending and receiving data over network streams
- Client-side communication with a server
- Connection management

### Multi-Threading
- Using background threads for network communication
- Preventing UI blocking while reading or sending data
- Working with asynchronous server responses

### Java Programming Concepts
- Classes and objects
- Exception handling
- Input/output streams
- BufferedReader and PrintWriter

---

## Code Breakdown

### Main Components

**HelloApplication.java** - Application entry point
```java
- Extends Application (JavaFX)
- Loads the FXML layout
- Sets up the main window
- Loads the application icon
```

**HelloController.java** - Main client logic
```java
- Handles GUI events
- Manages client connection
- Uses a dedicated client class for networking
- Starts separate threads for sending and receiving messages
```

**hello-view.fxml** - Layout definition
```java
- Defines the GUI components
- Contains fields for host, port, nickname, and message input
- Includes the message list and connection status display
- Provides buttons for connection and sending actions
```

---

## Client-Side Message Flow

### Connection Flow

1. User enters host, port, and nickname
2. Clicks Connect
3. Application creates a Socket connection
4. Sends the nickname to the server
5. Starts reading incoming messages from the server

### Message Flow

1. User types a message in the input field
2. Clicks Send or presses Enter
3. Message is sent via PrintWriter to the server
4. The server may broadcast it to other connected clients
5. Incoming messages are added to the JavaFX ListView

### Disconnection Flow

1. User sends `exit!` or closes the client
2. Socket is closed
3. Client disconnects from the server

---

## Troubleshooting

### Connection refused
- Make sure the server is running
- Check that the host and port are correct
- Verify the server is reachable from the machine running the client

### Incorrect host or port
- Verify hostname or IP address
- Confirm the port number matches the server configuration
- Check network connectivity

### Messages not sending
- Ensure you are connected to a server
- Check that the message field is not empty
- Confirm the server is still active and accepting connections

### Build errors with Maven
```bash
# Check Maven installation
mvn --version

# Clean build
mvn clean install

# Run with debug output
mvn javafx:run -e
```

---

## Enhancement Ideas

Possible improvements for this project:

1. File sharing
   - Send files through the chat
   - Add automatic download support

2. User authentication
   - Login with username and password
   - Add encrypted communication (SSL/TLS)

3. Message features
   - Add timestamps
   - Support private messages
   - Save chat history locally

4. UI improvements
   - Display connected users
   - Add emoji support
   - Improve styling and layout

5. Server integration
   - Add a matching Java server implementation
   - Support multi-user broadcasting and chat rooms

---

## Configuration

### Server Setup

To use this client, you need a server that:
- Listens on a known port
- Accepts client connections
- Receives and broadcasts messages
- Handles user join/leave events

### Connection Settings

Default recommended sample values:
- Host: `localhost` (for local testing)
- Port: `5000` or `8080`
- Nickname: your chosen display name

> This repository does not include the server implementation. The values above are examples for a compatible external server.

---

**Created by:** SpeedVlad  
**Type:** Desktop Client / Learning Project  
**Difficulty:** Intermediate  
**Technologies:** Java, JavaFX, Maven, Sockets  
**Time to Build:** Good for learning client-side networking and JavaFX UI development
