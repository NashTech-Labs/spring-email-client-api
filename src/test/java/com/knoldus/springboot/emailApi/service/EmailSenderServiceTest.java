package com.knoldus.springboot.emailApi.service;

import javax.mail.MessagingException;
import org.junit.Ignore;
import org.junit.Test;

public class EmailSenderServiceTest {
    /**
     * Method under test: {@link EmailSenderService#sendSimpleEmail(String, String, String)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testSendSimpleEmail() {
        // TODO: Complete this test.

        (new EmailSenderService()).sendSimpleEmail("shashikanttanti0213@gmail.com", "Hello Java Studio",
                "Not all who wander are lost");
    }

    /**
     * Method under test: {@link EmailSenderService#sendEmailWithAttachment(String, String, String, String)}
     */
    @Test
    @Ignore("TODO: Complete this test")
    public void testSendEmailWithAttachment() throws MessagingException {

        (new EmailSenderService()).sendEmailWithAttachment("shashikanttanti0213@gmail.com", "Not all who wander are lost",
                "Hello from Knoldus", "Attachment");
    }
}

