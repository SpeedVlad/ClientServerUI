package com.example.demo6;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HelloController {
    public TextField textFieldMessage;
    public TextField textFieldHost;
    public TextField textFieldPort;
    public TextField textFieldName;
    public ListView<String> listMessages;
    public Label status;
    public Boolean sendMessageFlag = false;

    public void buttonSend(ActionEvent actionEvent) {
        sendMessageFlag = true;
    }

    public void buttonConnect(ActionEvent actionEvent) throws IOException {
        new Client();
    }

    class Client {
        PrintWriter out;
        BufferedReader in;
        Socket socket;

        String fromServer = "";
        Client() throws IOException {
            int port = 0;
            try {
                port = Integer.parseInt(textFieldPort.getText());
            } catch (NumberFormatException e) {
                status.setText("Incorrect port");
            }
            try {
                socket = new Socket(textFieldHost.getText(), port);
                out = new PrintWriter(socket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out.println(textFieldName.getText() + " -> joined the chat");
            } catch (IOException e) {
                status.setText("Incorrect host or port");
            }

            runSendMessage();
            runReadMessage();
        }
        void sendMessage() throws IOException {
            String outStr;
            while (!(outStr = textFieldMessage.getText()).equalsIgnoreCase("exit!")) {
                if (sendMessageFlag && !textFieldMessage.getText().isEmpty()) {
                    final String messageToSend = outStr; //
                    Platform.runLater(() -> {//
                        out.println(messageToSend);//
                        textFieldMessage.setText("");//
                    });//
                }
                sendMessageFlag = false;

                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
            out.println(outStr);
            out.close();
            socket.close();
        }
        void runSendMessage() {
            new Thread(() -> {
                try {
                    sendMessage();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        void readMessage() throws IOException {
            while (!(fromServer = in.readLine()).equals("kick")) {
                final String message = fromServer; //
                Platform.runLater(() -> listMessages.getItems().add(message));//
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
            Platform.runLater(() -> listMessages.getItems().add("You have been kicked"));//
            in.close();
        }

        void runReadMessage() {
            new Thread(() -> {
                try {
                    readMessage();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}