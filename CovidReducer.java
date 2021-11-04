import java.io.IOException;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Reducer;

public class CovidReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
    @Override
    public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException{
        
        IntWritable total_cases = new IntWritable(0);
        IntWritable total_deaths = new IntWritable(0);

        for (IntWritable value : values){
            String[] token = values.toString().split(",");
            
        }

        context.write(key, new IntWritable(total_cases_deaths));



        
    }
}
