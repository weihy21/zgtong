/*
 * Copyright (c) 2016 ngmm365.com All rights reserved.
 */

package com.zgtong.web.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 */
public class IOUtil {


    /**
     * 一次性读完输入流的字节
     *
     * @param inputStream
     * @return
     * @throws IOException
     */
    public static byte[] read(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return new byte[0];
        }
        int                   length = -1;
        byte[]                buf    = new byte[1024];
        ByteArrayOutputStream bos    = new ByteArrayOutputStream();
        while ((length = inputStream.read(buf)) > -1) {
            if (length == 0) continue;
            bos.write(buf, 0, length);
        }
        return bos.toByteArray();
    }


}
