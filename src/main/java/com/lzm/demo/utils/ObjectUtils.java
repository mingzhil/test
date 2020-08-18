package com.lzm.demo.utils;

/**
 * @author lizhiming
 * @data 2020/7/21 10:12
 */

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/**
 * @描述：对象判断空工具类
 * @author MaoWei
 * @Date 2019-05-30
 */
public class ObjectUtils {

    /**
     * @描述：判断对象不为（null或toString后：空字符串、'null'）
     * @param o
     * @return
     */
    public static boolean isNotEmpty(Object obj) {
        return obj != null && !"".equals(obj) && !"null".equals(obj);
    }

    /**
     * @描述：判断对象为（null或toString后：空字符串、'null'）
     * @param o
     * @return
     */
    public static boolean isEmpty(Object obj) {
        return !isNotEmpty(obj);
    }

    /**
     * @描述：判断字符串不为（null或空字符串）
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * @描述：判断字符串为（null或空字符串）
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    /**
     * @描述：判断集合不为（null或空集合）
     * @param collection
     * @return
     */
    public static <T> boolean isNotEmpty(Collection<T> collection) {
        if (collection != null) {
            Iterator<T> iterator = collection.iterator();
            if (iterator != null) {
                while (iterator.hasNext()) {
                    Object next = iterator.next();
                    if (next != null) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * @描述：判断集合为（null或空集合）
     * @param collection
     * @return
     */
    public static <T> boolean isEmpty(Collection<T> collection) {
        return !isNotEmpty(collection);
    }

    /**
     * @描述：判断map集合不为（null或空map）
     *  @param map
     * @return
     */
    public static <T> boolean isNotEmpty(Map<T, T> map) {
        return map != null && !map.isEmpty();
    }

    /**
     * @描述：判断map集合不为（null或空map）
     * @param map
     * @return
     */
    public static <T> boolean isEmpty(Map<T, T> map) {
        return !isNotEmpty(map);
    }

    /**
     * @描述：判断数组不为（null或长度为0的数组）
     * @param array
     * @return
     */
    public static boolean isNotEmpty(Object[] array) {
        return array != null && array.length > 0;
    }

    /**
     * @描述：判断数组为（null或长度为0的数组）
     * @param t
     * @return
     */
    public static boolean isEmpty(Object[] array) {
        return !isNotEmpty(array);
    }
}
