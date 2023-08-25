import com.google.gson.Gson
import com.telnet.data.dto.WeatherResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

object WeatherClient {
    private val client = OkHttpClient()
    private val url : String = "https://api.openweathermap.org/data/2.5/"

    private suspend fun makeApiCall(path : String): Response = withContext(Dispatchers.IO) {
        val request = Request.Builder()
            .url(url+path)
            .build()

        client.newCall(request).execute()
    }

    suspend fun getWeatherByTown(lat: Double,lon:Double)= flow<WeatherResponse?> {
        try {
            val response: Response = makeApiCall("onecall?lat=$lat&lon=$lon&exclude=hourly,daily&appid={API key}")
            if (response.isSuccessful) {
                val responseData = response.body?.string()
                val gson = Gson()
                emit(gson.fromJson(responseData, WeatherResponse::class.java))
            } else {
                emit(null)
            }
        } catch (e: IOException) {
            emit(null)

        }
    }
}