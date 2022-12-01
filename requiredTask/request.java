package requiredTask;

import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class request {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = isReaderFileLineArray("requiredTask\\task01.txt");
        ArrayList<String[]> listPrepared = requestSQL(list);
        ArrayList<StringBuilder> result = resultRequestSQL(listPrepared);
        System.out.println(result);
    }

    static ArrayList<String> isReaderFileLineArray(String direction) throws IOException {
        File file = new File(direction);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        ArrayList<String> lineArray = new ArrayList<>();
        while ((line = in.readLine()) != null) {
            System.out.println(line);
            line = line.replace("{", "");
            line = line.replace("}", "");
            line = line.replace(":", " = ");
            lineArray.add(line);
        }
        in.close();
        // System.out.println(lineArray);
        return lineArray;
    }

    static ArrayList<String[]> requestSQL(ArrayList<String> listUser) {
        ArrayList<String[]> listUserArr = new ArrayList<>();
        for (String item : listUser) {
            String[] args = item.split(",");
            listUserArr.add(args);
            // System.out.println(Arrays.toString(args));
        }
        return listUserArr;
    }

    static ArrayList<StringBuilder> resultRequestSQL(ArrayList<String[]> list) {
        ArrayList<StringBuilder> result = new ArrayList<StringBuilder>();
        for (String[] item : list) {
            StringBuilder request = new StringBuilder ("select * from students where ");
            for (int i = 0; i < item.length; i++) {
                if (!item[i].contains("null")) {
                    if (i > 0) {
                        request.append(" and ");
                    }
                    request.append(item[i]);
                }
            }
            result.add(request);
        }
        // System.out.println(result);
        return result;
    }
}
