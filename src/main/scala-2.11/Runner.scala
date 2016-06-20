import com.twitter.scalding.{Args, Hdfs, Mode}
import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.mapred.JobConf

object Runner extends App {
  val jobConf = new JobConf
  val mode = Hdfs(true, jobConf)
  val arguments = Mode.putMode(mode, Args("--input 44f10992fa2488aa9d681fbc454af109.csv --output output"))
  val job = new WordCountJob(arguments)
  job.buildFlow.complete()
}