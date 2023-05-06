package org.itstep.pd011.utils;

import java.io.*;

// вспомогательные методы для работы с файлами
public class Files {

    // запись строки str в бинарный файл raf, длина буфера записи lenBuffer
    public static void writeString(DataOutput raf, String str, int lenBuffer) throws IOException {
        byte[] buffer = new byte[lenBuffer];           // создание буфера записи фиксированной длины
        byte[] strBytes = str.getBytes();              // создание байтового образа строки (!!! переменная длина !!!)

        System.arraycopy(strBytes, 0, buffer, 0, strBytes.length);

        raf.write(buffer);                           // собственно запись в файл
    } // writeString

    // чтение строки из бинарного файла raf, длина буфера записи lenBuffer
    public static String readString(DataInput raf, int lenBuffer) throws IOException {
        byte[] buffer = new byte[lenBuffer];   // буфер для чтения из файла

        raf.readFully(buffer);                 // чтение буфера из файла
        String str = new String(buffer);       // создали строку из буфера

        // забираем только значащие символы, до символа с кодом 0
        return str.substring(0, str.indexOf(0));
    } // readString
} // class Files
