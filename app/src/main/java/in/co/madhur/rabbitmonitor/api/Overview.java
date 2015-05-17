
package in.co.madhur.rabbitmonitor.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Overview {

    @SerializedName("management_version")
    @Expose
    private String managementVersion;
    @SerializedName("statistics_level")
    @Expose
    private String statisticsLevel;
    @SerializedName("exchange_types")
    @Expose
    private List<ExchangeType> exchangeTypes = new ArrayList<ExchangeType>();
    @SerializedName("rabbitmq_version")
    @Expose
    private String rabbitmqVersion;
    @SerializedName("erlang_version")
    @Expose
    private String erlangVersion;
    @SerializedName("erlang_full_version")
    @Expose
    private String erlangFullVersion;
    @SerializedName("message_stats")
    @Expose
    private MessageStats messageStats;
    @SerializedName("queue_totals")
    @Expose
    private QueueTotals queueTotals;
    @SerializedName("object_totals")
    @Expose
    private ObjectTotals objectTotals;
    @Expose
    private String node;
    @SerializedName("statistics_db_node")
    @Expose
    private String statisticsDbNode;
    @Expose
    private List<Listener> listeners = new ArrayList<Listener>();
    @Expose
    private List<Context> contexts = new ArrayList<Context>();

    /**
     * 
     * @return
     *     The managementVersion
     */
    public String getManagementVersion() {
        return managementVersion;
    }

    /**
     * 
     * @param managementVersion
     *     The management_version
     */
    public void setManagementVersion(String managementVersion) {
        this.managementVersion = managementVersion;
    }

    /**
     * 
     * @return
     *     The statisticsLevel
     */
    public String getStatisticsLevel() {
        return statisticsLevel;
    }

    /**
     * 
     * @param statisticsLevel
     *     The statistics_level
     */
    public void setStatisticsLevel(String statisticsLevel) {
        this.statisticsLevel = statisticsLevel;
    }

    /**
     * 
     * @return
     *     The exchangeTypes
     */
    public List<ExchangeType> getExchangeTypes() {
        return exchangeTypes;
    }

    /**
     * 
     * @param exchangeTypes
     *     The exchange_types
     */
    public void setExchangeTypes(List<ExchangeType> exchangeTypes) {
        this.exchangeTypes = exchangeTypes;
    }

    /**
     * 
     * @return
     *     The rabbitmqVersion
     */
    public String getRabbitmqVersion() {
        return rabbitmqVersion;
    }

    /**
     * 
     * @param rabbitmqVersion
     *     The rabbitmq_version
     */
    public void setRabbitmqVersion(String rabbitmqVersion) {
        this.rabbitmqVersion = rabbitmqVersion;
    }

    /**
     * 
     * @return
     *     The erlangVersion
     */
    public String getErlangVersion() {
        return erlangVersion;
    }

    /**
     * 
     * @param erlangVersion
     *     The erlang_version
     */
    public void setErlangVersion(String erlangVersion) {
        this.erlangVersion = erlangVersion;
    }

    /**
     * 
     * @return
     *     The erlangFullVersion
     */
    public String getErlangFullVersion() {
        return erlangFullVersion;
    }

    /**
     * 
     * @param erlangFullVersion
     *     The erlang_full_version
     */
    public void setErlangFullVersion(String erlangFullVersion) {
        this.erlangFullVersion = erlangFullVersion;
    }

    /**
     * 
     * @return
     *     The messageStats
     */
    public MessageStats getMessageStats() {
        return messageStats;
    }

    /**
     * 
     * @param messageStats
     *     The message_stats
     */
    public void setMessageStats(MessageStats messageStats) {
        this.messageStats = messageStats;
    }

    /**
     * 
     * @return
     *     The queueTotals
     */
    public QueueTotals getQueueTotals() {
        return queueTotals;
    }

    /**
     * 
     * @param queueTotals
     *     The queue_totals
     */
    public void setQueueTotals(QueueTotals queueTotals) {
        this.queueTotals = queueTotals;
    }

    /**
     * 
     * @return
     *     The objectTotals
     */
    public ObjectTotals getObjectTotals() {
        return objectTotals;
    }

    /**
     * 
     * @param objectTotals
     *     The object_totals
     */
    public void setObjectTotals(ObjectTotals objectTotals) {
        this.objectTotals = objectTotals;
    }

    /**
     * 
     * @return
     *     The node
     */
    public String getNode() {
        return node;
    }

    /**
     * 
     * @param node
     *     The node
     */
    public void setNode(String node) {
        this.node = node;
    }

    /**
     * 
     * @return
     *     The statisticsDbNode
     */
    public String getStatisticsDbNode() {
        return statisticsDbNode;
    }

    /**
     * 
     * @param statisticsDbNode
     *     The statistics_db_node
     */
    public void setStatisticsDbNode(String statisticsDbNode) {
        this.statisticsDbNode = statisticsDbNode;
    }

    /**
     * 
     * @return
     *     The listeners
     */
    public List<Listener> getListeners() {
        return listeners;
    }

    /**
     * 
     * @param listeners
     *     The listeners
     */
    public void setListeners(List<Listener> listeners) {
        this.listeners = listeners;
    }

    /**
     * 
     * @return
     *     The contexts
     */
    public List<Context> getContexts() {
        return contexts;
    }

    /**
     * 
     * @param contexts
     *     The contexts
     */
    public void setContexts(List<Context> contexts) {
        this.contexts = contexts;
    }

}
