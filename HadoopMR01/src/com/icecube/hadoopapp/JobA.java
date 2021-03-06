package com.icecube.hadoopapp;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.reduce.LongSumReducer;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class JobA extends Configured implements Tool {

	public static void main(String[] args) throws Exception {

		/*
		 * Validate that two arguments were passed from the command line.
		 */
		if (args.length != 2) {
			System.out.printf("Usage: StubDriver <input dir> <output dir>\n");
			System.exit(-1);
		}
		int rc = ToolRunner.run(new JobA(), args);
		System.exit(rc);

	}

	@Override
	public int run(String[] args) throws Exception {
		// TODO Auto-generated method stub
		/*
		 * Instantiate a Job object for your job's configuration.
		 */
		Job job = new Job();

		/*
		 * Specify the jar file that contains your driver, mapper, and reducer.
		 * Hadoop will transfer this jar file to nodes in your cluster running
		 * mapper and reducer tasks.
		 */
		job.setJarByClass(JobA.class);
		job.setMapperClass(DataMapper.class);
		job.setCombinerClass(DataReducer.class);
		job.setReducerClass(DataReducer.class);


		/*
		 * Specify an easily-decipherable name for the job. This job name will
		 * appear in reports and logs.
		 */
		job.setJobName("Job A");

		/*
		 * TODO implement
		 */
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));

	
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(LongWritable.class);

		/*
		 * Start the MapReduce job and wait for it to finish. If it finishes
		 * successfully, return 0. If not, return 1.
		 */
		boolean success = job.waitForCompletion(true);
		System.exit(success ? 0 : 1);
		return 0;
	}
}
