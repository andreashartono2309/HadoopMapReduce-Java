# HadoopMapReduce-JavaApp

Example Hadoop MapReduce using Java, 
There are 3 important files : 
DataMapper.java, DataReduce.java and JobA.java

Import the project to Eclipse, and run the app by providing 2 args --> Input data and Output
e.g: /data/datainput.txt output

The following is the example of input data, data aggregation from web server log that show page available in the web app and total visit per day :<BR>

1st column  - pagename<BR>
2nd column  - date<BR>
3rd column  - pagevisit/day<BR>
4th column  - number of active web server running on that day<BR>
5th column  - number of inactive web server running on that day<BR><BR>

http://www.abcx.com/index.php	10/Oct/2000	5000	10	0<BR>
http://www.abcx.com/index.php	11/Oct/2000	5000	8	2<BR>
http://www.abcx.com/index.php	12/Oct/2000	5000	10	0<BR>
http://www.abcx.com/index.php	13/Oct/2000	5000	10	0<BR>
http://www.abcx.com/login.php	10/Oct/2000	10000	10	0<BR>
http://www.abcx.com/login.php	11/Oct/2000	10000	10	0<BR>
http://www.abcx.com/login.php	12/Oct/2000	10000	10	0<BR>
http://www.abcx.com/login.php	13/Oct/2000	10000	10	0<BR>
http://www.abcx.com/logout.php	10/Oct/2000	10000	10	0<BR>
http://www.abcx.com/logout.php	11/Oct/2000	10000	10	0<BR>
http://www.abcx.com/logout.php	12/Oct/2000	10000	10	0<BR>
http://www.abcx.com/logout.php	13/Oct/2000	10000	10	0<BR>
http://www.abcx.com/searching.php	10/Oct/2000	10000	10	0<BR>
http://www.abcx.com/searching.php	11/Oct/2000	10000	20	12<BR>
http://www.abcx.com/searching.php	12/Oct/2000	10000	10	0<BR>
http://www.abcx.com/searching.php	13/Oct/2000	10000	10	0<BR>

We will calculate total pageview for each page ( index.php, login.php and logout.php).

Save data as datainput.txt, upload it to HDFS using the following command :<BR>
$hadoop fs -mkdir datainput<BR>
$hadoop fs -put datainput.txt datainput<BR>

Generate jar file from the source code, and run it in Hadoop Cluster :<BR><BR>

$hadoop jar target/HadoopMR01.jar com.icecube.hadoopapp.JobA datainput/datainput.txt output<BR><BR>

After the job finish, we will see output folder, and open file part-r-0000<BR>

http://www.abcx.com/index.php	20000<BR>
http://www.abcx.com/login.php	40000<BR>
http://www.abcx.com/logout.php	40000<BR>
http://www.abcx.com/searching.php	40000<BR>
