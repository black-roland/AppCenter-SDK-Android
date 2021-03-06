package com.microsoft.appcenter.ingestion.models;

import java.util.Date;
import java.util.UUID;

public interface Log extends Model {

    /**
     * Get the type value.
     *
     * @return the type value
     */
    String getType();

    /**
     * Get the timestamp value.
     *
     * @return the timestamp value
     */
    Date getTimestamp();

    /**
     * Set the timestamp value.
     *
     * @param timestamp the timestamp value to set
     */
    void setTimestamp(Date timestamp);

    /**
     * Get the sid value.
     *
     * @return the sid value
     */
    UUID getSid();

    /**
     * Set the sid value.
     *
     * @param sid the sid value to set
     */
    void setSid(UUID sid);

    /**
     * Get the device value.
     *
     * @return the device value
     */
    @SuppressWarnings("unused")
    Device getDevice();

    /**
     * Set the device value.
     *
     * @param device the device value to set
     */
    void setDevice(Device device);
}
