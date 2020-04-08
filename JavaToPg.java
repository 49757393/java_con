import java.util.*;
import com.mine.model.*;
import com.mine.db.*;
import com.mine.file.*;

public class JavaToPg{
    public static void main(String []args) {
        List<List<String>> data = ReadCsv.readCSV("/home/yangliang/data.csv",false);
        ConDb.insertDb(data);
        List<BrchQryDtl> brchs = ConDb.selectDb_1();
        for (BrchQryDtl brchqry : brchs)
        {
            System.out.println("tran_date======="+brchqry.getTranDate()) ;   
        }
    }
}