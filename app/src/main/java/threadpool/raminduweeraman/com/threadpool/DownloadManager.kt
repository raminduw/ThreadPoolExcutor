package threadpool.raminduweeraman.com.threadpool

import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

class DownloadManager {

    private var downloadThreadPool: ThreadPoolExecutor? = null
    private var downaloadWorkQueue: LinkedBlockingQueue<Runnable>? = null

    private val CORE_POOL_SIZE = 15
    private val MAX_POOL_SIZE = 15
    private val KEEP_ALIVE_TIME = 500L

    init {
        downaloadWorkQueue = LinkedBlockingQueue<Runnable>()

        downloadThreadPool = ThreadPoolExecutor(
            CORE_POOL_SIZE, MAX_POOL_SIZE,
            KEEP_ALIVE_TIME, TimeUnit.MILLISECONDS, downaloadWorkQueue
        )
    }

    public fun runDownloadFile(task:Runnable){
        downloadThreadPool?.execute(task)
    }

    public fun getCompleteCount():StringBuffer{
        val count =  downloadThreadPool?.taskCount
        val completeCount = downloadThreadPool?.completedTaskCount
        return StringBuffer("Complete count : $completeCount/$count")

    }

}