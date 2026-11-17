package com.datajpa.learning.fundamentals.interfaces;

// Console simulation: មិនផ្ញើ Email ពិត។
public class EmailNotification implements NotificationService {
    @Override
    public void send(String recipient, String message) {
        System.out.println("[EMAIL DEMO] To: " + recipient + " | " + message);
    }
}
