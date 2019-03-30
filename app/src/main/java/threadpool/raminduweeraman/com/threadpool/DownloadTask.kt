package threadpool.raminduweeraman.com.threadpool

import android.os.Handler
import android.util.Log

class DownloadTask(url:String,handler:Handler):Runnable {
    private val TAG = DownloadTask::class.java.simpleName
    private val urlName: String
    private val uiHandler :Handler
    init {
        urlName = url
        uiHandler = handler
    }
    override fun run() {
        Thread.sleep(1000)
        downloadData()
    }

    private fun downloadData(){
       Log.d(TAG,"downloadData = $urlName ")
      //  uiHandler.sendMessageDelayed(Message(),1)
        uiHandler.sendEmptyMessage(1)
    }



}