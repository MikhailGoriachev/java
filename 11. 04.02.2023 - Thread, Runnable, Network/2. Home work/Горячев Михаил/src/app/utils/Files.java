package app.utils;

import java.io.*;

// вспомогательные методы для работы с файлами
public class Files {

    // запись строки str в бинарный файл raf, длина буфера записи lenBuffer
    public static void writeString(DataOutput raf, String str, int lenBuffer) throws IOException {
        byte[] buffer = new byte[lenBuffer];
        byte[] strBytes = str.getBytes();

        System.arraycopy(strBytes, 0, buffer, 0, strBytes.length);

        raf.write(buffer);
    } // writeString

    // чтение строки из бинарного файла raf, длина буфера записи lenBuffer
    public static String readString(DataInput raf, int lenBuffer) throws IOException {
        byte[] buffer = new byte[lenBuffer];

        raf.readFully(buffer);
        String str = new String(buffer);


        return str.substring(0, str.indexOf(0));
    }
}
