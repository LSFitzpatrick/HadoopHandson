import java.io.IOException;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Reducer;

public class CovidReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
    @Override
    public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException{
        
        int total_cases_deaths = 0;

        for (IntWritable value : values){
            total_cases_deaths = total_cases_deaths + value.get();
        }

        context.write(key, new IntWritable(total_cases_deaths));



        
    }
}
