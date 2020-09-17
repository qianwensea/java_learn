package com.shi.java;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author 千文sea
 * @create 2020-04-07 17:29
 */
public class FileUtilsTest {
    public static void main(String[] args) {
        File srcFile = new File("day10\\tupian.jpg");
        File destFile = new File("day10\\tupian3.jpg");
        try {
            FileUtils.copyFile(srcFile,destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
