package br.com.mariojp.solid.dip;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmailNotifierTest {

    @Test
    void dry_run_should_not_touch_smtp() {
        
        MailSender fakeSender = new NoopMailSender();

        var notifier = new EmailNotifier(fakeSender);

        assertDoesNotThrow(() -> notifier.welcome(new User("Ana", "ana@example.com")),
                "Com a injeção de dependência, o SmtpClient real não deve ser invocado.");
    }
}