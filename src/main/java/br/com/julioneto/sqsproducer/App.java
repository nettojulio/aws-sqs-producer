package br.com.julioneto.sqsproducer;

import br.com.julioneto.sqsproducer.services.AwsSqsService;

import java.time.LocalDateTime;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Integer options;
        String from;
        String to;
        String message;
        String sendMessage;

        do {
            System.out.println("### CHOOSE AN OPTION ###\n\n1 - Send Message\n0 - Exit\n");
            System.out.print("Option: ");

            options = keyboard.nextInt();

            switch (options) {
                case 1:
                    System.out.print("From: ");
                    keyboard.nextLine();
                    from = keyboard.nextLine();

                    System.out.print("To: ");
                    to = keyboard.nextLine();

                    System.out.print("Message: ");
                    message = keyboard.nextLine();

                    sendMessage = "\n{\n\"from\":" + "\"" + from + "\",\n"
                            + "\"to\":" + "\"" + to + "\",\n"
                            + "\"message\":" + "\"" + message + "\",\n"
                            + "\"time\":" + "\"" + LocalDateTime.now() + "\""
                            + "\n}";

                    System.out.println();
                    AwsSqsService.sendMessage(sendMessage);
                    break;
                case 0:
                    System.out.println("Good Bye!");
                    break;
                default:
                    System.err.println("\nInvalid option!\nTry Again...\n\n");
            }

        } while (options != 0);
    }
}

