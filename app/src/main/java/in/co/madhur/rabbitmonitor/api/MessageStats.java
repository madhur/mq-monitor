
package in.co.madhur.rabbitmonitor.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MessageStats {

    @Expose
    private Integer publish;
    @SerializedName("publish_details")
    @Expose
    private PublishDetails publishDetails;
    @Expose
    private Integer ack;
    @SerializedName("ack_details")
    @Expose
    private AckDetails ackDetails;
    @SerializedName("deliver_get")
    @Expose
    private Integer deliverGet;
    @SerializedName("deliver_get_details")
    @Expose
    private DeliverGetDetails deliverGetDetails;
    @Expose
    private Integer confirm;
    @SerializedName("confirm_details")
    @Expose
    private ConfirmDetails confirmDetails;
    @Expose
    private Integer redeliver;
    @SerializedName("redeliver_details")
    @Expose
    private RedeliverDetails redeliverDetails;
    @Expose
    private Integer deliver;
    @SerializedName("deliver_details")
    @Expose
    private DeliverDetails deliverDetails;
    @Expose
    private Integer get;
    @SerializedName("get_details")
    @Expose
    private GetDetails getDetails;
    @SerializedName("get_no_ack")
    @Expose
    private Integer getNoAck;
    @SerializedName("get_no_ack_details")
    @Expose
    private GetNoAckDetails getNoAckDetails;

    /**
     * 
     * @return
     *     The publish
     */
    public Integer getPublish() {
        return publish;
    }

    /**
     * 
     * @param publish
     *     The publish
     */
    public void setPublish(Integer publish) {
        this.publish = publish;
    }

    /**
     * 
     * @return
     *     The publishDetails
     */
    public PublishDetails getPublishDetails() {
        return publishDetails;
    }

    /**
     * 
     * @param publishDetails
     *     The publish_details
     */
    public void setPublishDetails(PublishDetails publishDetails) {
        this.publishDetails = publishDetails;
    }

    /**
     * 
     * @return
     *     The ack
     */
    public Integer getAck() {
        return ack;
    }

    /**
     * 
     * @param ack
     *     The ack
     */
    public void setAck(Integer ack) {
        this.ack = ack;
    }

    /**
     * 
     * @return
     *     The ackDetails
     */
    public AckDetails getAckDetails() {
        return ackDetails;
    }

    /**
     * 
     * @param ackDetails
     *     The ack_details
     */
    public void setAckDetails(AckDetails ackDetails) {
        this.ackDetails = ackDetails;
    }

    /**
     * 
     * @return
     *     The deliverGet
     */
    public Integer getDeliverGet() {
        return deliverGet;
    }

    /**
     * 
     * @param deliverGet
     *     The deliver_get
     */
    public void setDeliverGet(Integer deliverGet) {
        this.deliverGet = deliverGet;
    }

    /**
     * 
     * @return
     *     The deliverGetDetails
     */
    public DeliverGetDetails getDeliverGetDetails() {
        return deliverGetDetails;
    }

    /**
     * 
     * @param deliverGetDetails
     *     The deliver_get_details
     */
    public void setDeliverGetDetails(DeliverGetDetails deliverGetDetails) {
        this.deliverGetDetails = deliverGetDetails;
    }

    /**
     * 
     * @return
     *     The confirm
     */
    public Integer getConfirm() {
        return confirm;
    }

    /**
     * 
     * @param confirm
     *     The confirm
     */
    public void setConfirm(Integer confirm) {
        this.confirm = confirm;
    }

    /**
     * 
     * @return
     *     The confirmDetails
     */
    public ConfirmDetails getConfirmDetails() {
        return confirmDetails;
    }

    /**
     * 
     * @param confirmDetails
     *     The confirm_details
     */
    public void setConfirmDetails(ConfirmDetails confirmDetails) {
        this.confirmDetails = confirmDetails;
    }

    /**
     * 
     * @return
     *     The redeliver
     */
    public Integer getRedeliver() {
        return redeliver;
    }

    /**
     * 
     * @param redeliver
     *     The redeliver
     */
    public void setRedeliver(Integer redeliver) {
        this.redeliver = redeliver;
    }

    /**
     * 
     * @return
     *     The redeliverDetails
     */
    public RedeliverDetails getRedeliverDetails() {
        return redeliverDetails;
    }

    /**
     * 
     * @param redeliverDetails
     *     The redeliver_details
     */
    public void setRedeliverDetails(RedeliverDetails redeliverDetails) {
        this.redeliverDetails = redeliverDetails;
    }

    /**
     * 
     * @return
     *     The deliver
     */
    public Integer getDeliver() {
        return deliver;
    }

    /**
     * 
     * @param deliver
     *     The deliver
     */
    public void setDeliver(Integer deliver) {
        this.deliver = deliver;
    }

    /**
     * 
     * @return
     *     The deliverDetails
     */
    public DeliverDetails getDeliverDetails() {
        return deliverDetails;
    }

    /**
     * 
     * @param deliverDetails
     *     The deliver_details
     */
    public void setDeliverDetails(DeliverDetails deliverDetails) {
        this.deliverDetails = deliverDetails;
    }

    /**
     * 
     * @return
     *     The get
     */
    public Integer getGet() {
        return get;
    }

    /**
     * 
     * @param get
     *     The get
     */
    public void setGet(Integer get) {
        this.get = get;
    }

    /**
     * 
     * @return
     *     The getDetails
     */
    public GetDetails getGetDetails() {
        return getDetails;
    }

    /**
     * 
     * @param getDetails
     *     The get_details
     */
    public void setGetDetails(GetDetails getDetails) {
        this.getDetails = getDetails;
    }

    /**
     * 
     * @return
     *     The getNoAck
     */
    public Integer getGetNoAck() {
        return getNoAck;
    }

    /**
     * 
     * @param getNoAck
     *     The get_no_ack
     */
    public void setGetNoAck(Integer getNoAck) {
        this.getNoAck = getNoAck;
    }

    /**
     * 
     * @return
     *     The getNoAckDetails
     */
    public GetNoAckDetails getGetNoAckDetails() {
        return getNoAckDetails;
    }

    /**
     * 
     * @param getNoAckDetails
     *     The get_no_ack_details
     */
    public void setGetNoAckDetails(GetNoAckDetails getNoAckDetails) {
        this.getNoAckDetails = getNoAckDetails;
    }

}
