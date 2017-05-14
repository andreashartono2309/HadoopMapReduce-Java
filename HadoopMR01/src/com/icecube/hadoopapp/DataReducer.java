package com.icecube.hadoopapp;
import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class DataReducer extends
		Reducer<Text, LongWritable, Text, LongWritable> {
	private LongWritable result = new LongWritable();

	@Override
	public void reduce(Text key, Iterable<LongWritable> values, Context context)
			throws IOException, InterruptedException {

		/*
		 * TODO implement
		 */
		long sum = 0;
		for (LongWritable val : values) {
			sum += val.get();
		}
		result.set(sum);
		context.write(key, result);
	}
}