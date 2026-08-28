# 💬 ClientServerUI - Chat Application

A **Java Desktop Chat Application** with a graphical user interface built using **JavaFX**. This project demonstrates network programming, multi-threading, and professional GUI design. Perfect for learning how client-server communication works!

---

## 📋 About This Project

ClientServerUI is a Java desktop application that demonstrates:
- **Network Programming** - Socket communication between client and server
- **Multi-Threading** - Handling concurrent connections
- **GUI Development** - JavaFX user interface
- **Event-Driven Programming** - Responding to user actions
- **Stream I/O** - Reading and writing data over networks

A fully functional chat application where multiple users can connect to a server and exchange messages in real-time!

---

## ✨ Key Features

### 💻 **Client-Server Architecture**
- Connect to a remote chat server
- Real-time message exchange
- Multiple users can chat simultaneously
- Graceful disconnect handling

### 🎨 **Professional GUI**
- Clean, intuitive interface built with JavaFX
- Message history displayed in a ListView
- Input fields for host, port, nickname, and messages
- Status indicator for connection state
- Send button for message submission

### 🔌 **Network Features**
- TCP socket communication
- Automatic connection management
- Server host and port configuration
- Message broadcasting to all connected clients

### 👤 **User Management**
- Custom nickname entry
- User join/leave notifications
- Message sender identification

### 📊 **Real-Time Messaging**
- Live message display
- Message history in scrollable list
- Input field auto-clearing after send
- Connection status feedback

---

## 🛠️ Technologies Used

| Technology | Purpose |
|-----------|---------|
| **Java 19** | Core programming language |
| **JavaFX 19** | GUI framework |
| **Socket API** | Network communication |
| **Threading** | Concurrent message handling |
| **Maven** | Project build and dependency management |

---

## 📂 Project Structure

```
ClientServerUI/
├── src/main/java/com/example/demo6/
│   ├── HelloApplication.java    # Main JavaFX application
│   ├── HelloController.java     # Controller with chat logic
│   └── module-info.java         # Module configuration
├── src/main/resources/
│   ├── com/example/demo6/
│   │   └── hello-view.fxml      # JavaFX layout file
│   └── icon.png                 # Application icon
├── pom.xml                      # Maven configuration
└── README.md                    # This file
```

---

## 🚀 How to Use

### Installation

1. **Install Java 19 or Higher**
   - Download from [oracle.com](https://www.oracle.com/java/technologies/downloads/)

2. **Install Maven** (if not already installed)
   - Download from [maven.apache.org](https://maven.apache.org/download.cgi)

3. **Clone the Repository**
   ```bash
   git clone https://github.com/SpeedVlad/ClientServerUI.git
   cd ClientServerUI
   ```

4. **Build the Project**
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

---

## 📖 How to Use the Chat

### Step-by-Step Guide

1. **Enter Server Details**
   - **Host**: IP address or hostname of the server (e.g., "localhost")
   - **Port**: Port number the server is listening on (e.g., "5000")
   - **Nickname**: Your display name in the chat

2. **Connect to Server**
   - Click **"Connect"** button
   - Wait for connection confirmation
   - Check status label for connection state

3. **Send Messages**
   - Type your message in the text field at the bottom
   - Click **"Send"** button or press Enter
   - Message appears in the chat history

4. **Receive Messages**
   - Messages from other users appear automatically
   - Scroll up to see message history
   - See who sent each message

5. **Disconnect**
   - Type "exit!" and send to disconnect
   - Or close the application window

---

## 💡 Learning Outcomes

This project demonstrates:

✅ **Network Programming**
- Creating TCP sockets
- Sending and receiving data over network
- Client-server model
- Connection management

✅ **Multi-Threading**
- Thread creation and management
- Concurrent message handling
- Avoiding UI blocking with threads
- Thread synchronization

✅ **GUI Programming with JavaFX**
- FXML layout files
- Controller classes
- Event handling
- Dynamic UI updates

✅ **Java Programming Concepts**
- Classes and objects
- Exception handling (try-catch)
- Input/Output streams
- BufferedReader and PrintWriter

✅ **Software Architecture**
- Separation of concerns
- Model-View-Controller pattern
- Client-server architecture

---

## 🎯 Code Breakdown

### Main Components

**`HelloApplication.java`** - Application Entry Point
```java
- Extends Application (JavaFX)
- Loads FXML layout file
- Sets up the main window
- Loads application icon
```

**`HelloController.java`** - Main Logic
```java
- Handles GUI events
- Manages client connection
- Inner Client class handles networking
- Separate threads for sending/receiving
```

**`hello-view.fxml`** - Layout Definition
```java
- Defines all GUI components
- TextFields for connection settings
- ListView for message history
- Buttons for actions
- Labels for status display
```

---

## 🔧 How the Chat Works

### Connection Flow

1. User enters server details (host, port, nickname)
2. Clicks "Connect" button
3. Application creates a Socket connection
4. Sends nickname to server
5. Server broadcasts "username joined the chat"
6. Starts listening for incoming messages

### Message Flow

1. User types message in TextField
2. Clicks "Send" button
3. Message sent to server via PrintWriter
4. Server broadcasts to all connected clients
5. Message appears in all clients' message lists

### Disconnection Flow

1. User sends "exit!" message
2. Client connection closes
3. Server notifies other users
4. Application window can be closed

---

## 🐛 Troubleshooting

### "Connection refused" Error
- Make sure server is running
- Check host and port are correct
- Server may be on different computer

### "Incorrect host or port" Message
- Verify hostname/IP address
- Verify port number is correct
- Check network connectivity

### Messages not sending
- Check that you're connected
- Verify message field is not empty
- Check status label for connection state

### Build errors with Maven
```bash
# Update Maven
mvn --version

# Clean build
mvn clean install

# Run with debug
mvn javafx:run -e
```

---

## 🎓 Perfect For Sixth Form Application

This project demonstrates:
- **Network Understanding** - How internet communication works
- **Java Skills** - OOP and advanced programming
- **GUI Design** - Professional user interfaces
- **Problem-Solving** - Building complex applications
- **Software Architecture** - Organizing large projects

When presenting, explain:
- How client-server model works
- Why multi-threading is necessary
- How sockets enable network communication
- How the GUI responds to events

---

## 💡 Enhancement Ideas

Ways to improve this project:

1. **File Sharing**
   - Send files through the chat
   - Automatic file download

2. **User Authentication**
   - Login with username/password
   - Encrypted connections (SSL/TLS)

3. **Message Features**
   - Timestamps for messages
   - Private messages between users
   - Message history storage

4. **Server Improvements**
   - Web-based server management
   - User ban/kick functionality
   - Message filtering

5. **Advanced UI**
   - User list display
   - Emoji support
   - Message styling

---

## 📝 Configuration

### Server Setup

To use this client, you need a chat server running. The server should:
- Listen on specified port
- Accept client connections
- Broadcast messages to all clients
- Handle user join/leave events

### Connection Settings

Default recommended settings:
- **Host**: `localhost` (for local testing)
- **Port**: `5000` or `8080`
- **Nickname**: Your chosen name

---

**Created by:** SpeedVlad  
**Type:** Desktop Application / Learning Project  
**Difficulty:** Intermediate to Advanced  
**Technologies:** Java, JavaFX, Maven, Sockets  
**Time to Build:** Excellent for learning network programming
