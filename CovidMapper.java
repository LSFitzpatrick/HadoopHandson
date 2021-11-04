
import java.util.StringTokenizer;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;

public class CovidMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

    Text continent = new Text();
    Text location = new Text();
    IntWritable new_cases = new IntWritable();
    IntWritable new_deaths = new IntWritable();
    Text cases_deaths = new Text();
    


    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException{
        //converts the mapper input to the string line
        String[] col = value.toString().split(",");
        int total = 0;

        String continent = col[0];
        String location = col[1];

        new_cases = Integer.parseInt(col[3]);
        new_deaths = Integer.parseInt(col[4]);
        
        cases_deaths = String.valueOf(new_cases) + " , " + String.valueOf(new_deaths);
     
        int isGeographicRegion = 0; //this will tell if the data set is a geographical region and not a country

        if (col[0].equals(" ")){
            isGeographicRegion = 1;
        }

        if(isGeographicRegion != 1){
            context.write(new Text(location), new Text(cases_deaths));
        }
       
    }
}