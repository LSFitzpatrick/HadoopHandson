
import java.util.StringTokenizer;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;

public class CovidMapper extends Mapper<LongWritable, Text, Text, IntWritable> {


    IntWritable new_cases = new IntWritable();
    IntWritable new_deaths = new IntWritable();
    


    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException{
        //converts the mapper input to the string line
        String[] col = value.toString().split(",");
        int total = 0;

        String continent = col[0];
        String location = col[1];

        int new_cases = Integer.parseInt(col[3]);
        int new_deaths = Integer.parseInt(col[4]);
        
        total = total +(new_cases + new_deaths);
     
        int isGeographicRegion = 0; //this will tell if the data set is a geographical region and not a country

        if (col[0].equals(" ")){
            isGeographicRegion = 1;
        }

        if(isGeographicRegion != 1 && total != 0){
            context.write(new Text(location), new IntWritable(total));
        }
        

    }
}