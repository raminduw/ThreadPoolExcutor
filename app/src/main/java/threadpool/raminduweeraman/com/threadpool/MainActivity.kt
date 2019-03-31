package threadpool.raminduweeraman.com.threadpool

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val TAG = MainActivity::class.java.simpleName
    lateinit var downloadManager:DownloadManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDownload.setOnClickListener {

            Log.d(TAG,"Click on download")

            val task1 =  DownloadTask("123", getHandler(),10000,applicationContext)
            val task2 =  DownloadTask("456", getHandler(),20000,applicationContext)
            val task3 =  DownloadTask("789", getHandler(),30000,applicationContext)
            val task4 =  DownloadTask("900", getHandler(),40000,applicationContext)

            downloadManager = DownloadManager()
            downloadManager.runDownloadFile(task1)
            downloadManager.runDownloadFile(task2)
            downloadManager.runDownloadFile(task3)
            downloadManager.runDownloadFile(task4)
        }
    }


    private fun getHandler():Handler{
        @SuppressLint("HandlerLeak")
        val  mHandler = object : Handler(Looper.getMainLooper()) {
            override fun handleMessage(msg: Message) {
                if (msg.what==20) {
                    Log.d(TAG,"Message Received")
                    Log.d(TAG,downloadManager.getCompleteCount().toString())
                }
            }
        }

        return mHandler;
    }
}
