package com.datajpa.learning.fundamentals.interfaces;

// Console simulation: មិនផ្ញើ SMS ពិត។
public class SmsNotification implements NotificationService {
    @Override
    public void send(String recipient, String message) {
        System.out.println("[SMS DEMO] To: " + recipient + " | " + message);
    }
}
