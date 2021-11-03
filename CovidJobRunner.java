public class CovidJobRunner{
    public int (String[] args) throws Exception {
        Job job = new Job();
        String userJarLocation = ""; //enter the location of the jar files here from eclipse
        job.setJobName("Covid over a million");
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        job.setMapperClass(CovidMapper.class);
        job.setReducerClass(CovidReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(intWritable.class)
        boolean success = job.waitForCompletion(true);
        return success ? 0 : 1
    }

    public static void main(String[] args) throws Exception{
        CovidJobRunner driver = new CovidJobRunner();
        driver.run(args);
    }
}