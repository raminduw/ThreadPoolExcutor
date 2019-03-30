package threadpool.raminduweeraman.com.threadpool

import android.os.Handler
import android.os.Message
import android.util.Log

class DownloadTask(url:String,handler:Handler,time:Long):Runnable {
    private val TAG = DownloadTask::class.java.simpleName
    private val urlName: String
    private val waitTime: Long
    private val uiHandler :Handler
    init {
        urlName = url
        uiHandler = handler
        waitTime = time
    }
    override fun run() {
        downloadData()
    }

    private fun downloadData(){
        Log.d(TAG,"downloadData %%%%%= $urlName")
        Thread.sleep(waitTime)
        Log.d(TAG,"downloadData #### = $urlName")
        val msg = Message.obtain()
        msg.what = 20
        uiHandler.sendMessage(msg)
    }

}