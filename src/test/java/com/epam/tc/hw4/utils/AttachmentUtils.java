package com.epam.tc.hw4.utils;

import io.qameta.allure.Attachment;

public class AttachmentUtils {

    @Attachment(type = "image/png", value = "Attachment {attachmentName}")
    public static byte[] makeImageAttachment(String attachmentName, byte[] source) {
        return source;
    }
}
