import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

class DuplicateRemover
{

    ArrayList<String> uniqueWords = new ArrayList();

    public void remove(String dataFile) throws IOException
    {
        BufferedReader buffReader = new BufferedReader(new FileReader(dataFile));
        String line = buffReader.readLine();
        while (line!=null)
        {
            String tempVal[] = line.split(" ");
            for (int i = 0; i<tempVal.length; i++)
            {
                if (!uniqueWords.contains(tempVal[i]))
                {
                    uniqueWords.add(tempVal[i]);
                }
            }
            line = buffReader.readLine();
        }
        buffReader.close();
    }

    public void write(String outputFile) throws FileNotFoundException
    {
        PrintWriter printtWriter = new PrintWriter(outputFile);
        for (String i : uniqueWords)
        {
            printtWriter.println(i);
        }
        printtWriter.close();
    }
}
