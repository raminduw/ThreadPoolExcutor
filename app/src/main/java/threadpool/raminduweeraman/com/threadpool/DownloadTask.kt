package threadpool.raminduweeraman.com.threadpool

import android.content.Context
import android.os.Handler
import android.os.Message
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley



class DownloadTask(url:String,handler:Handler,time:Long,context:Context):Runnable {
    private val TAG = DownloadTask::class.java.simpleName
    private val urlName: String
    private val waitTime: Long
    private val uiHandler :Handler
    private val appContext: Context
    init {
        urlName = url
        uiHandler = handler
        waitTime = time
        appContext=context
    }
    override fun run() {
        downloadData(appContext)
    }

    private fun downloadData(context:Context){
        //Log.d(TAG,"downloadData %%%%%= $urlName")
        //Thread.sleep(waitTime)


        doTask(context)
    }

    private fun doTask(context:Context){
        val queue = Volley.newRequestQueue(context)
        val url = "https://restcountries.eu/rest/v2/"

        val stringRequest = StringRequest(Request.Method.GET, url,
            Response.Listener<String> { response ->
                // Display the first 500 characters of the response string.
               // textView.text = "Response is: ${response.substring(0, 500)}"
                Log.d(TAG,"downloadData SUCCESS #### = $urlName")
                val msg = Message.obtain()
                msg.what = 20
                uiHandler.sendMessage(msg)
            },
            Response.ErrorListener {
               // textView.text = "That didn't work!"
                Log.d(TAG,"downloadData ERROR #### = $urlName")
            })

// Add the request to the RequestQueue.
        queue.add(stringRequest)
    }

}