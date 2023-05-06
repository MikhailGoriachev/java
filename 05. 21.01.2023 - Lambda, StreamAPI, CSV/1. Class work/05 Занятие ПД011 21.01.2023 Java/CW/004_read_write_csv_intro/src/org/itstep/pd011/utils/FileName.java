package org.itstep.pd011.utils;

import java.security.InvalidParameterException;

// вспомогательный класс для проверки того, что строка - правильное имя файла
public class FileName {
    private String fileName;

    public FileName(String fileName) {
      setFileName(fileName);
    } // FileName

    // геттер/сеттер для имени файла
    public String getFileName() { return fileName; }
    public void setFileName(String fileName) {
        if (!Utils.isValidFile(fileName))
            throw new InvalidParameterException(
                    String.format("\"%s\" не является корректным именем файла", fileName));
        this.fileName = fileName;
    } // setFileName

} // class FileName
