package com.zgtong.web.utils;

import java.util.List;
import java.util.Objects;

/**
 *
 */
public class ValidationUtil {
    /**
     * 以下情况方法返回true：
     * 1，数组有对象等于null；
     * 2，数组中有对象是Byte、Integer、Short、Long、Float、Double等数据类型的默认数据值；
     * 3，字符串的length==0.
     *
     * @param arr
     * @return
     */
    public static boolean containsNullOrEmpty(Object... arr) {
        if (arr == null)
            return false;

        for (Object temp : arr) {
            if (temp == null) {
                return true;
            }
            if (((temp instanceof Byte) && Objects.equals((byte) 0, temp))
                    || ((temp instanceof Integer) && Objects.equals(0, temp))
                    || ((temp instanceof Short) && Objects.equals((short) 0, temp))
                    || ((temp instanceof Long) && Objects.equals(0l, temp))
                    || ((temp instanceof Float) && Objects.equals(0.0f, temp))
                    || ((temp instanceof Double) && Objects.equals(0.0d, temp))) {
                return true;
            }
            if ((temp instanceof String) && String.valueOf(temp).trim().length() == 0) {
                return true;
            }
        }
        return false;
    }

    public static int computeNotNullNum(Object... arr) {
        int result = 0;
        if (arr == null) {
            return result;
        }
        for (Object obj : arr) {
            if (obj != null) {
                result++;
            }
        }
        return result;
    }

    public static boolean isNullOrEmpty(Object[] arr) {
        if (arr == null || arr.length == 0) {
            return true;
        }
        return false;
    }

    public static boolean isNullOrEmpty(List list) {
        if (list == null || list.size() == 0) {
            return true;
        }
        return false;
    }

}
