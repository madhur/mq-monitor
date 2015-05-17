
package in.co.madhur.rabbitmonitor.api.queue;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Queue {

    @Expose
    private Integer memory;
    @SerializedName("message_stats")
    @Expose
    private MessageStats messageStats;
    @Expose
    private Integer messages;
    @SerializedName("messages_details")
    @Expose
    private MessagesDetails messagesDetails;
    @SerializedName("messages_ready")
    @Expose
    private Integer messagesReady;
    @SerializedName("messages_ready_details")
    @Expose
    private MessagesReadyDetails messagesReadyDetails;
    @SerializedName("idle_since")
    @Expose
    private String idleSince;
    @Expose
    private String policy;
    @SerializedName("exclusive_consumer_tag")
    @Expose
    private String exclusiveConsumerTag;
    @Expose
    private Integer consumers;
    @SerializedName("backing_queue_status")
    @Expose
    private BackingQueueStatus backingQueueStatus;
    @Expose
    private String status;
    @Expose
    private String name;
    @Expose
    private String vhost;
    @Expose
    private Boolean durable;
    @SerializedName("auto_delete")
    @Expose
    private Boolean autoDelete;
    @Expose
    private Arguments arguments;
    @Expose
    private String node;
    @SerializedName("messages_unacknowledged")
    @Expose
    private Integer messagesUnacknowledged;
    @SerializedName("messages_unacknowledged_details")
    @Expose
    private MessagesUnacknowledgedDetails messagesUnacknowledgedDetails;

    /**
     * 
     * @return
     *     The memory
     */
    public Integer getMemory() {
        return memory;
    }

    /**
     * 
     * @param memory
     *     The memory
     */
    public void setMemory(Integer memory) {
        this.memory = memory;
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
     *     The messages
     */
    public Integer getMessages() {
        return messages;
    }

    /**
     * 
     * @param messages
     *     The messages
     */
    public void setMessages(Integer messages) {
        this.messages = messages;
    }

    /**
     * 
     * @return
     *     The messagesDetails
     */
    public MessagesDetails getMessagesDetails() {
        return messagesDetails;
    }

    /**
     * 
     * @param messagesDetails
     *     The messages_details
     */
    public void setMessagesDetails(MessagesDetails messagesDetails) {
        this.messagesDetails = messagesDetails;
    }

    /**
     * 
     * @return
     *     The messagesReady
     */
    public Integer getMessagesReady() {
        return messagesReady;
    }

    /**
     * 
     * @param messagesReady
     *     The messages_ready
     */
    public void setMessagesReady(Integer messagesReady) {
        this.messagesReady = messagesReady;
    }

    /**
     * 
     * @return
     *     The messagesReadyDetails
     */
    public MessagesReadyDetails getMessagesReadyDetails() {
        return messagesReadyDetails;
    }

    /**
     * 
     * @param messagesReadyDetails
     *     The messages_ready_details
     */
    public void setMessagesReadyDetails(MessagesReadyDetails messagesReadyDetails) {
        this.messagesReadyDetails = messagesReadyDetails;
    }

    /**
     * 
     * @return
     *     The idleSince
     */
    public String getIdleSince() {
        return idleSince;
    }

    /**
     * 
     * @param idleSince
     *     The idle_since
     */
    public void setIdleSince(String idleSince) {
        this.idleSince = idleSince;
    }

    /**
     * 
     * @return
     *     The policy
     */
    public String getPolicy() {
        return policy;
    }

    /**
     * 
     * @param policy
     *     The policy
     */
    public void setPolicy(String policy) {
        this.policy = policy;
    }

    /**
     * 
     * @return
     *     The exclusiveConsumerTag
     */
    public String getExclusiveConsumerTag() {
        return exclusiveConsumerTag;
    }

    /**
     * 
     * @param exclusiveConsumerTag
     *     The exclusive_consumer_tag
     */
    public void setExclusiveConsumerTag(String exclusiveConsumerTag) {
        this.exclusiveConsumerTag = exclusiveConsumerTag;
    }

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
     *     The backingQueueStatus
     */
    public BackingQueueStatus getBackingQueueStatus() {
        return backingQueueStatus;
    }

    /**
     * 
     * @param backingQueueStatus
     *     The backing_queue_status
     */
    public void setBackingQueueStatus(BackingQueueStatus backingQueueStatus) {
        this.backingQueueStatus = backingQueueStatus;
    }

    /**
     * 
     * @return
     *     The status
     */
    public String getStatus() {
        return status;
    }

    /**
     * 
     * @param status
     *     The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The vhost
     */
    public String getVhost() {
        return vhost;
    }

    /**
     * 
     * @param vhost
     *     The vhost
     */
    public void setVhost(String vhost) {
        this.vhost = vhost;
    }

    /**
     * 
     * @return
     *     The durable
     */
    public Boolean getDurable() {
        return durable;
    }

    /**
     * 
     * @param durable
     *     The durable
     */
    public void setDurable(Boolean durable) {
        this.durable = durable;
    }

    /**
     * 
     * @return
     *     The autoDelete
     */
    public Boolean getAutoDelete() {
        return autoDelete;
    }

    /**
     * 
     * @param autoDelete
     *     The auto_delete
     */
    public void setAutoDelete(Boolean autoDelete) {
        this.autoDelete = autoDelete;
    }

    /**
     * 
     * @return
     *     The arguments
     */
    public Arguments getArguments() {
        return arguments;
    }

    /**
     * 
     * @param arguments
     *     The arguments
     */
    public void setArguments(Arguments arguments) {
        this.arguments = arguments;
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
     *     The messagesUnacknowledged
     */
    public Integer getMessagesUnacknowledged() {
        return messagesUnacknowledged;
    }

    /**
     * 
     * @param messagesUnacknowledged
     *     The messages_unacknowledged
     */
    public void setMessagesUnacknowledged(Integer messagesUnacknowledged) {
        this.messagesUnacknowledged = messagesUnacknowledged;
    }

    /**
     * 
     * @return
     *     The messagesUnacknowledgedDetails
     */
    public MessagesUnacknowledgedDetails getMessagesUnacknowledgedDetails() {
        return messagesUnacknowledgedDetails;
    }

    /**
     * 
     * @param messagesUnacknowledgedDetails
     *     The messages_unacknowledged_details
     */
    public void setMessagesUnacknowledgedDetails(MessagesUnacknowledgedDetails messagesUnacknowledgedDetails) {
        this.messagesUnacknowledgedDetails = messagesUnacknowledgedDetails;
    }

}
