package PdfMerge;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.pdmodel.PDDocument;


public class PDFMerge {
    public static void main(String[] args){
        PDDocument doc1 = null;
        PDDocument doc2 = null;
        try {
            String workpath = "F:/test/";
            //加载pdf文件
            File file1 = new File(workpath + "test1.pdf");
            doc1 = PDDocument.load(file1);

            File file2 = new File(workpath + "test2.pdf");
            doc2 = PDDocument.load(file2);

            //实例化PDF工具类
            PDFMergerUtility mergerUtil = new PDFMergerUtility();

            //设置合并后的文件
            mergerUtil.setDestinationFileName(workpath + System.currentTimeMillis() + ".pdf");

            //添加要合并的文件
            mergerUtil.addSource(file1);
            mergerUtil.addSource(file2);

            //合并
            mergerUtil.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());

        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                doc1.close();
                doc2.close();
            } catch (IOException ex){
                ex.printStackTrace();
            }
        }
    }
}
