# A Hadoop Map-Reduce written in Scala!

This is an hadoop map-reduce implementation build in Scala. It uses [Scalding](https://github.com/twitter/scalding) for a typesafe interface for the hadoop library.

Usage:

Try a dryrun: 
```sh
sbt "run 44f10992fa2488aa9d681fbc454af109.csv output"
```

Execute the operation on a Hadoop cluster:
```sh
# Compile the project to a Jar
sbt assembly

# Execute jar on Hadoop cluster
hadoop jar target/scala-2.11/hadoop4s-assembly-1.0.jar 44f10992fa2488aa9d681fbc454af109.csv output
```

# Result

The current implementation will take a single grade csv file and groups it, and takes the average per date.

```csv
Mon Oct 28 00:00:00 PDT 2013	8.0
Fri Nov 01 00:00:00 PDT 2013	8.0
Fri Nov 08 00:00:00 PST 2013	6.833333333333333
Mon Jan 13 00:00:00 PST 2014	7.666666666666667
Mon Jan 27 00:00:00 PST 2014	7.0
Fri Jan 31 00:00:00 PST 2014	8.200000047683716
Mon Feb 03 00:00:00 PST 2014	7.0
Thu Feb 20 00:00:00 PST 2014	9.0
Mon Apr 07 00:00:00 PDT 2014	6.2571428162711005
Fri May 30 00:00:00 PDT 2014	7.900000095367432
Mon Jun 16 00:00:00 PDT 2014	7.0
Thu Jun 19 00:00:00 PDT 2014	7.099999904632568
Fri Jun 20 00:00:00 PDT 2014	7.150000015894572
Fri Jun 27 00:00:00 PDT 2014	6.0
Wed Nov 05 00:00:00 PST 2014	6.75
Fri Nov 07 00:00:00 PST 2014	6.350000023841858
Mon Jan 19 00:00:00 PST 2015	6.0
Mon Jan 26 00:00:00 PST 2015	5.699999809265137
Fri Jan 30 00:00:00 PST 2015	6.411111116409302
Mon Jul 06 00:00:00 PDT 2015	6.5
Mon Oct 26 00:00:00 PDT 2015	6.0
Tue Nov 03 00:00:00 PST 2015	10.0
Fri Nov 06 00:00:00 PST 2015	6.549999952316284
Fri Dec 04 00:00:00 PST 2015	8.0
Mon Jan 18 00:00:00 PST 2016	7.566666444142659
Fri Jan 22 00:00:00 PST 2016	6.0
Wed Jan 27 00:00:00 PST 2016	9.166666666666666
Fri Jan 29 00:00:00 PST 2016	7.599999904632568
```

