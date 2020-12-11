package example.java;

import java.util.ArrayList;
import java.util.List;

import example.scala.javainterop.package$;
import example.scala.javainterop.MessagesEx;

public class JavaClass {
    final String message;
    List<String> messages = new ArrayList<>();

    public JavaClass(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public List<String> getMessages() {
        return this.messages;
    }

    public boolean appendMessages(List<String> messages) {
        return this.messages.addAll(messages);
    }

    public boolean addMessagesFromScalaClass() {
        ArrayList<String> javaListMessages = new ArrayList<>();
        javaListMessages.add("this item is from java list");

        MessagesEx ex1 = MessagesEx.fromJava(javaListMessages);
        this.appendMessages(MessagesEx.toJavaList(ex1.messages()));

        // OR in case of package object
        return this.appendMessages(package$.MODULE$.toJavaList(ex1.messages()));
    }
}
