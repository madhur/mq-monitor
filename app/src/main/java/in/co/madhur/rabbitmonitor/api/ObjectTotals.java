
package in.co.madhur.rabbitmonitor.api;

import com.google.gson.annotations.Expose;

public class ObjectTotals {

    @Expose
    private Integer consumers;
    @Expose
    private Integer queues;
    @Expose
    private Integer exchanges;
    @Expose
    private Integer connections;
    @Expose
    private Integer channels;

    /**
     * 
     * @return
     *     The consumers
     */
    public Integer getConsumers() {
        return consumers;
    }

    /**
     * 
     * @param consumers
     *     The consumers
     */
    public void setConsumers(Integer consumers) {
        this.consumers = consumers;
    }

    /**
     * 
     * @return
     *     The queues
     */
    public Integer getQueues() {
        return queues;
    }

    /**
     * 
     * @param queues
     *     The queues
     */
    public void setQueues(Integer queues) {
        this.queues = queues;
    }

    /**
     * 
     * @return
     *     The exchanges
     */
    public Integer getExchanges() {
        return exchanges;
    }

    /**
     * 
     * @param exchanges
     *     The exchanges
     */
    public void setExchanges(Integer exchanges) {
        this.exchanges = exchanges;
    }

    /**
     * 
     * @return
     *     The connections
     */
    public Integer getConnections() {
        return connections;
    }

    /**
     * 
     * @param connections
     *     The connections
     */
    public void setConnections(Integer connections) {
        this.connections = connections;
    }

    /**
     * 
     * @return
     *     The channels
     */
    public Integer getChannels() {
        return channels;
    }

    /**
     * 
     * @param channels
     *     The channels
     */
    public void setChannels(Integer channels) {
        this.channels = channels;
    }

}
