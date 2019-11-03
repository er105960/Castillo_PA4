import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class DuplicateCounter
{
    Map<String, Integer> wordCounter = new HashMap<>();
    public void count(String dataFile) throws IOException
    {
        BufferedReader buffReader = new BufferedReader(new FileReader(dataFile));
        String line = buffReader.readLine();

        while(line!=null)
        {
            String temp[] = line.split(" ");
            for(int i = 0; i < temp.length; i++)
            {
                if (!wordCounter.containsKey(temp[i]))
                {
                    wordCounter.put(temp[i], 1);
                }
                else
                {
                    int count = wordCounter.get(temp[i]);
                    wordCounter.put(temp[i], count + 1);
                }
            }
            line = buffReader.readLine();
        }
        buffReader.close();
    }

    public void write(String outputFile) throws FileNotFoundException
    {
        PrintWriter printtWriter = new PrintWriter(outputFile);
        for (Map.Entry<String, Integer> entry : wordCounter.entrySet())
        {
            printtWriter.println(entry.getKey() + " -> " + entry.getValue());
        }
        printtWriter.close();
    }
}
