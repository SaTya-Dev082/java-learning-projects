package com.datajpa.learning.fundamentals.interfaces;

public class InterfaceDemo {
    public static void main(String[] args) {
        // new NotificationService() មិនបាន: Interface មិនមែនជា Concrete Class។
        NotificationService email = new EmailNotification();
        NotificationService sms = new SmsNotification();

        System.out.println("=== Same contract, different implementations ===");
        email.send("student@example.com", "Welcome to the Java lesson.");
        sms.send("DEMO_PHONE", "Welcome to the Java lesson.");

        System.out.println("\n=== Order confirmation via Email ===");
        OrderConfirmationService emailOrders = new OrderConfirmationService(email);
        emailOrders.sendConfirmation("ORD-001", "student@example.com");

        System.out.println("\n=== Same order service, SMS implementation ===");
        OrderConfirmationService smsOrders = new OrderConfirmationService(sms);
        smsOrders.sendConfirmation("ORD-002", "DEMO_PHONE");
        // OrderConfirmationService មិនត្រូវការកែ code ដើម្បីប្ដូរ channel។
    }
}
