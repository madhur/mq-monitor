
package in.co.madhur.rabbitmonitor.api.queue;

import com.google.gson.annotations.Expose;

public class GetDetails {

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
