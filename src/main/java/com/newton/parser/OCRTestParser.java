package com.newton.parser;

import net.sourceforge.tess4j.ITessAPI;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;

public class OCRTestParser {
  public static void main(String[] args) {
    System.out.println("Parsed data : \n" + parseText());
  }

  public static String parseText() {
    File image = new File("src/main/resources/sampleinput/sample.PNG");
    Tesseract tesseract = new Tesseract();
    tesseract.setDatapath("src/main/resources/traindata");
    tesseract.setLanguage("eng");
    tesseract.setPageSegMode(1);
    tesseract.setOcrEngineMode(ITessAPI.TessOcrEngineMode.OEM_DEFAULT);
    try {
      return tesseract.doOCR(image);
    } catch (TesseractException e) {
      e.printStackTrace();
    }
    return null;
  }
}
