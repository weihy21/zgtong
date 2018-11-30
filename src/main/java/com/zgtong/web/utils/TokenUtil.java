package com.zgtong.web.utils;

import java.util.UUID;

/**
 *
 */
public class TokenUtil {


    /**
     * example:2156a633-4062-445d-a0bc-e67771c8dc9a
     *
     * @return
     */
    public static String uuid(){
        return UUID.randomUUID().toString();
    }


}
