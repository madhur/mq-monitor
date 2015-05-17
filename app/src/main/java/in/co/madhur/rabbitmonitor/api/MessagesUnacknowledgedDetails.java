
package in.co.madhur.rabbitmonitor.api;

import com.google.gson.annotations.Expose;

public class MessagesUnacknowledgedDetails {

    @Expose
    private Double rate;

    /**
     * 
     * @return
     *     The rate
     */
    public Double getRate() {
        return rate;
    }

    /**
     * 
     * @param rate
     *     The rate
     */
    public void setRate(Double rate) {
        this.rate = rate;
    }

}
