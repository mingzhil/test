package com.lzm.demo.controller;

import com.lzm.demo.entity.User;
import com.lzm.demo.mapper.UserMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author lizhiming
 * @data 2020/7/31 11:22
 */
@Api
@RestController
@Slf4j
@RequestMapping("/userss")
public class RoleController {

    @Autowired
    private UserMapper userMapper;

    @ApiOperation(value = "根据id获取用户信息")
    @GetMapping("/{id}")
    public User get(@PathVariable Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @ApiOperation(value = "创建用户")
    @PostMapping
    public int create(@RequestBody User user) {
        return userMapper.insert(user);
    }
    @ApiOperation(value = "修改用户")
    @PutMapping
    public int update(@RequestBody User user) {
        return userMapper.updateByPrimaryKey(user);
    }
    @ApiOperation(value = "删除用户")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        userMapper.deleteByPrimaryKey(id);
    }


    public static void main(String[] args) {
        int[] arr = {1,52,23,44,15};
        int[] ints = bubbleSort(arr);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
        String  a = "abc";
        String b = new String("abc");
        String c = "ab" + "c";
        System.out.println(a==b);
        System.out.println(a==c);
        System.out.println(a==a.intern());
        biSearch(arr,3);
    }


    public static int[] bubbleSort(int[] array) {
                if (array.length == 0)
                     return array;
               for (int i = 0; i < array.length; i++)
                       for (int j = 0; j < array.length - 1 - i; j++)
                        if (array[j + 1] < array[j]) {
                               int temp = array[j + 1];
                      array[j + 1] = array[j];
                     array[j] = temp;
                    }
       return array;
    }



    public static int biSearch(int []array,int a){
        int lo=0;
        int hi=array.length-1;
        int mid;
        while(lo<=hi){
            mid=(lo+hi)/2;
            if(array[mid]==a){
                return mid+1;
            }else if(array[mid]<a){
                lo=mid+1;
            }else{
                hi=mid-1;
            }
        }
        return -1;
    }

    // 循环实现二分查找
    private static boolean binarySearch(int data, int[] arr) {
        int minIndex = 0;
        int maxIndex = arr.length - 1;
        int midIndex;

        while (minIndex <= maxIndex) {
            midIndex = (minIndex & maxIndex) + ((minIndex ^ maxIndex) >> 1);
            if (data > arr[midIndex]) {
                minIndex = midIndex + 1;
            } else if (data < arr[midIndex]) {
                maxIndex = midIndex - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
