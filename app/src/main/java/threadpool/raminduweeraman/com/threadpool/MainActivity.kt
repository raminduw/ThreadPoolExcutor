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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDownload.setOnClickListener {

            Log.d(TAG,"Click on download")

            val task1 =  DownloadTask("123", getHandler())
            val task2 =  DownloadTask("456", getHandler())
            val task3 =  DownloadTask("789", getHandler())
            val task4 =  DownloadTask("1222", getHandler())

            val downloadManager = DownloadManager()
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
                // code here
                Log.d(TAG,"Message Received")
            }
        }

        return mHandler;
    }
}
