package rest;

import retrofit.Call;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by giannis on 16/9/2016.
 */
public interface ApiService {

    @FormUrlEncoded
    @POST("requests/firms.php")
    Call<UpStreamData> getFirmNames(@Field("action") String action);

    /**
     * Created by giannis on 16/9/2016.
     */
    class UpStreamData {
        private String message;

        public UpStreamData(String message) {
            this.message = message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return this.message;
        }

    }
}
