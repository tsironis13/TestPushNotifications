import com.google.gson.Gson;

import rest.ApiService;
import rest.ServiceGenerator;

/**
 * Created by giannis on 16/9/2016.
 */
public class RetrofitSingleton {
    private static RetrofitSingleton rInstance = null;
    private static RetrofitSingleton rInstanceWithCustomGson = null;
    private ApiService apiService;

    private RetrofitSingleton(){
        apiService = ServiceGenerator.createService(ApiService.class);
    }

    private RetrofitSingleton(Gson gson){
//        apiService = ServiceGenerator.createServiceCustomGson(ApiService.class, gson);
    }

    public static RetrofitSingleton getInstance() {
        if ( rInstance == null ) {
            rInstance = new RetrofitSingleton();
        }
        return rInstance;
    }

    public static RetrofitSingleton getInstanceWithCustoGson(Gson gson) {
        if ( rInstanceWithCustomGson == null ) {
            rInstanceWithCustomGson = new RetrofitSingleton(gson);
        }
        return rInstanceWithCustomGson;
    }

    public ApiService getApiService() {
        return apiService;
    }
}
