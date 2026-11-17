package com.datajpa.learning.fundamentals.interfaces;

// កិច្ចសន្យា: ផ្ញើសារទៅ recipient តាម channel របស់ implementation។
public interface NotificationService {
    // Interface method នេះជា public abstract ដោយស្វ័យប្រវត្តិ។
    void send(String recipient, String message);
}
